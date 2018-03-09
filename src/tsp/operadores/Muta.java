/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.operadores;

import java.util.Random;
import tsp.Entidades.Individuo;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Muta {

        public static void muta2Puntos(Individuo ind){
          Random ran = new Random();
          int p1 = ran.nextInt(ind.getGenotipo().length-1)+1;
          int p2 = ran.nextInt(ind.getGenotipo().length-1)+1;
          if(p1!=p2){
          int aux = ind.getGenotipo()[p1];
          ind.getGenotipo()[p1]=ind.getGenotipo()[p2];
          ind.getGenotipo()[p2]= aux;
          ind.calcularFitness();
          }
              
          
        }
}
