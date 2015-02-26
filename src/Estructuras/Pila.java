
package Estructuras;

public class Pila extends ListaDoble {
    
    public Pila()
    {
        
    }
    public void push(P_Z dato)
    {
        Insertar(dato);
    }
    public NodoLista pop()
    {
        return EliminarAtras();
    }
    
    public void graficar()
    {
        Grafica("PILA","pilaimg");
    }
}
