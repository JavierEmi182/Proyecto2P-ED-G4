/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2P;

import static Data.ArbolData.arbolPorNivel;
import TDAs.BinaryTree;
import java.util.ArrayList;
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
        
        
        BinaryTree<String> arbol=new BinaryTree<>("¿Es este animal un mamífero?");
        arbol.setLeft(new BinaryTree<>("¿Es este animal un carnívoro?"));
        arbol.setRight(new BinaryTree<>("¿Es este animal un carnívoro?"));
        arbol.getLeft().setLeft(new BinaryTree<>("¿Se para este animal sobre cuatro patas?"));
        arbol.getLeft().setRight(new BinaryTree<>("¿Se para este animal sobre cuatro patas?"));
        arbol.getRight().setLeft(new BinaryTree<>("¿Se para este animal sobre cuatro patas?"));
        arbol.getRight().setRight(new BinaryTree<>("¿Se para este animal sobre cuatro patas?"));
        Map<Integer,LinkedList<String>> tabla = arbolPorNivel(arbol,orden);
        
        arbol.getRight().getRight().setRight(new BinaryTree<>("Paloma"));
        arbol.getRight().getRight().setLeft(new BinaryTree<>("Desconocido"));
        arbol.getRight().getLeft().setRight(new BinaryTree<>("Lechuza"));
        arbol.getLeft().getRight().setRight(new BinaryTree<>("Desconocido"));
        arbol.getRight().getLeft().setLeft(new BinaryTree<>("Desconocido"));
        arbol.getLeft().getRight().setLeft(new BinaryTree<>("Venado"));
        arbol.getLeft().getLeft().setRight(new BinaryTree<>("Desconocido"));
        arbol.getLeft().getLeft().setLeft(new BinaryTree<>("Oso"));
        
        
        
        
        
        
        
        System.out.println("Arbol que usaremos: ");
        LinkedList<String> respuestas=new LinkedList<>();
        
        respuestas.add("Oso");
        respuestas.add("Desconocido");
        respuestas.add("Venado");
        respuestas.add("Desconocido");
        respuestas.add("Desconocido");
        respuestas.add("Lechuza");
        respuestas.add("Desconocido");
        respuestas.add("Paloma");
        
        tabla.put(3, respuestas);

        System.out.println("Nivel 0: "+tabla.get(0));
        System.out.println("Nivel 1: "+tabla.get(1));
        System.out.println("Nivel 2: "+tabla.get(2));
        System.out.println("Nivel 3: "+tabla.get(3));
        //System.out.println(tabla.get(2).size());
        ///System.out.println(arbolPorNivel(arbol,orden));
        System.out.println("");
        System.out.println("/////////////////////////");
        System.out.println("Por favor piense en un animal");
        arbolActual=arbol;
        
        String resp1="";
        //while(!resp1.equals("SI")||!resp1.equals("NO")){
        while(arbolActual.getRootContent()!=null){
            if(arbolActual.getRootContent().startsWith("¿")){
                System.out.println(arbolActual.getRootContent());
                resp1=sc.nextLine().toUpperCase();
                if(resp1.equals("SI")){
                    arbolActual=arbolActual.getLeft();
                
                }else if(resp1.equals("NO")){
                    arbolActual=arbolActual.getRight();
                }
            }else{
                System.out.println("Estas pensando en un "+arbolActual.getRootContent()+"!");
                break;
            }
        }
    }
    
}
