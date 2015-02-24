/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.MDispersa;

import Estructuras.P_Z;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Byron <Byron.Jose at your.org>
 */
public class MDisp {
    private LNC _lcolumnas;
    public MDisp()
        {
            this._lcolumnas = new LNC();

        }
        public Boolean Vacio()
        {
            return this._lcolumnas.Vacio();
        }

        public void Insertar(int col, int fil,P_Z personaje)
        {
            NC Columna = this._lcolumnas.AgregarColumna(col);
            NF Fila = this._lcolumnas.getListaFilas().Agregar(fil);
            NCasilla casilla = Columna.Agregar(Fila,personaje);

        }
        
        public void Graficar(String nombre)
        {
            StringBuilder recolector = new StringBuilder();
            recolector.append("digraph g{"+"\n");
            recolector.append(this._lcolumnas.NodosGeneral()+"\n");
            recolector.append(this._lcolumnas.getListaFilas().graffila()+"\n");
            recolector.append(this._lcolumnas.GraficasCol()+"\n");
            recolector.append("\n");
            recolector.append("}");
            //return recolector;
            
            FileWriter fichero = null;
            PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\S. Alexander\\Documents\\byron\\"+nombre+".txt");
            pw = new PrintWriter(fichero);
 
           
                pw.println(recolector.toString());
 
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
        
        
        /*
        public StringBuilder[] graficarMDispersa()
        {
            StringBuilder[] gen = new StringBuilder[4];
 
            StringBuilder[] recolector = this.Lcolumnas.ListaFilas.GraficaHorizontal();
            StringBuilder[] reco = this._lcolumnas.GraficaVertical();
            for (int i = 0; i < recolector.Length; i++)
            {
               
                    gen[i] = new StringBuilder();
                    gen[i].AppendLine("digraph g{");
                    gen[i].AppendLine("ranksep = .5; splines=ortho;");
                    gen[i].AppendLine(recolector[i].ToString());
                    gen[i].AppendLine(reco[i].ToString());
                    gen[i].AppendLine("}");
                    
                

            }
            return gen;

        }
        */
}
