package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("/first")
    public String firstView(){
        return "first";
    }

    @GetMapping("/second")
    public String redirection(){
        return "redirect: third";
    }

    @GetMapping("/third")
    public String thirdView(){
        return "third";
    }
}
