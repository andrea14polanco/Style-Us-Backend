package com.styleus.backend.controller;


import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.Like;
import com.styleus.backend.models.Post;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping(value="/rest/like")

public class LikeServices {

    @RequestMapping(value="/addLike", method = RequestMethod.POST)

    public Like mostrarLike(@RequestParam(value = "id") Long id,
                            @RequestParam(value = "actionstate_id" ) Long actionstate_id,
                            @RequestParam(value = "users_id") Long users_id,
                            @RequestParam(value = "posts_id") Long posts_id){

        Like probando = new Like(id,actionstate_id,users_id,posts_id);

        StyleUsBackendMain.hmLike.put(probando.getId(),probando);
        return probando;
    }

    @RequestMapping(value="/cantidadLike", method = RequestMethod.GET)
    public int cantidadLike(@RequestParam(value = "posts_id") Long posts_id){

        int contador = 0;
        for(Map.Entry<Long,Like>temporal: StyleUsBackendMain.hmLike.entrySet()){

            if(temporal.getValue().getPosts_id().equals(posts_id)){
                contador++;

            }
        }
        return contador;
    }


    @RequestMapping(value="/quitarLike/{id}", method = RequestMethod.DELETE)
    public Like quitarLike(@PathVariable int id) throws Exception{

        Like borrado;
        if(StyleUsBackendMain.hmLike.containsKey(new Long(id))){
            borrado=(Like) StyleUsBackendMain.hmLike.get(new Long(id));
            StyleUsBackendMain.hmLike.remove(new Long(id));
        }
        else
            throw new Exception("Like "+id+" no encontrado");

        return borrado;
    }


}
