/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.controller;

import com.porfolio.Backend.model.Persona;
import com.porfolio.Backend.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://portfolio-front-analia.web.app/")
public class ControllerPersona {

    @Autowired
    private IPersonaService persoServ;

    
    @GetMapping("/ver")
    @ResponseBody
    public List<Persona> verPersona() {
        return persoServ.verPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void agregarPersona(@RequestBody Persona per) {
        persoServ.crearPersona(per);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id) {
        persoServ.borrarPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editPersona(@PathVariable Long id,
            @RequestBody Persona perDetail) {

        Persona per = persoServ.buscarPersona(id);
        
        per.setLink(perDetail.getLink());
        per.setImg(perDetail.getImg());
        per.setNombre(perDetail.getNombre());
        per.setDescripcion(perDetail.getDescripcion());

        persoServ.crearPersona(per);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public Persona detalleEducacion(@PathVariable Long id){
        return persoServ.buscarPersona(id);
    }
   
}
