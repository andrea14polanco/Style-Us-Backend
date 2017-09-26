
package com.styleus.backend.controller;

import com.styleus.backend.models.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

public class Application {

    public static HashMap <Long, User> hmUser = new HashMap<Long, User>();


}
