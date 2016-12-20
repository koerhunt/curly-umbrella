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
public class Convertidor {
    
    public Convertidor(){

    }
    
    //grado 3
    public static Nodo convertirArbolGeneralABinario(Nodo raiz){
        checarNodo(raiz);
        return raiz;
    }
    
    //
    public static Nodo convertirBosqueArbolBinario(Nodo arbol_uno, Nodo arbol_dos){
        incertarHaciaDerecha(arbol_dos,arbol_uno);
        return arbol_uno;
    }
    
    public static void checarNodo(Nodo n){
        
        if(n.getNodoIzq()!=null){
            checarNodo(n.getNodoIzq());
        }
        
        if(n.getNodoCen()!=null){
            checarNodo(n.getNodoCen());
        }
        
        if(n.getNodoCen()!=null){
            incertarHaciaDerecha(n.getNodoCen(), n);
//          incertarHaciaIzquierda(n.getNodoCen(), n);
            n.setNodoCen(null);
        }
        
        if(n.getNodoDer()!=null){
            checarNodo(n.getNodoDer());
        }
                
        if(n.getNodoDer()!=null){
            incertarHaciaDerecha(n.getNodoDer(), n);
            
            //incertarHaciaIzquierda(n.getNodoDer(), n);
            n.setNodoDer(null);
        }
        
    }

    
    private static void incertarHaciaIzquierda(Nodo nodo, Nodo padre) {
        if(padre.getNodoIzq()==null){
            padre.setNodoIzq(nodo);
            nodo.setNodoRaiz(padre);
        }else{
            incertarHaciaDerecha(nodo, padre.getNodoIzq());
            
            //padre.setNodoDer(null);
        }
    }
    
    private static void incertarHaciaDerecha(Nodo nodo, Nodo padre) {
        if(padre.getNodoDer()==nodo){
            incertarHaciaIzquierda(nodo, padre);
        }else{
            if(padre.getNodoDer()==null){
                padre.setNodoDer(nodo);
                nodo.setNodoRaiz(padre);
            }else{
                if(padre.getNodoCen()==nodo){
                    incertarHaciaIzquierda(nodo, padre);
                }else{
                    //incertarHaciaIzquierda(nodo, padre);
                    incertarHaciaDerecha(nodo, padre.getNodoDer());
                }
            }
        }
        
        
        
    }
//    
//    public static int altura(Nodo n){
//        int alt = 0;
//        int alt_izq;
//        int alt_der;
//                
//        if(n!=null){
//            alt_izq = altura(n.getNodoIzq());
//            alt_der = altura(n.getNodoDer());
//            
//            if( alt_izq > alt_der ){
//                return alt_izq + 1;
//            }else{
//                return alt_der + 1;
//            }
//        }
//        return -1;
//    }

    
}
