package com.styleus.backend.controllers;

import com.styleus.backend.dao.UserDao;
import com.styleus.backend.models.User;
import com.styleus.backend.utils.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserDao userDao;
    @Autowired
    private EmailManager emailManager;

    @RequestMapping(value = "/newUser/", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        System.out.println("Creating User : {" + user.toString() + "+}");
        User currentUser = userDao.findByUsername(user.getUsername());

        if (currentUser != null) {
            return new ResponseEntity("Usuario " + currentUser.getId() + " existe", HttpStatus.CONFLICT);
        }
        System.out.println("LLego aqui?");
        user.setUpdated_at(new Date());
        userDao.save(user);

        return new ResponseEntity("Usuario agregado", HttpStatus.OK);
    }

    @RequestMapping(value = "/getUser/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {
        User currentUser = userDao.findByUsername(username);
        System.out.println(username + " " + currentUser.toString());
        if (currentUser != null) {
            return new ResponseEntity("Usuario " + username + " existe", HttpStatus.OK);
        }

        return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ResponseEntity<?> forgotPassword(@RequestBody User user) throws Exception {
        System.out.println(user);
        User currentUser = userDao.findByEmail(user.getEmail());
        // User currentUserr = userDao.findByUsername(user);
        System.out.println(user + " " + currentUser);
        if (currentUser != null) {
            emailManager.sendEmail(user.getEmail(), "klk menor", "Prueba de correor");
            return new ResponseEntity("Usuario " + user.getEmail() + " existe", HttpStatus.OK);
        } else {
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public ResponseEntity<?> resetPassword(@RequestParam(value = "email") String email, @RequestParam(value = "newPassword") String newPassword,
                                           @RequestParam(value = "confirmPassword") String confirmPassword) throws Exception {
        User currentUser = userDao.findByEmail(email.trim()+"");
        System.out.println(email);
        System.out.println(currentUser);
        if(currentUser != null){
            if(confirmPassword.equals(newPassword))
            {
                currentUser.setPassword(confirmPassword);
                userDao.save(currentUser);
            }else{
                return  new ResponseEntity("Contraseña diferentes", HttpStatus.CONFLICT);
            }
        }

        return new ResponseEntity("Usuario no existe", HttpStatus.NO_CONTENT);
    }
}
