/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.user;

import com.prueba.models.Conexion;
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
@RequestMapping("adduser.htm")
public class AddUserController {
    private JdbcTemplate jdbcTemplate;

    public AddUserController() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @GetMapping
    public ModelAndView adduser(HttpServletRequest hsr){   
        HttpSession session = hsr.getSession();
        String sesion = (String)session.getAttribute("session");
       if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("usuario/adduser");
            mav.addObject("usuario", new Usuario());       
            return mav;   
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }                   
    }
    
    @PostMapping
    public ModelAndView adduser (@ModelAttribute("usuario") Usuario u,
                                BindingResult result,
                                SessionStatus status){
        Date fecha = new Date();
        String pass = Validar.Encriptar(u.getClave());//Encrypto la contraseña
            this.jdbcTemplate.update(
                        "INSERT INTO usuario (cedula,nombre,usuario,clave,tipo,fecha) VALUES (?,?,?,?,?,?)",
                        u.getCedula(),u.getNombre(),u.getUsuario(),pass,u.getTipo(),fecha);
            return new ModelAndView("redirect:/user.htm");        
    }
    
}
