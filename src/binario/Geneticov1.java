/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

/**
 *  Genetico sin muestreo
 *  
 * @author Roberto Cruz Leija
 */
public class Geneticov1 {
    
    // tamaño de la pob, prob muta, cantidad de generaciones
    private int tamPob;
    private double probMuta;
    private int numGeneraciones;
    private Poblacion pobActual;

    public Geneticov1(int tamPob, double probMuta, int numGeneraciones) {
        this.tamPob = tamPob;
        this.probMuta = probMuta;
        this.numGeneraciones = numGeneraciones;
        this.pobActual = new Poblacion(tamPob);
    }
    
    public void evolucionar(){
       Poblacion nuevaPoblacion; 
       this.pobActual.calcularMayorMenor();
       // agregar el ciclo para las generaciones 
       for(int g=0; g<this.numGeneraciones;g++){
          // proceso iterativo de construccion de la
          // nueva población
          nuevaPoblacion = new Poblacion();
          for(int i=0;i<this.tamPob;i++){
          
          // seleccionar a una madre y un padre
          Individuo madre = Seleccion.seleccionTorneoMin(pobActual);
          Individuo padre = Seleccion.seleccionAleatoria(pobActual);
          // cruza
          Individuo nuevoi = Cruza.cruzaBinaria(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,0}, madre, padre);
          // muta (evaluar la probabilidad)
          if(Math.random()<=this.probMuta){
          Muta.mutaAleatoria(nuevoi);
          } 
          // agregamos el individuo a la nueva poblacion
          nuevaPoblacion.getIndividuos().add(nuevoi);
          }
       // actualizamos la población actual 
       this.pobActual = new Poblacion(nuevaPoblacion);
     
       }
       
       System.out.println("Mejor: "+this.pobActual.getMenor().getFenotipo());
    
    }

    /**
     * @return the pobActual
     */
    public Poblacion getPobActual() {
        return pobActual;
    }
    
    
    
}
