
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

        
        
        public StringBuilder NodosGeneral()
        {
            StringBuilder recolector = new StringBuilder();
            NC aux = this._primero;
            while(aux!=null)
            {
                NCasilla aux2 = aux.getPrimero();
                while(aux2!=null)
                {
                    recolector.append(aux2.ToString()+"[ label = \""+aux2.getLista().graficaMatriz()+" \" ];");
                    aux2 = aux2.getAbajo();
                }
                aux = aux.getNext();
            }
            return recolector;
        }
        
        public StringBuilder GraficasCol()
        {
            StringBuilder recolector = new StringBuilder();
            NC aux = this._primero;
            while(aux!=null)
            {
                NCasilla aux2 = aux.getPrimero();
                while(aux2!=null)
                {
                    if(aux2.getArriba()!=null)
                    {
                        recolector.append(aux2.getArriba().ToString()+"->"+aux2.ToString()+";"+"\n");
                        recolector.append(aux2.ToString()+"->"+aux2.getArriba().ToString()+";"+"\n");
                    }
                    aux2 = aux2.getAbajo();
                }
                aux = aux.getNext();
            }
            return recolector;
        }
/*
        public StringBuilder[i] GraficaVertical()
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

  
    public LNF getListaFilas() {
        return _listaFilas;
    }

    public void setListaFilas(LNF _listaFilas) {
        this._listaFilas = _listaFilas;
    }

    public NC getPrimero() {
        return _primero;
    }

    
    public void setPrimero(NC _primero) {
        this._primero = _primero;
    }

    
    public NC getUltimo() {
        return _ultimo;
    }

    
    public void setUltimo(NC _ultimo) {
        this._ultimo = _ultimo;
    }

}
