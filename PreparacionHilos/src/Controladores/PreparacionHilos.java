/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Operacion;
import Modelos.OperacionpreHilos;

/**
 *
 * @author pipet
 */
public class PreparacionHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Cliente cliente1 = new Cliente("a1","Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
//        Cliente cliente2 = new Cliente("a2","Cliente 2", new int[]{1, 3, 5, 1, 1});
//
//        Cajera cajera1 = new Cajera("c1","Cajera 1",1);
//        Cajera cajera2 = new Cajera("c2","Cajera 2",1);
//        
//        cajera1.setCliente(cliente1);
//        cajera2.setCliente(cliente2);

        int[] vector = new int[] {1,10,6,1,5,1,13,15,2,5};
        int mitad = (0+vector.length)/2;

        Operacion nuevaOperacion = new Operacion(vector, 0, mitad-1);
        Operacion nuevaOperacion2 = new Operacion(vector, mitad, vector.length-1);
        
        Thread proceso1=new Thread(nuevaOperacion);
        Thread proceso2=new Thread(nuevaOperacion2);
        
        proceso1.start();
        proceso2.start();
        
        try {
            proceso1.join();
            proceso2.join();
        } catch (Exception e) {
            System.out.println(e);
        }  

        if(!proceso1.isAlive() && !proceso2.isAlive())
        {
            if(nuevaOperacion.getResultado() < nuevaOperacion2.getResultado())
            {
                System.out.println("El mayor número del vector es: "+nuevaOperacion2.getResultado());
                
            }else 
            {
                System.out.println("El mayor número del vector es: "+nuevaOperacion.getResultado());
            }
        }
        //time: 3 seg.
        
        System.out.println("-------------------- Pre-hilos -----------------------");
        
        OperacionpreHilos operacion4 = new OperacionpreHilos(vector, 0, mitad);
        OperacionpreHilos operacion5 = new OperacionpreHilos(vector, mitad, vector.length-1);
        
        operacion4.run();
        operacion5.run();  
        //time: 6 segs mas o menos
       
    }

}
