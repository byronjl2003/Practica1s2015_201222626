
package Estructuras;

public class Cola extends ListaDoble {
    
    public Cola()
    {
        
    }
    public void enqueue(P_Z dato)
    {
        Insertar(dato);
    }
    
    public NodoLista dequeue()
    {
        return EliminarAtras();
    }
    
    public void graficar()
    {
        Graficar("Cola","pilaimg");
    }
    
}
