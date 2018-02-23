/*
 * Copyright Marote-Somur software(c)
 * Author: Juan Carlos Benjamín Somohano Murrieta
 * This product may not be exchanged under any circumstances
 */

package inventario;

import java.io.Serializable;


public class VentaP implements Serializable {
    private String producto;
    private int cantidad;
    private float precio;
    private int vID;
    private int cantVendida;
    private float iva;
    private float venta;
    private VentaP siguiente;
    private float ganancia;
    public VentaP(int id,Producto p,int cant){
        this.vID=id;
        this.producto=p.getNombre();
        this.cantidad=p.getCantidad();
        this.precio=p.getPrecioV();
        this.cantVendida=cant;
        this.iva=(float) ((this.precio*cantVendida)*0.16);
        this.venta=cantVendida*this.precio;
        this.siguiente=null;
        this.ganancia=(p.getPrecioV()*cant)-p.getPrecioC();
    }
    public int getID(){
        return this.vID;
    }
    public float getPrecio(){
        return this.precio;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public float getGanancia(){
        return this.ganancia;
    }
    public float getIVA(){
        return this.iva;
    }
    public String getNombre(){
        return this.producto;
    }
    public VentaP getSiguiente(){
        return this.siguiente;
    }
    public void setSiguiente(VentaP sig){
        this.siguiente=sig;
    }
    @Override
    public String toString(){
        String cadena="ID de venta: "+this.vID+"\nNombre del producto: "+this.producto+" \nPrecio de venta (IVA incluido): "+this.precio+"\nCantidad vendida: "+this.cantVendida+"\nImporte total: "+this.venta+"\n IVA trasladado: "+this.iva+"\nGanancia"+this.ganancia;
        return cadena;
    }
}
