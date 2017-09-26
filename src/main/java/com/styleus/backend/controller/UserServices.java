package com.styleus.backend.controller;

import com.styleus.backend.models.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.security.acl.LastOwnerException;
import java.util.Date;
import java.util.HashMap;


@RestController
@RequestMapping(value ="/rest/user")
public class UserServices {


    @RequestMapping(value="/",method = RequestMethod.GET)
    public HashMap<Long,User> getAllUsers(){
        return Application.hmUser;
    }


    @RequestMapping(value="/registration",method = RequestMethod.POST)
    public User userRegistration(@RequestParam(value="name") String name,
                                 @RequestParam(value = "first_surname") String first_surname,
                                 @RequestParam(value = "date_of_birth") Date date_of_birth,
                                 @RequestParam(value = "gender") Boolean gender,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "privacity") Boolean privacity){

        User usuario = new User(name,first_surname,date_of_birth,email,password,privacity);
        Application.hmUser.put(new Long(usuario.getId()),usuario);
        return usuario;
    }



}
