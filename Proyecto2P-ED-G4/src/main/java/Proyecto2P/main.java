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
import TDAs.BinaryTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Javier
 */
public class main {
    private static Scanner sc;
    private static BinaryTree<String> arbolActual;
    
    public static void main(String[] args) {
        sc= new Scanner(System.in);
        
        
        ArrayList<String> orden=new ArrayList<>();
        orden.add("¿Es este animal un mamífero?");
        orden.add("¿Es este animal un carnívoro?");
        orden.add("¿Se para este animal sobre cuatro patas?");
        //System.out.println(orden);
        
        BinaryTree<String> arbolPreguntas= enlazarArbolesPreguntas(orden);
        //ArrayList<String> reverse = orden;
        //Collections.reverse(reverse);
        //Map<Integer,ArrayList<String>> tabla = arbolPorNivel(arbolPreguntas,orden,respuestas);
        //System.out.println(tabla);
        //System.out.println("Nivel 0: "+tabla.get(0));
        //System.out.println("Nivel 1: "+tabla.get(1));
        //System.out.println("Nivel 2: "+tabla.get(2));
        
        /*System.out.println("//////");
        //System.out.println(arbolPreguntas);
        System.out.println("0.Root: " +arbolPreguntas.getRootContent());
        System.out.println("1.1.Root izquierdo: "+arbolPreguntas.getLeft().getRootContent());
        System.out.println("1.2.Root derecho: "+arbolPreguntas.getRight().getRootContent());
        System.out.println("2.1."+arbolPreguntas.getLeft().getLeft().getRootContent());
        System.out.println("2.2."+arbolPreguntas.getLeft().getRight().getRootContent());
        System.out.println("2.3."+arbolPreguntas.getRight().getLeft().getRootContent());
        System.out.println("2.4."+arbolPreguntas.getRight().getRight().getRootContent());*/
        
        ArrayList<String> respuestas=new ArrayList<>();
        
        respuestas.add("Oso;SI;SI;SI");
        respuestas.add("Desconocido;SI;SI;NO");
        respuestas.add("Venado;SI;NO;SI");
        respuestas.add("Desconocido;SI;NO;NO");
        respuestas.add("Desconocido;NO;SI;SI");
        respuestas.add("Lechuza;NO;SI;NO");
        respuestas.add("Desconocido;NO;NO;SI");
        respuestas.add("Paloma;NO;NO;NO");
        
        BinaryTree<String> arbolFinal=enlazarRespuestas(arbolPreguntas,respuestas);
        /*System.out.println("PRUEBA RESPUESTAS");
        System.out.println("0.Root: " +arbolFinal.getRootContent());
        System.out.println("1.1.Root izquierdo: "+arbolFinal.getLeft().getRootContent());
        System.out.println("1.2.Root derecho: "+arbolFinal.getRight().getRootContent());
        System.out.println("2.1."+arbolFinal.getLeft().getLeft().getRootContent());
        System.out.println("2.2."+arbolFinal.getLeft().getRight().getRootContent());
        System.out.println("2.3."+arbolFinal.getRight().getLeft().getRootContent());
        System.out.println("2.4."+arbolFinal.getRight().getRight().getRootContent());
        System.out.println("3.1."+arbolFinal.getLeft().getLeft().getLeft().getRootContent());
        System.out.println("3.2."+arbolFinal.getLeft().getLeft().getRight().getRootContent());
        System.out.println("3.3."+arbolFinal.getLeft().getRight().getLeft().getRootContent());
        System.out.println("3.4."+arbolFinal.getLeft().getRight().getRight().getRootContent());
        System.out.println("3.5."+arbolFinal.getRight().getLeft().getLeft().getRootContent());
        System.out.println("3.6."+arbolFinal.getRight().getLeft().getRight().getRootContent());
        System.out.println("3.7."+arbolFinal.getRight().getRight().getLeft().getRootContent());
        System.out.println("3.6."+arbolFinal.getRight().getRight().getRight().getRootContent());*/
        
        Map<Integer,ArrayList<String>> tabla = arbolPorNivel(arbolPreguntas,orden,respuestas);
        System.out.println("Nivel 0: "+tabla.get(0));
        System.out.println("Nivel 1: "+tabla.get(1));
        System.out.println("Nivel 2: "+tabla.get(2));
        System.out.println("Nivel 3: "+tabla.get(3));
        
       /* BinaryTree<String> arbol=new BinaryTree<>("¿Es este animal un mamífero?");
        arbol.setLeft(new BinaryTree<>("¿Es este animal un carnívoro?"));
        arbol.setRight(new BinaryTree<>("¿Es este animal un carnívoro?"));
        arbol.getLeft().setLeft(new BinaryTree<>("¿Se para este animal sobre cuatro patas?"));
        arbol.getLeft().setRight(new BinaryTree<>("¿Se para este animal sobre cuatro patas?"));
        arbol.getRight().setLeft(new BinaryTree<>("¿Se para este animal sobre cuatro patas?"));
        arbol.getRight().setRight(new BinaryTree<>("¿Se para este animal sobre cuatro patas?"));
        //Map<Integer,LinkedList<String>> tabla = arbolPorNivel(arbol,orden);
        
        arbol.getRight().getRight().setRight(new BinaryTree<>("Paloma"));
        arbol.getRight().getRight().setLeft(new BinaryTree<>("Desconocido"));
        arbol.getRight().getLeft().setRight(new BinaryTree<>("Lechuza"));
        arbol.getLeft().getRight().setRight(new BinaryTree<>("Desconocido"));
        arbol.getRight().getLeft().setLeft(new BinaryTree<>("Desconocido"));
        arbol.getLeft().getRight().setLeft(new BinaryTree<>("Venado"));
        arbol.getLeft().getLeft().setRight(new BinaryTree<>("Desconocido"));
        arbol.getLeft().getLeft().setLeft(new BinaryTree<>("Oso"));
        */
        
        
        
        
        
        
        /*System.out.println("Arbol que usaremos: ");
        //LinkedList<String> respuestas=new LinkedList<>();
        
        respuestas.add("Oso");
        respuestas.add("Desconocido");
        respuestas.add("Venado");
        respuestas.add("Desconocido");
        respuestas.add("Desconocido");
        respuestas.add("Lechuza");
        respuestas.add("Desconocido");
        respuestas.add("Paloma");
        
        //tabla.put(3, respuestas);

        System.out.println("Nivel 0: "+tabla.get(0));
        System.out.println("Nivel 1: "+tabla.get(1));
        System.out.println("Nivel 2: "+tabla.get(2));
        System.out.println("Nivel 3: "+tabla.get(3));
        //System.out.println(tabla.get(2).size());
        ///System.out.println(arbolPorNivel(arbol,orden));
        System.out.println("");
        System.out.println("/////////////////////////");*/
        System.out.println("Por favor piense en un animal");
        arbolActual=arbolPreguntas;
        
        String resp1="";
        //while(!resp1.equals("SI")||!resp1.equals("NO")){
        while(arbolActual.getRootContent()!=null){
            if(ArbolData.esPregunta( arbolActual.getRootContent() ) ){
                System.out.println(arbolActual.getRootContent());
                resp1=sc.nextLine().toUpperCase();
                if(resp1.equals("SI")){
                    arbolActual=arbolActual.getLeft();
                
                }else if(resp1.equals("NO")){
                    arbolActual=arbolActual.getRight();
                }
            }else{
                if(arbolActual.getRootContent().equals("Desconocido")){
                    System.out.println("Lo sentimos, pero no tenemos un animal que cumpla esa descripccion");
                    break;
                }else{
                    System.out.println("Estas pensando en un "+arbolActual.getRootContent()+"!");
                    break;
                }
            }
        }
    }
    
}
