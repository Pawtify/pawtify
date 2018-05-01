package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.AnimalRepository;
import com.codeup.pawtify.daos.CatBreedRepository;
import com.codeup.pawtify.daos.DogBreedRepository;
import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.CatBreed;
import com.codeup.pawtify.models.DogBreed;
import com.codeup.pawtify.models.RescueShelter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class AnimalController {
 private final AnimalRepository animalDoa;
 private final CatBreedRepository catDao;
 private final DogBreedRepository dogDao;

    public AnimalController(AnimalRepository animalDoa, CatBreedRepository catDao, DogBreedRepository dogDao){
        this.animalDoa = animalDoa;
        this.catDao = catDao;
        this.dogDao = dogDao;
    }

//    Homepage
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("animals", animalDoa.findAll());
        return "/main/home";
    }
//
////    Browse available animals for pa-users
//    @GetMapping("/available/pets")
//    public String availableAnimals(Model model){
//        model.addAttribute("animals", animalDoa.findAll());
//        return "main/index";
//    }
//
//
////    Show one animal for pa-users
//    @GetMapping("/pet/{id}")
//    public String show(@PathVariable long id, Model model){
//        model.addAttribute("animal", animalDoa.findOne(id));
//        return "/main/show";
//    }
//
////    RS-create a animal
//
//    @GetMapping("/animal/create")
//    public String create(Model model){
//        Animal animal = new Animal();
//        Iterable<CatBreed> catBreeds = catDao.findAll();
//        Iterable<DogBreed> dogBreeds = dogDao.findAll();
//
//        model.addAttribute("catBreed", catBreeds);
//        model.addAttribute("dogBreed", dogBreeds);
//        model.addAttribute("animal", animal);
//        return "rescueshelter/rs-form";
//        }
//
//
////        RS-Post new Animal w/ image method, can be refactored once working
//    @Value("${file-upload-path}")
//    private String uploadPath;
//    @PostMapping("/animals/create")
//    public String insert(@Valid Animal animal, Errors errors, Model model, @RequestParam(name = "file") MultipartFile uploadedFile){
//        if(animal.getName().contains("noname")){
//            errors.rejectValue("name", "no-name", "Animal must have a real name");
//        }
//        String filename = uploadedFile.getOriginalFilename();
//        String filepath = Paths.get(uploadPath, filename).toString();
//        File destinationFile = new File(filepath);
//        try{
//            uploadedFile.transferTo(destinationFile);
////            RescueShelter rescueShelter = rescueShelterDao.loggedInUser();
////            animal.setRescueshelter(rescueShelter);
//            animal.setPath("/uploads" + filename);
//            animalDoa.save(animal);
//            model.addAttribute("message", "File successfully uploaded!");
//        return "redirect:/rescueshelter/rs-form";
//        } catch (IOException e){
//            e.printStackTrace();
//            model.addAttribute("message", "Oops! Something went wrong! " + e);
//        }
//        return ("redirect:/rescueshelter/rs-form");
//    }
//
////    Used for rs-form to display all animals in db by that rescue shelter
//    @GetMapping("/rescueshelter/animals/{id}")
//    public String rescueAnimals(@PathVariable long id, Model model){
////        Animal animal = animalDoa.findOne(id);
////        model.addAttribute("isAnimalOwner", resueShelterService.isLoggedInAndAnimalMatchesUser(animal.getRescueshelter()));
//        model.addAttribute("animals", animalDoa.findAll());
//        return "/rescueshelter/rs-form";
//    }
//
////    RS-edit animal
//    @GetMapping("/animal/{id}/edit")
//    public String edit(@PathVariable long id, Model model){
//        model.addAttribute("editAnimal", animalDoa.findOne(id));
//        model.addAttribute("path", animalDoa.findOne(id).getPath());
//        System.out.println(animalDoa.findOne(id).getPath());
//        return "rescueshelter/rs-form";
//    }
//
//    @PostMapping("/posts/edit")
//    public String update(@ModelAttribute Animal editAnimal){
//        Animal e = animalDoa.findOne(editAnimal.getId());
//        e.setName(editAnimal.getName());
//        e.setAge(editAnimal.getAge());
//        e.setGender(editAnimal.getGender());
//        e.setSize(editAnimal.getSize());
//        e.setColor(editAnimal.getColor());
//        e.setBehavior(editAnimal.getBehavior());
//        e.setPath(editAnimal.getPath());
//        e.setCatBreed(editAnimal.getCatBreed());
//        e.setDogBreed(editAnimal.getDogBreed());
//        animalDoa.save(e);
//        return "redirect:/rescueshelter/rs-form";
//    }
//
//    @GetMapping("/animal/{id}/confirm-delete")
//    public String confirmDelete(@PathVariable long id, Model model){
//        model.addAttribute("animal", animalDoa.findOne(id));
//        return "rescueshelter/rs-form";
//    }
//
//    @PostMapping("/animal/{id}/delete")
//    public String deletePost(@PathVariable long id){
//        animalDoa.delete(id);
//        return "redirect:/rescueshelter/rs-form";
//    }


}
