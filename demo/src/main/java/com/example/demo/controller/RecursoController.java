package com.example.demo.controller;

import com.example.demo.model.Recurso;
import com.example.demo.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> lista(){
        return recursoService.obtenertodos();
    }

    @GetMapping("/{id}")
    public Optional<Recurso>listarPorId(@PathVariable Long id){
        return recursoService.obtenerPorId(id);
    }

    @PostMapping
    public Recurso crear(@RequestBody Recurso recurso){
        return recursoService.crear(recurso);
    }

    @PutMapping("/{id}")
    public Optional<Recurso> actualizar (@PathVariable Long id, @RequestBody Recurso recurso){
        return recursoService.actualizar(id, recurso);
    }

    @PatchMapping("/{id]")
    public Optional<Recurso> actualizarParcial (@PathVariable Long id, @RequestBody Recurso recurso){
        return recursoService.actualizar(id, recurso);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Long id){
        recursoService.eliminar(id);
    }

}
