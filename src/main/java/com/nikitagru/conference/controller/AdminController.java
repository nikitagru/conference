package com.nikitagru.conference.controller;

import com.nikitagru.conference.entity.Role;
import com.nikitagru.conference.entity.User;
import com.nikitagru.conference.service.AdminService;
import com.nikitagru.conference.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/users/")
public class AdminController {
    private AdminService adminService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/makepresenter/{id}")
    public String changeListenerToPresenter(@PathVariable("id") Long id) {
        adminService.changeListenerToPresenter(id);
        return "redirect:/users/";
    }

    @GetMapping("/makelistener/{id}")
    public String changePresenterToListener(@PathVariable("id") Long id) {
        adminService.changePresenterToListener(id);
        return "redirect:/users/";
    }

    @GetMapping
    public String showAllUsers(Principal principal, Model model) {
        List<User> users = userService.getAllUsers();

        HashMap<User, List<String>> usersWithRoles = new HashMap<>();

        for (User user : users) {
            if (!user.getUsername().equals(principal.getName())) {
                List<String> roles = new ArrayList<>();

                for (Role role : user.getRoles()) {
                    roles.add(role.getName());
                }

                usersWithRoles.put(user, roles);
            }
        }

        model.addAttribute("users", usersWithRoles);

        return "users";
    }
}
