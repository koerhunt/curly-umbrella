package arbolgeneral;


import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

    
public class Principal{

   static int nivel_max = 4;
  //Constructor por defecto
  public static void main(String[] args){
      
      java.awt.EventQueue.invokeLater(() -> {
          
        //Nuestros nodos raiz
        Nodo arbol_uno = new Nodo();
        Nodo arbol_dos = new Nodo();
        
        nivel_max = Integer.parseInt(JOptionPane.showInputDialog(null, "Cual sera el nivel maximo para el primer arbol?"));
        arbol_uno.setDato(ThreadLocalRandom.current().nextInt(1, 70 + 1));
        System.out.print("R-");
        insertarNodoEnPosicionAleatoria(arbol_uno,1);
        insertarNodoEnPosicionAleatoria(arbol_uno,1);
        System.out.println("");
        new ArbolVisual(arbol_uno).setVisible(true);

        nivel_max = Integer.parseInt(JOptionPane.showInputDialog(null, "Cual sera el nivel maximo para el segundo arbol?"));
        arbol_dos.setDato(ThreadLocalRandom.current().nextInt(1, 70 + 1));
        System.out.print("R-");
        insertarNodoEnPosicionAleatoria(arbol_dos,1);
        insertarNodoEnPosicionAleatoria(arbol_dos,1);
        System.out.println("");
        new ArbolVisual(arbol_dos).setVisible(true);

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



}
