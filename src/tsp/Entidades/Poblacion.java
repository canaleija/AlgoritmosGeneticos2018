/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.Entidades;

import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Poblacion {
    
    private ArrayList<Individuo> individuos;
    private Individuo mejor;
    
    // población solo en memoria 
    public Poblacion(){
    this.individuos = new ArrayList<>();
    this.mejor= null;
    }
    
    // poblacion aleatoria 
    public Poblacion(int tamano, int ci){
        this.individuos = new ArrayList<>();
        for(int x=0;x<tamano;x++){
            Individuo i = new Individuo(ci);
            this.individuos.add(i);}
        calculaMejorIndividuo();
    }
    // la creacion de una poblacion en base a otra
    public Poblacion(Poblacion pob){
        this.individuos = new ArrayList<>();
        for (Individuo ind: pob.getIndividuos()){
            Individuo n = new Individuo(ind.getGenotipo());
            this.individuos.add(n);
        }
       calculaMejorIndividuo();
    }
    
    public void calculaMejorIndividuo(){
      int im = 0;
         // recorremos la población 
      for(int i=1;i<this.individuos.size();i++){
         if(this.individuos.get(im).getFitness()>this.individuos.get(i).getFitness()){
           im=i;
         }
      }
      this.mejor =
              new Individuo(this.individuos.get(im).getGenotipo());
    }

    /**
     * @return the individuos
     */
    public ArrayList<Individuo> getIndividuos() {
        return individuos;
    }

    /**
     * @return the mejor
     */
    public Individuo getMejor() {
        return mejor;
    }
    
    
    
}
