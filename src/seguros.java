
import com.sun.xml.internal.ws.model.RuntimeModeler;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public abstract class seguros implements Serializable, Comparable<seguros>{
    private double capital;
    private String dni;
    ArrayList<seguros>lista;
    
    
    public seguros(double capital, String dni) {
        this.capital = capital;
        this.dni = dni;
        lista=new ArrayList<>();
       
    }

    public seguros() {
    }
    
    public double calcularPrecioBase(){
        return capital*1.5/100;
    }

    @Override
    public String toString() {
        return "\nCapital: " + capital + "\nDni: " + dni;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<seguros> getLista() {
        return lista;
    }

    public void setLista(ArrayList<seguros> lista) {
        this.lista = lista;
    }
    
    public String mostrarDatos(){
        return dni+"\t"+capital;
    }

    
    @Override
    public int compareTo(seguros o) {
        return (int) (this.getCapital()-o.capital);
    }
    
    public double precioFinal(){
        return 0;
    }

    
    

}
