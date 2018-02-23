/*
 * Copyright Marote-Somur software(c)
 * Author: Juan Carlos Benjamín Somohano Murrieta
 * This product may not be exchanged under any circumstances
 */

package inventario;

import java.io.Serializable;
public class InventarioP implements Serializable {
    private Producto primero;
    private Producto ultimo(){
        if(this.isEmpty()){
            return null;
        }
        Producto aux=this.primero;
        while(aux.getSiguiente()!=null){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    private int tamanio;
   // private int[]pids=new int[15];
    private int c=0;
    public InventarioP(){
     this.tamanio=0;
     this.primero=null;
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
    public boolean buscar(int id){
        boolean res=false;
      
        return res;
    }
    public void insertar(Producto p){
        Producto aux=new Producto(c,p.getNombre(),p.getDescripcion(),p.getUnidad(),p.getCantidad(),p.getPrecioC());
        Producto ultimo=this.ultimo();
        if(ultimo==null){
            this.primero=aux;
        }else{
            ultimo.setSiguiente(aux);
        }
        this.tamanio++;
        this.c++;
    }
    public Producto getProducto(int pos){
        if(pos<0||pos>this.getTamanio()){
            return null;
        }
        Producto aux=this.primero;
        for(int x=0;x<pos;x++){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    public void pop(){
        if(this.isEmpty()){
            System.out.println("\nInventario vacio\n");
            return;
        }
        Producto prodAnterior=this.primero;
        this.primero=prodAnterior.getSiguiente();
        this.tamanio--;
    }
    public void eliminar(int pos){
        if(pos<0||pos>this.getTamanio()){
            System.out.println("\nPosicion invalida\n");
        }
        if(pos==0){
            this.pop();
        }else{
            Producto prodAnterior=this.getProducto(pos-1);
            if(prodAnterior==null){
                System.out.println("Producto no encontrado intente de nuevo\n");
                return;
            }
            Producto siguiente=prodAnterior.getSiguiente().getSiguiente();
            prodAnterior.getSiguiente().setSiguiente(null);
            prodAnterior.setSiguiente(siguiente);
            this.tamanio--;
        }
    }
    
    public void imprimir(){
        System.out.println("Inventario:\n");
        if(this.isEmpty()){
            System.out.println("Error :: InventarioP inventario vacío\n");
            return;
        }
        for(int x=0;x<this.tamanio;x++){
            System.out.println(this.getProducto(x).toString());
            System.out.println("\n");
        }
    }
}
