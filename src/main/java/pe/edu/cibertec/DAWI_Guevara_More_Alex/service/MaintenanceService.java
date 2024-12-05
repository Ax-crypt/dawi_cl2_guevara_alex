package pe.edu.cibertec.DAWI_Guevara_More_Alex.service;

import jakarta.persistence.Cacheable;
import pe.edu.cibertec.DAWI_Guevara_More_Alex.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_Guevara_More_Alex.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean registerFilm(FilmDetailDto filmDetailDto);

    Boolean deleteFilm(int id);


}
