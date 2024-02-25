package eus.birt.dam.controller;

import eus.birt.dam.domain.Disco;
import eus.birt.dam.domain.Grupo;
import eus.birt.dam.repository.DiscoRepository;
import eus.birt.dam.repository.EstiloRepository;
import eus.birt.dam.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    DiscoRepository discoRepository;

    @Autowired
    EstiloRepository estiloRepository;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        grupoRepository.deleteById(id);
        return "redirect:/grupo";
    }

    @GetMapping("/edit/{id}")
    public String initEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("grupo", grupoRepository.findById(id));
        return "grupoForm";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        Grupo grupo = new Grupo();
        model.addAttribute("grupo", grupo);
        return "grupoForm";
    }

    @PostMapping("/new/submit")
    public String processCreationForm(@ModelAttribute Grupo grupo) {
        grupoRepository.save(grupo);
        return "redirect:/grupo";
    }

    @GetMapping("/bandAlbums/{id}")
    public String getBandAlbum(@PathVariable("id") Integer id, Model model) throws NoSuchFieldException {
        Grupo grupo = grupoRepository.findById(id).orElseThrow(() -> new NoSuchFieldException("no existe banda"));
        model.addAttribute("grupo", grupo);
        return "discoGrupoForm";
    }

    @GetMapping("/bandAlbum/new/{id}")
    public String agregarAlbum(@PathVariable("id") Integer id, Model model) {
        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Grupo no encontrado"));
        Disco disco = new Disco();
        model.addAttribute("grupos", grupo);
        model.addAttribute("disco", disco);
        model.addAttribute("estilos", estiloRepository.findAll());
        return "discoNewGrupoForm";
    }

    @PostMapping("/newAlbum/submit")
    public String processCreationForm(@ModelAttribute Disco disco) {
        discoRepository.save(disco);
        return "redirect:/grupo";
    }


}
