package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarManager;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count, Model model) {
        CarManager carManager = new CarManager();
        model.addAttribute("fewCars", carManager.getCarList(Math.abs(count)));
        return "cars";
    }
}