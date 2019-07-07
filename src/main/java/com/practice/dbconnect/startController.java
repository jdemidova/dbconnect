package com.practice.dbconnect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class startController {

    @GetMapping("/start")
    public String start
            (@RequestParam(name="name", required=false, defaultValue="World")
                     String name, Model model) {
        model.addAttribute("name", name);
        return "start";
    }

}
