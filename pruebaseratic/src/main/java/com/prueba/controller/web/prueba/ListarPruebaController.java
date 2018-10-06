/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.prueba;

import com.prueba.models.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Edinson
 */
 @Controller


public class ListarPruebaController {
    private JdbcTemplate jdbcTemplate;

    public ListarPruebaController() {
        Conexion con = new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("listPrueba.htm")
    public ModelAndView users(HttpServletRequest hsr){
        
        HttpSession session = hsr.getSession();
        String sesion = (String)session.getAttribute("session");
        //if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            String sql="select * from prueba";
            List pruebas = this.jdbcTemplate.queryForList(sql);
            mav.addObject("pruebas", pruebas);
            mav.setViewName("prueba/listPrueba");
            return mav;  
       }// else {
          //  return new ModelAndView("redirect:/login.htm");  
       //}                             
    }
//}

    

