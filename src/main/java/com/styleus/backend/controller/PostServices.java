package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import org.springframework.web.bind.annotation.*;
import com.styleus.backend.models.User;
import com.styleus.backend.models.Post;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/rest/post")
public class PostServices {

    @RequestMapping(value = "/getAllPost", method = RequestMethod.GET)
    public HashMap<Long,Post> mostrarTodos(){
        return StyleUsBackendMain.hmPost;
    }

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



    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public Post agregarPost(@RequestParam(value="id") int id,
                            @RequestParam(value="body") String body,
                            @RequestParam(value="likes_count") int likes_count,
                            @RequestParam(value = "comments_count") int comments_count,
                            @RequestParam(value = "photo_type") String photo_type,
                            @RequestParam(value = "user_id") Long user_id,
                            @RequestParam(value = "actionstate_id") int actionstate_id,
                            @RequestParam(value = "clothe_id") int clothe_id){

        Post addPost = new Post(id,body,likes_count,comments_count,photo_type,user_id,actionstate_id,clothe_id);
        StyleUsBackendMain.hmPost.put(addPost.getId(),addPost);

        return addPost;


    }


    @RequestMapping(value = "/deletePost/{id}", method = RequestMethod.DELETE)
    public Post agregarPost(@PathVariable int id)throws Exception{
        Post postEliminado;
         if(StyleUsBackendMain.hmPost.containsKey(new Long(id))){
             postEliminado = (Post) StyleUsBackendMain.hmPost.get(new Long(id));
             StyleUsBackendMain.hmPost.remove(new Long(id));
         }
         else{
             throw new Exception("El usuario "+id+" no se encuentra");
         }

         return  postEliminado;

    }

}
