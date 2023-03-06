package com.example.RFForm;

import lombok.SneakyThrows;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramGetInboxRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramInboxResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramInboxThread;
import org.brunocvcunha.instagram4j.requests.payload.InstagramInboxThreadItem;

public class InstagramUploader {
    @SneakyThrows
    public void instagramAutoAns(){

        Instagram4j instagram = Instagram4j.builder().username("nurs__kanyb__").password("nurik987654").build();
        instagram.setup();
        instagram.login();

        InstagramInboxResult inboxResult = instagram.sendRequest(new InstagramGetInboxRequest());
        for (InstagramInboxThread instagramInboxThread : inboxResult.getInbox().getThreads()) {
            for (InstagramInboxThreadItem item : instagramInboxThread.getItems()) {
                System.out.println();
                System.out.println("By follower:"+item.user_id);
                System.out.println("The last message was :"+item.text);
                System.out.println();
            }

        }
    }
}

