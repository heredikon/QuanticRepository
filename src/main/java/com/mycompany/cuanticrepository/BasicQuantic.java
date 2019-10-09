/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuanticrepository;

import java.util.Arrays;

/**
 *
 * @author fabia
 */
public class BasicQuantic {
    
    Basic basic = new Basic();
    
    private int[] booleanAction(int[][] m, int[] v) {
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
    private double[] realAction(double[][] m, double[] v){
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
    
    public int[] booleanMarbles(int[][] matrizAdyacencia, int[] estadoInicial, int cantidadCambios) {
        int[] estadoFinal = estadoInicial;
        for (int i = 0; i < cantidadCambios; i++) {
            estadoFinal = booleanAction(matrizAdyacencia, estadoFinal);
        }
        return estadoFinal;
    }
    
    public double[] realMarbles(double[][] matrizAdyacencia, double[] estadoInicial, int cantidadCambios) {
        double[] estadoFinal = estadoInicial;
        for (int i = 0; i < cantidadCambios; i++) {
            estadoFinal = realAction(matrizAdyacencia, estadoFinal);
        }
        return estadoFinal;
    }
    
    public Complex[] complexPhotons(Complex[][] matrizAdyacencia, Complex[] estadoInicial, int cantidadCambios)  {
        Complex[] estadoFinal = estadoInicial;
        for (int i = 0; i < cantidadCambios; i++) {
            estadoFinal = basic.accion(matrizAdyacencia, estadoFinal);
        }
        return estadoFinal;
    }
    private double[][] multMatrix(double[][] m1, double[][] m2) {
        double[][] ans = new double[m1.length][m2[0].length];
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
                ans[i_f][j_f] = result;
            }
        }
        return ans;
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
    public String[] multiSlitBullet(int numeroSlits, int numeroTargets, double[][] probabilidades)  {
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
        double[][] matrizAdyacencia2 = multMatrix(matrizAdyacencia, matrizAdyacencia);
        double[] y = realAction(matrizAdyacencia2, x);
        String[] matrizVector = {matrizAString(matrizAdyacencia2), Arrays.toString(y)};
        return matrizVector;
    }
    
    private String interferenceCheck(Complex[][] m, int numeroSlits) {
        Complex cero = new Complex(0, 0);
        String interferencias = "interferencias: ";
        for (int i = numeroSlits + 1; i < m.length; i++) {
            if (m[i][0].equals(cero)) {
                interferencias += "[" + i + "," + 0 + "] ";
            }
        }
        return interferencias;
    }

    private void printPhotonMatrix(Complex[][] m) {
        System.out.println("MatrizFoton:");
        for (int i = 0; i < m.length; i++) {
            System.out.print("|");
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf(m[i][j].prettyPrintFormaNormalNumeroComplejo());
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    private void printPhotonVector(Complex[] y) {
        System.out.println("VectorFoton:");
        System.out.print("|");
        for (int i = 0; i < y.length; i++) {
            System.out.printf(y[i].prettyPrintFormaNormalNumeroComplejo());
            System.out.print("|");
        }
        System.out.println("");
    }

    private String stringifyPhotonMatrix(Complex[][] m) {
        String matrizString = "[";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i + 1 == m.length) {
                    matrizString += m[i][j].prettyPrintFormaNormalNumeroComplejo();
                } else {
                    matrizString += m[i][j].prettyPrintFormaNormalNumeroComplejo() + ", ";
                }
            }
            matrizString += "]";
        }
        return matrizString;
    }

    private String stringifyPhotonVector(Complex[] y) {
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

   
    public String[] multiSlitPhoton(int numeroSlits, int numeroTargets, Complex[][] probabilidades){
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
        Complex[][] matrizAdyacencia2 = basic.multM(matrizAdyacencia, matrizAdyacencia);
        Complex[] y = basic.accion(matrizAdyacencia2, x);
        printPhotonMatrix(matrizAdyacencia2);
        printPhotonVector(y);
        String[] matrizVector = {stringifyPhotonMatrix(matrizAdyacencia2), stringifyPhotonVector(y), interferenceCheck(matrizAdyacencia2, numeroSlits)};
        return matrizVector;
    }


    
    
    
}
