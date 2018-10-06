/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.aspirante;

import com.prueba.models.Aspirante;
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
public class AspiranteController {
    private JdbcTemplate jdbcTemplate;

    public AspiranteController() {
        Conexion con = new Conexion();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("aspirante.htm")
    public ModelAndView users(HttpServletRequest hsr){
        
        HttpSession session = hsr.getSession();
        String sesion = (String)session.getAttribute("session");
        if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            String sql="select * from aspirante";
            List aspirantes = this.jdbcTemplate.queryForList(sql);
            mav.addObject("aspirantes", aspirantes);
            mav.setViewName("aspirante/aspirante");
            return mav;  
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }                             
    }
}    
//}
