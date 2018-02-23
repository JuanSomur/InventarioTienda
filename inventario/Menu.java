/*
 * Copyright Marote-Somur software(c)
 * Author: Juan Carlos Benjamín Somohano Murrieta
 * This product may not be exchanged under any circumstances
 */

package inventario;
import java.io.Serializable;

public class Menu implements Serializable{
    public Menu(){}
    public void desplegar(){
        System.out.println("Ingrese una de las siguientes opciones: \n");
        System.out.println("1. Agregar producto\n");
        System.out.println("2. Modificar producto\n");
        System.out.println("3. Eliminar producto\n");
        System.out.println("4. Guardar inventario\n");
        System.out.println("5. Imprimir inventario\n");
        System.out.println("6. Vender producto\n");
        System.out.println("7. Imprimir reportes de ventas\n");
        System.out.println("8. Salir\n");
    }
}
