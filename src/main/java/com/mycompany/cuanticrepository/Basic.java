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
    
    private Complex x = new Complex(0, 0);
    private Complex y = new Complex(0, 0);
    private Complex ans = new Complex(0, 0);

    public Basic() {
    }
    
    public Complex sum(Complex x, Complex y){
        this.x = x;
        this.y = y;
        ans.setReal(x.getReal()+y.getReal());
        ans.setImaginary(x.getImaginary()+y.getImaginary());
        return ans;
    }
    public Complex subs(Complex x, Complex y){
        this.x = x;
        this.y = y;
        ans.setReal(x.getReal()-y.getReal());
        ans.setImaginary(x.getImaginary()-y.getImaginary());
        return ans;
    }
    
    public Complex mult(Complex x, Complex y){
        this.x = x;
        this.y = y;
        ans.setReal(x.getReal()*y.getReal()-x.getImaginary()*y.getImaginary());
        ans.setImaginary(x.getImaginary()*y.getReal()+x.getReal()*y.getImaginary());
        return ans;
    }
    
    public Complex[][] scalarMult(Complex x, Complex[][] yM){
        this.x = x;
        Complex[][] ansM = yM;
        for (int i = 0; i < ansM.length; i++) {
            for (int j = 0; j < ansM[0].length; j++) {
                ansM[i][j] = this.mult(x, yM[i][j]);
            }
        }
        return ansM;
        
    }
    public Complex divide(Complex x, Complex y){
        double denominator = Math.pow(y.getReal(), 2) + Math.pow(y.getImaginary(), 2);
        ans.setReal(((y.getReal() * y.getReal()) + (x.getImaginary() * y.getImaginary())) / denominator);
        ans.setImaginary(((y.getReal() * x.getImaginary()) - (x.getReal() * y.getImaginary())) / denominator);
        return ans;
        
    }
    
    public Complex polar(Complex x){
        return x.getPolar();
    }
    
    public Complex cartesian(Complex x){
        return x.getCartesian();
    }
    
    public Complex 
    
    
}
