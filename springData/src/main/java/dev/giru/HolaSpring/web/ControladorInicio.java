package dev.giru.HolaSpring.web;

import dev.giru.HolaSpring.dao.PersonaDao;
import dev.giru.HolaSpring.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    private PersonaDao personaDao;
    @GetMapping("/")
    public String inicio(Model model) {
        
        var personas=personaDao.findAll();
        log.info("ejecutando el controlador de inicio");
        model.addAttribute("personas",personas);
        
        return "index";
    }
}
