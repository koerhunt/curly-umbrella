package arbolgeneral;


import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

    
public class Principal{

   static int nivel_max = 4;
  //Constructor por defecto
  public static void main(String[] args){
      
      java.awt.EventQueue.invokeLater(new Runnable() {
          @Override
          public void run() {
              //Nuestros nodos raiz
              Nodo arbol_uno = new Nodo();
              
              Nodo arbol_dos = new Nodo();
              
              nivel_max = Integer.parseInt(JOptionPane.showInputDialog(null, "Cual sera el nivel maximo para el primer arbol?"));
              arbol_uno.setDato(ThreadLocalRandom.current().nextInt(1, 70 + 1));
              System.out.print("R-");
              insertarNodoEnPosicionAleatoria(arbol_uno,1);
              insertarNodoEnPosicionAleatoria(arbol_uno,1);
              insertarNodoEnPosicionAleatoria(arbol_uno,1);
              System.out.println("");
              
              javax.swing.JFrame frame1 = new ArbolVisual(arbol_uno);
              frame1.setVisible(true);
              frame1.setLocation(0, 0);
              
              new Thread(() -> {
                  
                  try {
                      Thread.sleep(1000);
                        javax.swing.JFrame frame2 = new ArbolVisual(Convertidor.convertirArbolGeneralABinario(arbol_uno));
                        frame2.setVisible(true);
                        frame2.setLocation(0, 340);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
              }).start();
              
              
              nivel_max = Integer.parseInt(JOptionPane.showInputDialog(null, "Cual sera el nivel maximo para el primer arbol?"));
              arbol_dos.setDato(ThreadLocalRandom.current().nextInt(1, 70 + 1));
              System.out.print("R-");
              insertarNodoEnPosicionAleatoria(arbol_dos,1);
              insertarNodoEnPosicionAleatoria(arbol_dos,1);
              insertarNodoEnPosicionAleatoria(arbol_dos,1);
              System.out.println("");
              
              javax.swing.JFrame frame3 = new ArbolVisual(arbol_dos);
              frame3.setVisible(true);
              frame3.setLocation(500, 0);
              
              new Thread(() -> {
                  
                  try {
                      Thread.sleep(1000);
                      javax.swing.JFrame frame4 = new ArbolVisual(Convertidor.convertirArbolGeneralABinario(arbol_dos));
                      frame4.setVisible(true);
                      frame4.setLocation(500, 340);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
              }).start();
              
              
              new Thread(() -> {
                  
                  try {
                      Thread.sleep(2000);
                      
                      Nodo binary_tree = Convertidor.convertirBosqueArbolBinario(arbol_uno, arbol_dos);
                      
                      javax.swing.JFrame frame5 = new ArbolVisual(binary_tree);
                      frame5.setVisible(true);
                      frame5.setLocationRelativeTo(null);
                      
                      
                      Thread.sleep(500);
                      System.out.println("Recorrido en inorden");
                      Recorridos.inorden(binary_tree);
                      
                      System.out.println("");
                      System.out.println("Recorrido en postorden");
                      Recorridos.postorden(binary_tree);
                      
                      System.out.println("");
                      System.out.println("Recorrido en preorden");
                      Recorridos.preorden(binary_tree);
                      
                      
                      System.out.println("");
                      System.out.println("Raiz: "+binary_tree.getDato());
                      System.out.println("Cantidad de Hojas: "+Recorridos.contarHojas(binary_tree));
//                      System.out.println("Altura del arbol: "+Convertidor.altura(binary_tree));
                      
                      
                  } catch (InterruptedException ex) {
                      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
              }).start();
              
          }
      });
      
  }

  //Incertamos un nodo en una parte aleatoria, teniendo como padre
  //al nodo recivido.
  public static void insertarNodoEnPosicionAleatoria(Nodo padre, int n){

    //Creamos el nodo
    Nodo nodo = new Nodo();

    //Asignamos su raiz
    nodo.setNodoRaiz(padre);

    //Numero aleatorio para asignar al nodo
    int dato = ThreadLocalRandom.current().nextInt(1, 70 + 1);
    //Asignamos su valor al nodo
    nodo.setDato(dato);

    //Inicializamos una variable para ver en que liga vamos a asignar al nodo
    int numero;

    //---- Checamos las tres ligas para vel en cual podemos incertarlo
    //---- Esto de manera aleatoria y dependiendo de las ligas disponibles

    //Si los tres nodos estan disponibles
    if(padre.getNodoIzq() == null && padre.getNodoCen() == null && padre.getNodoDer() == null){
      //Numero aleatorio para saber en que parte se incertara el nodo
      numero = ThreadLocalRandom.current().nextInt(1, 3 + 1);
      //Si el nodo izquierdo y el del centro estan disponibles
    }else if(padre.getNodoIzq() == null && padre.getNodoCen() == null && padre.getNodoDer() != null){
      //generar 1 o 2;
      numero = ThreadLocalRandom.current().nextInt(1, 2 + 1);
      //si el nodo izquierdo y el derecho estan disponibles
    }else if(padre.getNodoIzq() == null && padre.getNodoCen() != null && padre.getNodoDer() != null){
      //generar 1 o 3;
      numero = ThreadLocalRandom.current().nextInt(1, 2 + 1);
      if(numero==1){
        numero = 1;
      }else{
        numero = 3;
      }
      //si solo el nodo izquierdo esta disponible
    }else if (padre.getNodoIzq() == null && padre.getNodoCen() != null && padre.getNodoDer() != null){
      numero = 1;
      //si el nodo del centro y el derecho estan disponibles
    }else if (padre.getNodoIzq() != null && padre.getNodoCen() == null && padre.getNodoDer() == null){
      //generar 2 o 3
      numero = ThreadLocalRandom.current().nextInt(2, 3 + 1);
      //Si solo el nodo del centro esta disponible
    }else if(padre.getNodoIzq() != null && padre.getNodoCen() == null && padre.getNodoDer() != null){
      //gemerar 2
      numero = 2;
    }else{
      //El nodo derecho esta disponible
      numero = 3;
    }

    //Asignamos el nodo a la liga correspondiente
    switch(numero){
      case 1:
        padre.setNodoIzq(nodo);
        System.out.print("I-");
        break;
      case 2:
        padre.setNodoCen(nodo);
        System.out.print("C-");
        break;
      case 3:
        padre.setNodoDer(nodo);
        System.out.print("D-");
        break;
    }

    if(n<nivel_max){
      insertarNodoEnPosicionAleatoria(nodo,n+1);
    }
  }

      
    //grado 3
    public Nodo convertirArbolGeneralABinario(Nodo raiz){
        checarNodo(raiz);
        return raiz;
    }
    
    public void checarNodo(Nodo n){
        
        if(n.getNodoIzq()!=null){
            checarNodo(n.getNodoIzq());
        }
        
        if(n.getNodoCen()!=null){
            checarNodo(n.getNodoCen());
        }
        
        if(n.getNodoDer()!=null){
            checarNodo(n.getNodoDer());
        }
        
        
        //if(n.getNodoCen()!=null){
        //    throw new UnsupportedOperationException();
        //}
        
        if(n.getNodoDer()!=null){
            incertarHaciaDerecha(n.getNodoDer(), n);
            //n.setNodoDer(null);
        }
        
    }

    
    private void incertarHaciaIzquierda(Nodo nodo, Nodo padre) {
        if(padre.getNodoIzq()==null){
            padre.setNodoIzq(nodo);
        }else{
            incertarHaciaDerecha(nodo, padre.getNodoIzq());
            padre.setNodoDer(null);
        }
    }
    
    private void incertarHaciaDerecha(Nodo nodo, Nodo padre) {
        if(padre.getNodoDer()==nodo){
            incertarHaciaIzquierda(nodo, padre);
        }
        
//        if(padre.getNodoCen()==nodo){
//            incertarHaciaIzquierda(nodo, padre);
//        }
        
        if(padre.getNodoDer()==null){
            padre.setNodoDer(nodo);
        }
        
    }



}
