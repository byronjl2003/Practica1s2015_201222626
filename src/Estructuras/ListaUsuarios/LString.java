
package Estructuras.ListaUsuarios;

import Estructuras.NodoLista;

public class LString {
    
    private NodoString primero;
    private NodoString ultimo;
    String id;
    int tam = 0;
    public LString(String i)
    {
        this.id = i;
        this.primero = this.ultimo = null;
    }
    public boolean vacia()
    {
        return this.getPrimero()==null;
    }
    public void Insertar(String dato,String idusu)
    {
        if(vacia())
        {
            this.primero = new NodoString(dato,tam,idusu);
            this.ultimo = this.primero;
            tam++;
        }
        else
        {
            getUltimo().setNext(new NodoString(dato,tam,idusu));
            getUltimo().getNext().setBack(getUltimo());
            this.setUltimo(getUltimo().getNext());
            tam++;
            
        }
        
        
    }
    
     public NodoString getPrimero() {
        return primero;
    }

    
    public void setPrimero(NodoString primero) {
        this.primero = primero;
    }

    
    public NodoString getUltimo() {
        return ultimo;
    }

    
    public void setUltimo(NodoString ultimo) {
        this.ultimo = ultimo;
    }
    
    
    
    
      public StringBuilder graficar()
        {
            StringBuilder recolector = new StringBuilder();
            
            NodoString aux = this.primero;
            while(aux!=null)
            {
                recolector.append(aux.ToString()+"[label=\""+aux.getStuff()+"\"];");
                aux = aux.getNext();
            }
            recolector.append("{rank = same;");
            NodoString aux2 = this.primero;
            while(aux2!=null)
            {
                recolector.append(aux2.graficastuff());
                aux2 = aux2.getNext();
            }
            recolector.append("}\n");
            return recolector;
        }
    
}
