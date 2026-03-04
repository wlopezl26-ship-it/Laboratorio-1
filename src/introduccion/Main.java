package introduccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> estudiantes = new ArrayList<>();
    static List<Double> calificaciones = new ArrayList<>();


    public static void agregarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        
        double calificacion = 0; 
        boolean notaValida = false; 

        
        while (!notaValida) {
            System.out.print("Ingrese la calificación del estudiante (0-100): ");
            
            try {
                String entrada = scanner.nextLine();
                calificacion = Double.parseDouble(entrada); 

                
                if (calificacion >= 0 && calificacion <= 100) {
                    notaValida = true; // Si llega aquí, todo está bien
                } else {
                    System.out.println("Error: La calificación debe estar entre 0 y 100.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: No se permiten letras. Intente de nuevo.");
            }
        }

       
        estudiantes.add(nombre);
        calificaciones.add(calificacion);
        System.out.println("Estudiante agregado con éxito.");
    }
    


    public static void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("\nLista de estudiantes:");
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.println(estudiantes.get(i) + " - Calificación: " + calificaciones.get(i));
            }
        }
    }

    
    public static void mostrarPromedio() {
        if (calificaciones.isEmpty()) {
            System.out.println("No hay calificaciones registradas.");
        } else {
            double suma = 0;
            for (double c : calificaciones) {
                suma += c;
            }
            double promedio = suma / calificaciones.size();
            System.out.println("El promedio de calificaciones es: " + promedio);
        }
    }

    
    public static void mostrarMejorEstudiante() {
        if (calificaciones.isEmpty()) {
            System.out.println("No hay calificaciones registradas.");
        } else {
            double maxCalificacion = calificaciones.get(0);
            String estudianteMax = estudiantes.get(0);

            for (int i = 1; i < calificaciones.size(); i++) {
                if (calificaciones.get(i) > maxCalificacion) {
                    maxCalificacion = calificaciones.get(i);
                    estudianteMax = estudiantes.get(i);
                }
            }

            System.out.println("El estudiante con la calificación más alta es: "
                    + estudianteMax + " con " + maxCalificacion);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de estudiantes.");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Agregar estudiante");
            System.out.println("2. Mostrar lista de estudiantes");
            System.out.println("3. Calcular promedio de calificaciones");
            System.out.println("4. Mostrar estudiante con la calificación más alta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                agregarEstudiante(scanner);
            } else if (opcion == 2) {
                mostrarEstudiantes();
            } else if (opcion == 3) {
                mostrarPromedio();
            } else if (opcion == 4) {
                mostrarMejorEstudiante();
            } else if (opcion == 5) {
                System.out.println("Saliendo del sistema...");
                salir = true;
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}