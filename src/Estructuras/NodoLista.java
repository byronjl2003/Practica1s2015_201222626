
package Estructuras;

public class NodoLista {
    private NodoLista Next,Back;
    private P_Z personaje;
    
    public NodoLista(P_Z per)
    {
        this.personaje = per;
    }

   
    public NodoLista getNext() {
        return Next;
    }

   
    public void setNext(NodoLista Next) {
        this.Next = Next;
    }

    public NodoLista getBack() {
        return Back;
    }

   
    public void setBack(NodoLista Back) {
        this.Back = Back;
    }

   
    public P_Z getPersonaje() {
        return personaje;
    }

    public void setPersonaje(P_Z personaje) {
        this.personaje = personaje;
    }
    
    
}
