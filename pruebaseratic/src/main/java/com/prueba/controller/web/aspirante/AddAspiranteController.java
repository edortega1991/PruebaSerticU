/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.aspirante;

import com.prueba.models.Aspirante;
import com.prueba.models.Conexion;
import com.prueba.models.Validar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Edinson
 */

 @Controller
@RequestMapping("addaspirante.htm")
public class AddAspiranteController {
    private JdbcTemplate jdbcTemplate;

    public AddAspiranteController() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @GetMapping
    public ModelAndView adduser(HttpServletRequest hsr){   
        HttpSession session = hsr.getSession();
        String sesion = (String)session.getAttribute("session");
        if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("aspirante/addaspirante");
            mav.addObject("aspirante", new Aspirante());       
            return mav;   
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }                   
    }
    
    @PostMapping
    public ModelAndView adduser (@ModelAttribute("aspirante") Aspirante a,
                                BindingResult result,
                                SessionStatus status){
       // Date fecha = new Date();
       // String pass = Validar.Encriptar(a.getClave());//Encrypto la contraseña
            this.jdbcTemplate.update(
                        "INSERT INTO aspirante (cedula,nombre,carrera,telefono,correo) VALUES (?,?,?,?,?)",
                        a.getCedula(),a.getNombre(),a.getCarrera(),a.getTelefono(),a.getCorreo());
            return new ModelAndView("redirect:/aspirante.htm");        
    }
    
}
   

