package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarServiceImpl carService;

    public CarController(@Autowired CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cars", carService.index());
        return "cars";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carService.show(id));
        return "show_car";
    }
}
