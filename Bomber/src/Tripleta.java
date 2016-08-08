/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */

/**La clase tripleta, que permite crear objetos que almacenan tres datos que son
 fila, columna y valor.*/

public class Tripleta {
 private int fila;
    private int columna;
    private int valor;

    /**
     *Método Constructor de la clase Tripleta, con el cual se crean las
     *tripletas con los parámetros de fila ,columna y valor, es decir
     *f, c y v respectivamente.
     */

   public Tripleta (int f, int c, int v)
   {
       setFila(f);
       setColumna(c);
       setValor(v);
   }

   /**Método utilizado para asignar a una tripleta el valor del campo fila
    que le corresponde usando el parámetro int f.*/

   public void setFila (int f)
   {
       fila = f;
   }

   /**Método utilizado para asignar a una tripleta el valor del campo Columna
    que le corresponde usando el parámetro int c. */

   public void setColumna (int c)
   {
       columna = c;
   }

   /**Método utilizado para asignar a una tripleta el valor del campo Valor
    que le corresponde usando el parámetro int v. */

    public void setValor (int v)
   {
       valor = v;
   }

    /**Método utilizado retornar la fila de una determinada tripleta*/

    public int retornaFila ()
    {
        return fila;
    }

    /**Método utilizado retornar la columna de una determinada tripleta*/

    public int retornaColumna ()
    {
        return columna;
    }

    /**Método utilizado retornar el valor de una determinada tripleta*/

    public int retornaValor()
    {
        return valor;
    }
}
