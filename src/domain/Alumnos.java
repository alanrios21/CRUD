
package domain;

public class Alumnos {
    private int id_alumno;
    private int DNI;
    private String Nombre;
    private String Apellido;

  

    public Alumnos() {
        
    }

    public Alumnos(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    
     public Alumnos(int id_alumno, String Nombre, String Apellido, int DNI) {
        this.id_alumno = id_alumno;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
    }
 

    public Alumnos(String Nombre, String Apellido, int DNI) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
    }
    
    public int getIdAlumno() {
        return id_alumno;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setIdAlumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }
    
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

   

    @Override
    public String toString() {
        return "{" + " id_alumno = " + id_alumno + ", Nombre = " + Nombre + ", Apellido = " + Apellido + ", DNI = " + DNI + '}';
    } 
    
    
    
    
    
    
    
    
}
