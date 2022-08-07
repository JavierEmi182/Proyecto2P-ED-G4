/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2P;

import Data.ArbolData;
import static Data.ArbolData.arbolPorNivel;
import static Data.ArbolData.enlazarArbolesPreguntas;
import static Data.ArbolData.enlazarRespuestas;
import static Data.PreguntasData.leerPreguntas;
import static Data.RespuestasData.leerRespuestas;
import TDAs.BinaryTree;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class main {
    private static Scanner sc;
    private static BinaryTree<String> arbolActual;
    
    public static void main(String[] args) throws IOException {
        sc= new Scanner(System.in);
        
        String ruta = "recursos/Preguntas.txt";
        //array preguntas
        ArrayList<String> orden = leerPreguntas(ruta);
        
        
        BinaryTree<String> arbolPreguntas= enlazarArbolesPreguntas(orden);
        
       String rutaRespuestas = "recursos/Respuestas.txt";
       //array respuestas
        ArrayList<String> respuestas = leerRespuestas(rutaRespuestas);          
        
        //arbol preguntas con respuestas enlazadas
        BinaryTree<String> arbolFinal=enlazarRespuestas(arbolPreguntas,respuestas);               
        
        
        //INICIO DEL JUEGO
        System.out.println("Por favor piense en un animal");
        arbolActual=arbolFinal;
        
        String resp1="";
        while(arbolActual.getRootContent()!=null){
            if(ArbolData.esPregunta(arbolActual.getRootContent())){
                System.out.println("*"+arbolActual.getRootContent());
                resp1=sc.nextLine().toUpperCase();
                if(resp1.equals("SI")){
                    arbolActual=arbolActual.getLeft();
                    if(arbolActual==null){
                        System.out.println("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
                        break;
                    }
                }else if(resp1.equals("NO")){
                    arbolActual=arbolActual.getRight();
                    if(arbolActual==null){
                        System.out.println("Lo sentimos, pero no tenemos un animal que cumpla esa descripcion");
                        break;
                    }
                }
            }else{
                System.out.println("Estas pensando en un "+arbolActual.getRootContent()+"!");
                break;
            }
        }
        
        //impresion del arbol
        System.out.println("Presione enter para ver el arbol:");
        sc.nextLine();
        
        System.out.println("////ARBOL EN USO POR NIVEL////");
        Map<Integer,ArrayList<String>> tabla = arbolPorNivel(arbolPreguntas,orden,respuestas);
        System.out.println("Nivel 0: "+tabla.get(0));
        System.out.println("Nivel 1: "+tabla.get(1));
        System.out.println("Nivel 2: "+tabla.get(2));
        System.out.println("Nivel 3 (respuestas registradas): "+tabla.get(3));
        
    }
    
}
