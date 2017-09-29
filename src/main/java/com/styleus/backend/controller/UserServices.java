package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value ="/rest/user")
public class UserServices {


    @RequestMapping(value="/",method = RequestMethod.GET)
    public HashMap<Long,User> getAllUsers(){
        return StyleUsBackendMain.hmUser;
    }


    @RequestMapping(value="/registration",method = RequestMethod.POST)
    public User userRegistration(@RequestParam(value="name") String name,
                                 @RequestParam(value = "first_surname") String first_surname,
                                 //@RequestParam(value = "date_of_birth") Date date_of_birth,
                                 @RequestParam(value = "gender") Boolean gender,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "privacity") Boolean privacity){

        User usuario = new User(name,first_surname,/*date_of_birth,*/gender,email,password,privacity);
        StyleUsBackendMain.hmUser.put(new Long(usuario.getId()),usuario);
        //Application.hmUser.put(new Long(usuario.getId()),usuario);
        return usuario;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@RequestParam(value="email") String email,
                          @RequestParam(value = "password") String password){
        boolean encontrado = false;
        Integer contador =0;


        for (Map.Entry<Long, User> temporal: StyleUsBackendMain.hmUser.entrySet()){
                 if(temporal.getValue().getEmail().equals(email) && temporal.getValue().getPassword().equals(password)) {
                     encontrado = true;
                     break;
                 }
                 else
                     encontrado=false;
                 contador++;

        }

        if(encontrado)
            return "Entro";
        else
            return "Usuario incorrecto";





    }



}
