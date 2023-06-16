package co.edu.poli.usertaller1.controller;

import co.edu.poli.usertaller1.services.BarcoService;
import co.edu.poli.usertaller1.services.GameService;
import co.edu.poli.usertaller1.services.dto.BarcoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poli/api/v1")
public class BarcoController {
    private final BarcoService barcoService;
    private final GameService gameService;

    @PostMapping("/barco")
    public ResponseEntity<String> createBarco(@RequestBody BarcoDTO barcoDTO) {
        boolean created = barcoService.createBarco(barcoDTO);
        if (created) {
            return ResponseEntity.ok("Barco creado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el barco");
        }
    }

    @GetMapping("/game")
    public ResponseEntity<String> playGame(@RequestParam("coordinates") String coordinates) {
        boolean hit = gameService.checkCoordinates(coordinates);
        if (hit) {
            return ResponseEntity.ok("¡Encontraste el barco!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No has encontrado el barco. Sigue intentando.");
        }
    }
}
