package dev.giru.HolaSpring.web;

import dev.giru.HolaSpring.dao.PersonaDao;
import dev.giru.HolaSpring.domain.Persona;
import dev.giru.HolaSpring.servicio.PersonaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ba01160602
 */
@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    
    @Autowired
    private PersonaService PersonaService;
    @GetMapping("/")
    public String inicio(Model model) {
        
        var personas=PersonaService.listarPersonas();
        log.info("ejecutando el controlador de inicio");
        model.addAttribute("personas",personas);
        
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona,Model model){
        persona=PersonaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        PersonaService.eliminar(persona);
        return "redirect:/";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        PersonaService.guardar(persona);
        return "redirect:/";
    }
}
