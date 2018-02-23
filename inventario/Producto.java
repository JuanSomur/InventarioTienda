    /*
 * Copyright Marote-Somur software(c)
 * Author: Juan Carlos Benjamín Somohano Murrieta
 * This product may not be exchanged under any circumstances
 */

package inventario;
import java.io.Serializable;
import java.util.Random;
public class Producto implements Serializable{
    private int pId;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String unidad;
    private float precioC;
    private float precioV;
    private Producto siguiente;
    private Random r=new Random();
    
    public Producto(int c,String nombre,String descripcion,String unidad,int cantidad,float precioC){
        this.pId=c;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
        this.unidad=unidad;
        this.precioC=precioC;
        this.precioV=(float) ((precioC*2)+(precioC*0.16));
        this.siguiente=null;
    }
 
   public int getPID(){
        return this.pId;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public float getPrecioC(){
       return this.precioC;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public String getUnidad(){
        return this.unidad;
    }
    public float getPrecioV(){
     return this.precioV;   
    }
    public void setPrecioC(float precioC){
        this.precioC=precioC;
        this.precioV=(float) ((precioC*2)+(precioC*0.16));
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    } 
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setSiguiente(Producto siguiente){
        this.siguiente=siguiente;
    }
    public Producto getSiguiente(){
        return this.siguiente;
    }
    @Override
    public String toString(){
        String salida= "Id: "+this.pId+"\nNombre del producto: "+nombre+"\nDescripcion: "+descripcion+"\nCantidad: "+cantidad+"\nUnidad: "+unidad+"\n Precio de venta: "+precioV;
        return salida;
    }
}
