package eus.birt.dam.controller;

import eus.birt.dam.domain.Disco;
import eus.birt.dam.domain.Estilo;
import eus.birt.dam.repository.DiscoRepository;
import eus.birt.dam.repository.EstiloRepository;
import eus.birt.dam.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/discos")
public class DiscoController {

    @Autowired
    DiscoRepository discoRepository;

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    EstiloRepository estiloRepository;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        discoRepository.deleteById(id);
        return "redirect:/discos";
    }

    @GetMapping("/edit/{id}")
    public String initEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("disco", discoRepository.findById(id));
        model.addAttribute("grupos", grupoRepository.findAll());
        model.addAttribute("estilos", estiloRepository.findAll());
        return "discoForm";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        Disco disco = new Disco();
        model.addAttribute("disco", disco);
        model.addAttribute("grupos", grupoRepository.findAll());
        model.addAttribute("estilos", estiloRepository.findAll());
        return "discoForm";
    }

    @PostMapping("/new/submit")
    public String processCreationForm(@ModelAttribute Disco disco) {
        discoRepository.save(disco);
        return "redirect:/discos";
    }

}
