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

/**
 *
 * @author Javier
 */
public class ArbolData {
    
    //METODOS PARA LEER E INICIALIZAR ARBOLES
    public ArrayList<String> leerArbolesPregunta(String ruta) throws IOException{
        ArrayList<String> preguntas=new ArrayList<>();
        //Map<Integer,BinaryTree<String>> tabla = new LinkedHashMap<>();
        
        try(InputStream input = new URL("file:"+ruta).openStream();
                
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            //GENERA EL URL RELATIVO AL ARCHIVO QUE VAMOS A LEER
           
            /*URL u = App.class.getResource(ruta);
            File file = new File(u.toURI());
            try(BufferedReader bf = new BufferedReader(new FileReader(file))){*/
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
    }
    
    public static BinaryTree<String> enlazarArbolesPreguntas(ArrayList<String> preguntas){
        //INTENTO CON QUEUE
        //LLENO LA COLA
        ArrayList<String> reverse= preguntas;
        Collections.reverse(reverse);
        Queue<BinaryTree<String>> q= new ArrayDeque<>();
        int nv=preguntas.size()-1;
        for(String p:reverse){
            int i=preguntas.indexOf(p)*2;
            while(i>0){
                q.offer(new BinaryTree<String>(p));
                i--;
            }
            //PARA EL ULTIMO INDICE
            if(preguntas.indexOf(p)==0){
                q.offer(new BinaryTree<String>(p));
            }
            //PARAR EN EL LA PRIMERA PREGUNTA (ULTIMA INVERTIDA)
            break;
        }
        int cont=nv;
        while(q.size()>1){
            
            if(cont!=0){
                BinaryTree<String> t0=q.poll();
                BinaryTree<String> t1=q.poll();
                BinaryTree<String> padre= new BinaryTree<>(preguntas.get(nv-1)); //el padre
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
    
}
