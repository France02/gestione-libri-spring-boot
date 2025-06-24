package it.lamialibreria.gestione_libri.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il titolo non può essere vuoto")
    @Size(min = 2, max = 100, message = "il titolo deve essere tra i 2 e 100 caratteri")
    private String titolo;

    @NotBlank(message = "l'autore non può essere vuoto")
    private String autore;
    
    private String isbn;

}