/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class vida extends seguros{
    private int edad;
    public static final double TASAE = 3.25;
    
    public vida(int edad, double capital, String dni) {
        super(capital, dni);
        this.edad = edad;
    }
    
    public double importePrecioSeguroVida(){
        return calcularPrecioBase()+(edad*TASAE);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return super.toString()+"\nEdad: " + edad+"\nImporte del seguro de vida: "+importePrecioSeguroVida();
    }
    @Override
    public String mostrarDatos(){
        return super.mostrarDatos()+"\t\t\tSeguro Vida  "+"\t    "+importePrecioSeguroVida();
    }
    @Override
    public double precioFinal(){
        return calcularPrecioBase()+(edad*TASAE);
    }

}
