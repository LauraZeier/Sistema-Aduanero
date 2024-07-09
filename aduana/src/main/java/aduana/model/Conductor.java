package aduana.model;

public class Conductor extends Persona{
    private String numeroLicencia;



    public Conductor() {
    }
    
    public Conductor(String nombre, String apellido, int edad, String nacionalidad, String numeroLicencia) {
        super(nombre, apellido, edad, nacionalidad);
        this.numeroLicencia = numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    @Override
    public String toString() {
        return "Conductor {" + 
           "\n  Numero de Licencia='" + numeroLicencia + '\'' +
           "\n  Nombre='" + getNombre() + '\'' +
           "\n  Apellido='" + getApellido() + '\'' +
           "\n  Edad=" + getEdad() +
           "\n  Nacionalidad='" + getNacionalidad() + '\'' +
           "\n";
    }

   
    

    
}
