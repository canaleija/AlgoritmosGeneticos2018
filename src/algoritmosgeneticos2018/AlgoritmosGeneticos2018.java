/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos2018;

import binario.Cruza;
import binario.Geneticov1;
import binario.Individuo;
import binario.Muta;
import binario.Ordenamiento;
import binario.Poblacion;
import java.util.ArrayList;
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
        
        //Herramientas.guardarInstancia(Herramientas.generarMatrizDistanciasAleatoria(5, 1000));
        double[][]distancias = Herramientas.abrirInstancia();
        System.out.println();
    }
    
}
