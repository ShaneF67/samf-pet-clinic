package com.samf.samfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersController {


    @RequestMapping({"", "/index"})
    public String getOwners() {
        return "owners/index";
    }
}
