package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.CatBreedRepository;
import com.codeup.pawtify.daos.DogBreedRepository;
import com.codeup.pawtify.daos.PawtificationRepository;
import com.codeup.pawtify.daos.UsersRepository;
import com.codeup.pawtify.models.CatBreed;
import com.codeup.pawtify.models.DogBreed;
import com.codeup.pawtify.models.Pawtification;
import com.codeup.pawtify.models.User;
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

    public PawtificationController(PawtificationRepository pawDao, CatBreedRepository catDao, DogBreedRepository dogDao, UsersRepository userDao, UserService userService){
        this.pawDao = pawDao;
        this.catDao = catDao;
        this.dogDao = dogDao;
        this.userDao = userDao;
        this.userService = userService;
    }

 //set up to create new pawtification

    @GetMapping("/pawtification")
    public String create(Model model){
        Pawtification pawtification = new Pawtification();
        Iterable<CatBreed> catBreeds = catDao.findAll();
        Iterable<DogBreed> dogBreeds = dogDao.findAll();
        model.addAttribute("catBreeds", catBreeds);
        model.addAttribute("dogBreeds", dogBreeds);
        model.addAttribute("pawtification", pawtification);
        return "/potentialadopter/pawtification";
    }
//
//    Create a pawtification
    @PostMapping("/pawtification")
    public String pawtify(@Valid Pawtification pawtification, DogBreed dogBreed, CatBreed catBreed, Model model){
        User user = userService.loggedInUser();
        pawtification.setDogBreed(dogBreed);
        pawtification.setCatBreed(catBreed);
        pawtification.setUser(user);
        pawDao.save(pawtification);
        return "potentialadopter/pawtification";
    }



////    This will allow PawUser to see there displayed choices on their Paw Page
//    @GetMapping("/pawtification/{id}")
//    public String pawtifyChoice(@PathVariable long id, Model model){
//        Pawtification pawtify = pawDao.findOne(id);
//        model.addAttribute("isPawtifyOwner", userService.isLoggedInAndPostMatchesUser(pawtify.getUser()));
//        model.addAttribute("pawtify", pawDao.findOne(id));
//        return "/potentialadopter/pawtification";
//    }

    @GetMapping("pawtification/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("editPawtify", pawDao.findOne(id));
        return "potentialadopter/pawtification";
    }

    @PostMapping("/pawtification/edit")
    public String update(@ModelAttribute Pawtification editPawtification){
        Pawtification paw = pawDao.findOne(editPawtification.getId());
        paw.setAge(editPawtification.getAge());
        paw.setGender(editPawtification.getGender());
        paw.setColor(editPawtification.getGender());
        paw.setCatBreed(editPawtification.getCatBreed());
        paw.setDogBreed(editPawtification.getDogBreed());
        pawDao.save(paw);
        return "redirect:/potentialadopter/pawtification";
    }

    @GetMapping("pawtification/{id}/confirm-delete")
    public String confirmDelete(@PathVariable long id, Model model){
        model.addAttribute("pawtify", pawDao.findOne(id));
        return "redirect:/potentialadopter/pawtification";
    }

    @PostMapping("posts/{id}/delete")
    public String deletePawtify(@PathVariable long id){
        pawDao.delete(id);
        return "redirect:/potentialadopter/pawtifcation";
    }


}
