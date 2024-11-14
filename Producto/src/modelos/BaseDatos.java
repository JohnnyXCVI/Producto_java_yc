/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author JDfla
 */
public class BaseDatos {
    public static ArrayList<Producto> lista_producto = new ArrayList<>();
    
    public void iniciarDatos(){
        lista_producto.add(new Producto(
                "Teclado", 
                "SATE", 
                "48000", 
                "47500", 
                "ACTIVO"
        ));
    }

}
