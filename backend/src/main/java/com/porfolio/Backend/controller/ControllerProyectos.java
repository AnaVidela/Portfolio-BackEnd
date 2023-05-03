/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.controller;

import com.porfolio.Backend.model.Proyectos;
import com.porfolio.Backend.service.IProyectosService;
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

/**
 *
 * @author analia
 */
@RestController
@RequestMapping("/proyectos")
public class ControllerProyectos {
    
    @Autowired
    private IProyectosService proyServ;
    
    @PostMapping("/new")
    public void agregarProyecto(@RequestBody Proyectos proy) {
       proyServ.crearProyecto(proy);
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<Proyectos> verProyecto() {
        return proyServ.verProyectos();
    }

    @DeleteMapping("/delete/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proyServ.borrarProyectos(id);
    }

    @PutMapping("/editar/{id}")
    public Proyectos editProyectos(@PathVariable Long id,
            @RequestParam("link") String nuevoLink,
            @RequestParam("img") String nuevoImg,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("descripcion") String nuevoDescripcion) {

        Proyectos proy = proyServ.buscarProyectos(id);

        proy.setLink(nuevoLink);
        proy.setImg(nuevoImg);
        proy.setNombre(nuevoNombre);
        proy.setDescripcion(nuevoDescripcion);

        proyServ.crearProyecto(proy);

        return proy;
    }
    
    
    
    
}
