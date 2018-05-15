package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.AnimalRepository;
import com.codeup.pawtify.models.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilterController {
    private AnimalRepository animalDao;

    public FilterController(AnimalRepository animalDao) {
        this.animalDao = animalDao;
    }

    @GetMapping("/filter-animals")
    public String filterShelterAnimals(@RequestParam("search") String search, Model model){
        search = "%" +search+ "%";
        List<Animal> animals = animalDao.findByCatBreed_BreedIsLike(search);
        for (Animal animal: animals) {
            if(animal.equals(" ")){
                System.out.println("No Animal " + animal);
            }else {
                System.out.println("Animal name !!!!!!!!!!!!!!!!!!!!!!" + animal.getName());
                System.out.println("No Animal" + animal + ' ');
            }
        }
        model.addAttribute("animals", animals);

        return "main/search";
    }
}