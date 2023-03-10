package com.carlosdiaz.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlosdiaz.agenda.models.Contacto;
import com.carlosdiaz.agenda.services.ContactoService;

@RestController
public class ContactoController {
    @Autowired
    ContactoService service;

    @GetMapping("/contactos")
    List<Contacto> all(){
        return service.findAll();
    }

    @GetMapping("/contactos/{id}")
    Contacto findContacto(@PathVariable int id){
        return service.findById(id);
    }

    @DeleteMapping("/contactos/{id}")
    void deleteContacto(@PathVariable int id){
        service.deleteById(id);
    }

    @PostMapping("/contactos")
    Contacto guardar(@RequestBody Contacto contacto){
        service.save(contacto);
        return contacto;
    }

    @PutMapping("/contactos/{id}")
    void modificar(@PathVariable int id, @RequestBody Contacto contacto){
        
        service.update(id, contacto);
    

    }


    

}