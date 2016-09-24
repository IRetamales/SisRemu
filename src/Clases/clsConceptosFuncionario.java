/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sylar
 */
public class clsConceptosFuncionario {
    private String strRut;
    private Integer intAño;
    private Integer intMes;
    private String strCodigo;
    private Long lngMonto;
    private Long lngCalculo;
    private String strDescripcion;
    
    public clsConceptosFuncionario(Integer intAño, Integer intMes,  String strCodigo, String strRut, String strDescripcion) {
        this.intAño = intAño;
        this.intMes = intMes;
        this.strCodigo = strCodigo;
        this.strRut = strRut;
        this.strDescripcion = strDescripcion;
        /*this.intObligatorio = intObligatorio;
        this.lngMonto = lngMonto;
        this.lngCalculo = lngCalculo;
        this.strTipoConcepto = strTipoConcepto;
        this.strModo = strModo;
        this.intImponible = intImponible;
        this.intTributable = intTributable;*/
    }
    
    public clsConceptosFuncionario(){
        
    }
    
    public String getRut() {
        return strRut;
    }

    public void setRut(String sRut) {
        this.strRut = sRut;
    }
    
    public Integer getAño() {
        return intAño;
    }

    public void setAño(Integer intAño) {
        this.intAño = intAño;
    }
    
    public Integer getMes() {
        return intMes;
    }

    public void setMes(Integer intMes) {
        this.intMes = intMes;
    }

    public String getCodigo( ) {
        return this.strCodigo;
    }

    public void setCodigo(String strCodigo) {
        this.strCodigo = strCodigo;
    }
    
    public Long getMonto() {
        return lngMonto;
    }

    public void setMonto(Long lngMonto) {
        this.lngMonto = lngMonto;
    }

    public Long getCalculo() {
        return lngCalculo;
    }

    public void setCalculo(Long lngCalculo) {
        this.lngCalculo = lngCalculo;
    }
    
    public String getDescripcion( ) {
        return this.strDescripcion;
    }

    public void setDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }
    
    public boolean GuardarConceptoFuncionario(){
        String strSql= "insert into tconceptofuncionario (año,mes,codigo,rut,monto,valor) values (" + intAño + "," + intMes + ",'" + strCodigo + "','" + strRut +"',0,0)";
        
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
    
    public void ListarConceptosFuncionario(JTable Listado, String strTipo){
        //Integer i=0;
        
        
        String strSql= "Select t1.codigo, t2.descripcion ,t1.valor from tconceptofuncionario t1 "
                     + "join tconcepto t2 on t1.año=t2.año "
                     + " and t1.mes=t2.mes and t1.codigo=t2.codigo"
                     + " where t2.tipoconcepto='" + strTipo + "'";

        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
            
            DefaultTableModel listado = (DefaultTableModel) Listado.getModel();

            listado.addColumn("codigo");
            listado.addColumn("nombre");
            listado.addColumn("valor");
            Listado.setModel(listado);
            
            Object[] linea = new Object[3]; 
                   
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            while (resultado.next()){
                linea[0] = resultado.getObject("codigo"); 
                linea[1] = resultado.getObject("descripcion"); 
                linea[2] = resultado.getObject("valor"); 
                listado.addRow(linea); 
            }
            
            Listado.getColumnModel().getColumn(0).setMaxWidth(0);
            Listado.getColumnModel().getColumn(0).setMinWidth(0);
            Listado.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Listado.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    
    public void CalculaMonto(){
        Integer i=0;
        String strSql= "select codigo from tconceptofuncionario";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
                   
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            while (resultado.next()){
                //resultado.getString("codigo");
                AsignaMontoConcepto(resultado.getString("codigo"));
                i=i+1;
            }         
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public boolean RevisaLiquidada(){
        String strSql= "select liquidado from tconceptofuncionario";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
                   
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            resultado.next();
            if(resultado.getInt("liquidado")==1){
                return true;
            }else{
                return false;
            }
       
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean AsignaMontoConcepto(String strCodigo){
        String strSql= "update tconceptofuncionario set valor=(Select calculo from tconcepto where codigo='" + strCodigo + "'), liquidado=1"
                + " where codigo='" + strCodigo + "'";
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
    
    public boolean Reliquidar(){
        String strSql= "update tconceptofuncionario set valor=0, liquidado=0";
               // + " where codigo='" + strCodigo + "'";
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
    
    public boolean EliminaConceptoFuncionario(){
        String strSql= "delete from tconceptofuncionario where codigo='" + strCodigo + "'";
               // + " where codigo='" + strCodigo + "'";
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
    
    public Integer SumaConceptos(String strTipoConcepto, Integer strTipo){
    //Pediremos tipo de haber (0= total haberes y descuentos, 1=totalimponible, 2=totaltributable)
        String strSql;
        Integer Suma=0;
        try{
            if (strTipo==1){
                strSql= "select sum(tc.valor) as Suma from tconceptofuncionario tc"
                             + " join tconcepto c on tc.codigo=c.codigo and tc.mes=c.mes and tc.año=c.año"
                             + " where c.tipoconcepto='" + strTipoConcepto + "'";
            }
            if (strTipo==2){
                strSql= "select sum(tc.valor) as Suma from tconceptofuncionario tc"
                             + " join tconcepto c on tc.codigo=c.codigo and tc.mes=c.mes and tc.año=c.año"
                             + " where c.tipoconcepto='" + strTipoConcepto + "' and c.imponible=1";
            }else{
                strSql= "select sum(tc.valor) as Suma from tconceptofuncionario tc"
                             + " join tconcepto c on tc.codigo=c.codigo and tc.mes=c.mes and tc.año=c.año"
                             + " where c.tipoconcepto='" + strTipoConcepto + "' and c.tributable=1";
            }

            clsConexion con = new clsConexion();
            con.crearConexion();

            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            if (resultado.next()){
                Suma = resultado.getInt("Suma");
            }
            return Suma;
           
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
