package com.styleus.backend.controller.dao;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.Notification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest/notification")
public class NotificationServices {

    @RequestMapping(value = "/addNotification", method = RequestMethod.POST)
    public Notification agregarNotificacion(@RequestParam (value = "id") Long id,
                                            @RequestParam (value = "sender_id") Long sender_id,
                                            @RequestParam (value = "receiver_id") Long receiver_id,
                                            @RequestParam (value = "reference_id") Long reference_id,
                                            @RequestParam (value = "status") Boolean status,
                                            @RequestParam (value = "body") String body,
                                            @RequestParam (value = "action_type") Long action_type){

        Notification notificaccion = new Notification(id,sender_id,receiver_id,reference_id,status,body,action_type);
        StyleUsBackendMain.hmNotification.put(notificaccion.getId(),notificaccion);
        return notificaccion;
    }

    @RequestMapping(value = "/getNotification", method = RequestMethod.GET)
    public HashMap<Long, Notification> mostrarNotificaciones(@RequestParam (value = "receiver_id") int receiver_id)throws Exception{

        boolean encontrado = false;

        HashMap <Long, Notification> notificaciones = new HashMap<Long, Notification>();

        for(Map.Entry<Long,Notification> temporal : StyleUsBackendMain.hmNotification.entrySet()){
            if(temporal.getValue().getReceiver_id().equals(new Long(receiver_id))){
                notificaciones.put(temporal.getValue().getId(),temporal.getValue());
                encontrado = true;
            }
        }

        if(encontrado)
            return notificaciones;
        else
            throw new Exception("Este usuario no tiene notificaciones");


    }



}
