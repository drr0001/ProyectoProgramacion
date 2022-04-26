package model;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.ConexionMySql;
import controller.Controlador;
import controller.ControladorCoche;
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
    private static final String[] columnNames = {"matricula", "marca", "modelo", 
    "color", "precio","Dni"};
    private final LinkedList<Coche> list;
    private ControladorCoche conn;
    
    public TableModel_Coche(ControladorCoche conexion) {
        list = new LinkedList<>();
        conn = conexion;
    }
    public Coche getValueAt(int rowIndex) {
        return list.get(rowIndex);
    }
    public void cargarCoches() throws SQLException {
     
        ArrayList<Coche> coches = conn.selectCoche();
        System.out.println(coches.size());
        
        list.clear();
        list.addAll(coches);
       
        fireTableDataChanged();
    }
    public void insertar(String matricula, String marca, String modelo, String color, int precio) 
throws SQLException {
        Coche coche=new Coche(matricula,marca,modelo,color,precio,null);
        conn.insertCoche(matricula, marca, modelo, color, precio, null);
        list.add(coche);
        cargarCoches();
    }
    public void eliminar(String matricula, String marca, String modelo, String color, int precio){
        Coche coche=new Coche(matricula,marca,modelo,color,precio,null);
        try {
            conn.deleteCoche(matricula);
            list.remove(coche);
            cargarCoches();
        } catch (SQLException ex) {
            Logger.getLogger(TableModel_Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int actualizar(String matricula, String marca, String modelo, String color, int precio) throws SQLException {
        int nfilas =0;
        conn.updateCoche(matricula, marca, modelo, color, precio);
        cargarCoches();
        return nfilas;
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