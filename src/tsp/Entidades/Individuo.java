/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.Entidades;

import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    public static double[][] distancias;
    private int[]genotipo;
    private double fitness;
   
public Individuo(int[]genotipo){
 this.genotipo = genotipo;
 calcularFitness();
}
public Individuo(int ci) {
        // crear el individuo de forma aleatoria 
        this.genotipo = new int[distancias[0].length];
        this.genotipo[0] = ci;
        int c = 0;        
        for(int x=1; x<this.genotipo.length;x++){
           if(c!=ci){
            // agregar 
            this.genotipo[x]=c;
            c++;
           } else{
            x--;
            c++;
           }
        }
        // realizar intercambios
        Random ran = new Random();
        int ni = ran.nextInt(this.genotipo.length);
        for(int y=0;y<ni;y++){
          int p1 = ran.nextInt(this.genotipo.length-1)+1;
          int p2 = ran.nextInt(this.genotipo.length-1)+1;
          int aux = this.genotipo[p1];
          this.genotipo[p1]= this.genotipo[p2];
          this.genotipo[p2]= aux;
        }
        calcularFitness();
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @return the fitness
     */
    public double getFitness() {
        return fitness;
    }

    public void calcularFitness() {
       // 3 4 1 0 2
       double fit = 0;
       for (int x=0; x < this.genotipo.length;x++){
         if (x!=this.genotipo.length-1){
          fit+=distancias[this.genotipo[x]][this.genotipo[x+1]];
         }else{
          fit+=distancias[this.genotipo[x]][this.genotipo[0]];
         }
       }
       this.fitness = fit;
    }
    
        
}
