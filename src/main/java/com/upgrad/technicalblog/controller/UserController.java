package com.upgrad.technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser() {
        System.out.print("***** POST METHOD CALLED ****");
        return "redirect:/posts";
    }

    @RequestMapping(value="users/logout", method = RequestMethod.POST)
    public String logout() {
        return "redirect:/";
    }
}
