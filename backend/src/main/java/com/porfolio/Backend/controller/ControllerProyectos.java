/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.controller;

import com.porfolio.Backend.model.Proyectos;
import com.porfolio.Backend.service.IProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

/**
 *
 * @author analia
 */
@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<?> editProyecto(@PathVariable Long id,
            @RequestBody Proyectos proyDetail) {

        Proyectos proy = proyServ.buscarProyectos(id);

        proy.setLink(proyDetail.getLink());
        proy.setImg(proyDetail.getImg());
        proy.setNombre(proyDetail.getNombre());
        proy.setDescripcion(proyDetail.getDescripcion());

        proyServ.crearProyecto(proy);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public Proyectos detalleProyecto(@PathVariable Long id){
        return proyServ.buscarProyectos(id);
    }
    
    
    
    
}
