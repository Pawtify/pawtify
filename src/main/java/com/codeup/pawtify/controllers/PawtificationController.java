package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.CatBreedRepository;
import com.codeup.pawtify.daos.DogBreedRepository;
import com.codeup.pawtify.daos.PawtificationRepository;
import com.codeup.pawtify.daos.UsersRepository;
import com.codeup.pawtify.models.CatBreed;
import com.codeup.pawtify.models.DogBreed;
import com.codeup.pawtify.models.Pawtification;
import com.codeup.pawtify.models.User;
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
    private final UsersRepository userDao;
    private final UserService userService;
    private final PawtificationService pawService;

    public PawtificationController(PawtificationRepository pawDao, CatBreedRepository catDao, DogBreedRepository dogDao, UsersRepository userDao, UserService userService, PawtificationService pawService){
        this.pawDao = pawDao;
        this.catDao = catDao;
        this.dogDao = dogDao;
        this.userDao = userDao;
        this.userService = userService;
        this.pawService = pawService;
    }

    //set up to create new pawtification--ORIGINAL
    @GetMapping("/pawtification")
    public String create( Model model){
        Pawtification pawtification = new Pawtification();
//        Pawtification myPawtify = userService.isLoggedInAndAnimalMatchesRS(user);
        Iterable<CatBreed> catBreeds = catDao.findAll();
        Iterable<DogBreed> dogBreeds = dogDao.findAll();
        model.addAttribute("catBreeds", catBreeds);
        model.addAttribute("dogBreeds", dogBreeds);
        model.addAttribute("pawtification", pawtification);
        model.addAttribute("pawtifications", pawDao.findAll());
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



    //TODO; display pawtifications Users have made.
//    This will allow PawUser to see there displayed choices on their Paw Page
    @GetMapping("/pawtification/{id}")
    public String pawtifyChoice(@PathVariable long id, Model model){
        Pawtification pawtify = pawDao.findOne(id);
//        model.addAttribute("isPawtifyOwner", userService.isLoggedInAndPostMatchesUser(pawtify.getUser()));
        model.addAttribute("pawtifications", pawtify);
        return "/potentialadopter/pawtification";
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
        Pawtification paw = pawDao.findOne(editPawtify.getId());
        paw.setAge(editPawtify.getAge());
        paw.setGender(editPawtify.getGender());
        paw.setColor(editPawtify.getGender());
        paw.setCatBreed(editPawtify.getCatBreed());
        paw.setDogBreed(editPawtify.getDogBreed());
        pawDao.save(paw);
//        pawService.matchPawtificationAndAnimals(editPawtify);
        return "redirect:/pawtification";
    }

    @PostMapping("pawtification/delete")
    public String deletePawtify(@ModelAttribute Pawtification pawtification){
        pawDao.delete(pawtification);
        return "redirect:/pawtification";
    }
}