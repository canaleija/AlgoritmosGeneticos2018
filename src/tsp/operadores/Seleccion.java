/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.operadores;

import java.util.Random;
import tsp.Entidades.Individuo;
import tsp.Entidades.Poblacion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Seleccion {
    
    public static Individuo seleccionAleatoria(Poblacion pob) {
        Random ran = new Random();
        return pob.getIndividuos().get(ran.nextInt(pob.getIndividuos().size()));

    }
    
    public static Individuo seleccionTorneoTSP(Poblacion pob){
       pob.calculaMejorIndividuo();
       return pob.getMejor();
    }
    
}
