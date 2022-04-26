package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import model.Coche;
import view.JFrame2;

/**
 *
 * @author MEDAC-INVITADO
 */
public class ControladorCoche {

    public void insertCoche(String Matricula, String Marca, String Modelo, String Color, int Precio, String Dni) throws SQLException {
        String consulta = "";
        Controlador coche = new Controlador();

        coche.conectar();
        consulta = "INSERT INTO coche(Matricula,Marca,Modelo,Color, Precio, Dni) VALUES ('"+Matricula+"','"+Marca+"','"+Modelo+"','"+Color+"',"+Precio+",'"+Dni+"'); ";

        try {
            coche.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                coche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
    }

    public void deleteCoche(String matricula) throws SQLException {
        String consulta = "";
        Controlador coche = new Controlador();

        coche.conectar();
        consulta = "DELETE FROM `coche` WHERE matricula = "+matricula;

        try {
            coche.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                coche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }

    }
    public ArrayList <Coche> selectCoche() throws SQLException{
        String consulta = "";
        Controlador coche = new Controlador();
        
        coche.conectar();
        consulta = "SELECT * FROM `coche`;";
        ArrayList<Coche> coches = new ArrayList<>();
        try {
           
            coches = coche.ejecutarSelect(consulta);
            ResultSet rs = (ResultSet) coche.ejecutarSelect(consulta);
        //ArrayList <Coche> coches = new ArrayList<>();
            while(rs.next()){
                Coche co = new Coche();
                co.setMatricula(rs.getString("Matricula"));
                co.setMarca(rs.getString("Marca"));
                co.setModelo(rs.getString("Modelo"));
                co.setColor(rs.getString("Color"));
                co.setPrecio(rs.getInt("Precio"));
                coches.add(co);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                coche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
        return coches;
    }
    public void updateCoche(String matricula, String marca, String modelo , String color, int precio) throws SQLException {
        String consulta = "";
        Controlador coche = new Controlador();

        coche.conectar();
        consulta = "UPDATE coche SET marca = "+marca+",modelo = "+modelo+",color = "+color+",precio = "+precio+" WHERE = "+matricula+";";

        try {
            coche.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                coche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
    }
}
