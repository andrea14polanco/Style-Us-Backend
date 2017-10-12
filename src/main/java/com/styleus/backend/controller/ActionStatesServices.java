package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.ActionStates;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/rest/ActionState")

public class ActionStatesServices {

        @RequestMapping(value = "/Action", method = RequestMethod.POST)
        public String accion(@RequestParam(value = "id") int id, //este es el id de la accion a recivir, actualmente solo hay 2
                             @RequestParam (value = "name") String name) throws Exception{
            String accion = "";
            Boolean encontrada = false;

            for (Map.Entry<Long,ActionStates> temporal : StyleUsBackendMain.hmActionStates.entrySet()){
                if(temporal.getValue().getId().equals(new Long(id))){
                    encontrada=true;
                    accion = name+""+temporal.getValue().getDescription();
                }
            }


            if(encontrada)
                return  accion;
            else
                throw new Exception("Accion "+id+" no encontrda");

        }



}
