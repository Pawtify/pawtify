package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.AnimalRepository;
import com.codeup.pawtify.daos.CatBreedRepository;
import com.codeup.pawtify.daos.DogBreedRepository;
import com.codeup.pawtify.daos.RescueShelterRepository;
import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.CatBreed;
import com.codeup.pawtify.models.DogBreed;
import com.codeup.pawtify.models.RescueShelter;
import com.codeup.pawtify.models.User;
import com.codeup.pawtify.services.UserService;
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
    private final RescueShelterRepository shelterDao;
    private final UserService userService;

    public AnimalController(AnimalRepository animalDoa, CatBreedRepository catDao, DogBreedRepository dogDao, RescueShelterRepository shelterDao, UserService userService){
        this.animalDoa = animalDoa;
        this.catDao = catDao;
        this.dogDao = dogDao;
        this.shelterDao = shelterDao;
        this.userService = userService;
    }

    //    Homepage
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("animals", animalDoa.findAll());
        return "/main/home";
    }


    //    About Page
    @GetMapping("/about")
    public String about(){
        return "/main/about";
    }



    //    Browse available animals for pa-users
    @GetMapping("/pets")
    public String availableAnimals(Model model){
        model.addAttribute("animals", animalDoa.findAll());
        return "/main/index";
    }

    @GetMapping("/animal/{id}")
    public String show(@PathVariable long id, Model model){
        Animal animal = animalDoa.findOne(id);
        model.addAttribute("shelterName", animal.getRescueshelter().getName());
        model.addAttribute("shelterAddress", animal.getRescueshelter().getAddress());
        model.addAttribute("shelterNumber", animal.getRescueshelter().getPhone());
        model.addAttribute("animal", animal);

        if(animal.getCatBreed() == null){
            model.addAttribute("dogBreed", animal.getDogBreed().getBreed());
        } else
            model.addAttribute("catBreed", animal.getCatBreed().getBreed());
        return "/main/show";
    }

    @GetMapping("/animal/create")
    public String create(Model model){
        Animal animal = new Animal();
        Iterable<CatBreed> catBreeds = catDao.findAll();
        Iterable<DogBreed> dogBreeds = dogDao.findAll();
        Iterable<RescueShelter> rescueshelters = shelterDao.findAll();
        User user = userService.loggedInUser();
        model.addAttribute("animals", animalDoa.findAnimalsByRescueshelterId(user.getShelter().getId()));
        model.addAttribute("rescueshelters", rescueshelters);
        model.addAttribute("catBreeds", catBreeds);
        model.addAttribute("dogBreeds", dogBreeds);
        model.addAttribute("animal", animal);
        return "rescueshelter/rs-form";
    }


    //        RS-Post new Animal w/ image method, can be refactored once working

//    @Value("/Users/lalepro/IdeaProjects/pawtify/target/classes/static/uploads")
    @Value("${file-upload-path}")
    private String uploadPath;
    @PostMapping("/animal/create")
    public String insert(@Valid Animal animal, Model model,
                         @RequestParam(name = "file") MultipartFile uploadedFile){
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            animal.setPath("/uploads/" + filename);
            animalDoa.save(animal);
            model.addAttribute("message", "File successfully uploaded!");


            return "redirect:/animal/create";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
        return ("redirect:/animal/create");
    }

//    RS-edit animal
    @GetMapping("/animal/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        Iterable<CatBreed> catBreeds = catDao.findAll();
        Iterable<DogBreed> dogBreeds = dogDao.findAll();
        model.addAttribute("catBreeds", catBreeds);
        model.addAttribute("dogBreeds", dogBreeds);

        model.addAttribute("editAnimal", animalDoa.findOne(id));
        model.addAttribute("path", animalDoa.findOne(id).getPath());
        System.out.println(animalDoa.findOne(id).getPath());
        return "rescueshelter/rs-animal-edit";
    }

    @PostMapping("/animal/edit")
    public String update(@ModelAttribute Animal editAnimal){
        Animal updateAnimal = animalDoa.findOne(editAnimal.getId());
        updateAnimal.setName(editAnimal.getName());
        updateAnimal.setAge(editAnimal.getAge());
        updateAnimal.setGender(editAnimal.getGender());
        updateAnimal.setSize(editAnimal.getSize());
        updateAnimal.setColor(editAnimal.getColor());
        updateAnimal.setBehavior(editAnimal.getBehavior());
        updateAnimal.setPath(editAnimal.getPath());
        updateAnimal.setCatBreed(editAnimal.getCatBreed());
        updateAnimal.setDogBreed(editAnimal.getDogBreed());
        animalDoa.save(updateAnimal);
        return "redirect:/animal/create";
    }

    @PostMapping("/animal/delete")
    public String deletePost(@ModelAttribute Animal animal){
        animalDoa.delete(animal);
        return "redirect:/animal/create";
    }


}