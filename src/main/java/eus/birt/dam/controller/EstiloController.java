package eus.birt.dam.controller;

import eus.birt.dam.domain.Estilo;
import eus.birt.dam.repository.EstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estilos")
public class EstiloController {

    @Autowired
    EstiloRepository estiloRepository;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        estiloRepository.deleteById(id);
        return "redirect:/estilos";
    }

    @GetMapping("/edit/{id}")
    public String initEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("estilo", estiloRepository.findById(id));
        return "estiloForm";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        Estilo estilo = new Estilo();
        model.addAttribute("estilo", estilo);
        return "estiloForm";
    }

    @PostMapping("/new/submit")
    public String processCreationForm(@ModelAttribute Estilo estilo) {
        estiloRepository.save(estilo);
        return "redirect:/estilos";
    }

}
