package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.RescueShelterRepository;
import com.codeup.pawtify.daos.Roles;
import com.codeup.pawtify.daos.UsersRepository;
import com.codeup.pawtify.models.RescueShelter;
import com.codeup.pawtify.models.User;
import com.codeup.pawtify.models.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.Collection;

@Controller
public class UserController {
    private UsersRepository userdao;
    private RescueShelterRepository rescuedao;
    private PasswordEncoder passwordEncoder;
    private Roles rolesRepo;

    public UserController(UsersRepository userdao, RescueShelterRepository rescuedao, PasswordEncoder passwordEncoder, Roles rolesRepo) {
        this.userdao = userdao;
        this.rescuedao = rescuedao;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepo = rolesRepo;
    }

    //########################################################## Potential Adopter Users ##########################################################
    //SHOW REGISTER NEW ADOPTER FORM
    @GetMapping("/register/adopter")
    public String showPASignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/potentialadopter/pa-register";
    }

    //Redirect Based off Role of the User that Logged In
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

    //ADD NEW POTENTIAL ADOPTER TO THE DB
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

    //LOGIN POTENTIAL ADOPTER
    @GetMapping("/login")
    public String showPALoginForm() {
        return "potentialadopter/pa-signin";
    }

    //If you click on Pawtification, this will redirect you and ask you to sign in
    @GetMapping("/redirect")
    public String redirection(){
        return "main/redirect";
    }

    //SHOW EDIT ADOPTER FORM
    @GetMapping("/adopter/edit")
    public String editAdopter(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userdao.findOne(user.getId()));
        return "/potentialadopter/pa-edit";
    }

    // UPDATE EXISTING ADOPTER INFORMATION
    @PostMapping("/adopter/edit")
    public String updateAdopter(@ModelAttribute User editUser){
        User e = userdao.findOne(editUser.getId());
        e.setFull_name(editUser.getFull_name());
        e.setPhone(editUser.getPhone());
        e.setUsername(editUser.getUsername());
        e.setEmail(editUser.getEmail());
        e.setPassword(passwordEncoder.encode(editUser.getPassword()));
        userdao.save(e);
        return "redirect:/pawtification/";
    }

    //########################################################## Rescue Shelter Users ##########################################################
    //Show Rescue Shelter User Affiliation Drop Down
    @GetMapping("/register/rescue-shelter")
    public String showRSAffiliationForm(Model model) {
        User user = new User();
        Iterable<RescueShelter> rescueshelters = rescuedao.findAll();
        model.addAttribute("user", user);
        model.addAttribute("rescueshelters", rescueshelters);
        return "/rescueshelter/rs-portal";
    }

    //Add New Rescue Shelter to the DB
    @PostMapping("/register/rescue-shelter")
    public String registerNewRSUser(@Valid User user, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute(user);
            return "rescueshelter/rs-portal";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userdao.save(user);
        rolesRepo.save(new UserRole(user.getId(), "ROLE_STAFF"));
        return "redirect:/login";
    }

    //Login Rescue Shelter
    @GetMapping("/shelter/login")
    public String showRSLoginForm() {
        return "/rescueshelter/rs-portal";
    }

    //Edit Form Show for Rescue Shelter
    @GetMapping("/rescue-shelter/edit")
    public String editStaff(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userdao.findOne(user.getId()));
        return "/rescueshelter/rs-edit";
    }

    //Update DB with Rescue Shelter Changed Information
    @PostMapping("/rescue-shelter/edit")
    public String updateRescueShelter(@ModelAttribute User editRescue){
        User r = userdao.findOne(editRescue.getId());
        r.setFull_name(editRescue.getFull_name());
        r.setPhone(editRescue.getPhone());
        r.setUsername(editRescue.getUsername());
        r.setEmail(editRescue.getEmail());
        r.setPassword(passwordEncoder.encode(editRescue.getPassword()));
        userdao.save(r);
        return "redirect:/animal/create";
    }
}