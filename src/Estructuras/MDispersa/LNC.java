
package Estructuras.MDispersa;


public class LNC {
    
     private LNF _listaFilas;
     private NC _primero;
     private NC _ultimo;

     public LNC()
     {
            this._primero = this._ultimo = null;
            this._listaFilas = new LNF();
     }

        public Boolean Vacio()
        {
            return this.getPrimero() == null;
        }

   
        public NC AgregarColumna(int col)
        {
            NC Columna = BuscarColumna(col);
            if (Columna == null)
            {
                NC nuevo = new NC(col);
                if (Vacio())
                {
                    this.setPrimero(this._ultimo = nuevo);
                    return nuevo;
                }

                else if (this.getPrimero().getNum()> col)
                {

                    nuevo.setNext(this.getPrimero());
                    this.getPrimero().setBack(nuevo);
                    this.setPrimero(nuevo);
                    return nuevo;

                }
                else if (this.getUltimo().getNum() < col)
                {
                    nuevo.setBack(this.getUltimo());
                    this.getUltimo().setNext(nuevo);
                    this.setUltimo(nuevo);
                    return nuevo;
                }
                else
                {
                    NC aux = this.getPrimero();
                    while (aux != null)
                    {
                        if (aux.getNum() > col )
                        {
                            nuevo.setNext(aux);
                            nuevo.setBack(aux.getBack());
                            nuevo.getNext().setBack(nuevo);
                            nuevo.getBack().setNext(nuevo);
                            return nuevo;
                        }
                        else
                        {
                            aux = aux.getNext();
                        }
                    }
                    return null;
                }

            }
            else
                return Columna;

        }



        public NC BuscarColumna(int col)
        {
            if (!Vacio())
            {
                if (this.getPrimero().getNum() == col)
                    return this.getPrimero();
                else if (this.getUltimo().getNum() ==col)
                    return this.getUltimo();
                else
                {
                    NC aux = this.getPrimero();
                    while (aux != null)
                    {
                        if (aux.getNum() == col)
                        {
                            return aux;
                        }
                        else
                        {
                            aux = aux.getNext();
                        }

                    }
                    return null;
                }
            }
            else
                return null;
        }

        
        public StringBuilder GraficaColumna()
        {
            StringBuilder recolector = new StringBuilder();
            
        }
        
/*
        public StringBuilder[] GraficaVertical()
        {
            StringBuilder[] recolectores = new StringBuilder[4];
            recolectores[0] = new StringBuilder();
            recolectores[1] = new StringBuilder();
            recolectores[2] = new StringBuilder();
            recolectores[3] = new StringBuilder();

            String st1 = "rank = same; raiz ";
            String st2 = "raiz ";
            String st3 = "";
            String st1f = "raiz";
            String st2f = "";
            NC auxx = this.Primero;
            while (auxx != null)
            {
                st1 = st1 + auxx.ToString() + ";";
                st2 = st2 + "-> " + auxx.ToString();
                auxx = auxx.Next;

            }
            st2 = st2 + ";";
            NC au = this.Ultimo;
            while (au != null)
            {
                if (au == this.Primero)
                {
                    st3 = st3 + au.ToString() + ";";
                }
                else
                {
                    st3 = st3 + au.ToString() + "->";
                }
                au = au.Back;
            }
            NF auf = this.ListaFilas.Primero;
            while (auf != null)
            {
                st1f = st1f + " -> " + auf.ToString();
                auf = auf.Next;
            }
            st1f = st1f + ";";


            NF auG = this.ListaFilas.Ultimo;
            while (auG != null)
            {
                if (auG == this.ListaFilas.Primero)
                {
                    st3 = st3 + auG.ToString() + ";";
                }
                else
                {
                    st3 = st3 + auG.ToString() + "->";
                }
                auG = auG.Back;
            }
            for (int i = 0; i < 4; i++)
            {
                recolectores[i].AppendLine("{");
                recolectores[i].AppendLine(st1);
                recolectores[i].AppendLine("}");
                recolectores[i].AppendLine(st2);
                recolectores[i].AppendLine(st3);
                recolectores[i].AppendLine(st1f);
                recolectores[i].AppendLine(st2f);
            }


            NC aux = this.Primero;// primera columna

            while (aux != null)
            {
                for (int f = 0; f < 4; f++)
                {
                    NCasilla ta = aux.TraerPrimeroPorDim(f + 1);
                    if (ta != null)
                    {
                        NM ca = ta.Buscar(f + 1);

                        recolectores[f].AppendLine(aux.ToString() + "->" + ca.ToString() + ta.Ptrcolumna.Letra + ta.Ptrfila.Num);

                    }
                }

                NCasilla casillaaux = aux.Primero;
                while (casillaaux != null)
                {

                    String[] relaciones = casillaaux.relacionesV();
                    for (int y = 0; y < relaciones.Length; y++)
                    {
                        recolectores[y].AppendLine(relaciones[y]);
                    }
                    casillaaux = casillaaux.Abajo;
                }

                aux = aux.Next;
            }

            return recolectores;
        }
        
        */

    /**
     * @return the _listaFilas
     */
    public LNF getListaFilas() {
        return _listaFilas;
    }

    /**
     * @param _listaFilas the _listaFilas to set
     */
    public void setListaFilas(LNF _listaFilas) {
        this._listaFilas = _listaFilas;
    }

    /**
     * @return the _primero
     */
    public NC getPrimero() {
        return _primero;
    }

    /**
     * @param _primero the _primero to set
     */
    public void setPrimero(NC _primero) {
        this._primero = _primero;
    }

    /**
     * @return the _ultimo
     */
    public NC getUltimo() {
        return _ultimo;
    }

    /**
     * @param _ultimo the _ultimo to set
     */
    public void setUltimo(NC _ultimo) {
        this._ultimo = _ultimo;
    }

}
