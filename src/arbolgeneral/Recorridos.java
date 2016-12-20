/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgeneral;

/**
 *
 * @author elias
 */
public class Recorridos {


    public void Recorridos(){
    }


    //(izquierdo, raíz, derecho)
    public static void inorden(Nodo nodo_binario){

        if(nodo_binario.getNodoIzq()!=null){
            inorden(nodo_binario.getNodoIzq());
        }

        System.out.print(nodo_binario.getDato()+" - ");

        if(nodo_binario.getNodoDer()!=null){
            inorden(nodo_binario.getNodoDer());
        }

    }

    //(izquierdo, derecho, raíz)
    public static void postorden(Nodo nodo_binario){

        if(nodo_binario!=null){

        postorden(nodo_binario.getNodoIzq());
        postorden(nodo_binario.getNodoDer());

        System.out.print(nodo_binario.getDato()+" - ");

        }
    }

    //(raíz, izquierdo, derecho)
    public static void preorden(Nodo nodo_binario){

        if(nodo_binario!=null){
            System.out.print(nodo_binario.getDato()+" - ");

            preorden(nodo_binario.getNodoIzq());

            preorden(nodo_binario.getNodoDer());
        }
    }


    public static int contarHojas(Nodo nodo){
        if(nodo==null)
            return 0;

        if(nodo.getNodoIzq()==null && nodo.getNodoDer()==null ){
            return 1;
        }else{
            return contarHojas(nodo.getNodoIzq()) + contarHojas(nodo.getNodoDer());
        }
    }

}
