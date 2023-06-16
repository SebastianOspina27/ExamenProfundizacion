package co.edu.poli.usertaller1.services;

import co.edu.poli.usertaller1.persistence.entity.Barco;
import co.edu.poli.usertaller1.persistence.repository.BarcoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final BarcoRepository barcoRepository;

    public boolean checkCoordinates(String coordinates) {
        Barco barco = barcoRepository.findAll().stream().findFirst().orElse(null);
        if (barco != null && barco.getCoordinates().equals(coordinates)) {
            return true;
        } else {
            return false;
        }
    }
}
