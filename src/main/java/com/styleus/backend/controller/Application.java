
package com.styleus.backend.controller;

import com.styleus.backend.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Application {

    public static HashMap <Long, User> hmUser;

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat();
        Date dt = sdf.parse("10/10/200");

        hmUser = new HashMap<Long, User>();


        User uno = new User("miguel1","Oviedo",dt,true, "adeury@gmail.com","12345",false);

        hmUser.put(new Long(uno.getId()),uno);

        SpringApplication.run(Application.class, args);

        User dos = new User("dos","Oviedo",dt,true, "adeury@gmail.com","12345",false);
        hmUser.put(new Long(dos.getId()),dos);


    }


}
