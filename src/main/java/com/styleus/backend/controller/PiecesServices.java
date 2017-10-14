package com.styleus.backend.controller;
import java.util.Date;
import java.util.Map;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.Comments;
import com.styleus.backend.models.Pieces;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/piezas")
public class PiecesServices {



    @RequestMapping(value = "/addPieces", method = RequestMethod.POST)
    public Pieces agregarPieza(@RequestParam(value = "name") String name,
                               @RequestParam(value = "description") String description,
                               @RequestParam(value = "img_url") String img_url,
                               @RequestParam(value = "id") int id/*, //Ojo, los slash deben ser haci la derecha, asi /////, si se ponen asi \\\ no funciona.
                               @RequestParam(value = "create_at") Date create_at,
                               @RequestParam(value = "update_at") Date update_at,
                               @RequestParam(value = "delete_at") Date delete_at */
    ) {

        Pieces pieza = new Pieces(id, name, description, img_url);
        StyleUsBackendMain.hmPieces.put(pieza.getId(), pieza);
        return pieza;

    }
    //Filtrar por nombres

    //Ver todas las piezas de un usuario
    @RequestMapping(value = "getPiece", method = RequestMethod.GET)
    public Pieces mostrarPieza(@RequestParam(value = "id") int id) throws Exception{

        for(Map.Entry<Long,Pieces> temporal : StyleUsBackendMain.hmPieces.entrySet()){
            if(temporal.getValue().getId().equals(new Long(id))){
                return temporal.getValue();
            }
        }

        throw new Exception("El id "+id+" no se encuentra en la base de datos");
    }

    //ver una pieza

    //Eliminar una pieza
    @RequestMapping(value = "deletePiece/{id}", method= RequestMethod.DELETE)
    public Pieces eliminarPieza(@PathVariable int id) throws Exception{
        Pieces piezaBorrar;

        if(StyleUsBackendMain.hmPieces.containsKey(new Long(id))){
            piezaBorrar = StyleUsBackendMain.hmPieces.get(new Long(id));
            StyleUsBackendMain.hmPieces.remove(new Long(id));
        }
        else
            throw new Exception("El id "+id+" no se encuentra");

        return piezaBorrar;
    }

    //Editar pieza y comentario
    @RequestMapping(value = "/editPieces", method = RequestMethod.POST)
    public Pieces editarPieza(@RequestParam(value = "name") String name,
                               @RequestParam(value = "description") String description,
                               @RequestParam(value = "img_url") String img_url,
                               @RequestParam(value = "id") int id/*, //Ojo, los slash deben ser haci la derecha, asi /////, si se ponen asi \\\ no funciona.
                               @RequestParam(value = "create_at") Date create_at,
                               @RequestParam(value = "update_at") Date update_at,
                               @RequestParam(value = "delete_at") Date delete_at */
    ) throws Exception{

        if(StyleUsBackendMain.hmPieces.containsKey(new Long(id))){
            Pieces pieza = new Pieces(id, name, description, img_url);
            StyleUsBackendMain.hmPieces.put(pieza.getId(), pieza);
            return pieza;
        }
        else{
            throw new Exception("Esta pieza no se encuentra");
        }

    }



}
