package com.codeup.pawtify;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioTest {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACcdf7ce35f8d546df26cc502263850156";
    public static final String AUTH_TOKEN = "661e59735feab0ac177e61be6315dcf5";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("3059008059"),
                new PhoneNumber("8304200317 "),
                "Pawtify is the best! Laura is awesome!").create();

        System.out.println(message.getSid());
    }
}
