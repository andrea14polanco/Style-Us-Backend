package com.styleus.backend.controller;

import com.styleus.backend.StyleUsBackendMain;
import com.styleus.backend.models.Tags;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;

@RestController
@RequestMapping (value = "/rest/tags")

public class TagServices {

    @RequestMapping(value = "/addTags", method = RequestMethod.POST)
    public Tags agregarTags(@RequestParam(value = "id") int id,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "description") String description){

        Tags tag = new Tags(id,name,description);
        StyleUsBackendMain.hmTags.put(tag.getName(),tag);
        return tag;
    }

    @RequestMapping(value = "getTag", method = RequestMethod.GET)
    public Tags buscarTag(@RequestParam(value = "name") String name) throws Exception {

        if (StyleUsBackendMain.hmTags.containsKey(name)){
            return StyleUsBackendMain.hmTags.get(name);
        }
        else {
            throw new Exception("El tag "+name+" no esta registrado");
        }
    }
}
