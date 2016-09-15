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
public class clsConcepto {
    private Integer intAño;
    private Integer intMes;
    private String strCodigo;
    private String strDescripcion;
    private Integer intObligatorio;
    private Long lngMonto;
    private Long lngCalculo;
    private String strTipoConcepto;
    private String strModo;
    private Integer intImponible;
    private Integer intTributable;
    
    //public clsConcepto(Integer intAño, Integer intMes, String strCodigo, String strDescripcion, Integer intObligatorio, Long lngMonto, Long lngCalculo, String strTipoConcepto, String strModo, Integer intImponible, Integer intTributable) {
    public clsConcepto(Integer intAño, Integer intMes,  String strCodigo, String strDescripcion) {
        this.intAño = intAño;
        this.intMes = intMes;
        this.strCodigo = strCodigo;
        this.strDescripcion = strDescripcion;
        /*this.intObligatorio = intObligatorio;
        this.lngMonto = lngMonto;
        this.lngCalculo = lngCalculo;
        this.strTipoConcepto = strTipoConcepto;
        this.strModo = strModo;
        this.intImponible = intImponible;
        this.intTributable = intTributable;*/
    }
    
    public clsConcepto(){
        
    }

    public Integer getMes() {
        return intMes;
    }

    public void setMes(Integer intMes) {
        this.intMes = intMes;
    }

    public String getCodigo( ){
        return this.strCodigo;
    }
    
    public void setCodigo(String strCodigo) {
        this.strCodigo = strCodigo;
    }

    public String getDescripcion() {
        return strDescripcion;
    }

    public void setDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public Integer getObligatorio() {
        return intObligatorio;
    }

    public void setObligatorio(Integer intObligatorio) {
        this.intObligatorio = intObligatorio;
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

    public String getTipoConcepto() {
        return strTipoConcepto;
    }

    public void setTipoConcepto(String strTipoConcepto) {
        this.strTipoConcepto = strTipoConcepto;
    }

    public String getModo() {
        return strModo;
    }

    public void setModo(String strModo) {
        this.strModo = strModo;
    }

    public Integer getImponible() {
        return intImponible;
    }

    public void setImponible(Integer intImponible) {
        this.intImponible = intImponible;
    }

    public Integer getTributable() {
        return intTributable;
    }

    public void setTributable(Integer intTributable) {
        this.intTributable = intTributable;
    }
    
    public Integer getAño() {
        return intAño;
    }

    public void setAño(Integer intAño) {
        this.intAño = intAño;
    }
    
    public void LlenaComboConceptos(JComboBox Combo, String strTipo){
        String strSql= "Select mes, año, codigo, descripcion from tconcepto where Mes=8 and Año=2016 and tipoconcepto='" + strTipo + "'";
        //String strSql= "call spBuscaUsuario (?,?)";// + strLogin + "','" + strPassword + "'";
        
        try{
            clsConexion con = new clsConexion();
            con.crearConexion();
            
            Combo.removeAllItems();
        
            ResultSet resultado = con.ejecutarSQLSelect(strSql);
            while (resultado.next()){
                Combo.addItem(
                        new clsConcepto(resultado.getInt("mes"),
                                       resultado.getInt("año"),
                                       resultado.getString("codigo"),
                                       resultado.getString("descripcion")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    @Override
    public String toString(){
        return strDescripcion;
    }
}
