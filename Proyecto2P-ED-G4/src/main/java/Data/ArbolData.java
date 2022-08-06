/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import TDAs.BinaryTree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Javier
 */
public class ArbolData {
    
    //METODOS PARA LEER E INICIALIZAR ARBOLES
    /*public ArrayList<String> leerArbolesPregunta(String ruta) throws IOException{
        ArrayList<String> preguntas=new ArrayList<>();
        //Map<Integer,BinaryTree<String>> tabla = new LinkedHashMap<>();
        
        try(InputStream input = new URL("file:"+ruta).openStream();
                
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            //GENERA EL URL RELATIVO AL ARCHIVO QUE VAMOS A LEER
           
            //URL u = App.class.getResource(ruta);
            //File file = new File(u.toURI());
            //try(BufferedReader bf = new BufferedReader(new FileReader(file))){
                String linea;
                int nivel=0;
                //leemos linea a linea hasta llegar la final del archivo
                while( (linea=bf.readLine())!=null ){
                    //BinaryTree<String> t=new BinaryTree<>(linea);
                    preguntas.add(linea);

                    }
                //System.out.println(fotos);
                //System.out.println("Termine el archivo");
            } catch (FileNotFoundException ex) {
                //System.out.println("No se encontro archivo");
                System.out.println(ex.getMessage());
                throw ex;
            } catch (IOException ex) {
               // System.out.println("Paso algo al leer archivo");
                System.out.println(ex.getMessage());
                throw ex;
            } 
                
        
        return preguntas;   
    }*/
    
    public static BinaryTree<String> enlazarArbolesPreguntas(ArrayList<String> preguntas){
        //INTENTO CON QUEUE
        //LLENO LA COLA
        ArrayList<String> orden=preguntas;
        ArrayList<String> modificado=preguntas;
        ArrayList<String> reverse= new ArrayList<>(modificado);
        
        Collections.reverse(reverse);       
        //Collections.reverse(orden);
        
        Queue<BinaryTree<String>> q= new ArrayDeque<>(); 
        int nv=orden.size()-1;
        for(String p:reverse){
            /*System.out.println("orden: "+orden);
            System.out.println("p: "+p);
            System.out.println("index de p: "+orden.indexOf(p));
            System.out.println(2^2);*/
            //int i=(2^(orden.indexOf(p)))+1;
            int i=(int)Math.pow(2, orden.indexOf(p));
            //System.out.println(i);
            while(i>0){
                q.offer(new BinaryTree<String>(p));
                i--;
            }
            //PARA EL ULTIMO INDICE
            if(orden.indexOf(p)==0){
                q.offer(new BinaryTree<String>(p));
            }
            //PARAR EN EL LA PRIMERA PREGUNTA (ULTIMA INVERTIDA)
            break;
        }
        //System.out.println(q.peek().getRootContent());
        int cont=nv;
        //q.clear();
        //System.out.println(q.size());
        //System.out.println(q.peek().getRootContent());
        while(q.size()>1){
            //q.poll();
            //System.out.println("Entre while");
            if(cont!=0){
                BinaryTree<String> t0=q.poll();
                //System.out.println("hijo izquierdo: "+t0.getRootContent());
                BinaryTree<String> t1=q.poll();
                //System.out.println("hijo derecho: "+t1.getRootContent());
                //System.out.println("numero: "+(nv-1));
                //System.out.println(preguntas);
                //System.out.println(reverse);
                //System.out.println(orden);
                BinaryTree<String> padre= new BinaryTree<>(orden.get(nv-1));
                //System.out.println("Padre: "+padre.getRootContent());//el padre
                padre.setLeft(t0);
                padre.setRight(t1);
                q.offer(padre);
                cont--;
            }else{
                nv--;
                cont=nv;
            }
        }
        
        
        
        
        
        //BinaryTree<String> arbol=new BinaryTree<String>();
        //int nv=preguntas.size();
        //INICIALIZO EL NIVEL 0
       /* if(preguntas.size()>1){
            //ASUMIMOS QUE EL ARGUMENTO RAIZ QUE INGRESO CONTIENE EL NIVEL 0
            preguntas.remove(0);
            
            BinaryTree<String> tree = preguntas.get(0);
            preguntas.remove(0);
            //el nuevo indice 0
            ///
            raiz.setLeft(tree);
            raiz.setRight(tree);
            
            ////
            raiz.setLeft(preguntas.get(0));
            raiz.setRight(preguntas.get(0));
            enlazarArbolesPreguntas(preguntas,raiz.getLeft());
            enlazarArbolesPreguntas(preguntas,raiz.getRight());
        }else{
            //CUANDO ESTA EN LA ULTIMA PREGUNTA
            raiz.setLeft(preguntas.get(0));
            raiz.setRight(preguntas.get(0));
        }
        
        //while(nv>0){
        
        
        //}*/
       
       
        
        return q.poll();
    }
    
    
    //METODO PARA MOSTRAR ARBOL POR NIVEL
    public static Map<Integer,ArrayList<String>> arbolPorNivel(BinaryTree<String> arbol, ArrayList<String> orden,ArrayList<String> respuestas){
        Map<Integer,ArrayList<String>> tabla = new LinkedHashMap<>();
        Stack<BinaryTree<String>> s = new Stack<>();
        s.push(arbol);
        
        while (!s.isEmpty()) {
            BinaryTree<String> tree = s.pop();
            if (!tree.isEmpty()) {
                //traversal.add(tree.getRootContent());
                if(tabla.containsKey(orden.indexOf(tree.getRootContent()))){
                    tabla.get(orden.indexOf(tree.getRootContent())).add(tree.getRootContent());
                }else{
                tabla.putIfAbsent(orden.indexOf(tree.getRootContent()), new ArrayList<String>());
                tabla.get(orden.indexOf(tree.getRootContent())).add(tree.getRootContent());
                }
            }
            if (tree.getRight()!= null && !tree.getRight().isEmpty()) {
                s.push(tree.getRight());
            }
            if (tree.getLeft() != null && !tree.getLeft().isEmpty()) {
                s.push(tree.getLeft());
            }
        }
        tabla.put(orden.size(), respuestas);
        
        return tabla;
    }
    
    public static BinaryTree<String> enlazarRespuestas(BinaryTree<String> preguntas,ArrayList<String> respuestas){
        BinaryTree<String> arbol=preguntas;
        BinaryTree<String> navegar=preguntas;
        for(String linea:respuestas){
            //System.out.println("linea: "+linea);
            navegar=preguntas;
            String[] split=linea.split(" ");
            String animal=split[0];
            for(int i=1;i<split.length-1;i++){
                //System.out.println(i);
                if(split[i].equals("SI")){
                    //System.out.println("navegar antes de si: "+navegar.getRootContent());
                    navegar=navegar.getLeft();
                    //System.out.println("navegar despues de si: "+navegar.getRootContent());
                }else{
                    //System.out.println("navegar antes de no: "+navegar.getRootContent());
                    navegar=navegar.getRight();
                    //System.out.println("navegar despues de no: "+navegar.getRootContent());
                }
            }
            if(split[split.length-1].equals("SI")){
                //System.out.println("Editando si: "+navegar.getRootContent()+" con: "+animal);
                navegar.setLeft(new BinaryTree<String>(animal));
            }else{
                //System.out.println("Editando no: "+navegar.getRootContent()+" con: "+animal);
                navegar.setRight(new BinaryTree<String>(animal));
            }
            
        }
        
        return arbol;
    }
    
    public static boolean esPregunta(String s){        
        return s.startsWith("¿") && s.endsWith("?");
    }
    
    
    public void getLeaf(){
        
    }

}
