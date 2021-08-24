package com.example.wkquizapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/newpage")
    public  String newpage(){
        return "/newpage.html";
    }
}
