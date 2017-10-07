package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.User;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String userLogin2(@RequestParam(value="email") String email){
        boolean encontrado = false;


        for (Map.Entry<Long, User> temporal: StyleUsBackendMain.hmUser.entrySet()){
            if(temporal.getValue().getEmail().equals(email)) {
                encontrado = true;
                break;
            }
            else
                encontrado=false;

        }

        if(encontrado)
            return "Su enlace a sido enviado a su correo, si esta"; //Para mandar el link para rrecuperar contraseña
        else
            return "Su enlace a sido enviado a su correo, no esta";//Para mandar el link a un nuevo usuario que no esta registrado

    }




    @RequestMapping(value="/newPassword", method = RequestMethod.PUT)
    public String updatePassword2(@RequestParam(value="email") String email, @RequestParam(value="newPassword") String newPassword,
                                  @RequestParam(value="confirmPassword") String confirmPassword){
        for(Map.Entry<Long, User> temporal: StyleUsBackendMain.hmUser.entrySet()){
            if(temporal.getValue().getEmail().equals(email)){
                if(newPassword.equals(confirmPassword)){
                    StyleUsBackendMain.hmUser.get(temporal.getKey()).setPassword(newPassword);
                    return "Su clave fue actualizada";
                }
                else {
                    return "Las claves no son iguales";
                }
            }
            else
                return "Este usuario no esta registrado";
        }
        return "Error";
    }






}
