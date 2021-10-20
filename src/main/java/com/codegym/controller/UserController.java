package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;


    @GetMapping
    public ModelAndView index(Pageable pageable) {
        Page<User> users = userService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/register");
        }
        boolean checkUsername = userService.save(user);
        if (!checkUsername) {
            modelAndView = new ModelAndView("/register");
            modelAndView.addObject("message", "Tai khoan nay da co nguoi su dung");
            return modelAndView;
        }
        userService.save(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login", "user", new User());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("/login");
        boolean checkLogin = userService.isLogin(user);
        if (checkLogin) {
            return new ModelAndView("/result", "user", user);
        } else {
            modelAndView.addObject("message", "Sai ten tai khoan hoac mat khau.");
        }
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/result")
    public ModelAndView result(@ModelAttribute User user) {
        return new ModelAndView("/result");
    }
}
