/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos2018;

import tsp.Entidades.Individuo;
import tsp.Entidades.Poblacion;
import tsp.GeneticoTSPv1;
import tsp.GeneticoTSPv2;
import tsp.Grafica;
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
        
        //  Herramientas.guardarInstancia(Herramientas.generarMatrizDistanciasAleatoria(1000, 100));
        //  Herramientas.guardarInstancia(Herramientas.generarMatrizInclinacionesAleatoria(1000, 101));
          Individuo.distancias = Herramientas.abrirInstancia();
          Individuo.inclinaciones = Herramientas.abrirInstancia();
          Individuo.w1 = 1.1;
          Individuo.w2 = 0.8;
          
          GeneticoTSPv1 gen = new GeneticoTSPv1(65, 0.35,10000, 5);
          gen.evolucionar();
          
       //   System.out.println();
    }
    
}
