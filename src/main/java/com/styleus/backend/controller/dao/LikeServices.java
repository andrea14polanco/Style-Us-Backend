package com.styleus.backend.controller.dao;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.Like;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping(value="/rest/like")

public class LikeServices {

    @RequestMapping(value="/like", method = RequestMethod.POST)

    public Like mostrarLike(@RequestParam(value = "id") Long id,
                            @RequestParam(value = "actionstate_id" ) Long actionstate_id,
                            @RequestParam(value = "users_id") Long users_id,
                            @RequestParam(value = "posts_id") Long posts_id){

        Like probando = new Like(id,actionstate_id,users_id,posts_id);

        StyleUsBackendMain.hmLike.put(probando.getId(),probando);
        return probando;
    }

    @RequestMapping(value="/cantidadLike", method = RequestMethod.POST)
    public int cantidadLike(@RequestParam(value = "posts_id") Long posts_id){

        int contador = 0;
        for(Map.Entry<Long,Like>temporal: StyleUsBackendMain.hmLike.entrySet()){

            if(temporal.getValue().getPosts_id().equals(posts_id)){
                contador++;

            }
        }
        return contador;
    }

    @RequestMapping(value="/quitarLike", method = RequestMethod.POST)
    public Like quitarLike(@RequestParam(value = "posts_id") Long posts_id){

        Like borrado=null;
        for(Map.Entry<Long,Like>temporal: StyleUsBackendMain.hmLike.entrySet()){

            if(temporal.getValue().getPosts_id().equals(posts_id)){
                borrado=temporal.getValue();
                StyleUsBackendMain.hmLike.remove(temporal.getKey());


            }
        }
        return borrado;
    }
}

