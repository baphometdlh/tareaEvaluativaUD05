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
@Table(name="grupo")
public class Grupo extends BaseEntity {

    @Column(name="nombre")
    private String nombre;

    @Column(name="pais")
    private String pais;

    @Column(name="ano_creacion")
    private int anoCreacion;

    @OneToMany (mappedBy = "idGrupo", cascade = CascadeType.ALL)
    List<Disco> disco = new ArrayList<>();

    public Grupo(String nombre, String pais, int anoCreacion){
        super();
        this.nombre = nombre;
        this.pais = pais;
        this.anoCreacion = anoCreacion;
    }

}
