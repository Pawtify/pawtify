package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.AnimalRepository;
import com.codeup.pawtify.daos.SearchRepository;
import com.codeup.pawtify.models.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilterController {
    private AnimalRepository animalDoa;
    private SearchRepository searchDao;

    public FilterController(AnimalRepository animalDoa, SearchRepository searchDao) {
        this.animalDoa = animalDoa;
        this.searchDao = searchDao;
    }

    @GetMapping("/filter-animals")
    public String filterShelterAnimals(@RequestParam("search") String search, Model model){
        search = "%" +search+ "%";
        Iterable<Animal> catBreedLike = searchDao.findByCatBreedLike(search);
        Iterable<Animal> dogBreedLike = searchDao.findByDogBreedLike(search);
        model.addAttribute("catBreed", catBreedLike);
        model.addAttribute("dogBreed", dogBreedLike);
        return "/main/index";
    }

}
