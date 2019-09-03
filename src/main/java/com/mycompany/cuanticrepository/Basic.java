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
        ans.setReal(x.getReal() + y.getReal());
        ans.setImaginary(x.getImaginary() + y.getImaginary());
        return ans;
    }

    public Complex subs(Complex x, Complex y) {
        ans.setReal(x.getReal() - y.getReal());
        ans.setImaginary(x.getImaginary() - y.getImaginary());
        return ans;
    }

    public Complex mult(Complex x, Complex y) {
        ans.setReal(x.getReal() * y.getReal() - x.getImaginary() * y.getImaginary());
        ans.setImaginary(x.getImaginary() * y.getReal() + x.getReal() * y.getImaginary());
        return ans;
    }

    public Complex divide(Complex x, Complex y) {
        double denominator = Math.pow(y.getReal(), 2) + Math.pow(y.getImaginary(), 2);
        ans.setReal(((y.getReal() * y.getReal()) + (x.getImaginary() * y.getImaginary())) / denominator);
        ans.setImaginary(((y.getReal() * x.getImaginary()) - (x.getReal() * y.getImaginary())) / denominator);
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
    
    public Complex[] conjugadoV(Complex[] v1){
        Complex[] ansV = new Complex[v1.length];
        for (int i = 0; i < v1.length;i++){
            ansV[i]= v1[i].conjugado();
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
    
    public Complex internalProV(Complex[] v1, Complex[] v2){
        Complex[] V = conjugadoV(v1);
        for (int i = 0; i < v1.length; i++) {
            ans = sum(ans, mult(V[i], v2[i]));
        }
        return ans;
    }
    
    public Complex[][] sumM(Complex[][] m1, Complex[][] m2){
        Complex[][] ansM = new Complex[m1.length][m1[0].length];
        for (int i = 0; i < m1.length;i++){
            ansM[i] = sumV(m1[i], m2[i]);
        }
        return ansM;
    }
    
    public Complex[][] inverseM(Complex[][] m1){
        Complex[][] ansM = m1;
        for (int i = 0; i< m1.length; i++){
            ansM[i] = inverseV(m1[i]);
        }
        return ansM;    
    }
    
    public Complex[][] transpM(Complex [][] m1){
        Complex[][] ansM = new Complex[m1[0].length][m1.length];
        for (int i = 0;i < m1.length;i++){
            for (int j = 0;j < m1[0].length;j++){
                ansM[j][i] = m1[i][j];
            }
        }
        return ansM;
    }
    
    
    
    

}
