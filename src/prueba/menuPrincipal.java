package prueba;

import java.util.InputMismatchException;
import java.util.Scanner;
import datos.AlumnosDAO;
import domain.Alumnos;
import java.util.List;

public class menuPrincipal {

    public static void main(String[] args) {
        AlumnosDAO alumnoDao = new AlumnosDAO();
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        
        while (!salir) {

            System.out.println("1. Consultar datos");
            System.out.println("2. Registrar datos");
            System.out.println("3. Modificar datos");
            System.out.println("4. Eliminar datos");
            System.out.println("5. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = teclado.nextInt();
                
                switch (opcion) {
                    case 1:

                        System.out.println("Seleccionaste consultar datos");
                        List<Alumnos> alumnos = alumnoDao.seleccionar();
                        alumnos.forEach(alumno -> {
                            System.out.println("alumno = " + alumno);
                        });
                        System.out.println("¿Desea realizar otra acción?");
                        break;
                    case 2:
                        System.out.println("Seleccionaste registrar datos");
                        System.out.print("Escriba el nombre: ");
                        String nombre = teclado.next();
                        System.out.print("Escriba el apellido: ");
                        String apellido = teclado.next();
                        System.out.print("Escriba el dni: ");
                        int dni = teclado.nextInt();
                        
                        Alumnos alumnosNueva = new Alumnos(nombre, apellido, dni);
                        alumnoDao.insertar(alumnosNueva);
                        System.out.println("Usuario Registrado");
                        System.out.println("¿Desea realizar otra acción?");
                        break;
                    case 3:
                        System.out.println("Seleccionaste modificar datos");
                        System.out.print("Selecciona el numero de identificador(id): ");
                        int id = teclado.nextInt();
                        System.out.print("Escriba el nombre: ");
                        String nombreActualizar = teclado.next();
                        System.out.print("Escriba el apellido: ");
                        String apellidoActualizar = teclado.next();
                        System.out.print("Escriba el dni: ");
                        int dniActualizar = teclado.nextInt();
                        Alumnos alumnosModificar = new Alumnos(id, nombreActualizar, apellidoActualizar , dniActualizar);
                        alumnoDao.actualizar(alumnosModificar);
                        System.out.println("Usuario Actualizado");
                        System.out.println("¿Desea realizar otra acción?");
                        break;
                    case 4:
                        System.out.println("Seleccionaste eliminar datos");
                        System.out.print("Selecciona el numero de registro a eliminar: ");
                        int idEliminar = teclado.nextInt();
                        Alumnos alumnoEliminar = new Alumnos(idEliminar);
                        alumnoDao.eliminar(alumnoEliminar);
                        System.out.println("Registro del usuario Eliminado");
                        System.out.println("¿Desea realizar otra acción?");
                        break;
                    case 5:
                        System.out.println("Has seleecionado abandonar el programa.");
                        
                        salir = true;
                        break;
                    default:
                        System.out.println("Selecciona una opcion valida, si deseas salir del programa presiona 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                teclado.next();
            }
        }

    }

}
