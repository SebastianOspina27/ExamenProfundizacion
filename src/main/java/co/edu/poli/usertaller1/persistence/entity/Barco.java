package co.edu.poli.usertaller1.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "barcos")
public class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_barco")
    private Long idBarco;

    @Column(name = "coordinates", length = 30)
    private String coordinates;
}
