
package dev.giru.HolaSpring.servicio;

import dev.giru.HolaSpring.domain.Persona;
import java.util.List;

public interface PersonaService {
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public List<Persona> listarPersonas();
    public Persona encontrarPersona(Persona persona);
}
