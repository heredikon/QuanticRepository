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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Basic basic = new Basic();
        Complex x = new Complex(1,2);
        Complex y = x.conjugado();
        System.out.println(y);
        Complex [][] m1 = {{x,y}};
        System.out.println(m1[0][1]);
        System.out.println(m1);
        
        System.out.println(basic.divide(new Complex(1,45), new Complex(1,2)));
        
    }
    
}
