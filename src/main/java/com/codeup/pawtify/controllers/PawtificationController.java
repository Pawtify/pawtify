package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.*;
import com.codeup.pawtify.models.*;
import com.codeup.pawtify.services.PawtificationService;
import com.codeup.pawtify.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PawtificationController {
    private final PawtificationRepository pawDao;
    private final CatBreedRepository catDao;
    private final DogBreedRepository dogDao;
    private final UserService userService;
    private final PawtificationService pawService;

    public PawtificationController(PawtificationRepository pawDao, CatBreedRepository catDao, DogBreedRepository dogDao, UserService userService, PawtificationService pawService){
        this.pawDao = pawDao;
        this.catDao = catDao;
        this.dogDao = dogDao;
        this.userService = userService;
        this.pawService = pawService;
    }

    // SHOW CREATE PAWTIFICATION FORM
    @GetMapping("/pawtification")
    public String create( Model model){
        Pawtification pawtification = new Pawtification();
        Iterable<CatBreed> catBreeds = catDao.findAll();
        Iterable<DogBreed> dogBreeds = dogDao.findAll();
        User user = userService.loggedInUser();
        model.addAttribute("pawtifications", pawDao.findPawtificationByUserId(user.getId()));
        model.addAttribute("catBreeds", catBreeds);
        model.addAttribute("dogBreeds", dogBreeds);
        model.addAttribute("pawtification", pawtification);
        return "/potentialadopter/pawtification";
    }

    // ADD NEW PAWTIFICATION TO DB
    @PostMapping("/pawtification")
    public String pawtify(@Valid Pawtification pawtification){
        User user = userService.loggedInUser();
        pawtification.setUser(user);
        pawDao.save(pawtification);
        pawService.checkPawtificationtoDB(pawtification);
        return "redirect:/pawtification";
    }

    //SHOW EDIT EXISTING PAWTIFICATION FORM
    @GetMapping("/pawtification/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        Iterable<CatBreed> catBreeds = catDao.findAll();
        Iterable<DogBreed> dogBreeds = dogDao.findAll();
        model.addAttribute("catBreeds", catBreeds);
        model.addAttribute("dogBreeds", dogBreeds);
        model.addAttribute("editPawtify", pawDao.findOne(id));
        System.out.println(pawDao.findOne(id));
        return "/potentialadopter/pawtification-edit";
    }

    // UPDATE EDITED PAWTIFICATION IN DB
    @PostMapping("/pawtification/edit")
    public String update(@ModelAttribute Pawtification editPawtify){
        pawDao.save(editPawtify);
        pawService.checkPawtificationtoDB(editPawtify);
        return "redirect:/pawtification";
    }

    // DELETE EXISTING PAWTIFICATION
    @PostMapping("pawtification/delete")
    public String deletePawtify(@ModelAttribute Pawtification pawtification){
        pawDao.delete(pawtification);
        return "redirect:/pawtification";
    }

    // SHOW PAWTIFICATION-ANIMAL MATCH PAGE
    @GetMapping("/matches/{matchId}/paw")
    public String showMatch(@PathVariable long matchId, Model model) {
        Pawtification pawtification = pawDao.findOne(matchId);
        System.out.println(matchId);
        model.addAttribute("shelterName", pawService.showAnimalsThatMatched(pawtification).getRescueshelter().getName());
        model.addAttribute("shelterAddress", pawService.showAnimalsThatMatched(pawtification).getRescueshelter().getAddress());
        model.addAttribute("shelterNumber", pawService.showAnimalsThatMatched(pawtification).getRescueshelter().getPhone());
        model.addAttribute("animal", pawService.showAnimalsThatMatched(pawtification));
        if(pawService.showAnimalsThatMatched(pawtification).getCatBreed() == null){
            model.addAttribute("dogBreed", pawService.showAnimalsThatMatched(pawtification).getDogBreed().getBreed());
        } else
            model.addAttribute("catBreed", pawService.showAnimalsThatMatched(pawtification).getCatBreed().getBreed());
        return "/potentialadopter/match";
    }
}