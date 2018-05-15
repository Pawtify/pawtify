package com.codeup.pawtify.services;

import com.codeup.pawtify.daos.PawtificationRepository;
import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.Pawtification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService extends TwilioService{
    private PawtificationRepository pawDao;

    public AnimalService(PawtificationRepository pawDao) {
        this.pawDao = pawDao;
    }

    //Checks the animals entered into the database to the list of Pawtifications that are stored in the Pawtifications table of the database, then sends the a text message if a match is found
    public void checkAnimalToDB(Animal animal) {
        List<Pawtification> pawtificationList;
        System.out.println(animal.getDogBreed());
        if(animal.getDogBreed() != null) {
            pawtificationList = pawDao.findAllByAgeAndSizeAndColorAndGenderAndDogBreed(animal.getAge(), animal.getSize(), animal.getColor(), animal.getGender(), animal.getDogBreed());
        } else {
            pawtificationList = pawDao.findAllByAgeAndSizeAndColorAndGenderAndCatBreed(animal.getAge(), animal.getSize(), animal.getColor(), animal.getGender(), animal.getCatBreed());
        }
        System.out.println(animal.getColor());
        for (Pawtification pawtification : pawtificationList) {
            System.out.println(pawtification.getAge());
            sendSMS(pawtification.getUser());
        }
    }
}