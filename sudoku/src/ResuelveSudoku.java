 
/*
 * Es la clase en la que se encuentra el algoritmo de vuelta atrÃ¡s.
 * Es, por tanto, la clase en la que pasando el sudoku inicial como parametro
 * va a ejecutar todas combinaciones posibles para ver si el sudoku se puede resolver.
 */
public class ResuelveSudoku {

    public static int [][] sudoku;
    public static boolean cierto;
    public static boolean traza;

    public ResuelveSudoku(int [][] sudokuInicial, boolean t) {

        sudoku=sudokuInicial;
        cierto=false;
        traza=t;

    }

    /*
     * Metodo para imprimir el sudoku. Se aportan espacios adicionales para mayor legibilidad.
     * @param la matriz que contiene el sudoku.
     */
    public static void imprime(int [][] sudoku) {

        for (int i=0; i < sudoku.length; i++) {
            for (int j=0; j < sudoku.length; j++) {
                System.out.print (sudoku[i][j] + " ");
                //if para tratar los espacios y que el sudoku sea mas legible.
                if((j+1)%3==0 && j!=0) {
                    System.out.print(" ");
                }
            }
            System.out.println();	
            //if para tratar los espacios y que el sudoku sea mas legible.
            if((i+1)%3==0 && i!=0) {
                System.out.println();
            }	
        }
    }

    /*
     * Metodo que nos permite resolver el sudoku con el esquema general de vuelta atras.
     * @return un booleano que nos indicarÃ¡ si el sudoku tiene soluciÃ³n o no.
     * @param la matriz que contiene el sudoku.
     */
    public static boolean resolver(int[][] sudoku) {
        for (int i = 0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if(sudoku[i][j] ==0) {
                    //Mientras OpcionesPendientes(k) hacer:
                    //k empieza en 1 puesto que no es el primer int valido en nuestro sudoku
                    for (int k=1; k<=9; k++) {
                        //Vuelta atras, k+1 (El +1 nos lo da el propio bucle)
                        if (insertar(sudoku, i,j,k)) {
                            sudoku[i][j]=k;
                            if(traza) {
                                System.out.println("Valores a insertar: En la fila: " + (i+1) + " y columna: " + (j+1) + " el valor a insertar es: " + k );
                            }
                            boolean verdadero = resolver(sudoku);
                            if(verdadero) {
                                return true;
                            }
                            sudoku[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }

        System.out.println(" ");
        System.out.println("Se ha encontrado solucion");
        imprime(sudoku);
        return true;
    }

    /*
     * Solo insertamos si es seguro insertar en la fila, en la columna, y en el cuadrado de 3*3
     */
    private static boolean insertar(int[][]sudoku, int i, int j, int valor) {

        if((insertarColumna(sudoku, i, j, valor))&&(insertarFila(sudoku, i, j, valor))&&(insertarCuadrado(sudoku, i - (i%3), j - (j%3), valor))) {
            return true;
        } else {
            return false;
        }	
    }

    /*
     * MÃ©todos privados auxiliares que se aseguran de que sea posible insertar en la columna,
     * fila, o en el cuadrado 3*3.
     * @param la matriz del sudoku, el valor de la fila, el de la columna, y el valor a insertar
     * @return un booleano que nos indica si es seguro insertar.
     */
    private static boolean insertarColumna (int [][]sudoku, int i, int j, int valor) {

        for(int z=0; z<9; z++) {
            if(z!=i && sudoku[z][j]==valor) {
                return false;
            }
        }
        return true;
    }

    private static boolean insertarFila (int [][]sudoku, int i, int j, int valor) {	

        for(int z=0; z<9; z++) {
            if(z!=j && sudoku[i][z]==valor) {
                return false;
            }
        }
        return true;
    }

    private static boolean insertarCuadrado (int [][]sudoku, int i, int j, int valor) {
        //miramos cuadrado 3x3

        for(int fila=0; fila<3; fila++) {
            for(int columna=0; columna<9/3; columna++) {
                if(sudoku[fila+i][columna+j] == valor) {
                    return false;
                }
            }
        }
        return true;	
    }
}
