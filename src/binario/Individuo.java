/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    
    public static int dimGenotipo;
    private double[] genotipo;
    private double fenotipo;
    private double fitness;
    
    // contructor con un criterio aleatorio 

    public Individuo() {
        this.genotipo = new double[dimGenotipo];
        // generar de forma aleatoria el genotipo del ind
        generarAleatorio();
        
    }
    public Individuo(double[] genotipo){
        this.genotipo = genotipo.clone();
    
    }
    private void generarAleatorio() {
       Random ran = new Random();
      
       // asignar 0 o 1 a cada uno de los genes
       for (int x=0; x<dimGenotipo;x++)
           this.genotipo[x]= ran.nextInt(2);
      
    }

    /**
     * @return the genotipo
     */
    public double[] getGenotipo() {
        return genotipo;
    }

    /**
     * @param genotipo the genotipo to set
     */
    public void setGenotipo(double[] genotipo) {
        this.genotipo = genotipo;
    }

    /**
     * @return the fitness
     */
    public double getFitness() {
         // decodificamos 
       calcularFenotipo();
       calcularFitness();
       // calculamos fitness
        
        return fitness;
    }

    private void calcularFenotipo() {
        this.fenotipo = 0;
        //System.out.println();
        for(int i=(dimGenotipo-1);i>=0;i--){
           fenotipo+=Math.pow(2,(dimGenotipo-1)-i)*genotipo[i];
        // System.out.println();
        } 
    }
    private void calcularFitness() {
       this.fitness = this.fenotipo*this.fenotipo;
      //this.fitness = 2*this.fenotipo+4;
    }
    
    
    
    
}
