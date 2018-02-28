/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos2018;

import binario.Cruza;
import binario.Geneticov1;
import binario.Individuo;
import binario.Muta;
import binario.Ordenamiento;
import binario.Poblacion;
import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmosGeneticos2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Individuo.dimGenotipo = 23;
        Geneticov1 g1 = new Geneticov1(30,0.3, 200);
        g1.evolucionar();

        
      
    }
    
}
