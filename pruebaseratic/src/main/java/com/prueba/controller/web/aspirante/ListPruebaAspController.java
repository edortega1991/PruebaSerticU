/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.aspirante;

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
public class ListPruebaAspController {
    private JdbcTemplate jdbcTemplate;

    public ListPruebaAspController() {
        Conexion con = new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("listPruebaAsp.htm")
    public ModelAndView users(HttpServletRequest request){
        
        HttpSession session = request.getSession();
        String sesion = (String)session.getAttribute("session");
        String cedu=request.getParameter("cedula1");
        
        if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            String sql="SELECT * FROM prueba WHERE cedulaAs='"+cedu+"'";
            List pruebas = this.jdbcTemplate.queryForList(sql);
            mav.addObject("pruebas", pruebas);
            mav.setViewName("aspirante/listPruebaAsp");
            return mav;  
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }                             
    }
}

    
    

