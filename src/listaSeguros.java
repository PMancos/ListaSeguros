
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author loren
 */
public class listaSeguros implements Comparator<seguros> {

    static Scanner teclado = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Creamos un nuevo archivo
            File f = new File("seguros.dat");
            ArrayList<seguros> listaSeguros = null;
            //Si no existe el fichero creamos un nuevo arraylist de seguros
            if (!f.exists()) {
                listaSeguros = new ArrayList<seguros>();
            } else {
                //Si existe creamos una entrada de archivo y se la pasamos a una nueva entrada de objeto (Leemos)
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);

                listaSeguros = (ArrayList<seguros>) ois.readObject();

                ois.close();
                fis.close();
            }
            int opcion = 0;
            //
            boolean modificado = false;

            do {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        contratarSeguro(listaSeguros);
                        modificado = true;
                        break;
                    case 2:
                        Collections.sort(listaSeguros);
                        mostrar(listaSeguros);
                        modificado = true;
                        break;
                    case 3:
                        Collections.sort(listaSeguros, new listaSeguros());
                        mostrar(listaSeguros);
                        break;
                    case 4:
                        mostrarFactura(listaSeguros);
                        break;
                    case 5:
                        if (modificado) {
                            //Si se ha modificado guardamos los cambios
                            FileOutputStream fos = new FileOutputStream(f);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            System.out.println("Guardado correctamente");
                            oos.writeObject(listaSeguros);
                            oos.close();
                        } else {
                            System.out.println("No ha habido cambios, no se ha guardado");
                        }
                        System.out.println("Datos guardados correctamente.");
                        break;

                }
            } while (opcion != 5);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(listaSeguros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(listaSeguros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listaSeguros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int pedirNumeroEntero() {
        int n = 0;
        try {
            n = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error no has introducido un entero");
            teclado.nextLine();
        }
        return n;
    }

    public static int menu() {

        System.out.println("\n1. Contratar seguro"
                + "\n2. Listar seguros contratados ordenados por capital"
                + "\n3. Listar seguros contratados por el precio del seguro"
                + "\n4. Mostrar factura del seguro"
                + "\n5. Salir\n");

        int opcion;
        do {
            System.out.print("Introduce una opcion (1/5): ");
            opcion = pedirNumeroEntero();
        } while (opcion < 1 || opcion > 5);
        teclado.nextLine();
        return opcion;
    }

    public static void contratarSeguro(ArrayList<seguros> lista) {
        double capital, superficie;
        String dni;
        int opcion, edad, antiguedad;

        System.out.print("Introduzca el DNI: ");
        dni = teclado.nextLine();
        System.out.print("Introduzca el capital a asegurar: ");
        capital = pedirNumeroEntero();
        System.out.println("");
        System.out.println("Que tipo de seguro desea contratar");
        System.out.println("\tPulse 1 para Seguro del hogar"
                + "\n\t2 para seguro de Automovil"
                + "\n\t3 para seguro de vida");
        opcion = pedirNumeroEntero();

        if (opcion == 1) {
            System.out.println("***Hogar***");
            System.out.print("Introduzca la superficie: ");
            superficie = pedirNumeroEntero();
            System.out.print("Introduzca el tipo: ");
            System.out.println("0. Vivienda habitual"
                    + "\n1. Segunda vivienda");
            opcion = pedirNumeroEntero();

            lista.add(new hogar(superficie, opcion, capital, dni));
            System.out.println("Nuevo seguro de hogar creado");
            System.out.println(lista.toString());
        }
        if (opcion == 2) {
            System.out.println("***Automovil***");
            System.out.print("Introduzca la antiguedad en años: ");
            antiguedad = pedirNumeroEntero();
            System.out.print("Introduzca la edad: ");
            edad = pedirNumeroEntero();

            lista.add(new automovil(antiguedad, edad, capital, dni));
            System.out.println("Nuevo seguro de automovil creado");
            System.out.println(lista.toString());

        }
        if (opcion == 3) {
            System.out.println("***Vida***");
            System.out.print("Introduzca la edad: ");
            edad = pedirNumeroEntero();

            lista.add(new vida(edad, capital, dni));
            System.out.println("Nuevo seguro de vida creado");
            System.out.println(lista.toString());
        }

    }

    public static void mostrar(ArrayList<seguros> lista) {
        System.out.println("\nDNI asegurado\tCapital Asegurado\tTipo seguro    \t    Precio"
                + "\n_____________\t_________________\t____________   \t    ______");
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).mostrarDatos());
        }
    }

    public static void mostrarFactura(ArrayList<seguros> lista) {
        String dni;
        
        System.out.println("");
        System.out.print("Introduce el DNI del asegurado: ");
        System.out.println("");
            dni = teclado.nextLine();

        for (int i = 0; i < lista.size(); i++) {
            if (dni.equalsIgnoreCase(lista.get(i).getDni())) 
                System.out.println(lista.get(i).mostrarDatos()); 
        }

    }

    @Override
    public int compare(seguros o1, seguros o2) {
        return (int) (o1.precioFinal() - o2.precioFinal());
    }

}
