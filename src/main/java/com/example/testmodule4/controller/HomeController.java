package com.example.testmodule4.controller;


import com.example.testmodule4.model.City;
import com.example.testmodule4.model.Nation;
import com.example.testmodule4.service.IServiceCity;
import com.example.testmodule4.service.IServiceNation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    IServiceCity iServiceCity;
    @Autowired
    IServiceNation iServiceNation;

    @GetMapping("/home")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/city/home");
        modelAndView.addObject("city", iServiceCity.findAll(PageRequest.of(page, 5)));
        modelAndView.addObject("country", iServiceNation.findAll());
        return modelAndView;
    }
    @ModelAttribute("city")
    public City city() {
        return new City();
    }

    @ModelAttribute("nation")
    public List<Nation> Country() {
        return iServiceNation.findAll();
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }


    @PostMapping("/create")
    public Object create(@ModelAttribute(value = "city") City city, @RequestParam int idNation) {
        Nation nation = new Nation();
        nation.setIdNation(idNation);
        city.setNation(nation);
        iServiceCity.save(city);
        return "redirect:/home";
    }

    @GetMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable int id) {
        Optional<City> city = iServiceCity.findById(id);
        List<Nation> list = iServiceNation.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("edit", city);
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public ModelAndView edit(@ModelAttribute(value = "city") City city, @RequestParam int idNation) {
        Nation country = new Nation();
        country.setIdNation(idNation);
        city.setNation(country);
        iServiceCity.save(city);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteForm(@PathVariable int id) {
        Optional<City> city = iServiceCity.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/delete");
        modelAndView.addObject("delete", city);
        return modelAndView;
    }

    @PostMapping("delete/{id}")
    public ModelAndView delete(@PathVariable int id, @ModelAttribute City city) {
        iServiceCity.delete(id);
        return new ModelAndView("redirect:/home");
    }
    @PostMapping("/search")
    public ModelAndView find(@RequestParam(defaultValue = "0") int page, @RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("/city/home");
        modelAndView.addObject("city",iServiceCity.findByName(PageRequest.of(page, 5), name));
        return modelAndView;
    }
    @GetMapping("/details/{id}")
    public ModelAndView detail(@PathVariable int id){
        Optional<City> city = iServiceCity.findById(id);
        ModelAndView modelAndView = new ModelAndView("/details");
        modelAndView.addObject("city",city);
        return modelAndView;
    }

}
