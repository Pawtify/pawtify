package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.AnimalRepository;
import com.codeup.pawtify.daos.PawtificationRepository;
import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.Pawtification;
import com.codeup.pawtify.services.PawtificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TwilioController {
    private PawtificationService pawtificationService;
    private AnimalRepository animalDao;
    private PawtificationRepository pawtificationDao;

    public TwilioController(PawtificationService pawtificationService, AnimalRepository animalDao, PawtificationRepository pawtificationDao) {
        this.pawtificationService = pawtificationService;
        this.animalDao = animalDao;
        this.pawtificationDao = pawtificationDao;
    }

    @GetMapping("/notify")
    public String whateverGet() {
        return "/potentialadopter/pawtification";
    }

    @PostMapping("/notify")
    public String whateverPost(Pawtification pawtification, Animal animal) {
        pawtificationService.matchPawtificationAndAnimals(pawtification, animal);
        return "redirect:/pawtifcation";
    }
}
