package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(produces = "text/html; charset=UTF-8")
public class HeaderController {

    @GetMapping("/showUserAgent")
    public String userAgent (@RequestHeader("user-agent") String userAgent, Model model){
        model.addAttribute("userAgentValue", userAgent);
        return "userAgent";
    }
}
