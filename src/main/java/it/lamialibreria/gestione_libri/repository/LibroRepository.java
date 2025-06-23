package it.lamialibreria.gestione_libri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.lamialibreria.gestione_libri.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    
}
