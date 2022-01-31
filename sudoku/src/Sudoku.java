 
/*
 * Practica PREDA. Alumna Noelia Osta Supervia.
 * Clase Sudoku. Es la clase principal, la encargada de inciar el sudoku segun los 
 * parametros que se le hayan pasado.
 */
import java.util.ArrayList;

public class Sudoku {

    public static int sudoku [][] = new int [9][9];
    public static ArrayList<String> lineaSudoku = new ArrayList <String>();
    static boolean t=false;

    /* 
     * Metodo para pasar las lineas del sudoku a numeros y formar la matriz
     */

    public static void main(String [] args) {
        String nombreFichero=""; // Almacenamos nombre Fichero
        Boolean fichero = false;

        for (int c=0;c<args.length;c++) {
            if (args[c].equals("-t") ) {
                t=true;

            } else if (args[c].equals("-h")) {
                TratamientoFichero.muestraSintaxis();
            }
            //Si hay otro elemento en args lenght y no es ni la traza, ni la ayuda, tiene que ser el fichero.
            else if ((!args[c].equals("-t")) && (!args[c].equals("-h"))) {
                fichero=true;
                nombreFichero = args[c];
                TratamientoFichero.Leer(nombreFichero, lineaSudoku);
                System.out.println("Este es el sudoku inicial");
                EntradaDatos.convierteSudoku(sudoku, lineaSudoku);
            }
        }
        if(fichero==false){
            EntradaDatos.pideLinea(lineaSudoku); //Para que pida los datos al usuario.
            System.out.println("Este es el sudoku inicial");
            EntradaDatos.convierteSudoku(sudoku, lineaSudoku);
        }

        ResuelveSudoku.imprime(sudoku);
        ResuelveSudoku resuelveSudoku= new ResuelveSudoku(sudoku, t);

        if(!resuelveSudoku.resolver(sudoku)) {
            System.out.println("El sudoku no tiene solucion");
        }
    }

}
