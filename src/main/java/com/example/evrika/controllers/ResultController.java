package com.example.evrika.controllers;

import com.example.evrika.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultController {
    @GetMapping("/exists")
    public String onExists(Model model) {
        return "exists";
    }

    @GetMapping("/notexists")
    public String onNotExists(Model model) {
        return "notexists";
    }

    @RequestMapping(value="/exists", params="backFromIs")
    public String backFromIs(Model model) {
        return "home";
    }

    @RequestMapping(value="/notexists", params="backFromNot")
    public String backFromNot(Model model) {
        return "home";
    }
}
