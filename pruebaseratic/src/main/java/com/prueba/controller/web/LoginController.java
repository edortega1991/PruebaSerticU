/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web;

import com.prueba.models.Conexion;
import com.prueba.models.Usuario;
import com.prueba.models.Validar;
import java.util.List;
import java.util.Map;
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
@RequestMapping("login.htm")

public class LoginController {
    
    private JdbcTemplate jdbctemplate;
    
    public LoginController(){
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
         return new ModelAndView("redirect:/home.htm");
        }
        else{
           
            ModelAndView mav= new ModelAndView();
            mav.setViewName("login");
            mav.addObject("usuario", new Usuario());
            return mav;
        }
        
      }
    
    @PostMapping
    public ModelAndView login (@ModelAttribute("usuario") Usuario u,
                                BindingResult result,
                                SessionStatus status,HttpServletRequest hsr){         
        HttpSession session = hsr.getSession();
        String pass = Validar.Encriptar(u.getClave());
        String sql="SELECT * FROM usuario WHERE usuario='"+u.getUsuario()+"' AND clave='"+pass+"'";
        //List datos = this.jdbctemplate.queryForList(sql);
        List<Map<String, Object>> datos = this.jdbctemplate.queryForList(sql);
        if (datos.size() > 0){ 
            for (Map<String, Object> dato : datos) {
		String tipo = (String) dato.get("tipo");
                if(tipo.contentEquals("administrador")){
                    session.setAttribute("session", "si");
                    return new ModelAndView("redirect:/home.htm");            
                }
                else{
                    session.setAttribute("session", "si");
                    return new ModelAndView("redirect:/homePrueba.htm");            
                }
            }
            session.setAttribute("session", "si");
            return new ModelAndView("redirect:/home.htm");            
        }
        else{
            return new ModelAndView("redirect:/login.htm");
        }                              
        }
}