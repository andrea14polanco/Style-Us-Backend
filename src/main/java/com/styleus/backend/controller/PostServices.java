package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.styleus.backend.models.User;
import com.styleus.backend.models.Post;

import java.util.Map;

@RestController
@RequestMapping(value="/rest/post")
public class PostServices {


    @RequestMapping(value="/postUsuario", method = RequestMethod.POST)
    public Post mostrarUltimoPost(@RequestParam(value="email")String email){
        Post publicacion=null;
        User usuario = null;

        for(Map.Entry<Long,User> temporalU:StyleUsBackendMain.hmUser.entrySet()){
            if(temporalU.getValue().getEmail().equals(email)){
                //idUser=temporalU.getKey();
                usuario=temporalU.getValue();
                break;
            }
        }

        for(Map.Entry<Long,Post> temporalP:StyleUsBackendMain.hmPost.entrySet()){
            if(temporalP.getValue().getUser_id().equals(usuario.getId())){
                publicacion= temporalP.getValue();
            }
        }

        return  publicacion;



    }

}
