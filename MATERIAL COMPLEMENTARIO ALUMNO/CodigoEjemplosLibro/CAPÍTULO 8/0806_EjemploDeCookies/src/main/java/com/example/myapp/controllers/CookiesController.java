package com.example.myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CookiesController {

    @GetMapping("/")
    public String showList(@CookieValue(value = "monedaPrecios", required = false) String cookieMoneda,
            Model model) {
        String moneda = cookieMoneda == null ? "EUR" : cookieMoneda;
        model.addAttribute("moneda", moneda);
        return "listView";
    }

    @GetMapping("/setMoneda/{moneda}")
    public String showIndex(@PathVariable String moneda,
            HttpServletResponse response,
            Model model) {
        Cookie cookie = new Cookie("monedaPrecios", moneda);
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 días
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }

}
