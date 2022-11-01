package com.example.taykotoproject.controller;

import com.example.taykotoproject.model.Deal;
import com.example.taykotoproject.model.Users;
import com.example.taykotoproject.service.DealServiceImpl;
import com.example.taykotoproject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DealController {

    @Autowired
    private DealServiceImpl dealService;

    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping("/deal")
    public String deal(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Users user = usersService.findByUsername(username);

        List<Deal> list = dealService.getAllById(user.getCustomerId());


        model.addAttribute("user", user);
        model.addAttribute("deal", list);
        return "deal";
    }


}
