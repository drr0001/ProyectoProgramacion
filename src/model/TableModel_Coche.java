package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import controller.ConexionMySql;
import controller.Controlador;

import java.sql.ResultSet;
import model.Coche;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author MEDAC
 */
public class TableModel_Coche extends AbstractTableModel {

    private static final String[] columnNames = {"Matricula", "Marca", "Modelo",
        "Color", "Precio", "Dni"};
    private final LinkedList<Coche> list;
    ConexionMySql cnn;

    public TableModel_Coche(ConexionMySql conexion) {
        list = new LinkedList<>();
        cnn = conexion;
    }

    public Coche getValueAt(int rowIndex) {
        return list.get(rowIndex);
    }

    public void cargarCoches() throws SQLException {

        String consulta = "SELECT * FROM `coche`;";

        ResultSet resultado = cnn.ejecutarSelect(consulta);

        ArrayList<Coche> coches = new ArrayList<>();
        while (resultado.next()) {
            Coche co = new Coche();
            co.setMatricula(resultado.getString("Matricula"));
            co.setMarca(resultado.getString("Marca"));
            co.setModelo(resultado.getString("Modelo"));
            co.setColor(resultado.getString("Color"));
            co.setPrecio(resultado.getInt("Precio"));
            co.setDni(resultado.getString("Dni"));
            coches.add(co);
        }

        System.out.println(coches.size());

        list.clear();
        list.addAll(coches);

        fireTableDataChanged();
    }
    
    // Método que devuelve los coches que pertenecen a un mismo cliente
    public void cargarCochesCliente(String dni) throws SQLException {

        String consulta = "SELECT * FROM coche WHERE dni='" + dni + "'";

        ResultSet resultado = cnn.ejecutarSelect(consulta);

        ArrayList<Coche> coches = new ArrayList<>();
        while (resultado.next()) {
            Coche co = new Coche();
            co.setMatricula(resultado.getString("Matricula"));
            co.setMarca(resultado.getString("Marca"));
            co.setModelo(resultado.getString("Modelo"));
            co.setColor(resultado.getString("Color"));
            co.setPrecio(resultado.getInt("Precio"));
            co.setDni(resultado.getString("Dni"));
            coches.add(co);
        }

        System.out.println(coches.size());

        list.clear();
        list.addAll(coches);

        fireTableDataChanged();
    }

    public void insertar( String matricula, String marca, String modelo, String color, int precio, String dni)
            throws SQLException {
        String consulta = "INSERT INTO coche(Matricula,Marca,Modelo,Color,Precio,Dni) VALUES ('" + matricula + "','" + marca + "','" + modelo + "','" + color + "'," + precio + ",'" + dni + "'); ";
        int resultado = cnn.ejecutarInsertDeleteUpdate(consulta);

        System.out.println(resultado);
    }
    
    // Método para obtener los datos de un coche 
    public Coche cargarDatosCoche(String matricula) throws SQLException{
        String consulta = "SELECT * FROM `coche` WHERE matricula='" + matricula + "'";
        ResultSet resultado = cnn.ejecutarSelect(consulta);
        Coche coche = null;
        while (resultado.next()) {
            coche = new Coche(resultado.getString("matricula"),resultado.getString("marca"),resultado.getString("modelo"),resultado.getString("color"), resultado.getInt("precio"), resultado.getString("dni"));
        }
        return coche;
    }
    // Método para obtener los datos del cliente que posee el coche 
    public Cliente cargarClienteCoche(String matricula) throws SQLException{
        String consulta = "SELECT cliente.nombre,cliente.ciudad,cliente.direccion,cliente.telf,cliente.dni from coche,cliente where coche.dni=cliente.dni and coche.matricula='" + matricula + "'";
        ResultSet resultado = cnn.ejecutarSelect(consulta);
        Cliente cliente = null;
        while (resultado.next()) {
            cliente = new Cliente(resultado.getString("cliente.dni"),resultado.getString("cliente.nombre"),resultado.getString("cliente.direccion"),resultado.getString("cliente.ciudad"), resultado.getInt("cliente.telf"));
        }
        return cliente;
    } 
    public void eliminar(String matricula)throws SQLException {
        String consulta = "DELETE FROM coche WHERE matricula ='" + matricula + "' ";
        int resultado = cnn.ejecutarInsertDeleteUpdate(consulta);
        System.out.println(resultado);
    }

    

    public void actualizar(String matricula, String marca, String modelo, String color, int precio, String dni) throws SQLException {
        
        String consulta = "UPDATE coche SET marca='" + marca + "',modelo='" + modelo + "',color='" + color + "',precio='" + precio + "' WHERE matricula='" + matricula + "' ";
        int resultado = cnn.ejecutarInsertDeleteUpdate(consulta);
        System.out.println(resultado);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getMatricula();
            case 1:
                return list.get(rowIndex).getMarca();
            case 2:
                return list.get(rowIndex).getModelo();
            case 3:
                return list.get(rowIndex).getColor();
            case 4:
                return list.get(rowIndex).getPrecio();
        }
        return null;
    }
  
}
