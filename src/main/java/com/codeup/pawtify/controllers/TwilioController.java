package com.codeup.pawtify.controllers;

import com.codeup.pawtify.daos.PawtificationRepository;
import com.codeup.pawtify.daos.UsersRepository;
import com.codeup.pawtify.services.TwilioService;
import org.springframework.stereotype.Controller;

@Controller
public class TwilioController {
    private TwilioService twilioSvc;
    private PawtificationRepository pawtificationRepository;
    private UsersRepository usersRepository;

    public TwilioController(TwilioService twilioSvc, PawtificationRepository pawtificationRepository, UsersRepository usersRepository) {
        this.twilioSvc = twilioSvc;
        this.pawtificationRepository = pawtificationRepository;
        this.usersRepository = usersRepository;
    }
}
