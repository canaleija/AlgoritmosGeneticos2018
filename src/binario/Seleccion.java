/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.Random;

/**
 * Selección por torneo(mejor) y aleatoria
 *
 * @author Roberto Cruz Leija
 */
public class Seleccion {

    public static Individuo seleccionAleatoria(Poblacion pob) {
        Random ran = new Random();
        return pob.getIndividuos().get(ran.nextInt(pob.getIndividuos().size()));

    }

    public static Individuo seleccionTorneoMax(Poblacion pob){
      if (pob.getMayor() ==null || pob.getMenor()==null){
       pob.calcularMayorMenor();
      }
      return pob.getMayor();
    }
    
    public static Individuo seleccionTorneoMin(Poblacion pob){
      if (pob.getMayor() ==null || pob.getMenor()==null){
       pob.calcularMayorMenor();
      }
      return pob.getMenor();
    }
}
