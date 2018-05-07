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
//
//
//    Show one animal for pa-users
    @GetMapping("/animal/{id}")
    public String show(@PathVariable long id, Model model){
        Animal animal = animalDoa.findOne(id);
        CatBreed catBreed = catDao.findOne(id);
        DogBreed dogBreed = dogDao.findOne(id);
        RescueShelter rescueShelter = shelterDao.findOne(id);

        String dogbreedToString = dogBreed.getBreed();
        String catBreedToString = catBreed.getBreed();
        String shelterNameToString = rescueShelter.getName();
        String shelteraddressToString = rescueShelter.getAddress();
        String shelterPhoneNumberToString = rescueShelter.getPhone();

        model.addAttribute("catBreed", catBreedToString);
        model.addAttribute("dogBreed", dogbreedToString);
        model.addAttribute("shelterName", shelterNameToString);
        model.addAttribute("shelterAddress", shelteraddressToString);
        model.addAttribute("shelterNumber", shelterPhoneNumberToString);
        model.addAttribute("animal", animal);
        return "/main/show";
    }
//
////    RS-create a animal

    @GetMapping("/animal/create")
    public String create(Model model){
        Animal animal = new Animal();
        Iterable<CatBreed> catBreeds = catDao.findAll();
        Iterable<DogBreed> dogBreeds = dogDao.findAll();

//        CatBreed catBreedEdit = catBreeds.
//        DogBreed dogBreedEdit = dogDao.findOne(id);

//        String catEdit = catBreeds.toString();
//        String dogEdit = dogBreeds.toString();

        model.addAttribute("catBreeds", catBreeds);
        model.addAttribute("dogBreeds", dogBreeds);
        model.addAttribute("animal", animal);
//        model.addAttribute("catEdit", catEdit);
//        model.addAttribute("dogEdit", dogEdit);
        model.addAttribute("animals", animalDoa.findAll());
        return "rescueshelter/rs-form";
        }


//TODO: Animals Create For STAFF (Getting CODE LOOPY)
//        RS-Post new Animal w/ image method, can be refactored once working
//    @Value("${file-upload-path}")
    @Value("/Users/lalepro/IdeaProjects/pawtify/target/classes/static/uploads")
    private String uploadPath;
    @PostMapping("/animal/create")
    public String insert(@Valid Animal animal, Errors errors, Model model,
                         @RequestParam(name = "file") MultipartFile uploadedFile){
//        if (animal.getBehavior().contains(" ")) {
//            errors.rejectValue("behavior", "Empty", "Must fill out Animal behavior ");
//        }
//        if(animal.getName().contains(" ")){
//            errors.rejectValue("No Name", "Empty", "Enter a Nam");
//        }
//        {
            String filename = uploadedFile.getOriginalFilename();
            String filepath = Paths.get(uploadPath, filename).toString();
            File destinationFile = new File(filepath);
            try {
                 uploadedFile.transferTo(destinationFile);
                User user = userService.loggedInUser();
//            RescueShelter rescueShelter = rescueShelterDao.loggedInUser();
//            animal.setRescueshelter(rescueShelter);
//                animal.setDogBreed(dogBreed);
//                animal.setCatBreed(catBreed);
                animal.setPath("/uploads" + filename);
                animalDoa.save(animal);
                model.addAttribute("message", "File successfully uploaded!");
                return "redirect:/animal/create";
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Oops! Something went wrong! " + e);
            }
            return ("redirect:/animal/create");
//        }
    }

//    Used for rs-form to display all animals in db by that rescue shelter
    @GetMapping("/rescueshelter/animals/{id}")
    public String rescueAnimals(@PathVariable long id, Model model){
        Animal animal = animalDoa.findOne(id);
//        model.addAttribute("isAnimalOwner", resueShelterService.isLoggedInAndAnimalMatchesUser(animal.getRescueshelter()));
        model.addAttribute("animals", animal);
        return "/rescueshelter/rs-form";
    }
//
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

//    TODO: Throwing Get Method Errors for Deleting
//    @GetMapping("/animal/{id}/delete")
//    public String confirmDelete(@PathVariable long id, Model model){
//        model.addAttribute("animal", animalDoa.findOne(id));
//        return "rescueshelter/rs-form";
//    }

    @PostMapping("/animal/delete")
    public String deletePost(@ModelAttribute Animal animal){
        animalDoa.delete(animal);
        return "redirect:/animal/create";
    }


}
