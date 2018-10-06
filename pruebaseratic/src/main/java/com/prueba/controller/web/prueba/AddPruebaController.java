/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.prueba;

import com.prueba.models.Conexion;
import com.prueba.models.Prueba;
import com.prueba.models.Usuario;
import com.prueba.models.Validar;
import java.util.Date;
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
@RequestMapping("addprueba.htm")
public class AddPruebaController {


   private JdbcTemplate jdbcTemplate;

    public AddPruebaController() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @GetMapping
    public ModelAndView addprueba(HttpServletRequest hsr){   
        HttpSession session = hsr.getSession();
        String sesion = (String)session.getAttribute("session");
        if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("prueba/addprueba");
            mav.addObject("prueba", new Prueba());       
            return mav;   
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }                   
    }
    
    @PostMapping
    public ModelAndView addprueba (@ModelAttribute("prueba") Prueba p,
                                BindingResult result,
                                SessionStatus status){
        Date fecha = new Date();
        //String pass = Validar.Encriptar(p.getClave());//Encrypto la contraseña
            this.jdbcTemplate.update(
                        "INSERT INTO prueba (cedulaAs,nombreA,carreraA,cedulaE,nombreE,detalle,calificacion,fechap) VALUES (?,?,?,?,?,?,?,?)",
                        p.getCedulaAs(),p.getNombreA(),p.getCarreraA(),p.getCedulaE(),p.getNombreE(),p.getDetalle(),p.getCalificacion(),fecha);
            return new ModelAndView("redirect:/homePrueba.htm");        
    }
    
}

    

