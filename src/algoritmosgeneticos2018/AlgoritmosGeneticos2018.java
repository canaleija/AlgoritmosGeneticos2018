/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos2018;

import tsp.Entidades.Individuo;
import tsp.GeneticoTSPv1;
import tsp.Herramientas;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmosGeneticos2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
  //      Herramientas.guardarInstancia(Herramientas.generarMatrizDistanciasAleatoria(1000, 100));
          Individuo.distancias = Herramientas.abrirInstancia();
          GeneticoTSPv1 gen = new GeneticoTSPv1(50, 0.25, 50000,56);
          gen.evolucionar();
          System.out.println();
    }
    
}
