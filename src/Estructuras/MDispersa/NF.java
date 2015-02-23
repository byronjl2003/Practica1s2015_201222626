/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.MDispersa;

/**
 *
 * @author Byron <Byron.Jose at your.org>
 */
public class NF {
    
    private int _num;
    private NCasilla _primero, _ultimo;
    private NF _next, _back;
    
    public NF(int num)
        {
            this._num = num;
            this._primero = this._ultimo = null;
        }

        public Boolean Vacio()
        {
            return this.getPrimero() == null;
        }
        public void Agregar(NCasilla node)
        {
            if (Vacio())
            {
                this.setPrimero(this._ultimo = node);
            }
            else
            {
                if (node.getPtrColumna().getNum() < this._primero.getPtrColumna().getNum())
                {
                    node.setDerecha(this._primero);
                    this._primero.setIzquierda(node);
                    this._primero = node;
                }
                else if (node.getPtrColumna().getNum() > this._ultimo.getPtrColumna().getNum())
                {
                    node.setIzquierda(this._ultimo);
                    this._ultimo.setDerecha(node);
                    this._ultimo = node;
                }
                else
                {
                    NCasilla aux = this._primero;
                    while (aux != null)
                    {
                        if (aux.getPtrColumna().getNum() >  node.getPtrColumna().getNum())
                        {
                            break;
                        }
                        else
                        {
                            aux = aux.getADerecha();
                        }

                    }
                    node.setDerecha( aux);
                    node.setIzquierda(aux.getIzquierda());
                    node.getADerecha().setIzquierda(node);
                    node.getIzquierda().setDerecha(node);
                }
            }


        }


        public NCasilla Buscar(NC columna)
        {
            if (!Vacio())
            {
                if (this.getPrimero().getPtrColumna() == columna)
                {
                    return this.getPrimero();
                }
                else if (this.getUltimo().getPtrColumna() == columna)
                {
                    return this.getPrimero();
                }
                else
                {
                    NCasilla aux = this.getPrimero();
                    while (aux != null)
                    {
                        if (aux.getPtrColumna() == columna)
                            return aux;
                        else
                        {
                            aux = aux.getADerecha();
                        }


                    }
                    return aux;
                }
            }
            else
                return null;
        }

        public String ToString()
        {
            return "F" + this.getNum();
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
                    auxc = auxc.Derecha;


            }
            return auxc;
        }
        */

    /**
     * @return the _num
     */
    public int getNum() {
        return _num;
    }

    /**
     * @param _num the _num to set
     */
    public void setNum(int _num) {
        this._num = _num;
    }

    /**
     * @return the _primero
     */
    public NCasilla getPrimero() {
        return _primero;
    }

    /**
     * @param _primero the _primero to set
     */
    public void setPrimero(NCasilla _primero) {
        this._primero = _primero;
    }

    /**
     * @return the _ultimo
     */
    public NCasilla getUltimo() {
        return _ultimo;
    }

    /**
     * @param _ultimo the _ultimo to set
     */
    public void setUltimo(NCasilla _ultimo) {
        this._ultimo = _ultimo;
    }

    /**
     * @return the _next
     */
    public NF getNext() {
        return _next;
    }

    /**
     * @param _next the _next to set
     */
    public void setNext(NF _next) {
        this._next = _next;
    }

    /**
     * @return the _back
     */
    public NF getBack() {
        return _back;
    }

    /**
     * @param _back the _back to set
     */
    public void setBack(NF _back) {
        this._back = _back;
    }
}
