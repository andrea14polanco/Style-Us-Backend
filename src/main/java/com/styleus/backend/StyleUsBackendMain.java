package com.styleus.backend;

import com.styleus.backend.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.text.SimpleDateFormat;
import java.util.HashMap;

@SpringBootApplication
public class StyleUsBackendMain  extends SpringBootServletInitializer{

    public static HashMap<Long, User> hmUser;

    public static void main(String[] args) {

        hmUser = new HashMap<Long, User>();

        SimpleDateFormat sdf = new SimpleDateFormat();
        //Date dt = sdf.parse("10/10/200");

        User uno = new User("miguel1","Oviedo",true, "adeury@gmail.com","12345",false);
        hmUser.put(new Long(uno.getId()),uno);

        User dos = new User("dos","Oviedo",true, "adeury@gmail.com","12345",false);
        hmUser.put(new Long(dos.getId()),dos);

        SpringApplication.run(StyleUsBackendMain.class, args);
    }
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StyleUsBackendMain.class);
	}

}
