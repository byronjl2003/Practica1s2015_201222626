
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
        Grafica("Cola","pilaimg");
    }
    
    public ListaDoble ObtenerPrimeros5()
    {
        ListaDoble nodos = new ListaDoble();
        int cont = 0;
        NodoLista aux = this.getPrimero();
        while(aux!=null||cont <5)
        {
            nodos.Insertar(aux.getPersonaje());
            cont++;
            aux = aux.getNext();
        }
        return nodos;
    }
    
}
