/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.cuanticrepository.Basic;
import com.mycompany.cuanticrepository.Complex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fabia
 */
public class Tests {
    
    public Tests() {
    }
    Basic basic = new Basic();
    Complex x,y;
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void s1(){
        
        System.out.println(basic.sum(new Complex(1,2), new Complex(1,2)));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Tests. For example:
    //
    // @Tests
    // public void hello() {}
}
