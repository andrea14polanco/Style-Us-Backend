package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.Comments;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest/comments")
public class CommentServices {

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public Comments agregarComentario(@RequestParam(value = "id") int id,
                                      @RequestParam(value = "post_id") int post_id,
                                      @RequestParam(value = "user_id") int user_id,
                                      @RequestParam(value = "comment_body") String comment_body,
                                      @RequestParam(value = "actionstate_id") int actionstate_id,
                                      @RequestParam(value = "comment_id") int comment_id/*,
                                      @RequestParam(value = "created_at")Date created_at,
                                      @RequestParam(value = "updated_at")Date updated_at,
                                      @RequestParam(value = "deleted_at")Date deleted_at*/
    ) {

        Comments comentario = new Comments(id, post_id, user_id, comment_body, actionstate_id, comment_id);
        StyleUsBackendMain.hmComments.put(comentario.getId(), comentario);
        return comentario;


    }

    @RequestMapping(value = "/Comment", method = RequestMethod.POST)
    public Comments buscarComentario(@RequestParam(value = "id") int id) throws Exception{
        
        boolean encontro = false;
        Comments comentar = null;
        
        

        for(Map.Entry<Long,Comments> temporal : StyleUsBackendMain.hmComments.entrySet()){
            if(temporal.getValue().getId().equals(new Long(id))){
                comentar=temporal.getValue();
                encontro = true;
                break;
            }
        }
        
        if(encontro)
            return comentar;
        else 
           throw new Exception("El comentario del id "+id+" no se encontro");
        
 


    }

    @RequestMapping(value = "/allCommentToPostId", method = RequestMethod.POST)
    public HashMap <Long, Comments> todosLosComentarios(@RequestParam(value = "post_id") int post_id) throws Exception{

        boolean encontro = false;
        HashMap <Long, Comments> comentarios = new HashMap<Long, Comments>();




        for(Map.Entry<Long,Comments> temporal : StyleUsBackendMain.hmComments.entrySet()){
            if(temporal.getValue().getPost_id().equals(new Long(post_id))){
                comentarios.put(temporal.getValue().getId(),temporal.getValue());
                encontro = true;
            }
        }

        if(encontro)
            return comentarios;
        else
            throw new Exception("No se encuentran comentarios con el post_id "+post_id);

    }

    @RequestMapping(value = "/countCommentToPostId", method = RequestMethod.POST)
    public long contarComentarios(@RequestParam(value = "post_id") int post_id) throws Exception{

        boolean encontro = false;
        long contador=0;




        for(Map.Entry<Long,Comments> temporal : StyleUsBackendMain.hmComments.entrySet()){
            if(temporal.getValue().getPost_id().equals(new Long(post_id))){
                contador++;
                encontro = true;
            }
        }

        if(encontro)
            return contador;
        else
            throw new Exception("El post_id "+post_id+" no tiene comentarios");

    }

    @RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.DELETE)
    public Comments borrarComentario(@PathVariable int id) throws Exception{

        boolean encontro = false;
        Comments borrado = null;




        for(Map.Entry<Long,Comments> temporal : StyleUsBackendMain.hmComments.entrySet()){
            if(temporal.getValue().getId().equals(new Long(id))){
                borrado=temporal.getValue();
                StyleUsBackendMain.hmComments.remove(temporal.getValue().getId());
                encontro = true;
                break;
            }
        }

        if(encontro)
            return borrado;
        else
            throw new Exception("El id "+id+" no se encuentra");

    }


}