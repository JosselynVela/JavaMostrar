/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicasistemacentralizado;

/**
 *
 * @author Josselyn Vela
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;


public class Test {


    public Test() {
        
        //Test t  = new Test();
        
       // t.insertar();
       // t.actualizar(1, "PERA", 33.15);
        //t.eliminar(1);

    }
    
    
    
    public Connection getConexion() 
    {
        Connection conexion = null;
    
        String servidor = "localhost";
        
        String puerto = "5432";
        
        String baseDatos = "super";
        
        String url = "jdbc:postgresql://" + servidor + ":" + puerto + "/" + baseDatos;
        
        String usuario = "postgres";
        
        String clave = "1998";
        
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
            
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    
     public void insertar() {

        Connection conexion = getConexion();
        
        String sql = "INSERT INTO producto (codigo,nombre,precio) VALUES (3,'Arroz',10.00)";
        //String sql = "insert into producto values (" + codigo + ",'" + nombre + "','" + precio + "')";
        try (Statement st = conexion.createStatement()) {
            
            //EL executeUpdate ES LA EJECUCIÓN DE LA SENTENCIA
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }
    
     public void actualizar(int codigo, String nombre, double precio) {
         
        Connection conexion = getConexion();
        
        String sql = "UPDATE practicauno SET " + "nombre='" + nombre + "'" + ",precio=" + precio + "WHERE codigo=" + codigo;
        try (Statement st = conexion.createStatement()) {
            
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

    public void eliminar(int codigo) {
        
        Connection conexion = getConexion();
        
        String sql = "DELETE FROM practicauno WHERE codigo = " + codigo;
        
        try (Statement st = conexion.createStatement()) 
        {
            st.executeUpdate(sql);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }
    public ResultSet getTabla(String Consulta) {
        
        
        Connection conexion = getConexion();
        Statement st;
        ResultSet datos=null;
        try{
            st=conexion.createStatement();
            datos=st.executeQuery(Consulta);
        }
        catch(Exception e){
            System.out.print(e.toString());
        }
        return datos;
    }
    
}