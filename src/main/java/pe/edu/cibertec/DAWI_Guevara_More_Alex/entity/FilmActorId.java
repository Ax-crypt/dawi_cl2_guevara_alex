package pe.edu.cibertec.DAWI_Guevara_More_Alex.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class FilmActorId {
    private Integer filmId;
    private Integer actorId;
}
