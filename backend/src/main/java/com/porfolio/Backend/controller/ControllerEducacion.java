/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.controller;

import com.porfolio.Backend.model.Educacion;
import com.porfolio.Backend.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
public class ControllerEducacion {
    
    @Autowired
    private IEducacionService educServ;
    
    @PostMapping("/new")
    public void agregarEducacion(@RequestBody Educacion educ) {
       educServ.crearEduc(educ);
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return educServ.verEducacion();
    }

    @DeleteMapping("/delete/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        educServ.borrarEduc(id);
    }

    @PutMapping("/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id,
            @RequestParam("link") String nuevoLink,
            @RequestParam("img") String nuevoImg,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("descripcion") String nuevoDescripcion) {

        Educacion educ = educServ.buscarEduc(id);

        educ.setLink(nuevoLink);
        educ.setImg(nuevoImg);
        educ.setNombre(nuevoNombre);
        educ.setDescripcion(nuevoDescripcion);

        educServ.crearEduc(educ);

        return educ;
    }
    
    
    
    
}
