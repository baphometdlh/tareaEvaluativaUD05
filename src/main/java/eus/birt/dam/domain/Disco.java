package eus.birt.dam.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="disco")
public class Disco extends BaseEntity{

    @Column(name="nombre")
    private String nombre;

    @Column(name="ano_publicacion")
    private int anoPublicacion;

    @ManyToOne
    @JoinColumn(name="id_grupo")
    private Grupo idGrupo;

    @ManyToOne
    @JoinColumn(name="id_estilo")
    private Estilo idEstilo;

    @Column(name="duracion")
    private int duracion;

}
