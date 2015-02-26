
package Estructuras.ListaUsuarios;

import java.io.FileWriter;
import java.io.PrintWriter;

public class LUsuarios {
    
    private NUsuario primero;
    private NUsuario ultimo;
    
    public LUsuarios()
    {
        this.primero = this.ultimo = null;
    }
    public boolean vacia()
    {
        return this.getPrimero()==null;
    }
    public void Insertar(String nom,int cant,String id)
    {
        if(vacia())
        {
            this.primero = new NUsuario(nom,cant,id);
            this.ultimo = this.primero;
        }
        else
        {
            getUltimo().setNext(new NUsuario(nom,cant,id));
            getUltimo().getNext().setBack(getUltimo());
            this.setUltimo(getUltimo().getNext());
        }
        
        
    }
    public NUsuario getuserbyid(String id)
    {
        NUsuario aux = this.primero;
        while(aux!=null)
        {
            if(aux.getId().equals(id))
                return aux;
            else
                aux = aux.getNext();
           
        }
        return aux;
    }
    
     public NUsuario getPrimero() {
        return primero;
    }

    
    public void setPrimero(NUsuario primero) {
        this.primero = primero;
    }

    
    public NUsuario getUltimo() {
        return ultimo;
    }

    
    public void setUltimo(NUsuario ultimo) {
        this.ultimo = ultimo;
    }
    
    
    
     public void Graficar(String archivo, String nombreimg)
    {
        try {
            CrearArchivo(archivo);
      
      String dotPath = "C:\\byron\\release\\bin\\dot.exe";
      
      String fileInputPath = "C:\\byron\\"+archivo+".txt";
      String fileOutputPath = "C:\\byron\\"+nombreimg+".jpg";
      
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
        constructor.append("node [shape = record ];\n");
        //----encabezado de usuarios
        NUsuario aux = this.primero;
        while(aux!=null)
        {
            constructor.append(aux.ToStringEncabezado());
            aux = aux.getNext();
        }
        //-- ralaciones entre usuarios
        NUsuario aux2 = this.primero;
        while(aux2!=null)
        {
            if(aux2.getNext()!=null)
                constructor.append(aux2.ToString()+"->"+aux2.getNext().ToString());
            aux2 = aux2.getNext();
        }
        constructor.append(";"+"\n");
        //-- se grafica los string en cada usuario
        
        NUsuario aux3 = this.primero;
        while(aux3!=null)
        {
            constructor.append(aux3.getLstuff().graficar());
            if(aux3.getLstuff().getPrimero()!=null)
            constructor.append(aux3.ToString()+" -> "+aux3.getLstuff().getPrimero().ToString()+";\n");
            aux3 = aux3.getNext();
        }
        
        constructor.append("\n }");
        
        
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\byron\\"+nombre+".txt");
            pw = new PrintWriter(fichero);
 
            
                pw.println(constructor.toString());
 
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
   
}
