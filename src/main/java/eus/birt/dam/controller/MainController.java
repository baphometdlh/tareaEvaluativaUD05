package eus.birt.dam.controller;

import eus.birt.dam.repository.DiscoRepository;
import eus.birt.dam.repository.EstiloRepository;
import eus.birt.dam.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    GrupoRepository grupoRepository;
    @Autowired
    EstiloRepository estiloRepository;
    @Autowired
    DiscoRepository discoRepository;

    @GetMapping("/index")
    public String index(){return "index";}


    @GetMapping({"/grupo"})
    public String getBands(Model model){
        model.addAttribute("grupo", grupoRepository.findAll());
        return "grupo";
    }

    @GetMapping({"/discos"})
    public String getAlbum(Model model){
        model.addAttribute("disco", discoRepository.findAll());
        return "discos";
    }

    @GetMapping({"/estilos"})
    public String getEstilo(Model model){
        model.addAttribute("estilo", estiloRepository.findAll());
        return "estilos";
    }

}
