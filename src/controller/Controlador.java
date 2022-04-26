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

/**
 *
 * @author MEDAC-INVITADO
 */
public class Controlador {

    ConexionMySql cnn = new ConexionMySql();//inicializar en el metodo conectar

    public void conectar() throws SQLException {
        cnn.conectar();
        System.out.println("CONECTADO");
    }

    public void desconectar() throws SQLException {
        cnn.desconectar();
        System.out.println("desconectadoo");
    }

    public void ejecutarInsertDeleteUpdate(String consulta) throws SQLException {
        cnn.ejecutarInsertDeleteUpdate(consulta);
    }

    public ArrayList<Coche> ejecutarSelect(String consulta) throws SQLException {

        //cnn.ejecutarSelect(consulta);
        ResultSet rs = cnn.ejecutarSelect(consulta);
        ArrayList <Coche> coches = new ArrayList<>();
            while(rs.next()){
                Coche co = new Coche();
                co.setMatricula(rs.getString("Matricula"));
                co.setMarca(rs.getString("Marca"));
                co.setModelo(rs.getString("Modelo"));
                co.setColor(rs.getString("Color"));
                co.setPrecio(rs.getInt("Precio"));
                coches.add(co);
            }
        return coches;
    }
    

}
