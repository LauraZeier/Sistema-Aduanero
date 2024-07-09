package aduana.data;

import java.util.Scanner;

import aduana.model.Camion;
import aduana.model.Conductor;

public class camionService {
    
    private camionDAO camionDAO;
    Camion camion;
    Conductor conductor;

    public camionService() {
        this.camionDAO = new camionDAO();
    }

    public void insertarCamionDesdeMenu() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario para el camión
        System.out.println("Ingrese los datos del nuevo camión:");
        System.out.print("Nombre de la Empresa: ");
        String nombreEmpresa = scanner.nextLine();
        System.out.print("Tipo de Carga: ");
        String tipoCarga = scanner.nextLine();
        System.out.print("País de Origen: ");
        String paisOrigen = scanner.nextLine();
        System.out.print("País de Destino: ");
        String paisDestino = scanner.nextLine();
        System.out.print("¿Tiene Acoplado? (true/false): ");
        boolean acoplado = scanner.nextBoolean();
        System.out.print("Peso de la Carga: ");
        double pesoCarga = scanner.nextDouble();

        // Crear el objeto Camion
        Camion camion = new Camion (0, nombreEmpresa, tipoCarga, paisOrigen, paisDestino, acoplado, pesoCarga, null);

        // Solicitar datos al usuario para el conductor
        System.out.println("\nIngrese los datos del conductor:");
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Nombre: ");
        String nombreConductor = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellidoConductor = scanner.nextLine();
        System.out.print("Edad: ");
        int edadConductor = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Nacionalidad: ");
        String nacionalidadConductor = scanner.nextLine();
        System.out.print("Número de Licencia: ");
        String numeroLicenciaConductor = scanner.nextLine();

        // Crear el objeto Conductor
        Conductor conductor = new Conductor(nombreConductor, apellidoConductor, edadConductor,nacionalidadConductor, numeroLicenciaConductor);

        // Asignar el conductor al camión
        camion.setConductor(conductor);

        // Insertar camión y conductor en la base de datos
        camionDAO.insertar(camion);

        System.out.println("Camión y Conductor insertados correctamente.");
    }
}




    


