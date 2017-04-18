
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class hogar extends seguros implements Comparator<seguros>{

    private double superficie;
    private String[] tipo = {"Vivienda habitual", "Segunda residencia"};
    private int tipos;
    public static final int HABITUAL = 0;
    public static final int SEGUNDA = 1;
    public static final double TASAH = 0.25;
    public static final double TASAS = 0.15;
    
    
    public hogar(double superficie, int tipos, double capital, String dni) {
        super(capital, dni);
        this.superficie = superficie;
        this.tipos = tipos;
    }

    public double calculoPrecioSeguroHogar() {
        if (tipos == HABITUAL) {
            return calcularPrecioBase() + (TASAH * superficie);
        } else {
            return calcularPrecioBase() + (TASAS * superficie);
        }
    }

    @Override
    public String toString() {
        return super.toString()+"\nSuperficie: " + superficie + "\nTipo de vivienda: "+ tipo[tipos]+ "\nImporte seguro del hogar: "+calculoPrecioSeguroHogar();
    }
    
    @Override
    public String mostrarDatos(){
        return super.mostrarDatos()+"\t\t\tSeguro Hogar  "+"\t    "+calculoPrecioSeguroHogar();
    }

    @Override
    public int compare(seguros o1, seguros o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public double precioFinal(){
      if (tipos == HABITUAL) {
            return calcularPrecioBase() + (TASAH * superficie);
        } else {
            return calcularPrecioBase() + (TASAS * superficie);
        }
        
    }

}
