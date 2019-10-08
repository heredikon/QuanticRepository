/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuanticrepository;

import java.util.List;

/**
 *
 * @author fabia
 */
public class QuantumSystem {
    Basic basic = new Basic();

    public double probabilidadEnUnaPosicionParticular(int posicionesPosiblesAOcupar, Complex[] ket, int x) {
        double normaKet = basic.normaKet(ket);
        double probabilidad = Math.pow(ket[x].module(), 2) / Math.pow(normaKet, 2);
        return probabilidad;
    }


    public Complex calcularAmplitudTransicional(Complex[] ket1, Complex[] ket2){
        return basic.internalProV(ket2, ket1);
    }


    public Complex mediaDeUnObservableSobreUnVectorEstado(Complex[][] m, Complex[] ket) {
        Complex[] accion = basic.accion(m, ket);
        Complex media = basic.internalProV(accion, ket);
        return media;
    }


    public Complex varianzaDeUnOperador(Complex[][] m, Complex[] ket) {

        Complex[][] mediaObservableSobreVector = basic.scalarMult(mediaDeUnObservableSobreUnVectorEstado(m, ket), basic.identityM(m.length));
        Complex[][] deltaObservable = basic.sumM(m, basic.inverseM(mediaObservableSobreVector));
        Complex[][] deltaObservable2 = basic.multM(deltaObservable, deltaObservable);
        Complex varianza = basic.internalProV(basic.accion(deltaObservable2, ket), ket);
        return varianza;
    }

 

    

    public static double probabilidadQueElSistemaTransiteALosVectoresPropios(Complex[][] m, Complex[] ket) {
        return 0;
    }
    
    public Complex[] dinamica(int times, Complex[] ket, List<Complex[][]> sequence){
        Complex[] finalState = ket;
        for (int i = 0; i < times; i++) {
            finalState = basic.accion(sequence.get(i), finalState);
        }
        return finalState;
    }

}
