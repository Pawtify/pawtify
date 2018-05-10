package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.*;
import com.codeup.pawtify.models.*;
import com.codeup.pawtify.services.AnimalService;
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
    private final AnimalRepository animalDao;
    private final CatBreedRepository catDao;
    private final DogBreedRepository dogDao;
    private final UsersRepository userDao;
    private final UserService userService;
    private final PawtificationService pawService;
    private final AnimalService animalService;

    public PawtificationController(PawtificationRepository pawDao, AnimalRepository animalDao, CatBreedRepository catDao, DogBreedRepository dogDao, UsersRepository userDao, UserService userService, PawtificationService pawService, AnimalService animalService){
        this.pawDao = pawDao;
        this.animalDao = animalDao;
        this.catDao = catDao;
        this.dogDao = dogDao;
        this.userDao = userDao;
        this.userService = userService;
        this.pawService = pawService;
        this.animalService = animalService;
    }

    //set up to create new pawtification--ORIGINAL
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

    //    Create a pawtification
    @PostMapping("/pawtification")
    public String pawtify(@Valid Pawtification pawtification){
        User user = userService.loggedInUser();
        pawtification.setUser(user);
        pawDao.save(pawtification);
        pawService.checkPawtificationtoDB(pawtification);
        return "redirect:/pawtification";
    }

//    TODO: EDIT Pawtification

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

    @PostMapping("/pawtification/edit")
    public String update(@ModelAttribute Pawtification editPawtify){
        pawDao.save(editPawtify);
        pawService.checkPawtificationtoDB(editPawtify);
        return "redirect:/pawtification";
    }

    @PostMapping("pawtification/delete")
    public String deletePawtify(@ModelAttribute Pawtification pawtification){
        pawDao.delete(pawtification);
        return "redirect:/pawtification";
    }

    @GetMapping("/matches/{matchId}/paw")
    public String showMatch(@PathVariable long matchId, Model model) {
        Pawtification pawtification = pawDao.findOne(matchId);
        System.out.println(matchId);
//        pawService.showAnimalsThatMatched(pawtification);

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