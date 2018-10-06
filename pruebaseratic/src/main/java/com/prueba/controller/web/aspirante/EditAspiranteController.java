/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.aspirante;

import com.prueba.models.Aspirante;
import com.prueba.models.Conexion;
import com.prueba.models.Validar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
@RequestMapping("editaspirante.htm")
public class EditAspiranteController {
    private JdbcTemplate jdbcTemplate;

    public EditAspiranteController() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @GetMapping
    public ModelAndView EditAspirante(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        String sesion = (String)session.getAttribute("session");
        
        if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            String id=request.getParameter("id");
            Aspirante datos = this.selectAspirante(id);
           // String desencriptado = Validar.Desencriptar(datos.getClave());//desencripto la contraseña
            mav.setViewName("aspirante/editaspirante");
            mav.addObject("aspirante",new Aspirante(id,datos.getNombre(),datos.getCarrera(),datos.getTelefono(),datos.getCorreo()));
            return mav;  
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }    
        
        
    }
    
    @PostMapping
    public ModelAndView EditAspirante(@ModelAttribute("aspirante") Aspirante a,
                                BindingResult result,
                                SessionStatus status,
                                HttpServletRequest request){
            //String pass = Validar.Encriptar(u.getClave());   
            String id=request.getParameter("id");
            this.jdbcTemplate.update(
                    "UPDATE aspirante "
                    + "set nombre=?,"
                    + "carrera=?,"
                    + "telefono=?,"
                    + "correo=?"
                    + "where "
                    + "cedula=?",                    
                    a.getNombre(),a.getCarrera(),a.getTelefono(),a.getCorreo(),id);
            return new ModelAndView("redirect:/user.htm");
        
    }
    
    public Aspirante selectAspirante(String cedula){
        final Aspirante app = new Aspirante();
        String sql = "SELECT * FROM aspirante WHERE cedula='"+cedula+"'";
        return (Aspirante) jdbcTemplate.query(sql, new ResultSetExtractor<Aspirante>(){
            public Aspirante extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    app.setCedula(rs.getString("cedula"));
                    app.setNombre(rs.getString("nombre"));
                    app.setCarrera(rs.getString("carrera"));
                    app.setTelefono(rs.getString("telefono"));
                    app.setCorreo(rs.getString("correo"));
                }
                return app;
            }
        }  );
    }
    
}
    

