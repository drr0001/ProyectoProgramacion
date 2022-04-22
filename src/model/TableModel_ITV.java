package model;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.ConexionMySql;
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
    public void insertar(String titulo, int año, int puntuacion, String sinopsis) 
throws SQLException {
        Pelicula pelicula=new Pelicula(titulo,año,puntuacion,sinopsis);
        list.add(pelicula);
        cargarPeliculas();
    }
    public void eliminar(Pelicula pelicula){
        
        try {
            conn.eliminar(pelicula);
            list.remove(pelicula);
            cargarPeliculas();
        } catch (SQLException ex) {
            Logger.getLogger(TableModel_ITV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int actualizar(String tituloOriginal, String titulo, int año, int 
    puntuacion, String sinopsis) throws SQLException {
        int nfilas =0;
        conn.actualizar(tituloOriginal, titulo, año, puntuacion, sinopsis);
        
        cargarPeliculas();
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
                return list.get(rowIndex).getTitulo();
            case 1:
                return list.get(rowIndex).getAño();
            case 2:
                return list.get(rowIndex).getPuntuacion();
            case 3:
                return list.get(rowIndex).getSinopsis();
        }
        return null;
    }
}