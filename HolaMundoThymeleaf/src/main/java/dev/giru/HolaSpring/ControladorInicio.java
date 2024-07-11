package dev.giru.HolaSpring;

import dev.giru.HolaSpring.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
    @GetMapping("/")
    public String inicio(Model model) {
        var persona=new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("a@gmail.com");
        persona.setTelefono("0992616224");
        var persona2=new Persona();
        persona2.setNombre("Karla");
        persona2.setApellido("Perez");
        persona2.setEmail("b@gmail.com");
        persona2.setTelefono("0982616224");
        List<Persona> personas=new ArrayList<Persona>();
        personas.add(persona);
        personas.add(persona2);
        var Mensaje="adios con thymeleaf";
        log.info("ejecutando el controlador de inicio");
        model.addAttribute("mensaje",Mensaje);
        model.addAttribute("saludo",saludo);
        model.addAttribute("personas",personas);
        
        return "index";
    }
}
