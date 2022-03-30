/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author az230
 */
public class Operacion implements Runnable{
    private int[] vector; 
    private int inicio; 
    private int fin; 
    private int resultado;
    private boolean listo; 

    public Operacion(int[] vector, int inicio, int fin) {
        this.vector = vector;
        this.inicio = inicio;
        this.fin = fin;
        this.resultado = 0;
    }
   
    @Override
    public void run() 
    {
        for(int i = inicio+1; i < fin+1; i++)
	{
            int v = vector[i];

            int j=i-1;

            while(j >= inicio && vector[j]>v)
            {
                vector[j+1]=vector[j];

                j=j-1;
            }

            vector[j+1]=v;
            esperarXsegundos(vector[j+1]);
	}
        
        resultado = vector[fin];
	System.out.println("Uno de los números mayores: " + resultado);      
    }
    
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

 
    /**
     * @return the resultado
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * @param listo the listo to set
     */
    public void setListo(boolean listo) {
        this.listo = listo;
    }
 
}
