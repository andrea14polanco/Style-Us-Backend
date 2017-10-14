package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.Clothes;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/clothes")
public class ClothesServices {

    @RequestMapping(value = "/addClothes", method = RequestMethod.POST)
    public Clothes agregarConjunto(@RequestParam(value = "name") String name,
                               @RequestParam(value = "description") String description,
                               @RequestParam(value = "img_url") String img_url,
                               @RequestParam(value = "id") int id/*, //Ojo, los slash deben ser haci la derecha, asi /////, si se ponen asi \\\ no funciona.
                               @RequestParam(value = "create_at") Date create_at,
                               @RequestParam(value = "update_at") Date update_at,
                               @RequestParam(value = "delete_at") Date delete_at */
    ){

        Clothes conjunto = new Clothes(id, name, description, img_url);
        StyleUsBackendMain.hmClothes.put(conjunto.getId(), conjunto);
        return conjunto;

    }
    //Filtrar por nombres

    //Ver todas las piezas de un usuario
    @RequestMapping(value = "/getClothes", method = RequestMethod.GET)
    public Clothes mostrarConjunto(@RequestParam(value = "id") int id) throws Exception{

        for(Map.Entry<Long,Clothes> temporal : StyleUsBackendMain.hmClothes.entrySet()){
            if(temporal.getValue().getId().equals(new Long(id))){
                return temporal.getValue();
            }
        }

        throw new Exception("El id "+id+" no se encuentra en la base de datos");
    }

    //ver una pieza

    //Eliminar una pieza
    @RequestMapping(value = "deleteClothes/{id}", method= RequestMethod.DELETE)
    public Clothes eliminarPieza(@PathVariable int id) throws Exception{
        Clothes conjuntoBorrar;

        if(StyleUsBackendMain.hmClothes.containsKey(new Long(id))){
            conjuntoBorrar = StyleUsBackendMain.hmClothes.get(new Long(id));
            StyleUsBackendMain.hmClothes.remove(new Long(id));
        }
        else
            throw new Exception("El id "+id+" no se encuentra");

        return conjuntoBorrar;
    }

    //Editar pieza y comentario
    @RequestMapping(value = "/editClothes", method = RequestMethod.POST)
    public Clothes editarPieza(@RequestParam(value = "name") String name,
                              @RequestParam(value = "description") String description,
                              @RequestParam(value = "img_url") String img_url,
                              @RequestParam(value = "id") int id/*, //Ojo, los slash deben ser haci la derecha, asi /////, si se ponen asi \\\ no funciona.
                               @RequestParam(value = "create_at") Date create_at,
                               @RequestParam(value = "update_at") Date update_at,
                               @RequestParam(value = "delete_at") Date delete_at */
    ) throws Exception {

        if(StyleUsBackendMain.hmClothes.containsKey(new Long(id))){
            Clothes conjunto = new Clothes(id, name, description, img_url);
            StyleUsBackendMain.hmClothes.put(conjunto.getId(), conjunto);
            return conjunto;
        }
        else
            throw new Exception("Este conjunto no se encuentra en la base de datos");
    }

}
