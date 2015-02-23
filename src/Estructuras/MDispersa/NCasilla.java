
package Estructuras.MDispersa;

import Estructuras.ListaDoble;
import Estructuras.P_Z;

/**
 *
 * @author Byron <Byron.Jose at your.org>
 */
public class NCasilla {
    
    private NF _ptrfila;
    private NC _ptrcolumna;
    private ListaDoble lista;
    private NCasilla _arriba, _abajo, _derecha, _izquierda;
    
    public NCasilla getArriba()
    {
        return this._arriba;
    }
    public void setArriba(NCasilla ca)
    {
        this._arriba = ca;
    }
    public NCasilla getAbajo()
    {
        return this._abajo;
    }
    public void setAbajo(NCasilla ca)
    {
        this._abajo = ca;
    }
    
    public NCasilla getADerecha()
    {
        return this._derecha;
    }
    public void setDerecha(NCasilla ca)
    {
        this._derecha =  ca;
    }
    public NCasilla getIzquierda()
    {
        return this._izquierda;
    }
    public void setIzquierda(NCasilla ca)
    {
        this._izquierda =  ca;
    }
    public NF getPtrFila()
    {
        return this._ptrfila;
    }
    public void setPtrFila(NF fil)
    {
        this._ptrfila = fil;
    }
    public NC getPtrColumna()
    {
        return this._ptrcolumna;
    }
    public void setPtrColumna(NC col)
    {
        this._ptrcolumna = col;
    }
        


        public NCasilla(NC columna, NF fila)
        {
            this.lista = new ListaDoble();
            this._ptrcolumna = columna;
            this._ptrfila = fila;

        }
        
        public void Agregar(P_Z personaje)
        {
            this.lista.Insertar(personaje);
        }
        
        public StringBuilder graficaCasillaH()
        {
            StringBuilder recolector = new StringBuilder();
            if(this.getIzquierda()!=null)
            {
                recolector
            }
        }
        
        public String ToString()
        {
            return "NODO"+this._ptrcolumna.getNum()+this._ptrfila.getNum();
        }
        /*
        public NM Agregar(String dato, int dimension)
        {
            NM ta = Buscar(dimension);
            if (Buscar(dimension) == null)
            {
                NM nodo = new NM(dato, dimension);
                if (Vacia())
                {
                    this.Primero = this.Ultimo = nodo;
                    return nodo;

                }
                else
                {
                    if (dimension < this.Primero.Dimension)
                    {
                        nodo.Next = this.Primero;
                        this.Primero.Back = nodo;
                        this.Primero = nodo;
                        return nodo;
                    }
                    else if (dimension > this.Ultimo.Dimension)
                    {
                        nodo.Back = this.Ultimo;
                        this.Ultimo.Next = nodo;
                        this.Ultimo = nodo;
                        return nodo;
                    }
                    else
                    {
                        NM aux = this.Primero;
                        while (aux != null)
                        {
                            if (aux.Dimension > dimension)
                            {
                                break;
                            }
                            else
                            {
                                aux = aux.Next;
                            }

                        }
                        nodo.Next = aux;
                        nodo.Back = aux.Back;
                        nodo.Next.Back = nodo;
                        nodo.Back.Next = nodo;
                        return nodo;
                    }
                }
            }
            else
                return null;


        }

        public Boolean Vacia()
        {
            return this._primero == null;
        }

        public NM Buscar(int dim)
        {
            if (!Vacia())
            {
                if (dim == this.Primero.Dimension)
                    return this.Primero;
                else if (dim == this.Ultimo.Dimension)
                    return this.Ultimo;
                else
                {
                    NM aux = this.Primero;
                    while (aux != null)
                    {
                        if (dim == aux.Dimension)
                        {
                            return aux;
                        }
                        aux = aux.Next;
                    }
                    return aux;
                }
            }
            else
            {
                return null;
            }

        }
/*
        public String[] relacionesH()
        {
            String[] relations = new String[4];
            relations[0] = "";
            relations[1] = "";
            relations[2] = "";
            relations[3] = "";
            NM aux = this.Primero;
            while (aux != null)
            {


                if (this.Derecha != null)
                {

                    NCasilla casillaaux = this.Derecha;
                    while (casillaaux != null)
                    {

                        NM aux2 = casillaaux.Buscar(aux.Dimension);
                        if (aux2 != null)
                        {
                            relations[aux.Dimension - 1] = relations[aux.Dimension - 1] + aux.ToString() + this.Ptrcolumna.Letra + this.Ptrfila.Num + " -> " + aux2.ToString() + casillaaux.Ptrcolumna.Letra + casillaaux.Ptrfila.Num + "; " + aux2.ToString() + casillaaux.Ptrcolumna.Letra + casillaaux.Ptrfila.Num + " -> " + aux.ToString() + this.Ptrcolumna.Letra + this.Ptrfila.Num + ";";
                            break;
                        }
                        else
                        {

                            casillaaux = casillaaux.Derecha;
                        }



                    }

                }

                /*
                if (this.Izquierda != null)
                {
                    NCasilla casillaaux = this.Izquierda;
                    while (casillaaux != null)
                    {

                        NM aux2 = casillaaux.Buscar(aux.Dimension);
                        if (aux2 != null)
                        {
                            relations[aux.Dimension - 1] = relations[aux.Dimension - 1] + aux.ToString() + this.Ptrcolumna.Letra + this.Ptrfila.Num + " -> " + aux2.ToString() + casillaaux.Ptrcolumna.Letra + casillaaux.Ptrfila.Num + "; " + aux2.ToString() + casillaaux.Ptrcolumna.Letra + casillaaux.Ptrfila.Num + " -> " + aux.ToString() + this.Ptrcolumna.Letra + this.Ptrfila.Num + ";";
                            break;
                        }
                        else
                        {
                            casillaaux = casillaaux.Izquierda;
                        }


                    }
                }
                

                aux = aux.Next;

            }

            return relations;
        }



        public String[] relacionesV()
        {
            String[] relations = new String[4];
            relations[0] = "";
            relations[1] = "";
            relations[2] = "";
            relations[3] = "";
            NM aux = this.Primero;
            while (aux != null)
            {

                if (this.Abajo != null)
                {
                    NCasilla casillaaux = this.Abajo;
                    while (casillaaux != null)
                    {

                        NM aux2 = casillaaux.Buscar(aux.Dimension);
                        if (aux2 != null)
                        {
                            relations[aux.Dimension - 1] = relations[aux.Dimension - 1] + aux.ToString() + this.Ptrcolumna.Letra + this.Ptrfila.Num + " -> " + aux2.ToString() + casillaaux.Ptrcolumna.Letra + casillaaux.Ptrfila.Num + "; " + aux2.ToString() + casillaaux.Ptrcolumna.Letra + casillaaux.Ptrfila.Num + " -> " + aux.ToString() + this.Ptrcolumna.Letra + this.Ptrfila.Num + ";";
                            break;
                        }
                        else
                        {
                            casillaaux = casillaaux.Abajo;
                        }


                    }
                }

                
                if (this.Arriba != null)
                {

                    NCasilla casillaaux = this.Arriba;
                    while (casillaaux != null)
                    {

                        NM aux2 = casillaaux.Buscar(aux.Dimension);
                        if (aux2 != null)
                        {
                            relations[aux.Dimension - 1] = relations[aux.Dimension - 1] + aux.ToString() + this.Ptrcolumna.Letra + this.Ptrfila.Num + " -> " + aux2.ToString() + casillaaux.Ptrcolumna.Letra + casillaaux.Ptrfila.Num + "; " + aux2.ToString() + casillaaux.Ptrcolumna.Letra + casillaaux.Ptrfila.Num + " -> " + aux.ToString() + this.Ptrcolumna.Letra + this.Ptrfila.Num + ";";
                            break;
                        }
                        else
                        {
                            casillaaux = casillaaux.Arriba;
                        }


                    }




                }
                
                

                aux = aux.Next;
            }
            return relations;
        }


        public String ToString()
        {
            //return "Casilla" + this.Ptrcolumna.Letra + this.Ptrfila.Num;
        }
*/    
}
