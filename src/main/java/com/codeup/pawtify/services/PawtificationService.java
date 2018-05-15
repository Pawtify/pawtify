package com.codeup.pawtify.services;

import com.codeup.pawtify.daos.AnimalRepository;
import com.codeup.pawtify.daos.PawtificationRepository;
import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.Pawtification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PawtificationService extends TwilioService {
    private PawtificationRepository pawDao;
    private AnimalRepository animalDao;

    public PawtificationService(PawtificationRepository pawDao, AnimalRepository animalDao) {
        this.pawDao = pawDao;
        this.animalDao = animalDao;
    }

    //Checks the Pawtification fields to a list of all the animals in the Animals table in the database, then sends the a text message if a match is found
    public void checkPawtificationtoDB(Pawtification pawtification) {
        List<Animal> animalList;
        System.out.println(pawtification.getDogBreed());
        if(pawtification.getDogBreed() != null) {
            animalList = animalDao.findAllByAgeAndSizeAndColorAndGenderAndDogBreed(pawtification.getAge(), pawtification.getSize(), pawtification.getColor(), pawtification.getGender(), pawtification.getDogBreed());
        } else {
            animalList = animalDao.findAllByAgeAndSizeAndColorAndGenderAndCatBreed(pawtification.getAge(), pawtification.getSize(), pawtification.getColor(), pawtification.getGender(), pawtification.getCatBreed());
        }
        for (Animal animal : animalList) {
            System.out.println(animal.getColor());
            sendSMS(pawtification.getUser());
        }
    }

    //Returns any animals that are matched when the Pawtification criteria is check so that the adopter can view their matches.
    public Animal showAnimalsThatMatched(Pawtification pawtification) {
        List<Animal> animalList;
        System.out.println(pawtification.getDogBreed());
        if(pawtification.getDogBreed() != null) {
            animalList = animalDao.findAllByAgeAndSizeAndColorAndGenderAndDogBreed(pawtification.getAge(), pawtification.getSize(), pawtification.getColor(), pawtification.getGender(), pawtification.getDogBreed());
        } else {
            animalList = animalDao.findAllByAgeAndSizeAndColorAndGenderAndCatBreed(pawtification.getAge(), pawtification.getSize(), pawtification.getColor(), pawtification.getGender(), pawtification.getCatBreed());
        }
        for (Animal animal : animalList) {
            return animal;
        }
        return null;
    }
}