/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class automovil extends seguros{
    private int antiguedad;
    private int edad;
    public static final double TASAA = 1.25;
    public static final double TASAE = -0.75;
    
    public automovil(int antiguedad, int edad, double capital, String dni) {
        super(capital, dni);
        this.antiguedad = antiguedad;
        this.edad = edad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public double importePrecioSeguroAutomovil(){
        return calcularPrecioBase()+(antiguedad*TASAA)+(edad*TASAE);
    }

    @Override
    public String toString() {
        return super.toString()+"\nAntiguedad: " + antiguedad + "\nEdad: " + edad + "\nImporte del precio del seguro de automovil: "+importePrecioSeguroAutomovil();
    }
    @Override
    public String mostrarDatos(){
        return super.mostrarDatos()+"\t\t\tSeguro Auto  "+"\t    "+importePrecioSeguroAutomovil();
    }
    @Override
    public double precioFinal(){
         return calcularPrecioBase()+(antiguedad*TASAA)+(edad*TASAE);
    }

}
