/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sylar
 */
public class clsFuncionario {
    String strRut;
    String strNombres;
    String strApellidoPaterno;
    String strApellidoMaterno;
    String strFechaNacimiento;
    String strDireccion;
    String strTelefono;
    String strCelular;
    String strMail;
    Integer intSalud;
    Integer intPension;
        
    public String getRut( ){
        return this.strRut;
    }
 
    public void setRut(String Rut){
        this.strRut = Rut;
    }
    
    public String getNombre( ){
        return this.strNombres;
    }
 
    public void setNombre(String Nombre){
        this.strNombres = Nombre;
    }
    
    public String getApellidoPaterno( ){
        return this.strApellidoPaterno;
    }
 
    public void setApellidoPaterno(String ApellidoPaterno){
        this.strApellidoPaterno = ApellidoPaterno;
    }
    
    public String getApellidoMaterno( ){
        return this.strApellidoMaterno;
    }
 
    public void setApellidoMaterno(String ApellidoMaterno){
        this.strApellidoMaterno = ApellidoMaterno;
    }
    
    public String getFechaNacimiento( ){
        return this.strFechaNacimiento;
    }
 
    public void setFechaNacimiento(String strFechaNacimiento){
        this.strFechaNacimiento = strFechaNacimiento;
    }
    
    public String getDireccion( ){
        return this.strDireccion;
    }
 
    public void setDireccion(String Direccion){
        this.strDireccion = Direccion;
    }
    
    public String getTelefono( ){
        return this.strTelefono;
    }
 
    public void setTelefono(String Telefono){
        this.strTelefono = Telefono;
    }
    
    public String getCelular( ){
        return this.strCelular;
    }
 
    public void setCelular(String Celular){
        this.strCelular = Celular;
    }
    
    public String getMail( ){
        return this.strMail;
    }
 
    public void setMail(String Mail){
        this.strMail = Mail;
    }
    
    public Integer getSalud( ){
        return this.intSalud;
    }
 
    public void setSalud(Integer Salud){
        this.intSalud = Salud;
    }
    
    public Integer getPension( ){
        return this.intPension;
    }
 
    public void setPension(Integer Pension){
        this.intPension = Pension;
    }
    
    public boolean GuardarFuncionario(){
        String strSql= "insert into tfuncionario (rut,nombres,apellidopaterno,apellidomaterno,fechanacimiento,direccion,telefono,celular,mail,salud,pension) values ('" + strRut + "','" + strNombres + "','" + strApellidoPaterno + "','" + strApellidoMaterno +"','" + strFechaNacimiento + "','" + strDireccion + "','" + strTelefono + "','" + strCelular + "','" + strMail + "'," + intSalud + "," + intPension + ")";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();

            con.ejecutarSQL(strSql);
            return true;  
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void ListarFuncionario(JTable Listado){
        Integer i=0;
        String strSql= "Select rut,nombres ,mail from tfuncionario";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
            
            DefaultTableModel listado = (DefaultTableModel) Listado.getModel();
            
            listado.addColumn("RUT");
            listado.addColumn("NOMBRE");
            listado.addColumn("MAIL");
            Listado.setModel(listado);
            
            Object[] linea = new Object[3]; 
                   
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            while (resultado.next()){
                linea[0] = resultado.getObject("rut"); 
                linea[1] = resultado.getObject("nombres"); 
                linea[2] = resultado.getObject("mail"); 
                listado.addRow(linea); 
                /*Listado.setValueAt(resultado.getString("rut"), i, 0);
                Listado.setValueAt(resultado.getString("nombres"), i, 1);
                Listado.setValueAt(resultado.getString("mail"), i, 2);
                i=i+1;*/
            }         
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public void CargarFuncionario(){
        String strSql= "Select * from tfuncionario where rut='" + strRut + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
                   
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            while (resultado.next()){
                strRut=resultado.getString("rut");
                strNombres=resultado.getString("nombres");
                strApellidoPaterno=resultado.getString("apellidopaterno");
                strApellidoMaterno=resultado.getString("apellidomaterno");
                strFechaNacimiento=String.valueOf(resultado.getDate("fechanacimiento"));
               // strFechaNacimiento=String.valueOf(resultado.getString("fechanacimiento"));
                strDireccion=resultado.getString("direccion");
                strTelefono=resultado.getString("telefono");
                strCelular=resultado.getString("celular");
                strMail=resultado.getString("mail");
                intSalud=resultado.getInt("salud");
                intPension=resultado.getInt("pension");
            }
        }catch(Exception e) {
            e.printStackTrace();       
        }      
    }
    
    public boolean ModificarFuncionario(){
        String strSql= "update tfuncionario set nombres='" + strNombres + "', apellidopaterno='" + strApellidoPaterno + "', apellidomaterno='" + strApellidoMaterno +"', fechanacimiento='" + strFechaNacimiento + "', direccion='" + strDireccion + "', telefono='" + strTelefono + "', celular='" + strCelular + "', mail='" + strMail + "', salud=" + intSalud + ", pension=" + intPension + " where rut='" + strRut + "'";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();

            con.ejecutarSQL(strSql);
            return true;  
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean EliminarFuncionario(){
        String strSql= "delete from tfuncionario where rut='" + strRut + "'";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();

            con.ejecutarSQL(strSql);
            return true;  
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
