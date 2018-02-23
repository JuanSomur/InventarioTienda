/*
 * Copyright Marote-Somur software(c)
 * Author: Juan Carlos Benjamín Somohano Murrieta
 * This product may not be exchanged under any circumstances
*/

package inventario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
public class Inventario implements Serializable {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Menu menu=new Menu();
        String ruta = "C:\\Users\\juans\\Desktop\\JCB\\Universidad\\4°\\Principios de construccion de software\\Practicas\\inventario.txt";
        String ruta2="C:\\Users\\juans\\Desktop\\JCB\\Universidad\\4°\\Principios de construccion de software\\Practicas\\ventas.txt";
        Ventas vent=new Ventas();
        InventarioP inv=new InventarioP();
        File salida=new File(ruta);
        File salida2=new File(ruta2);
        if(salida.exists()){
            FileInputStream ae=new FileInputStream(ruta);
            ObjectInputStream entrada = new ObjectInputStream(ae); 
            inv=(InventarioP)entrada.readObject();
            
        }
        if(salida2.exists()){
            FileInputStream ea=new FileInputStream(ruta2);
            ObjectInputStream entrada2=new ObjectInputStream(ea);
            vent=(Ventas)entrada2.readObject();
        }
        Scanner sc=new Scanner(System.in);
        menu.desplegar();
        int c=0;
        int opcion=sc.nextInt();
        sc.nextLine();
        while(opcion!=8){
            switch(opcion){
                case 1:
                    System.out.println("Ingrese nombre del producto: ");
                    String nombre=sc.next();
                    sc.nextLine();
                    System.out.println("Ingrese una breve descripción: ");
                    String descripcion=sc.nextLine();
                    System.out.println("Ingrese la cantidad del producto: ");
                    int cantidad=sc.nextInt();
                    System.out.println("Ingrese la unidad de medida: ");
                    String unidad=sc.next();
                    System.out.println("Ingrese el precio de compra");
                    float precioC=sc.nextFloat();
                    Producto aux1=new Producto(c,nombre,descripcion,unidad,cantidad,precioC);
                    inv.insertar(aux1);
                    break;
                case 2:
                    System.out.println("Inserte el Id del producto a modificar: ");
                    int id=sc.nextInt();
                    System.out.println("Ingrese el cambio de nombre: ");
                    String name=sc.next();
                    System.out.println("Ingrese la cantidad de producto que se va a modificar: ");
                    int cant=sc.nextInt();
                    System.out.println("Ingrese el precio de compra que va a modificar: ");
                    int pC=sc.nextInt();
                    inv.getProducto(id).setNombre(name);
                    inv.getProducto(id).setCantidad(cant);
                    inv.getProducto(id).setPrecioC(pC);
                    System.out.println("Producto modificado :)");
                    break;
                case 3:
                    System.out.println("Ingrese el Id del producto que desea eliminar: ");
                    int pid=sc.nextInt();
                    inv.eliminar(pid);
                    break;
                case 4:
                    FileOutputStream fo=new FileOutputStream(ruta);
                    ObjectOutputStream inventario=new ObjectOutputStream(fo);
                    inventario.writeObject(inv);
                    inventario.close();
                    System.out.println("Inventario guardado\n");
                    break;
                case 5:
                    inv.imprimir();
                    break;
                case 6:
                   System.out.println("Ingrese Id de objeto a vender: ");
                    int idr=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese la cantidad a vender: ");
                    int ammount=sc.nextInt();
                    sc.nextLine();
                    if(inv.getProducto(idr).getCantidad()<ammount){
                        System.out.println("No contamos con la cantidad suficiente, intente más tarde");
                        break;
                    }
                    inv.getProducto(idr).setCantidad(inv.getProducto(idr).getCantidad()-ammount);
                    System.out.println("Gracias por su compra");
                    vent.agregar(inv.getProducto(idr),ammount);
                    FileOutputStream as=new FileOutputStream(ruta2);
                    ObjectOutputStream ventas=new ObjectOutputStream(as);
                    ventas.writeObject(vent);
                    ventas.close();
                    break;
                case 7:
                    vent.imprimir();
                    break;
                case 8:
                    break;
                }
            menu.desplegar();
            opcion=sc.nextInt();
            }
        
    }
}
