/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controller.web.user;

import com.prueba.models.Conexion;
import com.prueba.models.Usuario;
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
@RequestMapping("edituser.htm")
public class EditUserController {
    private JdbcTemplate jdbcTemplate;

    public EditUserController() {
        Conexion con = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @GetMapping
    public ModelAndView edituser(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        String sesion = (String)session.getAttribute("session");
        
        if (sesion == "si"){
            ModelAndView mav = new ModelAndView();
            String id=request.getParameter("id");
            Usuario datos = this.selectUser(id);
            String desencriptado = Validar.Desencriptar(datos.getClave());//desencripto la contraseña
            mav.setViewName("usuario/edituser");
            mav.addObject("usuario",new Usuario(id,datos.getNombre(),datos.getUsuario(),desencriptado,datos.getTipo(),datos.getFecha()));
            return mav;  
       } else {
            return new ModelAndView("redirect:/login.htm");  
       }    
        
        
    }
    
    @PostMapping
    public ModelAndView edituser(@ModelAttribute("usuario") Usuario u,
                                BindingResult result,
                                SessionStatus status,
                                HttpServletRequest request){
            String pass = Validar.Encriptar(u.getClave());   
            String id=request.getParameter("id");
            this.jdbcTemplate.update(
                    "UPDATE usuario "
                    + "set nombre=?,"
                    + "usuario=?,"
                    + "clave=?,"
                    + "tipo=?,"
                    + "fecha=?"
                    + "where "
                    + "cedula=?",                    
                    u.getNombre(),u.getUsuario(),pass,u.getTipo(),u.getFecha(),id);
            return new ModelAndView("redirect:/user.htm");
        
    }
    
    public Usuario selectUser(String cedula){
        final Usuario user = new Usuario();
        String sql = "SELECT * FROM usuario WHERE cedula='"+cedula+"'";
        return (Usuario) jdbcTemplate.query(sql, new ResultSetExtractor<Usuario>(){
            public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException{
                if(rs.next()){
                    user.setCedula(rs.getString("cedula"));
                    user.setNombre(rs.getString("nombre"));
                    user.setUsuario(rs.getString("usuario"));
                    user.setClave(rs.getString("clave"));
                    user.setTipo(rs.getString("tipo")); 
                    user.setFecha(rs.getString("fecha"));
                }
                return user;
            }
        }  );
    }
    
}
