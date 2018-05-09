package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.AnimalRepository;
import com.codeup.pawtify.daos.CatBreedRepository;
import com.codeup.pawtify.daos.SearchRepository;
import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.CatBreed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilterController {
    private AnimalRepository animalDoa;
    private SearchRepository searchDao;
    private CatBreedRepository catDoa;

    public FilterController(AnimalRepository animalDoa, SearchRepository searchDao, CatBreedRepository catDoa) {
        this.animalDoa = animalDoa;
        this.searchDao = searchDao;
        this.catDoa = catDoa;
    }

    @GetMapping("/filter-animals")
    public String filterShelterAnimals(@RequestParam("search") String search, Model model){
        search = "%" +search+ "%";
        List<Animal> catBreed = animalDoa.findByCatBreedIsLike(search);
        model.addAttribute("catBreed", catBreed);
//        model.addAttribute("dogBreed", dogBreedLike);
        return "/main/search";
    }

}
