/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Cruza {
    
    public static Individuo cruzaBinaria (int mascara[],
            Individuo madre, Individuo padre){
     double genotipo1 [] = new double[madre.getGenotipo().length];
     double genotipo2 [] = new double[madre.getGenotipo().length];
     // verificar los genes de los padres y en base 
     // a la mascara crear nuevos genotipos
     // con la premisa que 1 = madre y 0 = padre
     for (int x=0; x<mascara.length;x++){
          if(mascara[x]==0){
          genotipo1[x]= padre.getGenotipo()[x];
          genotipo2[x]= madre.getGenotipo()[x];
          } else{
          genotipo1[x]= madre.getGenotipo()[x];
          genotipo2[x]= padre.getGenotipo()[x];
          }
     }
     // crear los nuevos ind
     Individuo hijo1 = new Individuo(genotipo1);
     Individuo hijo2 = new Individuo(genotipo2);
     // comparamos el grado de bondad de los 2 hijos 
     
     if (hijo1.getFitness()>hijo2.getFitness()){
     return hijo1;
     }else {
      return hijo2;
     }
     
    }
    
}
