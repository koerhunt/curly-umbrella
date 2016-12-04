package arbolgeneral;

public class Nodo{

    
  //metodos para dibujar
  public int x;
  public int y;
    
  //Ligas
  private Nodo raiz = null;
  private Nodo izq = null;
  private Nodo cen = null;
  private Nodo der = null;


  //Dato
  private int dato;

  //Constructor
  public void Nodo(){
  }

  //Getters
  public Nodo getNodoRaiz(){ return this.raiz; }
  public Nodo getNodoIzq(){ return this.izq; }
  public Nodo getNodoCen(){ return this.cen; }
  public Nodo getNodoDer(){ return this.der; }
  public int getDato(){ return this.dato; }

  //Setters
  public void setNodoRaiz(Nodo nodo){ this.raiz = nodo; }
  public void setNodoIzq(Nodo nodo){ this.izq = nodo; }
  public void setNodoCen(Nodo nodo){ this.cen = nodo; }
  public void setNodoDer(Nodo nodo){ this.der = nodo; }
  public void setDato(int dato){ this.dato = dato; }

  

}
