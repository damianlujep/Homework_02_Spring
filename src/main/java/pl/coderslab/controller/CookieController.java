package pl.coderslab.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {
    @GetMapping("/add-cookies")
    @ResponseBody
    public String addCookies(HttpServletResponse response){
        Cookie cookie1 = new Cookie("user", "Jan");
        Cookie cookie2 = new Cookie("uid-c4f", "ccb1b154-c4f");
        Cookie cookie3 = new Cookie("IDE", "IntelliJ");
        cookie1.setMaxAge(10*60);
        cookie1.setMaxAge(10*24*60*60);
        cookie1.setMaxAge(30*24*60*60);

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);

        return "Cookies set";
    }

    @GetMapping("/all-cookies")
    public String allCookies(HttpServletRequest request, Model m, HttpServletResponse response){
        Cookie user = WebUtils.getCookie(request, "user");
        Cookie cookie2 = WebUtils.getCookie(request, "uid-c4f");
        Cookie ide = WebUtils.getCookie(request, "IDE");

        List<Cookie> allCookies = new ArrayList<>();
        allCookies.add(user);
        allCookies.add(cookie2);
        allCookies.add(ide);

        m.addAttribute("cookiesList", allCookies);

        return "cookies";

//        return "cookie1: " + user.getValue()+"\n"+
//                "cookie 2: " + cookie2.getValue()+"\n"+
//                "cookie 3: " + ide.getValue()+"\n";

    }

    @GetMapping("/all-cookies1")
    @ResponseBody
    public String allCookies(@CookieValue("user") String user, @CookieValue("uid-c4f") String cookie2, @CookieValue("IDE") String ide ){
        return "cookie1: " + user+"\n"+
                "cookie 2: " + cookie2+"\n"+
                "cookie 3: " + ide+"\n";
    }


}
