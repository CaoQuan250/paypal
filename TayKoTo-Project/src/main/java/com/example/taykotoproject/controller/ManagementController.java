package com.example.taykotoproject.controller;

import com.example.taykotoproject.common.ScheduleEmailRequest;
import com.example.taykotoproject.common.ScheduleEmailResponse;
import com.example.taykotoproject.model.Deal;
import com.example.taykotoproject.model.InfoService;
import com.example.taykotoproject.model.Users;
import com.example.taykotoproject.model.Vehicle;
import com.example.taykotoproject.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.Optional;

@Controller
public class ManagementController {

    private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

    @Autowired
    private VehicleServiceImpl vehicleService;

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private DealServiceImpl dealService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private InfoServicesImpl infoService;

    @Autowired
    private PasswordEncoder encoder;

    private static final String UPLOADED_FOLDER = "src/main/resources/static/upload/";

    @GetMapping(value = {"/management"})
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showCarsManagement(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Users user = usersService.findByUsername(username);

        model.addAttribute("listVehicle", vehicleService.getAll());
        model.addAttribute("user", user);
        model.addAttribute("listDeal", dealService.getAll());
        model.addAttribute("listCustomer", customerService.getAll());
        model.addAttribute("listUser", usersService.getAll());
        return "management";
    }

    @GetMapping(path = "/add-vehicle")
    public String showFormVehicle(Vehicle vehicle,
                                  Model model) {
        model.addAttribute("vehicle", vehicle);
        return "vehicle-form";
    }

    @PostMapping(path = "/add-vehicle")
    public String saveVehicle(@Valid Vehicle vehicle,
                              BindingResult result,
                              @RequestParam("img")MultipartFile myFile) {
        vehicle.setImg("_");
//        if (result.hasErrors()) {
//            return "vehicle-form";
//        }

        try {
            Path path = Paths.get(UPLOADED_FOLDER + myFile.getOriginalFilename());
            Files.write(path, myFile.getBytes());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        vehicle.setImg("/upload/" + myFile.getOriginalFilename());
        vehicleService.saveVehicle(vehicle);

        InfoService info = new InfoService();

        info.setVehicleId(vehicle.getVehicleId());
        info.setVehicleMake(vehicle.getVehicleMake());
        info.setVehicleModel(vehicle.getVehicleModel());
        info.setBodyStyle(vehicle.getBodyStyle());
        info.setVehicleType(vehicle.getVehicleType());
        info.setVehicleYear(vehicle.getVehicleYear());
        info.setVehicleEngine(vehicle.getVehicleEngine());
        info.setVehicleHorsepower(vehicle.getVehicleHorsepower());
        info.setPrice(vehicle.getPrice());
        infoService.save(info);

        return "redirect:/management";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Vehicle vehicle = vehicleService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("vehicle", vehicle);
        return "vehicle-update";
    }

    @PostMapping(value = { "/update/{id}" },
            consumes = {"multipart/form-data"})
    public String updateVehicle(@PathVariable("id") Long id,
                                @Valid Vehicle vehicle,
                                BindingResult result,
                                @RequestParam("imgnew") MultipartFile myFile) {

        if (!myFile.getOriginalFilename().equals("null")) {
            try {
                Path path = Paths.get(UPLOADED_FOLDER + myFile.getOriginalFilename());
                Files.write(path, myFile.getBytes());
                vehicle.setImg("/upload/" + myFile.getOriginalFilename());
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        InfoService info = infoService.getOne(id);

        vehicle.setVehicleId(id);
        vehicleService.saveVehicle(vehicle);

        info.setVehicleId(id);
        info.setVehicleMake(vehicle.getVehicleMake());
        info.setVehicleModel(vehicle.getVehicleModel());
        info.setBodyStyle(vehicle.getBodyStyle());
        info.setVehicleType(vehicle.getVehicleType());
        info.setVehicleYear(vehicle.getVehicleYear());
        info.setVehicleEngine(vehicle.getVehicleEngine());
        info.setVehicleHorsepower(vehicle.getVehicleHorsepower());
        info.setPrice(vehicle.getPrice());
        infoService.save(info);
        return "redirect:/management";
    }

    @GetMapping("/delete-vehicle/{id}")
    public String deleteVehicle(@PathVariable("id") Long id) {
        Vehicle vehicle = vehicleService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle id: " + id));
        InfoService info = infoService.findByVehicleId(vehicle.getVehicleId()).get();

        infoService.delete(info.getServiceId());
        vehicleService.deleteVehicle(id);
        return "redirect:/management";
    }

    @GetMapping("/deal/update/{id}")
    public String deal(Model model,
                       @PathVariable("id") Long id) {
        Deal deal = dealService.getOne(id);

        model.addAttribute("deal", deal);
        return "deal-update";
    }

    @PostMapping("/deal/update/{id}")
    public String updateDeal(@Valid Deal deal,
                             @PathVariable("id") Long id) {
        deal.setDealId(id);
        deal.setStatus("1");
        dealService.save(deal);

//        ScheduleEmailRequest scheduleEmailRequest
//        try {
//            ZonedDateTime dateTime = ZonedDateTime.of(scheduleEmailRequest.getDateTime(), scheduleEmailRequest.getTimeZone());
//            if (dateTime.isBefore(ZonedDateTime.now())) {
//                ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(false, "dateTime must be after current time");
//                System.err.println(scheduleEmailResponse);
//            }
//
//
//        }

        return "redirect:/management";
    }

    @GetMapping("/deal/delete/{id}")
    public String deleteDeal(@PathVariable("id") Long id) {
        Deal deal = dealService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid deal id: " + id));
        dealService.delete(id);

        return "redirect:/management";
    }

    @GetMapping("/user/reset-password/{id}")
    public String resetPassword(@PathVariable("id") Long id) {
        Users users = usersService.findUserById(id);

        String password = encoder.encode("1234");
        users.setUsername(users.getUsername());
        users.setCustomerId(users.getCustomerId());
        users.setPassword(password);

        usersService.saveUsers(users);

        return "redirect:/management";
    }
}
