    package co.edu.poli.usertaller1.services;

    import co.edu.poli.usertaller1.persistence.entity.Barco;
    import co.edu.poli.usertaller1.persistence.repository.BarcoRepository;
    import co.edu.poli.usertaller1.services.dto.BarcoDTO;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class BarcoService {
        private final BarcoRepository barcoRepository;

        public boolean createBarco(BarcoDTO barcoDTO) {
            try {
                Barco barco = new Barco();
                barco.setCoordinates(barcoDTO.getCoordinates());
                barcoRepository.save(barco);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
