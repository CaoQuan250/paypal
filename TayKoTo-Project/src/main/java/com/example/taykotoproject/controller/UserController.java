package com.example.taykotoproject.controller;

import com.example.taykotoproject.common.Constans;
import com.example.taykotoproject.model.Customer;
import com.example.taykotoproject.model.Roles;
import com.example.taykotoproject.model.Users;
import com.example.taykotoproject.payload.RegisterUser;
import com.example.taykotoproject.service.CustomerServiceImpl;
import com.example.taykotoproject.service.RoleServiceImpl;
import com.example.taykotoproject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping(path = "/login-register")
    public String loginRegister() {
        return "login-register";
    }

    @PostMapping(value = "/register")
    public String registerSubmit(@ModelAttribute RegisterUser registerUser) {
        if (usersService.existsByUsername(registerUser.getUsername())) {

        } else {
            Users users = new Users();
            users.setUsername(registerUser.getUsername());
            users.setEmail(registerUser.getEmail());
            String password = encoder.encode(registerUser.getPassword());
            users.setPassword(password);

            Set<Roles> roles = new HashSet<>();
            Roles r = roleService.findByRoleName(Constans.ROLE_CUSTOMER).get();
            roles.add(r);

            users.setRoles(roles);

            Customer customer = new Customer();
            customer.setCustomerEmail(users.getEmail());
            customerService.save(customer);

            users.setCustomerId(customer.getCustomerId());
            usersService.saveUsers(users);
        }
        return "redirect:/home";
    }


}
