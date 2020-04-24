package com.example.demo.web.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController implements ErrorController {
    @GetMapping({"/test", "/error"})
    public String index() {
        return "index.html";
    }
    @Override public String getErrorPath() {
        return "/error";
    }
}

