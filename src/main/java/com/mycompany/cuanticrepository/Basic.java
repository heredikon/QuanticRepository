/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuanticrepository;

/**
 *
 * @author fabia
 */
public class Basic {

    private Complex ans = new Complex(0, 0);

    public Basic() {
    }

    public Complex sum(Complex x, Complex y) {
        Complex ans = new Complex(0,0);
        ans.setReal(x.getReal() + y.getReal());
        ans.setImaginary(x.getImaginary() + y.getImaginary());
        return new Complex(ans.getReal(), ans.getImaginary());
    }

    public Complex subs(Complex x, Complex y) {
        ans.setReal(x.getReal() - y.getReal());
        ans.setImaginary(x.getImaginary() - y.getImaginary());
        return new Complex(ans.getReal(), ans.getImaginary());
    }

    public Complex mult(Complex x, Complex y) {
        ans.setReal(x.getReal() * y.getReal() - x.getImaginary() * y.getImaginary());
        ans.setImaginary(x.getImaginary() * y.getReal() + x.getReal() * y.getImaginary());
        return new Complex(ans.getReal(), ans.getImaginary());
    }

    public Complex divide(Complex x, Complex y) {
        Complex ans = new Complex(0,0);
        double denominador = Math.pow(y.getReal(), 2) + Math.pow(y.getImaginary(), 2);
        ans.setReal(((x.getReal() * y.getReal()) + (x.getImaginary() * y.getImaginary())) / denominador);
        ans.setImaginary(((y.getReal() * x.getImaginary()) - (x.getReal() * y.getImaginary())) / denominador);
        return ans;

    }

    public Complex polar(Complex x) {
        return x.getPolar();
    }

    public Complex cartesian(Complex x) {
        return x.getCartesian();
    }

    public Complex[] sumV(Complex[] v1, Complex[] v2) {
        //if (v1.length != v2.length){return new Complex(-0.123, -0.123)};
        Complex[] ansV = new Complex[v1.length];
        for (int i = 0; i < v1.length; i++) {
            ansV[i] = sum(v1[i], v2[i]);
        }
        return ansV;

    }

    public Complex[] inverseV(Complex[] v1) {
        Complex[] ansV = new Complex[v1.length];
        for (int i = 0; i < v1.length; i++) {
            ansV[i] = v1[i].inverse();
        }
        return ansV;
    }

    public Complex[] conjugadoV(Complex[] v1) {
        Complex[] ansV = new Complex[v1.length];
        for (int i = 0; i < v1.length; i++) {
            ansV[i] = v1[i].conjugado();
        }
        return ansV;
    }

    public Complex[][] scalarMult(Complex x, Complex[][] yM) {
        Complex[][] ansM = yM;
        for (int i = 0; i < ansM.length; i++) {
            for (int j = 0; j < ansM[0].length; j++) {
                ansM[i][j] = this.mult(x, yM[i][j]);
            }
        }
        return ansM;
    }

    public Complex internalProV(Complex[] v1, Complex[] v2) {
        Complex ans = new Complex(0,0);
        Complex[] V = conjugadoV(v1);
        for (int i = 0; i < v1.length; i++) {
            ans = sum(ans, mult(V[i], v2[i]));
        }
        return ans;
    }

    public boolean equalsV(Complex[] v1, Complex[] v2) {
        if (v1.length!=v2.length){
            return false;
        }
        for (int i = 0; i < v1.length; i++) {
            if (!v1[i].equals(v2[i])) {
                return false;
            }
        }
        return true;
    }

    public Complex[][] identityM(int length) {
        Complex[][] ansM = new Complex[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                ansM[i][j] = i == j ? new Complex(1, 0) : new Complex(0, 0);
            }
        }
        return ansM;
    }

    public boolean equalsM(Complex[][] m1, Complex[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            if (!equalsV(m1[i], m2[i])) {
                return false;
            }
        }
        return true;
    }

    public Complex[][] sumM(Complex[][] m1, Complex[][] m2) {
        Complex[][] ansM = new Complex[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            ansM[i] = sumV(m1[i], m2[i]);
        }
        return ansM;
    }

    public Complex[][] inverseM(Complex[][] m1) {
        Complex[][] ansM = m1;
        for (int i = 0; i < m1.length; i++) {
            ansM[i] = inverseV(m1[i]);
        }
        return ansM;
    }

    public Complex[][] transpM(Complex[][] m1) {
        Complex[][] ansM = new Complex[m1[0].length][m1.length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                ansM[j][i] = m1[i][j];
            }
        }
        return ansM;
    }

    public Complex[][] conjugadoM(Complex[][] m1) {
        Complex[][] ansM = new Complex[m1.length][m1[0].length];
        for (int i = 0; i < ansM.length; i++) {
            ansM[i] = conjugadoV(m1[i]);
        }
        return ansM;
    }

    public Complex[][] attachedM(Complex[][] m1) {
        Complex[][] ansM = new Complex[m1.length][m1[0].length];
        ansM = transpM(conjugadoM(m1));
        return ansM;
    }

    public Complex[][] multM(Complex[][] m1, Complex[][] m2) {
        Complex[][] ansM = new Complex[m1.length][m2[0].length];
        Complex result;
        int i;
        int j;
        for (int i_f = 0; i_f < m1.length; i_f++) {
            for (int j_f = 0; j_f < m2[0].length; j_f++) {
                result = new Complex(0, 0);
                i = 0;
                j = 0;
                while (j < m1[0].length && i < m2.length) {
                    result = sum(result, mult(m1[i_f][j], m2[i][j_f]));
                    j++;
                    i++;
                }
                ansM[i_f][j_f] = result;
            }
        }
        return ansM;
    }

    public Complex trace(Complex[][] m1) {
        Complex ans = new Complex(0, 0);
        for (int i = 0; i < m1.length && i < m1[0].length; i++) {
            ans = sum(ans, m1[i][i]);
        }
        return ans;
    }

    public Complex internalprodM(Complex[][] m1, Complex[][] m2) {
        return trace(multM(m1, m2));
    }

    public Complex[] accion(Complex[][] m1, Complex[] v1) {
        Complex[] ansV = new Complex[v1.length];
        for (int i = 0; i < m1.length; i++) {
            ansV[i] = new Complex(0, 0);
            for (int j = 0; j < m1.length; j++) {
                ansV[i] = sum(ansV[i], mult(m1[i][j], v1[j]));
            }
        }
        return ansV;
    }

    public boolean isHermitian(Complex[][] m1) {
        return equalsM(m1, attachedM(m1));
    }

    public boolean isUnitary(Complex[][] m1) {
        return equalsM(multM(m1, attachedM(m1)), identityM(m1.length));
    }

    public double normV(Complex[] v1) {
        return Math.sqrt(internalProV(v1, v1).getReal());
    }
    
    public double distanceV(Complex[] v1, Complex[] v2){
        Complex[] aux = sumV(v1, inverseV(v2));
        return Math.sqrt(internalProV(aux, aux).getReal());
    }

    public Complex[][] tensorProduct(Complex[][] m1, Complex[][] m2) {
        Complex[][] ansM = new Complex[m1.length * m2.length][m1[0].length * m2[0].length];
        System.out.println(m2[0].length);
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                for (int p = 0; p < m2.length; p++) {
                    for (int q = 0; q < m2[0].length; q++) {
                        ansM[i * m2.length + p][j * m2[0].length + q] = mult(m1[i][j], m2[p][q]);
                    }
                }
            }
        }
        return ansM;
    }

}
