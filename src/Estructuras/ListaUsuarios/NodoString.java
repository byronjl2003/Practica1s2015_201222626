
package Estructuras.ListaUsuarios;


public class NodoString {
    
    private String stuff = "";

    private NodoString next;
    private NodoString back;
     int id;
     String idusu;
    public NodoString(String st, int i,String idusu)
    {
        this.idusu = idusu;
        this.stuff = st;
        this.next = this.back = null;
       this.id = i;
    }
    
    public String ToString()
    {
        return"Nodo"+id+idusu;
    }
    public StringBuilder graficastuff()
        {
            StringBuilder recolector = new StringBuilder();
            
            if(this.back!=null)
            {
                recolector.append(this.back.ToString()+" -> "+this.ToString()+";\n");
                
            }
           // if(this.next!=null)
            //{
              //  recolector.append(this.ToString()+" -> "+this.next.ToString()+";\n");
                
            //}
            
            
            
          
            
            return recolector;
        }
        
    
    /**
     * @return the stuff
     */
    public String getStuff() {
        return stuff;
    }

    /**
     * @param stuff the stuff to set
     */
    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    /**
     * @return the next
     */
    public NodoString getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoString next) {
        this.next = next;
    }

    /**
     * @return the back
     */
    public NodoString getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(NodoString back) {
        this.back = back;
    }
    
}
