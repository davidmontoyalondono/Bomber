
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */

/**La clase matriz en tripleta representada en Arreglo unidimensional,
 * esta es la clase necesaria para hacer la matriz de botones
 * y mejorar el desarrollo del juego */

public class MatrizEnTripletas {
Tripleta V[];

/**Es el constructor de la clase MatrizEnTripletas, recibiendo una tripleta como
   parámetro inicializa el vector de tripletas con los valores de la misma,
 *asignando estos valores a la posicion cero del arreglo.*/

   public MatrizEnTripletas(Tripleta t)
   {
        int m = t.retornaValor();
        V = new Tripleta[m+1];
        V[0] = t;

   }

   /**Este método retorna el número de filas que tiene el Arreglo de
    tripletas*/

   public int retornaNumeroFilas()
   {
      return V[0].retornaFila();
   }

   /**Este método retorna el número de columnas que tiene el Arreglo de
    tripletas*/

   public int retornaNumeroColumnas()
   {
       return V[0].retornaColumna();
   }

   /**Este método retorna el número de elementos representados por el valor de
    *la posición cero del Arreglo de tripletas*/

   public int retornaNumeroElementos ()
   {
       return V[0].retornaValor();

   }

    /**Este método retorna la tripleta que se encuentra en la posición i del
   * Arreglo de tripletas*/

   public Tripleta retornaTripleta(int i)
   {
      return V[i];
   }


    /**Este método asigna la tripleta t a la posición i del
     * arreglo de tripletas*/

   public void setTripleta(Tripleta t,int i)
   {
       V[i] = t;
   }

   /**Método utilizado para asignar a la Tripleta de la posición cero(0) del
   * Arreglo el número de elementos del mismo*/

   public void setNumeroElementos (int n)
   {
       V[0].setValor(n);
   }


   /**Método usado para Mostrar la información guardada en el Arreglo
    * de Tripletas, (Muestra todas las Tripletas almacenadas en el arreglo)*/

   
   public void muestraMatriz ()
   {
       for (int i=1; i <= retornaNumeroElementos(); i++)
       {
           Tripleta salvar = retornaTripleta(i);
           int f = salvar.retornaFila();
           int c = salvar.retornaColumna();
           int v = salvar.retornaValor();
           System.out.println(i+"" + "-"+f+"" +c+ "" +v) ;

       }
   }
}
