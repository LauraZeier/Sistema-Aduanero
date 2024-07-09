package aduana.model;


import aduana.data.camionDAO;
import aduana.data.camionService;
import java.util.List;
import java.util.Scanner;



public class TestMain {
    public static void main(String[] args) {
        camionDAO cDao = new camionDAO();
        camionService camionSer = new camionService();
        Scanner sc = new Scanner(System.in);
    
        int opcion;
      
        do {
            System.out.println("\n----- Menú de Opciones -----");
            System.out.println("1. Listar todos los camiones de la base de datos");
            System.out.println("2. Agregar un nuevo camión");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nListado de camiones ingresados:");
                    List<Camion> camiones = cDao.listar();
                    for (Camion camion : camiones) {
                        System.out.println(camion);
                    }
                 
                    
                    break;
                
                case 2:
                    System.out.println("Inserción de nuevo camión:");
                    camionSer.insertarCamionDesdeMenu(); 
                    break;
                
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
      
        } while (opcion != 0);

        sc.close(); 
    }
}

