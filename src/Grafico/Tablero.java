
package Grafico;

import Estructuras.Cola;
import Estructuras.MDispersa.MDisp;
import Estructuras.P_Z;
import Estructuras.Pila;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    int filas=0;
    int columnas = 0;
    FilaPanel paneles[];
    MDisp matriz = new MDisp();
    PanelPila tabpila ;
    PanelCola abcola;
    P_Z actualpila, actualcola;
    DataFlavor dataFlavor;
   public Tablero(int fi,int col,Pila pila, Cola cola)
   {
       dataFlavor = new DataFlavor(P_Z.class,
			P_Z.class.getSimpleName());
       this.setBounds(0, 0, 1000, 700);
       this.filas = fi;
       this.columnas = col;
       this.setLayout(null);
       paneles = new FilaPanel[fi];
       
       CrearFilas();
   }
   
   public void CrearFilas()
   {
        DragSource ds1 = new DragSource();
            DragSource ds2 = new DragSource();
		ds1.createDefaultDragGestureRecognizer(actualpila,
				DnDConstants.ACTION_MOVE, new DragGestureListImp(actualpila));
                ds2.createDefaultDragGestureRecognizer(actualcola,
				DnDConstants.ACTION_MOVE, new DragGestureListImp(actualcola));
       int y = 0;
       int w = 70* this.columnas;
       for(int i=0;i<this.paneles.length;i++)
       {
           
           this.paneles[i] = new FilaPanel(this.columnas,this.filas,i+1);
           this.paneles[i].setBounds(0, y,w,70);
           this.add(this.paneles[i]);
           y = y+70;
           //--------------------------------------
           
           
		new MyDropTargetListImp(this.paneles[i]);
           
       }
       }
   
   private class FilaPanel extends JPanel
   {
       int columnas,filas;
       int x=0;
       int y=0;
       Color colores[] = new Color[2];
       public FilaPanel(int col,int fil,int flag)
       {
           this.columnas = col;
           this.filas = fil;
           CrearColores(flag%2);
           
       }
       public void CrearColores(int flag)
       {
           System.out.println("EN FLAG EN LA CREACION DE COLORES: "+flag);
           if(flag==0)
           {
               
               colores[0] = new Color(128,255,0);
               colores[1] = new Color(76,153,0);
           }
           else
           {
               colores[1] = new Color(128,255,0);
               colores[0] = new Color(76,153,0);
           }
           
       }
       @Override
	public void paint(Graphics g) {
            
            
            Graphics2D g2d = (Graphics2D) g;
            int colornum =0;
            for(int i=0;i<this.columnas;i++)
            {
              System.out.println("Columna: "+(i+1));
              g2d.setColor(colores[colornum]);
              if(colornum==1)
                  colornum=0;
              else
                  colornum++;

              g2d.fillRect(this.x,this.y,70,70);
              System.out.println("SE DIBUJO EN: x: "+this.x+" y en y: "+this.y);
              x=x+70;
              //y=y+70;
            }
            x=0;
            y=0;
            
            
		
	}
   }
   
   class TransferableP_Z implements Transferable {
 
		private P_Z per;
 
		public TransferableP_Z(P_Z ani) {
			this.per = ani;
		}
 
		@Override
		public DataFlavor[] getTransferDataFlavors() {
			return new DataFlavor[] { dataFlavor };
		}
 
		@Override
		public boolean isDataFlavorSupported(DataFlavor flavor) {
			return flavor.equals(dataFlavor);
		}
 
		@Override
		public Object getTransferData(DataFlavor flavor)
				throws UnsupportedFlavorException, IOException {
 
			if (flavor.equals(dataFlavor))
				return per;
			else
				throw new UnsupportedFlavorException(flavor);
		}
	}
 
	class DragGestureListImp implements DragGestureListener {
 
            P_Z label;
            public DragGestureListImp(P_Z ind)
            {
                this.label =ind;
            }
		@Override
		public void dragGestureRecognized(DragGestureEvent event) {
			Cursor cursor = null;
			P_Z lblAnimal = (P_Z) event.getComponent();
                        if(lblAnimal==label)
			if (event.getDragAction() == DnDConstants.ACTION_COPY) {
				cursor = DragSource.DefaultCopyDrop;
			}
			P_Z animal = lblAnimal;
 
			event.startDrag(cursor, new TransferableP_Z(animal));
		}
	}
 
	class MyDropTargetListImp extends DropTargetAdapter implements
			DropTargetListener {
 
		private DropTarget dropTarget;
		private JPanel panel;
 
		public MyDropTargetListImp(JPanel panel) {
			this.panel = panel;
 
			dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this,
					true, null);
		}
 
		public void drop(DropTargetDropEvent event) {
			try {
				Transferable tr = event.getTransferable();
				P_Z an = (P_Z) tr.getTransferData(dataFlavor);
 
				if (event.isDataFlavorSupported(dataFlavor)) {
					event.acceptDrop(DnDConstants.ACTION_COPY);
                                        //JLabelAnimal ta = new JLabelAnimal(an);
                                        Random rn = new Random();
					int x = rn.nextInt(300)+1;
                                        int y = rn.nextInt(300)+1;
                                        an.setBounds(x,y, 200, 200);
                                        this.panel.add(an);
					event.dropComplete(true);
					this.panel.validate();
                                        System.out.println(this.panel.getComponentCount());
					return;
				}
				event.rejectDrop();
			} catch (Exception e) {
				e.printStackTrace();
				event.rejectDrop();
			}
		}
	}
   
   
   }


   
   
    


