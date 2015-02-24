
package Estructuras.MDispersa;

public class LNF {
    
     private NF _primero;
     private NF _ultimo;
     public LNF()
     {
         this._primero = this._ultimo = null;
     }

        public Boolean Vacio()
        {
            return this._primero == null;
        }
        public NF Agregar(int num)
        {
            NF fila = Buscar(num);
            if (fila == null)
            {
                fila = new NF(num);
                if (Vacio())
                {
                    this._primero = this._ultimo = fila;
                    return fila;
                }
                else if (this._primero.getNum() > num)
                {
                    fila.setNext(this._primero);
                    this._primero.setBack(fila);
                    this._primero = fila;
                    return fila;
                }
                else if (this._ultimo.getNum() < num)
                {
                    fila.setBack(this._ultimo);
                    this._ultimo.setNext(fila);
                    this._ultimo = fila;
                    return fila;
                }
                else
                {
                    NF aux = this._primero;
                    while (aux != null)
                    {
                        if (aux.getNum() > num)
                        {
                            fila.setNext( aux);
                            fila.setBack(aux.getBack());
                            fila.getNext().setBack( fila);
                            fila.getBack().setNext( fila);
                            return fila;
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
                return fila;
        }
        public NF Buscar(int num)
        {
            if (!Vacio())
            {
                if (this._primero.getNum() == num)
                {
                    return this._primero;
                }
                else if (this._ultimo.getNum() == num)
                {
                    return this._ultimo;
                }
                else
                {
                    NF aux = this._primero;
                    while (aux != null)
                    {
                        if (aux.getNum() == num)
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
        
        public StringBuilder graffila()
        {
            StringBuilder recolector = new StringBuilder();
            NF aux = this._primero;
            while(aux!=null)
            {
                NCasilla aux2 = aux.getPrimero();
                recolector.append("{rank = same;");
                while(aux2!=null)
                {
                    recolector.append(aux2.graficaCasillaH());
                    aux2 = aux2.getADerecha();
                }
                recolector.append("\n"+"}");
                aux = aux.getNext();
            }
            return recolector;
        }
/*
        public StringBuilder[] GraficaHorizontal()
        {
            StringBuilder[] recolectores = new StringBuilder[4];
            recolectores[0] = new StringBuilder();
            recolectores[1] = new StringBuilder();
            recolectores[2] = new StringBuilder();
            recolectores[3] = new StringBuilder();

            String relaf = "raiz";
            NF aa = this.Primero;
            while (aa != null)
            {
                relaf = relaf + " ->" + aa.ToString();
                aa = aa.Next;
            }
            for (int i = 0; i < 4; i++)
            {
                recolectores[i].AppendLine("{");
                recolectores[i].AppendLine("node [shape = record ];");
                recolectores[i].AppendLine(relaf + "[color = white];");
                recolectores[i].AppendLine("}");
                recolectores[i].AppendLine("node [shape = box ];");

            }




            NF aux = this.Primero;// la primera fila
            Boolean flag = false;
            while (aux != null)
            {
                if (flag)
                {
                    for (int i = 0; i < 4; i++)
                    {
                        recolectores[i].AppendLine("}");
                    }
                }
                flag = true;

                for (int i = 0; i < 4; i++)
                {
                    recolectores[i].AppendLine("{");
                    recolectores[i].AppendLine("rank = same;");
                    NCasilla auxc = aux.TraerPrimeroPorDim(i + 1);
                    if (auxc != null)
                    {
                        recolectores[i].AppendLine(aux.ToString() + " -> " + auxc.Buscar(i + 1).ToString() + auxc.Ptrcolumna.Letra + auxc.Ptrfila.Num + ";");
                        recolectores[i].AppendLine(auxc.Buscar(i + 1).ToString() + auxc.Ptrcolumna.Letra + auxc.Ptrfila.Num + " -> " + aux.ToString() + ";");
                    }


                }
                NCasilla casillaaux = aux.Primero;
                while (casillaaux != null)
                {
                    int y;
                    String[] relaciones = casillaaux.relacionesH();
                    for (y = 0; y < relaciones.Length; y++)
                    {
                        recolectores[y].AppendLine(relaciones[y]);


                    }


                    casillaaux = casillaaux.Derecha;


                }

                aux = aux.Next;

            }


            if (aux == null)
            {
                for (int i = 0; i < 4; i++)
                {
                    recolectores[i].AppendLine("}");
                }
            }
            return recolectores;
        }
        */
}
