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
     Grafica grafica;

    public GeneticoTSPv1(int tamPob, double probMuta, int numGeneraciones, int ci) {
        this.tamPob = tamPob;
        this.probMuta = probMuta;
        this.numGeneraciones = numGeneraciones;
        this.pobActual = new Poblacion(tamPob, ci);
        // graficamos 
        grafica = new Grafica("Grafica","inclinaciones"
                             ,"Distancias");
          grafica.crearSerie("pobinicial");
          grafica.agregarConjuntoDatosASerie("pobinicial", pobActual);
    }
    
    public void evolucionar(){
       Poblacion nuevaPoblacion;
       
      // Individuo lectura = Herramientas.sacarMejor();
       
   //  this.pobActual.getIndividuos().add(lectura);
   //    this.pobActual.calculaMejorIndividuo();
   //    Individuo mejor = this.pobActual.getMejor();
      
       

// agregar el ciclo para las generaciones 
       for(int g=0; g<this.numGeneraciones;g++){
          // proceso iterativo de construccion de la
          // nueva población
          nuevaPoblacion = new Poblacion();
         
          for(int i=0;i<this.tamPob;i++){
          
          // seleccionar a una madre y un padre
          Individuo madre = Seleccion.seleccionAleatoria(pobActual);
          Individuo padre = Seleccion.seleccionTorneoTSP(pobActual);
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
//       if (this.pobActual.getMejor().getFitnessDistancias()<mejor.getFitnessDistancias()) mejor = this.pobActual.getMejor();
//       System.out.println("Mejor "+g+": "+this.pobActual.getMejor().getFitnessDistancias());
//       
//       }
       //        System.out.println("Mejor mejor: "+mejor.getFitnessDistancias());
       System.out.println(g);
       }
       
       // vamos a graficar la ultima población
       this.grafica.crearSerie("pobFinal");
       this.grafica.agregarConjuntoDatosASerie("pobFinal", pobActual);
       this.grafica.creaYmuestraGraficaPuntos();
    }
}
