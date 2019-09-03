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
public class Complex {
    
    private double real=0;
    private double imaginary = 0;

    public Complex(double real,  double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public double module() {
        return Math.sqrt(Math.pow(real,2) + Math.pow(imaginary, 2));
    }
    
    public double phase(){
        return Math.atan(imaginary/real);
    }
    
    public Complex conjugado(){
        return new Complex(real, -imaginary);
    }
    
    public Complex getPolar(){
        return new Complex(this.module(),this.phase());
    }
    public Complex getCartesian(){
        return new Complex(this.getReal() * Math.cos(this.getImaginary()), this.getReal() * Math.sin(this.getImaginary()));
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return (imaginary > 0)? Double.toString(real) +" + "+ Double.toString(imaginary)+"i" :
                                Double.toString(real) +" "+ Double.toString(imaginary)+"i";
    }
    
    
}
