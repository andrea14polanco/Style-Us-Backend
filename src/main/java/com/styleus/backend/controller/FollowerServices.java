package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.Followers;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/rest/followers")

public class FollowerServices {

    @RequestMapping(value="/addFollowers", method = RequestMethod.POST)

    public Followers mostrarFollower(@RequestParam(value = "id") Long id,
                                     @RequestParam(value = "users_id" ) Long users_id,
                                     @RequestParam(value = "state_id") Long state_id,
                                     @RequestParam(value = "FollowersStates_id") Long FollowersStates_id){

        Followers probando = new Followers(id,users_id,state_id,FollowersStates_id);

        StyleUsBackendMain.hmFollowers.put(probando.getId(),probando);
        return probando;
    }

    @RequestMapping(value="/cantidadFollowers", method = RequestMethod.GET)
    public int cantidadFollowes(@RequestParam(value = "users_id") Long users_id){

        int contador = 0;
        for(Map.Entry<Long, Followers> temporal: StyleUsBackendMain.hmFollowers.entrySet()){

            if(temporal.getValue().getUsers_id().equals(users_id)){
                contador++;

            }
        }
        return contador;
    }

    @RequestMapping(value="/quitarFollowers/{id}", method = RequestMethod.DELETE)
    public Followers quitarFollowers(@PathVariable int id) throws Exception{

        Followers borrado;
        if(StyleUsBackendMain.hmFollowers.containsKey(new Long(id))){
            borrado =(Followers) StyleUsBackendMain.hmFollowers.get(new Long(id));
            StyleUsBackendMain.hmFollowers.remove(new Long(id));
        }
        else
            throw new Exception("Follower "+id+" no encontrado");

        return borrado;
    }

}
