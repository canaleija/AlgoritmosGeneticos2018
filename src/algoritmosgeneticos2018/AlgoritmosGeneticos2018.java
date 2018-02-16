/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos2018;

import binario.Individuo;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmosGeneticos2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Individuo.dimGenotipo = 5;
        
        Individuo[] poblacion = new Individuo[150];
        
        for (int x=0; x < 150;x++)
            poblacion[x] = new Individuo();
        
        System.out.println(poblacion[0].getFitness());
        System.out.println(poblacion[149].getFitness());
        System.out.println(poblacion[49].getFitness());
      
      
    }
    
}
