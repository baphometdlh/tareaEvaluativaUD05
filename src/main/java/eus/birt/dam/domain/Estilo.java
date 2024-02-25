package eus.birt.dam.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="estilo")
public class Estilo extends BaseEntity{

    @Column(name="nombre")
    private String nombre;

    @Column(name="pais_creacion")
    private String paisCreacion;

    @OneToMany(mappedBy = "idEstilo", cascade = CascadeType.ALL)
    List<Disco> disco = new ArrayList<>();

    public Estilo(String nombre, String paisCreacion){
        super();
        this.nombre = nombre;
        this.paisCreacion = paisCreacion;
    }

}
