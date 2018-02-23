/*
 * Copyright Marote-Somur software(c)
 * Author: Juan Carlos Benjamín Somohano Murrieta
 * This product may not be exchanged under any circumstances
 */

package inventario;

import java.io.Serializable;

public class Ventas implements Serializable {
    private int tamanio;
    private int id=0;
    private VentaP primero;
    private VentaP ultimo(){
        if(this.isEmpty()){
            return null;
        }
        VentaP aux=this.primero;
        while(aux.getSiguiente()!=null){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    public Ventas(){
        this.tamanio=0;
        
    }
   public boolean isEmpty(){
    if(this.primero==null){
            return true;
        }else{
            return false;
        }   
   }
   public int getTamanio(){
       return this.tamanio;
   }
   public void agregar(Producto p,int cant){
       VentaP aux=new VentaP(id,p,cant);
        VentaP ultimo=this.ultimo();
        if(ultimo==null){
            this.primero=aux;
        }else{
            ultimo.setSiguiente(aux);
        }
        this.tamanio++;
        this.id++;
   }
   public VentaP getProducto(int pos){
        if(pos<0||pos>this.getTamanio()){
            return null;
        }
        VentaP aux=this.primero;
        for(int x=0;x<pos;x++){
            aux=aux.getSiguiente();
        }
        return aux;
    }
     public void imprimir(){
         int ivaTotal=0;
         int gananciasTotales=0;
         float costoInventario=0;
        System.out.println("Ventas:\n");
        if(this.isEmpty()){
            System.out.println("Error :: VentaP inventario vacío\n");
            return;
        }
        for(int x=0;x<this.tamanio;x++){
            ivaTotal+=this.getProducto(x).getIVA();
            gananciasTotales+=this.getProducto(x).getGanancia();
            System.out.println(this.getProducto(x).toString());
            System.out.println("\n");
            
        }
        costoInventario=(float) (gananciasTotales*0.9);
        costoInventario-=gananciasTotales;
        if(costoInventario<0){
            costoInventario*=-1;
        }
        System.out.println("Ganancias totales: "+gananciasTotales+"\n IVA trasladado total: "+ivaTotal+"\nCosto de inventario: "+costoInventario+"\n");
    }
     
}
