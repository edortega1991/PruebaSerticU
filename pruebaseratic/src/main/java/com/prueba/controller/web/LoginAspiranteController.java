/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web;

import com.prueba.models.Aspirante;
import com.prueba.models.Conexion;
import com.prueba.models.Validar;
import java.util.List;
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
@RequestMapping("loginAspirante.htm")

public class LoginAspiranteController {
    
    private JdbcTemplate jdbctemplate;
    
    public LoginAspiranteController(){
    Conexion con=new Conexion();
    this.jdbctemplate= new JdbcTemplate(con.conectar());
    }
    
    @GetMapping
    public ModelAndView loginController(HttpServletRequest hsr)
    {
        HttpSession session = hsr.getSession();
        String sesion =(String)session.getAttribute("session");
        
        if(sesion == "si")
        {
         return new ModelAndView("redirect:/user.htm");
        }
        else{
           
            ModelAndView mav= new ModelAndView();
            mav.setViewName("loginAspirante");
            mav.addObject("aspirante", new Aspirante());
            return mav;
        }
        
      }
    
    @PostMapping
    public ModelAndView loginAspirante (@ModelAttribute("aspirante") Aspirante a,
                                BindingResult result,
                                SessionStatus status,HttpServletRequest hsr){         
        HttpSession session = hsr.getSession();
        //String pass = Validar.Encriptar(a.getClave());
        String sql="SELECT * FROM aspirante WHERE correo='"+a.getCorreo()+"' AND nombre='"+a.getNombre()+"'";
        List datos = this.jdbctemplate.queryForList(sql);
        if (datos.size() > 0){            
            session.setAttribute("session", "si");
            return new ModelAndView("redirect:/user.htm");            
        }else{
            return new ModelAndView("redirect:/loginAspirante.htm");
        }                              
        }       
}   

