package it.lamialibreria.gestione_libri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.lamialibreria.gestione_libri.domain.Libro;
import it.lamialibreria.gestione_libri.repository.LibroRepository;

@RestController
@RequestMapping("/api/v1/libri")
public class LibroController {
    
    private final LibroRepository libroRepository;

    @Autowired
    public LibroController(LibroRepository libroRepository){
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public List<Libro> getAllLibri(){
        return libroRepository.findAll();
    }
}
