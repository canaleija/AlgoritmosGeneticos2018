/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tsp.Entidades.Individuo;
import tsp.Entidades.Poblacion;
import tsp.operadores.Cruza;
import tsp.operadores.Muta;
import tsp.operadores.Seleccion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneticoTSPv1 {
    private int tamPob;
    private double probMuta;
    private int numGeneraciones;
    private Poblacion pobActual;

    public GeneticoTSPv1(int tamPob, double probMuta, int numGeneraciones, int ci) {
        this.tamPob = tamPob;
        this.probMuta = probMuta;
        this.numGeneraciones = numGeneraciones;
        this.pobActual = new Poblacion(tamPob, ci);
    }
    
    public void evolucionar(){
       Poblacion nuevaPoblacion; 
       this.pobActual.getIndividuos().add(Herramientas.sacarMejor());
       Individuo mejor = this.pobActual.getMejor();
       // agregar el ciclo para las generaciones 
       for(int g=0; g<this.numGeneraciones;g++){
          // proceso iterativo de construccion de la
          // nueva población
          nuevaPoblacion = new Poblacion();
         
          for(int i=0;i<this.tamPob;i++){
          
          // seleccionar a una madre y un padre
          Individuo madre = Seleccion.seleccionTorneoTSP(pobActual);
          Individuo padre = Seleccion.seleccionAleatoria(pobActual);
          // cruza
          Individuo nuevoi = Cruza.cruzaAsexual(padre, madre);
          // muta (evaluar la probabilidad)
          if(Math.random()<=this.probMuta){
          Muta.muta2Puntos(nuevoi);
          } 
          // agregamos el individuo a la nueva poblacion
          nuevaPoblacion.getIndividuos().add(nuevoi);
          }
       // actualizamos la población actual 
       
       this.pobActual = new Poblacion(nuevaPoblacion);
       if (this.pobActual.getMejor().getFitness()<mejor.getFitness()) mejor = this.pobActual.getMejor();
       System.out.println("Mejor "+g+": "+this.pobActual.getMejor().getFitness());
       
       }
        try {
            // guardar el mejor
            Herramientas.guardarMejorIndividuo(mejor);
        } catch (IOException ex) {
            Logger.getLogger(GeneticoTSPv1.class.getName()).log(Level.SEVERE, null, ex);
        }
       System.out.println("Mejor mejor: "+mejor.getFitness());
       
    
    }
}
