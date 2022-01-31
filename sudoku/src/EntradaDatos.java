import java.util.ArrayList;
import java.util.Scanner;

/*
 * Clase EntradaDatos
 * Es la encargada de obtener los numeros que introduce el usuario por pantalla
 * y convertirlos en elementos de la matriz del sudoku.
 */
public class EntradaDatos {

    public static Scanner entrada = new Scanner (System.in);

    /*
     * metodo encargada de pedir al usuario las lineas de numeros por consola.
     * Esta metodo recurre a comprobarLineaCorrecta para comprobar que tiene el formato correcto para
     * ser introducido en el ArrayList, es decir, que sen 9 numeros y se pueda pasar a entero.
     * (No tenga caracteres raros)
     * @param el arrayList que almacera las lineas de numeros.
     */

    public static void pideLinea(ArrayList<String> lineaSudoku) {
        Boolean lineaCorrecta=false;
        System.out.println("Formatos validos para introducir la linea:");
        System.out.println("5 3 0 0 7 0 0 0 0");
        System.out.println("530070000");
        System.out.println("976 298 755");
        System.out.println(" ");

        for(int i=0; i<9; i++) {
            String lineaFormat;
            do {
                System.out.println("Por favor, introduzca la linea " + (i+1) +" de numeros del Sudoku: ");
                String linea = entrada.nextLine();

                //Control de lo que se ha introducido: 
                String lineaAux= linea.trim();
                lineaFormat = lineaAux.replace(" ", "");

                lineaCorrecta = comprobarLineaCorrecta(lineaFormat);

                if(lineaCorrecta==false) System.out.println("Introduzca la linea en los formatos indicados anteriormente");
            } while (lineaCorrecta ==false); 

            lineaSudoku.add(lineaFormat); 
        }
    }

    /*
     * Metodo encargado de comprobar que el usuario a introducido la linea correctamente.
     * @param la linea de numeros que ha introducido el usuario por consola.
     */
    private static Boolean comprobarLineaCorrecta(String linea) {

        String lineaFormat = linea;
        boolean resultado = false;

        int numero = lineaFormat.length();

        try {
            Integer.parseInt(lineaFormat);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        if(resultado == true && numero ==9) {
            resultado = true;
        } else {
            resultado = false;
        }

        return resultado;
    }

    /*
     * Es el metodo encargado de convertir las lineas del arrayList lineaSudoku, a valores int que vamos a introducir
     * en la matriz de enteros del sudoku. Es metodo que forma la matriz inicial.
     * 
     */
    public static void convierteSudoku(int [][] sudoku, ArrayList <String> lineaSudoku) {
        String texto;
        String textoSinEspacios;
        String textoSinGuiones;

        int numero;

        for (int i=0; i<lineaSudoku.size(); i++) {
            texto = lineaSudoku.get(i);
            textoSinEspacios = texto.replace(" ","");
            textoSinGuiones = textoSinEspacios.replace('-', '0'); //Aqui ya tenemmos solo los numeros
            //Guardamos los numeros en el array

            for (int j=0; j<textoSinGuiones.length(); j++) {
                numero= Character.getNumericValue(textoSinGuiones.charAt(j));
                sudoku[i][j]=numero;
            }
        }

    }

}
