
/******************************************************************************************
 * Clase tratamiento fichero

 * En esta clase nos encargamos de leer el fichero que nos pasen y asi
 * crear un ArrayList con los numeros que deberian ir en cada fila del sudoku.
 *****************************************************************************************/

import java.util.ArrayList;
import java.io.*;

public class TratamientoFichero
{
    public static boolean ficheroExiste;

    /*
     * Metodo para leer los numeros del fichero.
     * @return un ArrayList con las cadenas de los numeros
     * @param el nombre del archivo en el que debe buscar los numeros, y un arrayList con lo que van a ser
     * las lineas del sudoku.
     */
    public static ArrayList<String> Leer(String nombreArchivo, ArrayList <String>lineaSudoku){ 
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        try
        {
            fr = new FileReader (nombreArchivo); //Abrimos el fichero
            br = new BufferedReader(fr); // Creamos un BufferReader para leer cada linea
            
            while((linea=br.readLine())!=null){
                lineaSudoku.add(linea); //Insertamos los numeros del sudoku
            }
        }
        catch(java.io.IOException e)
        {
            System.out.println ("Error en la lectura del fichero");
            System.exit(0);
        }finally{ //Cerramos el fichero
            try{
                if( fr != null ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        ficheroExiste=true;
        return lineaSudoku;

    }

    /*
     * Este metodo muestra la ayuda pedida por la pec. Realmente no tieen relacion
     * con el tratamiento del fichero, pero tampoco con la entrada de datos ni con el sudoku,
     * por tanto, se queda ubica en esta clase para no hacer una clase propia.
     */

    public static void muestraSintaxis() {
        System.out.println("*******************************************************************************");
        System.out.println("  Sudoku  ");
        System.out.println("*******************************************************************************");
        System.out.println("Formato de la linea de parametros: java sudoku [-t] [-h] [ficheroentrada]");
        System.out.println();
        System.out.println("[-t]: Traza la parametrizacion de cada invocacion recursiva y sus parametros");
        System.out.println();
        System.out.println("[-h]: muestra esta ayuda");
        System.out.println();
        System.out.println("[ficheroentrada] : Tabla inicial del sudoku");
        System.out.println();
        System.out.println("*******************************************************************************");
        System.out.println();
    }

    /*
     * Metodo que devuelve verdadero si el fichero existe y falso si no existe.
     */

    public static boolean preguntarFichero() {
        return ficheroExiste;
    }

} 
