/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Sylar
 */
public class clsPension {
    private Integer intMes;
    private Integer intAño;
    private Integer intIdInstitucion;
    private String strNombre;
    private String strTipo;
    
    public clsPension(Integer intMes, Integer intAño, Integer intIdInstitucion, String strNombre, String strTipo){
        this.intMes=intMes;
        this.intAño=intAño;
        this.intIdInstitucion=intIdInstitucion;
        this.strNombre=strNombre;
        this.strTipo=strTipo;
    }
    
    public clsPension(){
        
    }
    
    public Integer getMes( ){
        return this.intMes;
    }
 
    public void setMes(Integer Mes){
        this.intMes = Mes;
    }
    
    public Integer getAño( ){
        return this.intAño;
    }
 
    public void setAño(Integer Año){
        this.intAño = Año;
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
    
    public String getTipo( ){
        return this.strTipo;
    }
 
    public void setTipo(String Tipo){
        this.strTipo = Tipo;
    }
    
     public void LlenaComboInstitucionPension(JComboBox Combo, String strTipo){
        String strSql= "Select mes, año, idInstitucion, Nombre, tiposistema from tpension where Mes=8 and Año=2016 and tiposistema='" + strTipo + "'";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
            
            Combo.removeAllItems();
        
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            while (resultado.next()){
                Combo.addItem(
                        new clsPension(resultado.getInt("mes"),
                                       resultado.getInt("año"),
                                       resultado.getInt("idinstitucion"),
                                       resultado.getString("nombre"),
                                       resultado.getString("tiposistema")
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
    
    public void CargaInstitucionPension(Integer intID){
       String strSql= "Select mes, año, idInstitucion, nombre, tiposistema from tpension where Mes=8 and Año=2016 and idinstitucion='" + intID + "'";
                
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
                
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            while (resultado.next()){
                intMes=resultado.getInt("mes");
                intAño= resultado.getInt("año");
                intIdInstitucion=resultado.getInt("idinstitucion");
                strNombre=resultado.getString("nombre");
                strTipo=resultado.getString("tiposistema");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }    
    }
}
