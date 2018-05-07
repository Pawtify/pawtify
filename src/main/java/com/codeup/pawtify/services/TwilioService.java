//package com.codeup.pawtify.services;
//
//import com.codeup.pawtify.models.User;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class TwilioService {
//
//    private String twiliosid = "ACcdf7ce35f8d546df26cc502263850156";
//    private String twiliotoken = "661e59735feab0ac177e61be6315dcf5";
//    private String twilionumber = "8304200317";
//
//    //in case we can send customized messages
//    public String customMessage() {
//        return null;
//    }
//
//    public Message sendSMS(User user) {
//        Twilio.init(this.twiliosid, this.twiliotoken);
//
//        PhoneNumber phoneNumberTo = new PhoneNumber(user.getPhone());
//        PhoneNumber phoneNumberFrom = new PhoneNumber(twilionumber);
//
//        Message message = Message.creator(phoneNumberTo, phoneNumberFrom, "You've received a Pawtification Match! Click the link to meet your match: " + mediaURL()).create();
//
//        return message;
//    } //can this return void?
//}