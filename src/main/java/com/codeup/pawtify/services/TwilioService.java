//package com.codeup.pawtify.services;
//
//import com.codeup.pawtify.models.Pawtification;
//import com.codeup.pawtify.models.User;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.rest.api.v2010.account.MessageCreator;
//import com.twilio.rest.lookups.v1.PhoneNumber;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServlet;
//import java.text.ParseException;
//
//@Service
//public class TwilioService extends HttpServlet {
//    private String twiliosid = "ACcdf7ce35f8d546df26cc502263850156";
//    private String twiliotoken = "661e59735feab0ac177e61be6315dcf5";
//    private String twilionumber = "8304200317";
//
//    public String sendSMS(Pawtification pawtification, User user) throws ParseException {
//        Twilio.init(this.twiliosid, this.twiliotoken);
//
//        PhoneNumber phoneNumberTo = new PhoneNumber(user.getPhone());
//        PhoneNumber phoneNumberFrom = new PhoneNumber(twilionumber);
//
//        //what do we want in the message??
////        String animalName = String.valueOf(pawtification.getCatBreed());
//
//        Message message = null;
//        MessageCreator creator = Message.creator(phoneNumberTo, phoneNumberFrom, pawtification.getUser())
//    }
//}
