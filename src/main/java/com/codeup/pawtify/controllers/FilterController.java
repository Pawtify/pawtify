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
    private AnimalRepository animalDao;
    private SearchRepository searchDao;
    private CatBreedRepository catDoa;

    public FilterController(AnimalRepository animalDao, SearchRepository searchDao, CatBreedRepository catDoa) {
        this.animalDao = animalDao;
        this.searchDao = searchDao;
        this.catDoa = catDoa;
    }

    @GetMapping("/filter-animals")
    public String filterShelterAnimals(@RequestParam("search") String search, Model model){
        search = "%" +search+ "%";
        List<Animal> animals = animalDao.findByCatBreed_BreedIsLike(search);
//        List<Animal> animals1 = animalDao.findByDogBreed_BreedIsLike(search);

        for (Animal animal: animals) {

            System.out.println("Animal name !!!!!!!!!!!!!!!!!!!!!!" + animal.getName());

        }

        model.addAttribute("animals", animals);
//        model.addAttribute("animals", animals1);
//        model.addAttribute("dogBreed", dogBreedLike);
        return "main/search";
    }

}
