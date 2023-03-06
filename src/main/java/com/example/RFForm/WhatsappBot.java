package com.example.RFForm;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Random;

public class WhatsappBot extends Thread {
    public static final String ACCOUNT_SID = "ACf883f7f9623ca3f03e01274a1495dbbe";
    public static final String AUTH_TOKEN = "0a67b20ce0978478c2c5dbbabf497d69";

    public void sendMessage(String messageValue) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+996509020253"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                messageValue
        ).create();

        System.out.println(message.getSid());
    }

    private String greetingPage() {
        String[] greet = {"Мы знакомы? Дээ шучу, Привет!", "Не верю своим глазам! Ты ли это бро?", "Мне кажется или я где-то вас видел?", "Какие люди нарисовались!", "Здравствуйте, товарищи!", "Давно не виделись, что я забыл черты твоего лица.", "Салют!", "Мое почтение!", "Вот ты и попался! Come here bro"};
        Random r = new Random();
        return greet[r.nextInt(greet.length)];
    }
}
