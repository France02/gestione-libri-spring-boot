package it.lamialibreria.gestione_libri;

import it.lamialibreria.gestione_libri.domain.Libro;
import it.lamialibreria.gestione_libri.repository.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GestioneLibriApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestioneLibriApplication.class, args);
    }

    // Questo metodo verrà eseguito da Spring all'avvio dell'applicazione
    @Bean
    public CommandLineRunner commandLineRunner(LibroRepository repository) {
        return args -> {
            // Creiamo un paio di libri di esempio
            Libro libro1 = new Libro(null, "Il Signore degli Anelli", "J.R.R. Tolkien", "978-8845279289");
            Libro libro2 = new Libro(null, "Lo Hobbit", "J.R.R. Tolkien", "978-8845274451");

            // Li salviamo nel database usando il nostro repository
            repository.saveAll(List.of(libro1, libro2));
            System.out.println(">>> Dati di prova inseriti!");
        };
    }
}