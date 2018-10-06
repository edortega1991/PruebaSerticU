/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.aspirante;

import com.prueba.models.Conexion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Edinson
 */

    
@Controller
@RequestMapping("delaspirante.htm")
public class DeleteAspiranteCntroller {
    private JdbcTemplate jdbcTemplate;

    public DeleteAspiranteCntroller() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @GetMapping
    public ModelAndView deluser(HttpServletRequest request){        
        String id = request.getParameter("id");
        this.jdbcTemplate.update(
                        "DELETE FROM aspirante "
                    + "WHERE "
                    + "cedula=?",                    
                    id);
                
        return new ModelAndView("redirect:/aspirante.htm");
    }
}

