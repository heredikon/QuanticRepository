package com.mycompany.cuanticrepository;

import java.util.Arrays;

public class Quantic {

    private int[] cambioEstadoBooleanos(int[][] m, int[] v){
        int[] accion = new int[v.length];
        int result = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result = result + (m[i][j] * v[j]);
            }
            accion[i] = result;
            result = 0;
        }
        return accion;
    }

    private double[] cambioEstadoFracciones(double[][] m, double[] v) {

        double[] accion = new double[v.length];
        double result = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result = result + (m[i][j] * v[j]);
            }
            accion[i] = result;
            result = 0;
        }
        return accion;
    }


    public int[] experimentoConMarblesBooleano(int[][] matrizAdyacencia, int[] estadoInicial, int cantidadCambios){
        int[] estadoFinal = estadoInicial;
        for (int i = 0; i < cantidadCambios; i++) {
            estadoFinal = cambioEstadoBooleanos(matrizAdyacencia, estadoFinal);
        }
        return estadoFinal;
    }

   
    public double[] experimentoConMarblesFracciones(double[][] matrizAdyacencia, double[] estadoInicial, int cantidadCambios) {
        double[] estadoFinal = estadoInicial;
        for (int i = 0; i < cantidadCambios; i++) {
            estadoFinal = cambioEstadoFracciones(matrizAdyacencia, estadoFinal);
        }
        return estadoFinal;
    }

    private double[][] multiplicarMatrices(double[][] m1, double[][] m2) {
        double[][] multiplicacionMatrices = new double[m1.length][m2[0].length];
        if (m1[0].length != m2.length) {
            System.out.println("No se pueden multiplicar matrices con dimensiones diferentes.");
        }
        double result;
        int i;
        int j;
        for (int i_f = 0; i_f < m1.length; i_f++) {
            for (int j_f = 0; j_f < m2[0].length; j_f++) {
                result = 0;
                i = 0;
                j = 0;
                while (j < m1[0].length && i < m2.length) {
                    result = result + (m1[i_f][j] * m2[i][j_f]);
                    j++;
                    i++;
                }
                multiplicacionMatrices[i_f][j_f] = result;
            }
        }
        return multiplicacionMatrices;
    }

    private void mostrarMatrizAdyacencia(double[][] m) {
        System.out.println("MatrizBala:");
        for (int i = 0; i < m.length; i++) {
            System.out.print("|");
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%.3f", m[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    private void mostrarVectorCambioEstado(double[] y) {
        System.out.println("VectorBala:");
        System.out.print("|");
        for (int i = 0; i < y.length; i++) {
            System.out.printf("%.3f", y[i]);
            System.out.print("|");
        }
        System.out.println("");
    }

    private String matrizAString(double[][] m) {
        String matrizString = "[";
        for (int i = 0; i < m.length; i++) {
            if (i + 1 == m.length) {
                matrizString += Arrays.toString(m[i]) + "]";
            } else {
                matrizString += Arrays.toString(m[i]) + ", ";
            }
        }
        return matrizString;
    }

    public String[] experimentoMultirendijasBalas(int numeroSlits, int numeroTargets, double[][] probabilidades){
        int n = numeroSlits + numeroTargets + 1;
        double[][] matrizAdyacencia = probabilidades;
        for (int i = 1; i < numeroSlits + 1; i++) {
            matrizAdyacencia[i][0] = 1.0 / ((double) numeroSlits);
        }
        for (int i = numeroSlits + 1; i < probabilidades.length; i++) {
            matrizAdyacencia[i][i] = 1.0;
        }
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                x[i] = 1.0;
            } else {
                x[i] = 0.0;
            }
        }
        double[][] matrizAdyacencia2 = multiplicarMatrices(matrizAdyacencia, matrizAdyacencia);
        double[] y = cambioEstadoFracciones(matrizAdyacencia2, x);
        mostrarMatrizAdyacencia(matrizAdyacencia2);
        mostrarVectorCambioEstado(y);
        String[] matrizVector = {matrizAString(matrizAdyacencia2), Arrays.toString(y)};
        return matrizVector;
    }

    private String verificarInterferencias(Complex[][] m, int numeroSlits) {
        Complex cero = new Complex(0, 0);
        String interferencias = "interferencias: ";
        for (int i = numeroSlits + 1; i < m.length; i++) {
            if (m[i][0].equals(cero)) {
                interferencias += "[" + i + "," + 0 + "] ";
            }
        }
        return interferencias;
    }

    private void mostrarMatrizFoton(Complex[][] m) {
        System.out.println("MatrizFoton:");
        for (int i = 0; i < m.length; i++) {
            System.out.print("|");
            for (int j = 0; j < m[0].length; j++) {
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    private void mostrarVectorFoton(Complex[] y) {
        System.out.println("VectorFoton:");
        System.out.print("|");
        for (int i = 0; i < y.length; i++) {
            System.out.print("|");
        }
        System.out.println("");
    }

    private String matrizAStringFoton(Complex[][] m) {
        String matrizString = "[";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i + 1 == m.length) {
                } else {
                }
            }
            matrizString += "]";
        }
        return matrizString;
    }

    private String vectorAStringFoton(Complex[] y) {
        String vectorS = "{";
        for (int i = 0; i < y.length; i++) {
            if (i + 1 == y.length) {
                vectorS += y[i].prettyPrintFormaNormalNumeroComplejo();
            } else {
                vectorS += y[i].prettyPrintFormaNormalNumeroComplejo() + ", ";
            }
        }
        vectorS = "}";
        return vectorS;
    }

    /**
     * Este metodo representa el experimento probabilístico de las dobles
     * rendijas (en este caso con 2 o más rendijas). Con este experimento se
     * logro demostrar que al lanzar un foton por las rendijas, este toma varios
     * caminos simultaneamente cuando no es medido, formando un patron llamado
     * interferencia, que se refiere al choque de varias ondas al mismo tiempo.
     * Este experimento es el paso de lo clasico a lo cuantico. Muestra la
     * matriz de complejos que se forma de las probabilidades de que los fotones
     * lleguen a distintos objetivos y el vector estado de complejos despues de
     * realizar dos clicks. Aqui tambien se verifican si existen interferencias,
     * es decir,existen dos caminos para llegar a un mismo objetivo, por lo que
     * se cancelan los numeros complejos cuando son sumados.
     *
     * @param numeroSlits representa la cantidad de rendijas a usar.
     * @param numeroTargets representa la cantidad de objetivos despues de las
     * rendijas.
     * @param probabilidades es una matriz con la probabilidades de que un foton
     * vaya de una rendija a un objetivo.
     * @return String[] : retorna la matriz multiplicada por si misma y el
     * vector estado despues de realizar dos clicks.
     * @throws BasicException : si la dimension de las columnas de m1 son
     * distintas a las filas de m2, la multiplicacion entre matrices no esta
     * definida en los numeros complejos.
     */
    public String[] experimentoMultirendijasFotones(int numeroSlits, int numeroTargets, Complex[][] probabilidades) throws BasicException {
        int n = numeroSlits + numeroTargets + 1;
        Complex[][] matrizAdyacencia = probabilidades;
        for (int i = 1; i < numeroSlits + 1; i++) {
            matrizAdyacencia[i][0] = new Complex(Math.sqrt(1.0 / ((double) numeroSlits)), 0);
        }
        for (int i = numeroSlits + 1; i < probabilidades.length; i++) {
            matrizAdyacencia[i][i] = new Complex(1.0, 0);
        }
        Complex[] x = new Complex[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                x[i] = new Complex(1.0, 0);
            } else {
                x[i] = new Complex(0.0, 0);
            }
        }
        Complex[][] matrizAdyacencia2 = Basic.multiplicarMatrices(matrizAdyacencia, matrizAdyacencia);
        Complex[] y = Basic.accion(matrizAdyacencia2, x);
        mostrarMatrizFoton(matrizAdyacencia2);
        mostrarVectorFoton(y);
        String[] matrizVector = {matrizAStringFoton(matrizAdyacencia2), vectorAStringFoton(y), verificarInterferencias(matrizAdyacencia2, numeroSlits)};
        return matrizVector;
    }

}
