package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.RescueShelterRepository;
import com.codeup.pawtify.daos.Roles;
import com.codeup.pawtify.daos.UsersRepository;
import com.codeup.pawtify.models.RescueShelter;
import com.codeup.pawtify.models.User;
import com.codeup.pawtify.models.UserRole;
import com.codeup.pawtify.services.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {
    private UsersRepository userdao;
    private RescueShelterRepository rescuedao;
    private PasswordEncoder passwordEncoder;
    private UserService userService;
    private Roles rolesRepo;

    public UserController(UsersRepository userdao, RescueShelterRepository rescuedao, PasswordEncoder passwordEncoder, UserService userService, Roles rolesRepo) {
        this.userdao = userdao;
        this.rescuedao = rescuedao;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.rolesRepo = rolesRepo;
    }

    //################### Potential Adopters Users ###################
    //Show the Register Form for the Potential Adopter
    @GetMapping("/register/adopter")
    public String showPASignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/potentialadopter/pa-register";
    }


    @GetMapping("/route")
    public String routeUsers() {

        Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println("roles.toArray()[0] = " + roles.toArray()[0]);
        if (roles.toArray()[0].toString().equals("ROLE_ADOPTER")) {
            System.out.println("HI ADOPTER");
            return "redirect:/pawtification/";
        }
        return "redirect:/animal/create";
    }

    //Add New Potential Adopter to the DB
    @PostMapping("/register/adopter")
    public String registerNewPAUser(@Valid User user, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute(user);
            return "potentialadopter/pa-register";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userdao.save(user);
        rolesRepo.save(new UserRole(user.getId(), "ROLE_ADOPTER"));
        return "redirect:/login";
    }

    //Login Potential Adopter
    @GetMapping("/login")
    public String showPALoginForm() {
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "potentialadopter/pa-signin";
    }

    //Edit Form Show for Potential Adopter---FOR EDIT
    @GetMapping("/adopter/{id}/edit")
    public String editAdopter(@PathVariable long id, Model model){
        model.addAttribute("editUser", userdao.findOne(id));
        return "pa-edit";
    }

    //Update DB with Potential Adopter Changed Information---FOR EDIT
    @PostMapping("/adopter/{id}/edit")
    public String updateAdopter(@ModelAttribute User editUser){
        User e = userdao.findOne(editUser.getId());
        e.setFull_name(editUser.getFull_name());
        e.setPhone(editUser.getPhone());
        e.setUsername(editUser.getUsername());
        e.setEmail(editUser.getEmail());
        e.setPassword(editUser.getPassword());
        userdao.save(e);
        return "redirect:/pawtification/";
    }
//
//    //Delete the Potential Adopter User
//    @PostMapping("/adopter/{id}/delete")
//    public String deletePAUser(@PathVariable long id){
//        userdao.delete(id);
//        return "redirect:/home";
//    }
//
    //################### Rescue Shelter Users ###################
//    // Show the Register Form for the Rescue Shelter
//    @GetMapping("/register/rescue-shelter")
//    public String showRSSignUpForm(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "/rescueshelter/rs-portal";
//    }

    //Show Rescue Shelter User Affiliation Drop Down
    @GetMapping("/register/rescue-shelter")
    public String showRSAffiliationForm(Model model) {
        User user = new User();
        Iterable<RescueShelter> rescueshelters = rescuedao.findAll();
        model.addAttribute("user", user);
//        model.addAttribute("rescueshelter", new RescueShelter());
        model.addAttribute("rescueshelters", rescueshelters);
        return "/rescueshelter/rs-portal";
    }
    //Add New Rescue Shelter to the DB
    @PostMapping("/register/rescue-shelter")
    public String registerNewRSUser(@Valid User user, RescueShelter rescueShelter, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute(user);
            return "rescueshelter/rs-portal";
        }
        user.setShelter_id(rescueShelter);
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userdao.save(user);
        rolesRepo.save(new UserRole(user.getId(), "ROLE_STAFF"));
        return "redirect:/animal/create";
    }

//    //Update User to Have Connection to Rescue Shelter Table
//    @PostMapping("/register/shelter-registration")
//    public String connectUserToShelter(User user, RescueShelter rescueShelter) {
//        User user = userService.loggedInUser();
////        RescueShelter shelter = rescuedao.findOne(id);
//        user.setShelter_id(rescueShelter);
////        System.out.println(shelter);
////        user.setShelter_id(shelter);
//        userdao.save(user);
//        return "redirect:/animal/create";
//    }

    //Login Rescue Shelter
    @GetMapping("/shelter/login")
    public String showRSLoginForm() {
//    User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "/rescueshelter/rs-portal";
    }

//    //Edit Form Show for Rescue Shelter
//    @GetMapping("/rescue-shelter/{id}/edit")
//    public String editRescueShelter(@PathVariable long id, Model model){
//        model.addAttribute("editUser", userdao.findOne(id));
//        return "rs-edit";
//    }
//
//    //Update DB with Rescue Shelter Changed Information
    @PostMapping("/rescue-shelter/edit")
    public String updateRescueShelter(@ModelAttribute User editRescue){
        User r = userdao.findOne(editRescue.getId());
        r.setFull_name(editRescue.getFull_name());
        r.setPhone(editRescue.getPhone());
        r.setUsername(editRescue.getUsername());
        r.setEmail(editRescue.getEmail());
        r.setPassword(editRescue.getPassword());
        userdao.save(r);
        return "redirect:/rs-form";
    }

//    //Delete the Rescue Shelter User
//    @PostMapping("/rescue-shelter/{id}/delete")
//    public String deleteRSUser(@PathVariable long id){
//        userdao.delete(id);
//        return "redirect:/home";
//    }
}