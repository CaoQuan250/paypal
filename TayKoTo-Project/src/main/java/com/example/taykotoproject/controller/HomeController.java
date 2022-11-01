package com.example.taykotoproject.controller;

import com.example.taykotoproject.model.Users;
import com.example.taykotoproject.model.Vehicle;
import com.example.taykotoproject.service.UsersServiceImpl;
import com.example.taykotoproject.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping(path = {"/index", "/home", "/"})
    public String home(Model model,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "6") int limit) {
        Page<Vehicle> pagination = vehicleService.getAllLimit(PageRequest.of(page - 1, limit));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Users user = usersService.findByUsername(username);

        model.addAttribute("list", pagination);
        model.addAttribute("user", user);
        return "index";
    }
}
