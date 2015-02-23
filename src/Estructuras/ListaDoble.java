
package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;

public class ListaDoble {
    private NodoLista primero;
    private NodoLista ultimo;
    
    public ListaDoble()
    {
        this.primero = this.ultimo = null;
    }
    public boolean vacia()
    {
        return this.getPrimero()==null;
    }
    public void Insertar(P_Z dato)
    {
        if(vacia())
        {
            this.setPrimero(this.ultimo = new NodoLista(dato));
        }
        else
        {
            getUltimo().setNext(new NodoLista(dato));
            getUltimo().getNext().setBack(getUltimo());
            this.setUltimo(getUltimo().getNext());
        }
        
        
    }
    
    public NodoLista EliminarFrente()
    {
        if(!vacia())
        {
            NodoLista eliminado = this.getPrimero();
            if(this.getPrimero()==this.getUltimo())
                this.setPrimero(this.ultimo = null);
            else
                this.setPrimero(this.getPrimero().getNext());
            return eliminado;
        }
        else
            return null;
            
            
        
    }
    
    public NodoLista EliminarAtras()
    {
        if(!vacia())
        {
            NodoLista eliminado = this.getUltimo();
            if(this.getPrimero()==this.getUltimo())
                this.setPrimero(this.ultimo = null);
            else
                this.setUltimo(this.getUltimo().getBack());
            return eliminado;
        }
        else
            return null;
    }
    
    public StringBuilder graficaMatriz()
    {
        StringBuilder recolector = new StringBuilder();
        NodoLista aux = this.primero;
        while(aux!=null)
        {
            recolector.append(aux.getPersonaje().toString()+"\\"+"n");
            aux= aux.getNext();
        }
        return recolector;
    }
    
    public void Graficar(String archivo, String nombreimg)
    {
        try {
            CrearArchivo(nombreimg);
      
      String dotPath = "C:\\Users\\Keila\\Desktop\\release\\bin\\dot.exe";
      
      String fileInputPath = "C:\\Users\\Keila\\Documents\\byron\\"+archivo+".txt";
      String fileOutputPath = "C:\\Users\\Keila\\Documents\\byron\\"+nombreimg+".jpg";
      
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }
    }
    
    public void CrearArchivo(String nombre)
    {
        StringBuilder constructor  = new StringBuilder();
        constructor.append("digraph g{ \n");
        constructor.append("subgraph cluster0 { \n");
        constructor.append("node [style=filled,color=white]; \n");
        constructor.append("style=filled; \n");
        constructor.append("color=lightgrey; \n");
        constructor.append("ranksep = .1; splines=ortho; \n");
        constructor.append("{ \n" +" node [shape = record ]; \n");
        constructor.append(Imprimir().toString());
        constructor.append("[color=white]; \n");
        constructor.append("}\n" +"label = \""+nombre+"\";\n" +"}\n" +"} \n");
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\Keila\\Documents\\byron\\"+nombre+".txt");
            pw = new PrintWriter(fichero);
 
            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        
        
    }
    
    public StringBuilder Imprimir()
    {
        NodoLista aux = this.getPrimero();
        StringBuilder recolector = new StringBuilder();
        while(aux!=null)
        {
            recolector.append(aux.getPersonaje().getNombre());
            if(aux!=getUltimo())
                recolector.append("->");
            
            aux = aux.getNext();
        }
        return recolector;
    }

    
    public NodoLista getPrimero() {
        return primero;
    }

    
    public void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    
    public NodoLista getUltimo() {
        return ultimo;
    }

    
    public void setUltimo(NodoLista ultimo) {
        this.ultimo = ultimo;
    }
    
}
