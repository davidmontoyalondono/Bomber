
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lis
 */

/**La clase matriz en tripleta representada en Vector, esta es la clase
 * necesaria para hacer la matriz de botones y mejorar el desarrollo del
 * juego */

public class MatrizEnT {
    
    Vector V;

    /**Es el constructor de la clase MatrizEnT, recibiendo una tripleta como
     parámetro inicializa el vector de tripletas con los valores de la misma.
     */

   public MatrizEnT(Tripleta t)
   {

        V = new Vector();
        V.addElement(t);

   }

   /**Este método retorna el número de filas que tiene el Vector de
    tripletas*/

   public int retornaNumeroFilas()
   {
      return ((Tripleta)V.elementAt(0)).retornaFila();
   }

   /**Este método retorna el número de columnas que tiene el Vector de
    tripletas*/
   public int retornaNumeroColumnas()
   {
       return ((Tripleta)V.elementAt(0)).retornaColumna();
   }

   /**Este método retorna el número de elementos representados por el valor de 
    * la primera posición que tiene el Vector de tripletas*/

  public int retornaNumeroElementos ()
   {
       return ((Tripleta)V.elementAt(0)).retornaValor();

   }

  /**Este método retorna la tripleta que se encuentra en la posición i del 
   * Vector de tripletas*/

  public Tripleta retornaTripleta(int i)
   {
      return (Tripleta)V.elementAt(i);
   }

  /**Este método asigna la tripleta t al Vector de tripletas*/

  public void setTripleta(Tripleta t)
   {

       V.addElement(t);
   }

  /**Método utilizado para asignar a la Tripleta de la posición cero(0) del
   * vector el número de elementos del mismo*/

  public void setNumeroElementos (int n)
   {
       ((Tripleta)V.elementAt(0)).setValor(n);
   }


  /**método utilizado para comparar con los parámetros dados de fila y columna
   y buscarlos en el Vector de minas, si son iguales los parámetros
   * de fila y columna con las filas y columnas de la tripleta del vector de
   * minas, quiere decir que en esa posición del tablero hay una mina.*/

public boolean Comparar (int fila, int columna)
   {
    
    
       for (int i = 1; i< V.size(); i++)
       {
           if ((V.elementAt(i)!= null))
           if ((fila==((Tripleta)V.elementAt(i)).retornaFila())&&
                   (columna==((Tripleta)V.elementAt(i)).retornaColumna()))
               return false;

       }
       return true;
   }


/**Método usado para Mostrar la información guardada en el Vector
  de Tripletas, (Muestra todas las Tripletas almacenadas en el Vector)*/

   public void muestraMat ()
   {
       for (int i=1; i < V.size(); i++)
       {
           Tripleta s = retornaTripleta(i);
           int f = s.retornaFila();
           int c = s.retornaColumna();
           int v = s.retornaValor();
           System.out.println(i+"" + "-"+f+"" +c+ "" +v) ;

       }
   }

}
