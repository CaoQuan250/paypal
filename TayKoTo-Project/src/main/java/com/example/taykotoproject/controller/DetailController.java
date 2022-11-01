package com.example.taykotoproject.controller;

import com.example.taykotoproject.model.*;
import com.example.taykotoproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class DetailController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private DealServiceImpl dealService;

    @Autowired
    private InfoServicesImpl infoService;

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private VehicleServiceImpl vehicleService;

    @Autowired
    private VehicleGalleryServiceImpl galleryService;

    @GetMapping(path = "/car/{id}")
    public String detailCar(@PathVariable Long id,

                                        Model model,

                                        Deal deal) {

        Optional<Vehicle> vehicle = vehicleService.findById(id);

        Optional<InfoService> info = infoService.findByVehicleId(id);

        List<VehicleGallery> gallery = galleryService.findAllById(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        Users user = usersService.findByUsername(username);

        Customer customer = customerService.getOne(user.getCustomerId());

        if (info.isPresent() && vehicle.isPresent()) {

            model.addAttribute("vehicle", vehicle.get());

            model.addAttribute("info", info.get());

            model.addAttribute("gallery", gallery);

            model.addAttribute("user", user);

            model.addAttribute("customer", customer);

            model.addAttribute("deal", deal);

            return "car-details";

        } else {

            return "redirect:/";

        }

    }

    @PostMapping(path = "/order/{id}")
    public String submitOrder(@PathVariable Long id,

                              @Valid Deal deal,

                              @Valid Customer customer,

                              Model model) {

        LocalDate localDate = LocalDate.now();

        Optional<Vehicle> vehicle = vehicleService.findById(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        Users user = usersService.findByUsername(username);

        Customer customer1 = customerService.getOne(user.getCustomerId());

        customer.setCustomerId(customer1.getCustomerId());

        customerService.save(customer);

        Vehicle vehiclefind = vehicleService.findById(id).get();

        deal.setCustomerId(user.getCustomerId());

        deal.setVehicle(vehiclefind);

        deal.setStatus("0");

        deal.setPrice(vehicle.get().getPrice());

        deal.setOrderDate(Date.valueOf(localDate));

        dealService.save(deal);

        model.addAttribute("deal", deal);

        return "payment";
    }

    @PostMapping(path = "cancel/deal/{id}")
    public String cancel(@PathVariable Long id){
        Optional<Deal> deal = dealService.findById(id);
        dealService.delete(deal.get().getDealId());
        return "redirect:/";

    }

//    @GetMapping(path = "OnlineBanking")
//    public String Banking() {
//        return "OlineBanking";
//    }


//    @GetMapping("pay")
//    public String pay(){
//        return "redirect:/";
//    }



}
