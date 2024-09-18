package org.project.gestiontournoisjeuxvideo;

import org.project.gestiontournoisjeuxvideo.service.UserService;
import org.project.gestiontournoisjeuxvideo.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionTournoisJeuxVideoApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(GestionTournoisJeuxVideoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(userService.createUser("Charlotte", "Charlotte", "Charlotte@yopmail.com", Role.ADMIN) ==null){
            System.out.println("L'admin Charlotte existe déjà.");}
        userService.createUser("Charlotte", "Charlotte", "Charlotte@yopmail.com", Role.ADMIN);
    }


    }