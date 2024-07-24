/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.giru.HolaSpring.dao;

import dev.giru.HolaSpring.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ba01160602
 */
public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
