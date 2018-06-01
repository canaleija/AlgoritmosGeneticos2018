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
    public static double[][] inclinaciones;
    private int[]genotipo;
    private double fitnessDistancias;
    private double fitnessInclinaciones;
   
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
     * @return the fitnessDistancias
     */
    public double getFitnessDistancias() {
        return fitnessDistancias;
    }

    public void calcularFitness() {
       // 3 4 1 0 2
       double fit = 0;
       double fit2 = 0;
       for (int x=0; x < this.genotipo.length;x++){
         if (x!=this.genotipo.length-1){
          fit+=distancias[this.genotipo[x]][this.genotipo[x+1]];
          
          fit2+=inclinaciones[this.genotipo[x]][this.genotipo[x+1]]>0
                   ?inclinaciones[this.genotipo[x]][this.genotipo[x+1]]:0;
          
         }else{
          fit+=distancias[this.genotipo[x]][this.genotipo[0]];
          fit2+=inclinaciones[this.genotipo[x]][this.genotipo[0]]>0
                  ?inclinaciones[this.genotipo[x]][this.genotipo[0]]:0;
         }
       }
       this.fitnessDistancias = fit;
       this.fitnessInclinaciones = fit2;
    }

    /**
     * @return the fitnessInclinaciones
     */
    public double getFitnessInclinaciones() {
        return fitnessInclinaciones;
    }
    
    public boolean isMejor(Individuo ind){
       double distancia = ind.getFitnessDistancias();
       double inclinacion = ind.getFitnessInclinaciones();
       
       if(this.fitnessDistancias>distancia && 
               this.fitnessInclinaciones>inclinacion) 
           return false;
       return true;
    }
    
        
}
