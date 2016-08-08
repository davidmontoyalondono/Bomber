
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.painter.text.DefaultTextPainter;
import org.jvnet.substance.watermark.SubstanceImageWatermark;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VBuscaminas.java
 *
 * Created on 16/07/2010, 12:58:13 PM
 */

/**
 *
 * @author Administrador
 */

/**Es la ventana principal donde se maneja casi la totalidad del programa
 Buscaminas, teniendo en cuenta varios parámetros además de la información dada
 por la ventana de Personalizar.*/

public class VBuscaminas extends javax.swing.JFrame {

     JButton ArrBot[][];
     Tripleta TIni;
     SubstanceImageWatermark s = new SubstanceImageWatermark("calavera3.jpg");
     static Personalizar d = new Personalizar();
     int filas , columnas , minas;
     Icon bandera = new ImageIcon(getClass().getResource("travelguides.gif"));
     MatrizEnT MMinas;
     Tripleta t1;
     int MatNum[][];
     int cont = 0;
     

    /** Creates new form VBuscaminas */
     /**Constructor de la clase VBuscaminas sin parámetros en el cual se
      maneja la parte gráfica, además de dar dimensiones al tablero de
      juego, poner las minas y los números y demás.*/

    public VBuscaminas() {
        initComponents();
        this.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin(
                "org.jvnet.substance.skin.BusinessBlueSteelSkin");
        SubstanceLookAndFeel.setCurrentWatermark(s);
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.8));
        SubstanceLookAndFeel.setCurrentTheme(
                "org.jvnet.substance.theme.SubstanceAquaTheme");
        setIconImage(new ImageIcon(getClass().getResource
        ("mn.png")).getImage());
        this.filas = Personalizar.alto;
        this.columnas = Personalizar.ancho;
        this.minas = Personalizar.mina;
        
    

        if(filas == 0 && columnas == 0 ){
         filas = 10;
         columnas = 10;
         minas = 10;
         cont = 10;
       }

        jLabel2.setText("Minas: "+cont);
        Tablero(columnas,filas);
        Minas(columnas,filas,minas);
        MatNum = new int [filas][columnas];

        for (int i = 0; i < filas; i++)
         {
             for (int j = 0; j < columnas; j++)
             {
                 MatNum[i][j]= 0;

             }
         }

       Numeros();
       jButton1.setIcon(new ImageIcon(getClass().getResource("caraGA.png")));




    }

    /**Constructor de la clase VBuscaminas con parámetros en el cual igualmente
     * se maneja la parte gráfica, además de dar dimensiones al tablero de
      juego, poner las minas y los números y demás, pero usando los parametros
     * de fila, columnas y minas.*/

       public VBuscaminas(int f1,int c1,int m1) {
        initComponents();
        this.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin(
                "org.jvnet.substance.skin.BusinessBlueSteelSkin");
        SubstanceLookAndFeel.setCurrentWatermark(s);
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.8));
        SubstanceLookAndFeel.setCurrentTheme(
                "org.jvnet.substance.theme.SubstanceAquaTheme");
        setIconImage(new ImageIcon(getClass().getResource
        ("mn.png")).getImage());
        

        this.filas = Personalizar.alto;
        this.columnas = Personalizar.ancho;
        this.minas = Personalizar.mina;
        int mnb = (filas*columnas) - 20;

 

        
         filas = f1;
         columnas = c1;
         minas = m1;
         
       

        cont = minas;
         jLabel2.setText("Minas: "+cont);
        Tablero(columnas,filas);
        Minas(columnas,filas,minas);
        MatNum = new int [filas][columnas];

        for (int i = 0; i < filas; i++)
         {
             for (int j = 0; j < columnas; j++)
             {
                 MatNum[i][j]= 0;

             }
         }

       Numeros();
       jButton1.setBounds(30, 100, 30, 30);
       jButton1.setIcon(new ImageIcon(getClass().getResource("caraGA.png")));

           

    }

       /**Es el método con el cual se crea el tablero y se maneja el evento
        de clic en cada botón del tablero, además de decir cuando se gana
        y se pierde, recibe como parámetros el ancho y el alto del
        * tablero enviados por el usuario.*/

    public void Tablero(final int ancho, final int alto){

        int k = 0;
        int m = 0;
       ArrBot = new JButton[alto][ancho];
       this.setResizable(true);
       this.setSize((ancho*30)+22,(alto*30)+105);

        for(int i = 0; i < alto;i++){

            for(int j = 0; j < ancho; j++)
        {
                final int alt = i;
                final int anc = j;
               ArrBot[i][j] = new JButton();
               jPanel1.add(ArrBot[i][j]);
               ArrBot[i][j].setBounds(k, m, 30, 30);
               ArrBot[i][j].setBackground(Color.DARK_GRAY);
               ArrBot[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    if(evt.getButton() == MouseEvent.BUTTON1)
                    {
                         jButton1.setIcon(
                           new ImageIcon(getClass().getResource("caraGP.png")));

                         if (ArrBot[alt][anc].getIcon() != bandera)
                                {
                                     Abrir(alt,anc );
                                }

                    }


                    if(evt.getButton() == MouseEvent.BUTTON3){

                           if ((ArrBot[alt][anc].isEnabled()==true))
                            {
                                if (ArrBot[alt][anc].getIcon() == bandera)
                              {
                                 ArrBot[alt][anc].setIcon(null);

                                 cont = cont + 1;
                                jLabel2.setText("minas: "+cont);
                              }
                             else
                           {
                                 ArrBot[alt][anc].setIcon(bandera);
                                 cont = cont - 1;
                                 jLabel2.setText("minas: "+cont);
                           }

                           }

                    }




                }

                

               });




               k = k + 30;
        }
            m = m+30;
            k = 0;

        }

       this.setResizable(false);


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BUSCAMINAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Minas");

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Juego");

        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("Novato");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("Normal");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setText("Difícil");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setText("Personalizar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Salir");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
         d.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

   

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
      
        this.setVisible(false);
        VBuscaminas otro2 = new VBuscaminas(filas,columnas,minas);
        otro2.setVisible(true);
        
     
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        VBuscaminas otro3 = new VBuscaminas(10,10,10);
        otro3.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        VBuscaminas otro1 = new VBuscaminas(15,15,25);
        otro1.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        VBuscaminas otro2 = new VBuscaminas(20,20,60);
        otro2.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        VBuscaminas otro2 = new VBuscaminas(filas,columnas,minas);
        otro2.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    /**Es el método usado para hacer la matriz en tripletas de minas
     generando aleatoriamente las posiciones que deberían tener en el
     tablero, además de mostrar la matriz de minas y sus posiciones por
     consola.*/

public void Minas(int ancho, int alto, int minas){

    TIni = new Tripleta(alto,ancho,minas);
    MMinas = new MatrizEnT(TIni);
    int c = 0;

    while(c < minas){
    int filaX = (int) (Math.random()*alto);
    int ColumnaY = (int)(Math.random()*ancho);
    if(MMinas.Comparar(filaX, ColumnaY))
    {
    t1 = new Tripleta(filaX,ColumnaY,0);
    MMinas.setTripleta(t1);
    c = c+1;
    }
    }

     MMinas.muestraMat();
}


/**Es el método utilizado para  abrir los campos del tablero, es el método que
 permite el libre desarrollo del juego. es el método que dice cuando se gana
 * y cuanto se pierde. Entre otras cosas.*/

public void Abrir (int fil, int col)
    {
        if (fil >= 0 && fil < filas && col >= 0 && col<columnas
                && ArrBot[fil][col].isEnabled() &&
                ArrBot[fil][col].getIcon()==null)
        {
            boolean respaldo = MMinas.Comparar(fil, col);
            if (respaldo == false)
            {
                for (int i = 1; i <= MMinas.retornaNumeroElementos(); i++)
                {
                     Tripleta Gx = MMinas.retornaTripleta(i);
                     int f1 = Gx.retornaFila();
                     int c1 = Gx.retornaColumna();
                     ArrBot[f1][c1].setIcon(
                             new ImageIcon(getClass().getResource("mina.png")));
                     

                }
           ArrBot[fil][col].setIcon(
           new ImageIcon(getClass().getResource("minas21.png")));
          jButton1.setIcon(new ImageIcon(getClass().getResource("Crying.png")));
               
        for (int p = 0; p<filas; p++ )
         {
            for(int q = 0; q<columnas; q++)
            {
               if( ArrBot[p][q].getIcon()== bandera &&
                       MMinas.Comparar(p, q) == true )
               {
                  ArrBot[p][q].setIcon(
                          new ImageIcon(getClass().getResource("BadMina.PNG")));
               }



            }
         }


                JOptionPane.showMessageDialog(null, "¡¡¡Perdiste!!!");


                  this.setVisible(false);
                  VBuscaminas otto = new VBuscaminas(filas,columnas,minas);
                  otto.setVisible(true);

            }
            else{
             int guardar = MatNum[fil][col];
             if (guardar == 0)
             {
                 ArrBot[fil][col].setEnabled(false);
                 Ganar();
                 for (int x =fil-1 ; x <= fil + 1; x++)
                 {
                     for (int y= col - 1; y <=col + 1; y++)
                     {

                         Abrir(x , y);
                     }
                 }
             }

             else
             {
                 int sop = MatNum[fil][col];
                 String numero = ""+sop;
                 ArrBot[fil][col].setText(numero);
                 ArrBot[fil][col].setEnabled(false);
                 Ganar();
             }
            }
        }

    }

/**Es el método que coloca los números en el tablero, tomando en cuenta las
 posiciones de las minas en el tablero.*/

 public void Numeros()
    {
         for (int i=1; i < MMinas.retornaNumeroElementos()+1; i++)
       {
           Tripleta soporte = (Tripleta)MMinas.retornaTripleta(i);
           int f = soporte.retornaFila();
           int c = soporte.retornaColumna();

           for (int x = f-1; x <= f+1; x++ )
           {
               for (int y = c-1; y <= c+1; y++)
               {
                    boolean posible = MMinas.Comparar(x, y);
                    if (x >= 0 && x < filas && y >= 0 &&
                            y < columnas && posible == true)
                    {
                       int guarda1 = MatNum[x][y];
                       guarda1 = guarda1 + 1;
                       MatNum[x][y] = guarda1;

                    }
               }
           }

       }
         for (int i = 0; i < filas; i++)
         {
             for (int j = 0; j < columnas; j++)
             {
                 if (MatNum[i][j]!= 0)
                 {
                     System.out.println(MatNum[i][j]+"  "+i+"  "+j);
                 }
             }
         }
    }

 /**Es el método que dice al jugador cuando gana el juego. */

 public void Ganar(){

 int contador = 0;
         for (int i = 0; i < filas; i ++)
        {
            for (int j = 0; j < columnas; j++)
            {
                if (ArrBot[i][j].isEnabled())
                {
                    contador = contador + 1;
                }

            }
        }

        if (contador == minas)
        {
            for (int i = 1; i <= MMinas.retornaNumeroElementos(); i++)
                {
                     Tripleta Gx = MMinas.retornaTripleta(i);
                     int f1 = Gx.retornaFila();
                     int c1 = Gx.retornaColumna();
                     ArrBot[f1][c1].setIcon(null);


                }

            JOptionPane.showMessageDialog(null,"¡¡¡Ganaste!!!");
            this.setVisible(false);
            VBuscaminas fin = new VBuscaminas(filas,columnas,minas);
            fin.setVisible(true);

        }


 }



    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VBuscaminas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
