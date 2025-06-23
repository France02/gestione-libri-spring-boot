package it.lamialibreria.gestione_libri.controller;

import it.lamialibreria.gestione_libri.domain.Libro;
import it.lamialibreria.gestione_libri.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/libri")
public class LibroController {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // --- READ ---
    @GetMapping
    public List<Libro> getAllLibri() {
        return libroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    // --- CREATE ---
    @PostMapping
    public Libro createLibro(@RequestBody Libro nuovoLibro) {
        return libroRepository.save(nuovoLibro);
    }

    // --- UPDATE ---
    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libroAggiornato) {
        return libroRepository.findById(id)
                .map(libroEsistente -> {
                    libroEsistente.setTitolo(libroAggiornato.getTitolo());
                    libroEsistente.setAutore(libroAggiornato.getAutore());
                    libroEsistente.setIsbn(libroAggiornato.getIsbn());
                    Libro salvato = libroRepository.save(libroEsistente);
                    return ResponseEntity.ok(salvato);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // --- DELETE ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}