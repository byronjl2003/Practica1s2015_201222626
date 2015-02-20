
package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;

public class ListaDoble {
    NodoLista primero;
    NodoLista ultimo;
    
    public ListaDoble()
    {
        this.primero = this.ultimo = null;
    }
    public boolean vacia()
    {
        return this.primero==null;
    }
    public void Insertar(P_Z dato)
    {
        if(vacia())
        {
            this.primero = this.ultimo = new NodoLista(dato);
        }
        else
        {
            ultimo.setNext(new NodoLista(dato));
            ultimo.getNext().setBack(ultimo);
            this.ultimo = ultimo.getNext();
        }
        
        
    }
    
    public NodoLista EliminarFrente()
    {
        if(!vacia())
        {
            NodoLista eliminado = this.primero;
            if(this.primero==this.ultimo)
                this.primero = this.ultimo = null;
            else
                this.primero = this.primero.getNext();
            return eliminado;
        }
        else
            return null;
            
            
        
    }
    
    public NodoLista EliminarAtras()
    {
        if(!vacia())
        {
            NodoLista eliminado = this.ultimo;
            if(this.primero==this.ultimo)
                this.primero = this.ultimo = null;
            else
                this.ultimo = this.ultimo.getBack();
            return eliminado;
        }
        else
            return null;
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
        NodoLista aux = this.primero;
        StringBuilder recolector = new StringBuilder();
        while(aux!=null)
        {
            recolector.append(aux.getPersonaje().getNombre());
            if(aux!=ultimo)
                recolector.append("->");
            
            aux = aux.getNext();
        }
        return recolector;
    }
    
}
