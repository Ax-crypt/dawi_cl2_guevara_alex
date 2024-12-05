package pe.edu.cibertec.DAWI_Guevara_More_Alex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.cibertec.DAWI_Guevara_More_Alex.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_Guevara_More_Alex.dto.FilmDto;
import pe.edu.cibertec.DAWI_Guevara_More_Alex.entity.Language;
import pe.edu.cibertec.DAWI_Guevara_More_Alex.repository.LanguageRepository;
import pe.edu.cibertec.DAWI_Guevara_More_Alex.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @Autowired
    LanguageRepository languageRepository;

    @GetMapping("/start")
    public String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_detail";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_edit";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/new-film")
    public String newFilm(Model model) {
        List<Language> languages = languageRepository.findAll();
        model.addAttribute("languages", languages);
        model.addAttribute("film", new FilmDetailDto(null, null, null, null, null, null, null, null, null, null, null, null, null));
        return "maintenance_create";
    }

    @PostMapping("/register-film")
    public String registerFilm(@ModelAttribute FilmDetailDto filmDetailDto) {
        maintenanceService.registerFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }


    @PostMapping("/remove/{id}")
    public String remove(@PathVariable Integer id, Model model) {
        boolean success = maintenanceService.deleteFilm(id);
        System.out.println("Eliminando " + id);
        if (success) {
            return "redirect:/maintenance/start";
        } else {
            return "redirect:/maintenance/start";        }
    }

}
