/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Poblacion {
    
    private ArrayList<Individuo> individuos;
    private Individuo menor;
    private Individuo mayor;
    
    // poblacion aleatoria 
    public Poblacion(int tamano){
        this.individuos = new ArrayList<>();
        for(int x=0;x<tamano;x++){
            Individuo i = new Individuo();
            i.getFitness();
            this.individuos.add(i);}
    }
    // la creacion de una poblacion en base a otra
    public Poblacion(Poblacion pob){
        this.individuos = new ArrayList<>();
        for (Individuo ind: pob.getIndividuos()){
           this.individuos.add(new Individuo(ind.getGenotipo()));
        }
        if (pob.getMayor() !=null && pob.getMenor()!=null){
           this.menor = new Individuo(pob.getMenor().getGenotipo());
           this.mayor = new Individuo(pob.getMayor().getGenotipo());
           
        }
    }
    
    public void calcularMayorMenor(){
      // recorrer la población completa 
      this.mayor = new Individuo(this.individuos.get(0).getGenotipo());
      this.menor = new Individuo(this.individuos.get(0).getGenotipo());
      
      for(int x=1; x<this.individuos.size();x++){
          if(this.individuos.get(x).getFitness()
                  >this.mayor.getFitness()){
           this.mayor = new Individuo(this.individuos.get(x).getGenotipo());
          }
           if(this.individuos.get(x).getFitness()
                  <this.menor.getFitness()){
           this.menor = new Individuo(this.individuos.get(x).getGenotipo());
          }
      }
    }

    /**
     * @return the individuos
     */
    public ArrayList<Individuo> getIndividuos() {
        return individuos;
    }

    /**
     * @return the menor
     */
    public Individuo getMenor() {
        return menor;
    }

    /**
     * @return the mayor
     */
    public Individuo getMayor() {
        return mayor;
    }
    
    
    
}
