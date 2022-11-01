package com.example.taykotoproject.controller;

import com.example.taykotoproject.model.Users;
import com.example.taykotoproject.model.Vehicle;
import com.example.taykotoproject.service.UsersServiceImpl;
import com.example.taykotoproject.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Calendar;
import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping(path = {"/cars"})
    public String cars(Model model,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "6") int limit,
                       @Param("brand")String brand,
                       @Param("body")String body) {
        Page<Vehicle> pagination = vehicleService.filter(PageRequest.of(page - 1, limit),brand,body);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Users user = usersService.findByUsername(username);

        model.addAttribute("pagination", pagination);
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        model.addAttribute("datetime", Calendar.getInstance().getTime());
        model.addAttribute("user", user);
        return "cars";
    }

    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword) {
        List<Vehicle> search = vehicleService.search(keyword);

        model.addAttribute("search", search);
        return "search";
    }
}
