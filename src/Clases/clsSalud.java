/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.JComboBox.*;

/**
 *
 * @author Sylar
 */
public class clsSalud {
    private Integer intIdInstitucion;
    private String strNombre;
    
    public clsSalud(Integer intIdInstitucion, String strNombre){
        this.intIdInstitucion=intIdInstitucion;
        this.strNombre=strNombre;
    }
    
    public clsSalud(){
        
    }
    
    public Integer getIdInstitucion( ){
        return this.intIdInstitucion;
    }
 
    public void setIdInstitucion(Integer IdInstitucion){
        this.intIdInstitucion = IdInstitucion;
    }
    
    public String getNombre( ){
        return this.strNombre;
    }
 
    public void setNombre(String Nombre){
        this.strNombre = Nombre;
    }
    
    public void CargaInstitucionSalud(JComboBox<clsSalud> Combo){
        String strSql= "Select idinstitucion,nombre from tsalud";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
            
            Combo.removeAllItems();
        
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            while (resultado.next()){
                Combo.addItem(
                        new clsSalud(resultado.getInt("idinstitucion"),
                                     resultado.getString("nombre")
                        )
                );  
            }         
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    @Override
    public String toString(){
        return strNombre;
    }
    
}
