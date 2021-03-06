/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.IOException;
import java.util.ArrayList;
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
public class GeneticoTSPv2 {
    private int tamPob;
    private double probMuta;
    private int numGeneraciones;
    private Poblacion pobActual;
    private int porMuestra;

    public GeneticoTSPv2(int tamPob, double probMuta, int numGeneraciones, int ci) {
        this.tamPob = tamPob;
        this.probMuta = probMuta;
        this.numGeneraciones = numGeneraciones;
        this.pobActual = new Poblacion(tamPob, ci);
        this.porMuestra = 10;
    }
    
    public void evolucionar(){
       Poblacion nuevaPoblacion;
       
       //Individuo lectura = Herramientas.sacarMejor();
       
       //this.pobActual.getIndividuos().add(lectura);
       this.pobActual.calculaMejorIndividuo();
       Individuo mejor = this.pobActual.getMejor();
      
        ArrayList<Double> datosG = new ArrayList<>();
        
       

// agregar el ciclo para las generaciones 
       for(int g=0; g<this.numGeneraciones;g++){
          // proceso iterativo de construccion de la
          // nueva población
          nuevaPoblacion = new Poblacion();
          // generar el muestreo
          int cantidadM = (int)(this.tamPob*this.porMuestra/100);
          //generarMuestreo(cantidadM,nuevaPoblacion);
          nuevaPoblacion.recibirMuestra(this.pobActual.generarGrupoMejores(cantidadM));
          for(int i=cantidadM;i<this.tamPob;i++){
          
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
       if (this.pobActual.getMejor().getFitnessDistancias()<mejor.getFitnessDistancias()) {
           mejor = this.pobActual.getMejor();
           datosG.add(mejor.getFitnessDistancias());
       }
       System.out.println("Mejor "+g+": "+this.pobActual.getMejor().getFitnessDistancias());
       
       }
       // guardar el mejor
        // Herramientas.guardarMejorIndividuo(mejor);
       System.out.println("Mejor mejor: "+mejor.getFitnessDistancias());
       
       
       Grafica grafica = new Grafica("Mejores","generacion","Fit");
       grafica.agregarSerie(datosG,"fit");
       grafica.creaYmuestraGrafica();
       
       }

    /**
     * @param porMuestra the porMuestra to set
     */
    public void setPorMuestra(int porMuestra) {
        this.porMuestra = porMuestra;
    }
        
    
    }



