/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.prueba;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Edinson
 */
   @Controller
public class HomePruebaController {
    @RequestMapping("homePrueba.htm")
    
    public ModelAndView homePrueba(HttpServletRequest hsr) 
    {
       HttpSession session = hsr.getSession();
       String sesion = (String)session.getAttribute("session");
       
       if (sesion == "si"){ 
            return new ModelAndView ();
         }
       else{
           return new ModelAndView("redirect:/login.htm");
       }
    }   
   }

