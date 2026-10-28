package com.example.demo.service;

import com.example.demo.model.Recurso;
import com.example.demo.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> obtenertodos (){
        return recursoRepository.findAll();
    }

    public Optional<Recurso> obtenerPorId(Long id){
        return recursoRepository.findById(id);
    }

    public Recurso crear(Recurso recurso){
        return recursoRepository.save(recurso);
    }

    public boolean eliminar (Long id){
        return recursoRepository.deleteById(id);
    }

    public Optional<Recurso> actualizar (Long id, Recurso recurso){
        return recursoRepository.findById(id).map(recursoExists ->{
            recursoExists.setTitulo(recurso.getTitulo());
            recursoExists.setCategoria(recurso.getCategoria());
            recursoExists.setTipo(recurso.getTipo());
            recursoExists.setUrl(recurso.getUrl());
            return recursoRepository.save(recursoExists);
        });
    }

    public Optional<Recurso> actualizarParcial (Long id, Recurso recurso){
        return recursoRepository.findById(id).map(recursoExists -> {
            if (recurso.getTitulo() != null) recursoExists.setTitulo(recurso.getTitulo());
            if(recurso.getCategoria() != null) recursoExists.setCategoria(recurso.getCategoria());
            if(recurso.getTipo() != null) recursoExists.setTipo(recurso.getTipo());
            if(recurso.getUrl() != null) recursoExists.setUrl(recurso.getUrl());
            return recursoRepository.save(recursoExists);
        });
    }

}
