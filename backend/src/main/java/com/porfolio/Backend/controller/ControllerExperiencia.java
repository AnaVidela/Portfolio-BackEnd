/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.controller;

import com.porfolio.Backend.model.Experiencia;
import com.porfolio.Backend.service.IExperienciaService;
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

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerExperiencia {
    
    @Autowired
    private IExperienciaService expServ;
    
    @PostMapping("/new")
    public void agregarExperiencia(@RequestBody Experiencia exp){
        expServ.crearExperiencia(exp);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia () {
        return expServ.verExperiencia();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        expServ.borrarExperiencia(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editExperiencia(@PathVariable Long id,
            @RequestBody Experiencia expDetail) {

        Experiencia exp = expServ.buscarExperiencia(id);

        exp.setImg(expDetail.getImg());
        exp.setNombre(expDetail.getNombre());
        exp.setDescripcion(expDetail.getDescripcion());

        expServ.crearExperiencia(exp);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public Experiencia detalleEducacion(@PathVariable Long id){
        return expServ.buscarExperiencia(id);
    }
    
}
