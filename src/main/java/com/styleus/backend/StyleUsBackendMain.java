package com.styleus.backend;

import com.styleus.backend.models.Post;
import com.styleus.backend.models.Like;
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
    public static HashMap<Long, Post> hmPost;
    public static HashMap<Long, Like> hmLike;

    public static void main(String[] args) {

        hmUser = new HashMap<Long, User>();
        hmPost = new HashMap<Long, Post>();
        hmLike = new HashMap<Long, Like>();


        SimpleDateFormat sdf = new SimpleDateFormat();
        //Date dt = sdf.parse("10/10/200");

        User uno = new User((long) 1,"miguel1","Oviedo",true, "adeury@gmail.com","12345",false);
        hmUser.put(uno.getId(),uno);

        User dos = new User((long)2,"dos","Oviedo",true, "adeury@gmail.com","12345",false);
        hmUser.put(dos.getId(),dos);

        Post post1 = new Post(1,"Este es el cuerpo del post",5,0,"C:\\Users\\Adeury\\IdeaProjects\\Style-Us-Backend\\img\\imagen1",uno.getId(),1,1);
        hmPost.put(post1.getId(),post1);

        SpringApplication.run(StyleUsBackendMain.class, args);
    }
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StyleUsBackendMain.class);
	}

}
