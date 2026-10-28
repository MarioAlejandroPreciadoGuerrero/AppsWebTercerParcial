package com.example.pokemonApi.Service;

import com.example.pokemonApi.Model.Pokemon;
import com.example.pokemonApi.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    Pokemon obtenerPorId (Long id){
        pokemonRepository.findById(Long id);
    }
}
