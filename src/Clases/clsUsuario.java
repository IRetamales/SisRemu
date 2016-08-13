/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.*;
import java.sql.CallableStatement;

/**
 *
 * @author Sylar
 */
public class clsUsuario {
    private String strLogin;
    private String strPassword;
    
    public String getLogin( ){
        return this.strLogin;
    }
 
    public void setLogin(String login){
        this.strLogin = login;
    }
    
    public String getPassword( ){
        return this.strPassword;
    }
 
    public void setPassword(String password){
        this.strPassword = password;
    }
    
    public boolean BuscarUsuario(){
        String strSql= "Select * from tusuario where login='" + strLogin + "' and password='" + strPassword + "'";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{            
            clsConexion con = new clsConexion();
            con.crearConexion();
            
            /*CallableStatement prc = con.conexion.prepareCall("{call spBuscaUsuario(?,?,?,?)}");
            prc.setString(1, strLogin);
            prc.setString(2, strPassword);
            
            
            prc.registerOutParameter(3, Types.VARCHAR);
            //prc.registerOutParameter("Pas", Types.VARCHAR);
            prc.execute();
            String aaa=prc.getString(3);
            String bbb=prc.getString(4);
            
            
            if(prc.getString("idUsu")!=null){
                return true;
            }else{
                return false;
            }*/
            
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            if (resultado.next()) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
