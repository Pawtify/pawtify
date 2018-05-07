package com.codeup.pawtify.services;

import com.codeup.pawtify.daos.AnimalRepository;
import com.codeup.pawtify.daos.PawtificationRepository;
import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.Pawtification;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class PawtificationService extends TwilioService {
    private PawtificationRepository pawDao;
    private AnimalRepository animalDao;

    public PawtificationService(PawtificationRepository pawDao, AnimalRepository animalDao) {
        this.pawDao = pawDao;
        this.animalDao = animalDao;
    }
    public Message matchPawtificationAndAnimals(Pawtification paw) {
        Animal animal = (Animal) animalDao.findAll();
        if ((paw.getCatBreed() == animal.getCatBreed()) && (paw.getGender() == animal.getGender()) && (paw.getAge() == animal.getAge()) && (paw.getColor() == animal.getColor()) && (paw.getSize() == animal.getSize())) {
            return sendSMS(paw.getUser()); //change method from String to Method
        }
        return null; //only send/use this method if there is a match, when does this message run? every time a pawtification is created
    }
}
//test