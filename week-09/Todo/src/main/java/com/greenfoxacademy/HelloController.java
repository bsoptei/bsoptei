package com.greenfoxacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Söp on 2016.12.20..
 */
@Controller
public class HelloController {

    @RequestMapping("/helloWorld")
    public String hello(@RequestParam(value="name", required=false, defaultValue="Thymeleaf") final String name, Model model) {
        model.addAttribute("name", name);
        return "helloWorld";
    }
}
