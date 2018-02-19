/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos2018;

import binario.Cruza;
import binario.Individuo;
import binario.Ordenamiento;
import binario.Poblacion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmosGeneticos2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Poblacion p = new Poblacion(10);
        
        Ordenamiento merge = new Ordenamiento();
        merge.ordenar(p);
        System.out.println();
//        Individuo.dimGenotipo = 7;
//        Individuo i1 = new Individuo
//             (new double[]{1,0,0,1,1,1,0});
//        Individuo i2 = new Individuo
//             (new double[]{1,0,1,1,0,1,0});
//        
//        Individuo hijo = Cruza.cruzaBinaria(new int[]{0,1,0,1,0,1,0}, i1, i2);
       
//        Poblacion p1 = new Poblacion(10);
//        p1.calcularMayorMenor();
//        Individuo menor = p1.getMenor();
//        Individuo mayor = p1.getMayor();
//        Poblacion p2 = new Poblacion(p1);
//        p2.getMayor().getFitness();
//        p2.getMenor().getFitness();
       
       
       
      
      
    }
    
}
