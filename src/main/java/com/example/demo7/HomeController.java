package com.example.demo7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/tvform")
    public String loadTvForm(Model model) {
        model.addAttribute("tvshow", new Tvshow());  //the input from this page will be used to create the tvshow object
        return "tvform";
    }

    @PostMapping("/tvform")
    public String processTvForm(@Valid Tvshow tvshow, BindingResult result) {  //method that will validate inputted data
        if (result.hasErrors()) {
            return "tvform";       //if an error will return to input page if not then will go to confirm page
        }
        return  "tvshowconfirm";
    }
}
