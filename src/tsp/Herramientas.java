/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import tsp.Entidades.Individuo;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Herramientas {

    public static double[][] generarMatrizDistanciasAleatoria(int n, int distTope) {
        Random ran = new Random();

        double matriz[][] = new double[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x == y) {
                    matriz[x][y] = 0;
                } else {// si no es igual
                    double dist = ran.nextInt(distTope) + ran.nextDouble();
                    matriz[x][y] = dist;
                    matriz[y][x] = dist;
                }
            }
        }
        return matriz;
    }

    public static void guardarInstancia(double[][] matriz) {
        //llamamos el metodo que permite cargar la ventana
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);
        //abrimos el archivo seleccionado
        File abre = file.getSelectedFile();

        String ruta = abre.getAbsolutePath();//"C:\\Users\\DE LEON\\Desktop\\" + nombre + ".txt";
        File archivo = new File(ruta + ".txt");
        BufferedWriter bw = null;
        try {
            if (archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Archivo ya Existente",
                        "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                for (int x = 0; x < matriz.length; x++) {
                    for (int y = 0; y < matriz.length; y++) {
                        if (y == matriz.length - 1) {
                            bw.append("" + matriz[x][y]);
                        } else {
                            bw.append("" + matriz[x][y] + ",");
                        }
                    }
                    bw.newLine();
                }
                bw.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double[][] abrirInstancia() {
        // generar la ventana de dialogo para abrir la instancias
        String texto, aux, nombre;
        LinkedList<String> lista = new LinkedList();
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            nombre = abre.getName();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                // calcular el numero de cidades
                int numCiu = lista.size();
                // instanciar la matriz
                double matriz[][] = new double[numCiu][numCiu];

                //leer los elementos y almacenarlos en la matriz
                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    for (int x = 0; x < lista2.size(); x++) {
                        matriz[x][i] = Double.parseDouble(lista2.get(x));
                    }
                    lista2.clear();
                }
                //retornar la matriz
                return matriz;
            }
        } catch (Exception e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Archivo no encontrado",
                    "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public static Individuo sacarMejor(){
        BufferedReader br;
        Individuo mejor,tmp;
        String s;
        String c_ind[];
        int cromosoma[];
        ArrayList<Individuo> individuos;
        
        individuos = new ArrayList<>();
        
         try {        
            br = new BufferedReader(new FileReader("mejor_10.txt"));
            
            //Agregar todos los individous a un ArrayList
            while((s=br.readLine())!=null){
                c_ind=s.split(",");
                cromosoma=new int[c_ind.length];
                
                //Convertir de arreglo de string a int
                for(int x=0;x<c_ind.length;x++){
                    cromosoma[x]=Integer.parseInt(c_ind[x]);
                }
                
                tmp=new Individuo(cromosoma);
      
                individuos.add(tmp);
            }
            br.close();
            
            //Sacar el mejor
            if(!individuos.isEmpty()){
                mejor=individuos.get(0);
            
            for(int x=0;x<individuos.size();x++){
                if(individuos.get(x).getFitness()<(mejor.getFitness())){
                    mejor=individuos.get(x);
                }
            }
            
                return mejor;
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
         
        return null;
}
    
    public static void guardarMejorIndividuo(Individuo ind) throws IOException
    {
        //llamamos el metodo que permite cargar la ventana
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);
        //abrimos el archivo seleccionado
        File abre = file.getSelectedFile();

        String ruta = abre.getAbsolutePath();//"C:\\Users\\DE LEON\\Desktop\\" + nombre + ".txt";
        File archivo = new File(ruta + ".txt");
        BufferedWriter bw = null;
        try {
            if (archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Archivo ya Existente",
                        "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                bw = new BufferedWriter(new FileWriter(archivo)); 
                int pos= ind.getGenotipo().length-1;
                for(int j=0; j<ind.getGenotipo().length;j++)
                {      
                    if(j==pos)
                    {
                    bw.append("" + ind.getGenotipo()[j]);
                    }
                    else
                    bw.append("" +ind.getGenotipo()[j] + ",");
                }         
            }
                bw.close(); 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
