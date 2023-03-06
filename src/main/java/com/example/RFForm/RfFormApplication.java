package com.example.RFForm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


@SpringBootApplication
//@EnableScheduling

public class RfFormApplication {
    public static void main(String[] args) {
        SpringApplication.run(RfFormApplication.class, args);

        InstagramUploader instagramUploader = new InstagramUploader();
        instagramUploader.instagramAutoAns();
    }

}
