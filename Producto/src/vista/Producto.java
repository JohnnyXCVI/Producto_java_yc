/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JDfla
 */
public class Producto {
    public void guardar(app.Producto ventana){
        if (ventana.nombre_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar el nombre del producto");
            return;
        }
        if (ventana.marca_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar la marca del producto");
            return;
        }
        if (ventana.costo_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar el costo del producto");
            return;
        }
        if (ventana.precio_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar el precio del producto");
            return;
        }
        new modelos.BaseDatos().lista_producto.add(new modelos.Producto(
                ventana.nombre_txt.getText(),
                ventana.marca_txt.getText(),
                ventana.precio_txt.getText(),
                ventana.costo_txt.getText(),
                ventana.estado_box.getSelectedItem().toString()
        ));
        cargarTabla(ventana.producto_tb);
    }

    public void cargarTabla(JTable tabla) {
        //se obtiene la lista de productos
        ArrayList<modelos.Producto> lista = new modelos.BaseDatos().lista_producto;
        //se crea un modelo de tabla pra insertar datos
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        //recorremos la lista y agregamos en la tabla
        modelo.setNumRows(0);
        //fore
        for (modelos.Producto producto : lista) {
            modelo.addRow(new Object[]{
                producto.getNombre(),
                producto.getMarca(),
                producto.getPrecio(),
                producto.getCosto(),
                producto.getEstado()
            });
        }
    }
    
     
    public void eliminar(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(
                null, 
                "Estas seguro de eliminar el registro?", 
                "ATENCIÓN", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            new modelos.BaseDatos().lista_producto.remove(fila);
            cargarTabla(tabla);
        }
    }

   
        
}
