/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.MDispersa;

import Estructuras.P_Z;

/**
 *
 * @author Byron <Byron.Jose at your.org>
 */
public class NC {
    
    private int _num;
    private NCasilla _primero;
    private NCasilla _ultimo;
    private NC _next;
    private NC _back;


        public NC(int num)
        {
            this._num = num;
            this._primero = this._ultimo = null;
        }
        public Boolean Vacia()
        {
            return this.getPrimero() == null;
        }

        public NCasilla Buscar(NF fila)
        {
            if (!Vacia())
            {
                if (this.getPrimero().getPtrFila() == fila)
                {
                    return this.getPrimero();
                }
                else if (this.getUltimo().getPtrFila() == fila)
                {
                    return this.getUltimo();
                }
                else
                {
                    NCasilla aux = this.getPrimero();
                    while (aux != null)
                    {
                        if (aux.getPtrFila() == fila)
                            return aux;
                        else
                            aux = aux.getAbajo();
                    }
                    return null;
                }
            }
            else
                return null;

        }
        public NCasilla Agregar(NF fila,P_Z personaje)
        {
            NCasilla casilla = Buscar(fila);
            if (casilla == null)// no existe la casilla central
            {
                casilla = new NCasilla(this, fila);
                casilla.Agregar(personaje);
                if (Vacia())
                {
                    this.setPrimero(this._ultimo = casilla);
                    fila.Agregar(casilla);
                    return casilla;

                }
                else
                {
                    if (casilla.getPtrFila().getNum() < this.getPrimero().getPtrFila().getNum())// se agrega como primero por la fila
                    {
                        casilla.setAbajo(this.getPrimero());
                        this.getPrimero().setArriba(casilla);
                        this.setPrimero(casilla);
                        fila.Agregar(casilla);
                        return casilla;
                    }
                    else if (casilla.getPtrFila().getNum() > this.getUltimo().getPtrFila().getNum())
                    {
                        casilla.setArriba(this.getUltimo()); 
                        this.getUltimo().setAbajo(casilla);
                        this.setUltimo(casilla);
                        fila.Agregar(casilla);
                        return casilla;
                    }
                    else// se va a ingresar entre dos casillas
                    {
                        NCasilla aux = this.getPrimero();
                        while (aux != null)
                        {
                            if (aux.getPtrFila().getNum() > casilla.getPtrFila().getNum())// se localiza el nodo en la columna que vaya abajo
                                break;
                            else
                                aux = aux.getAbajo();
                        }
                        casilla.setAbajo(aux);
                        casilla.setArriba(aux.getArriba());
                        casilla.getAbajo().setArriba(casilla);
                        casilla.getArriba().setAbajo(casilla);
                        fila.Agregar(casilla);
                        return casilla;

                    }
                }

            }
            else// si existe la casilla central, hay que meter el dato a la casilla si es que su dimension no esta ocupada
            {
                casilla.Agregar(personaje);
                return casilla;
            }


        }


        
        /*
        
        public NCasilla TraerPrimeroPorDim(int dim)
        {
            NM au = null;
            NCasilla auxc = this.Primero;
            while (auxc != null)
            {
                au = auxc.Buscar(dim);
                if (au != null)
                    return auxc;
                else
                    auxc = auxc.Abajo;


            }
            return auxc;
        }
*/
        public String ToString()
        {
            return "C_" + this.getNum();
        }

    
    public int getNum() {
        return _num;
    }

   
    public void setNum(int _num) {
        this._num = _num;
    }

   
    public NCasilla getPrimero() {
        return _primero;
    }

   
    public void setPrimero(NCasilla _primero) {
        this._primero = _primero;
    }

    
    public NCasilla getUltimo() {
        return _ultimo;
    }

   
    public void setUltimo(NCasilla _ultimo) {
        this._ultimo = _ultimo;
    }

   
    public NC getNext() {
        return _next;
    }

    
    public void setNext(NC _next) {
        this._next = _next;
    }

   
    public NC getBack() {
        return _back;
    }

    
    public void setBack(NC _back) {
        this._back = _back;
    }
    
}
