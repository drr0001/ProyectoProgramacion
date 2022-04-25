package model;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.ConexionMySql;
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
public class TableModel_ITV extends AbstractTableModel {
    private static final String[] columnNames = {"Matricula", "Marca", "Modelo", 
    "Color", "Precio"};
    private final LinkedList<Coche> list;
    private ConexionMySql conn;
    
    public TableModel_ITV(ConexionMySql conexion) {
        list = new LinkedList<>();
        conn = conexion;
    }
    public Coche getValueAt(int rowIndex) {
        return list.get(rowIndex);
    }
    public void cargarPeliculas() throws SQLException {
     
        ArrayList<Coche> coches = conn.getCoche();
        System.out.println(coches.size());
        
        list.clear();
        list.addAll(coches);
       
        fireTableDataChanged();
    }
    public void insertar(String matricula, String marca, String modelo, String color, int precio, Cliente cliente) 
throws SQLException {
        Coche coche=new Coche(matricula,marca,modelo,color,precio);
        list.add(coche);
        cargarPeliculas();
    }
    public void eliminar(Coche coche){
        
        try {
            conn.eliminar(coche);
            list.remove(coche);
            cargarCoches();
        } catch (SQLException ex) {
            Logger.getLogger(TableModel_ITV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int actualizar(String matriculaOriginal, String matricula, String marca, String modelo, String color, int precio) throws SQLException {
        int nfilas =0;
        conn.actualizar(matriculaOriginal, matricula, marca, modelo, color, precio);
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