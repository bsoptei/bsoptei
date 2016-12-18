package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Söp on 2016.12.18..
 */
@Controller
public class HelloWebController {
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("web/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") final String name, Model model) {
        Map<String, String> params = new HashMap<String, String>(){{
            put("name", name);
            put("count", String.valueOf(counter.incrementAndGet()));
        }};
        model.addAllAttributes(params);
        return "greeting";
    }


}
