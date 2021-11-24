package test;

import datos.AlumnosDAO;
import domain.Alumnos;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        AlumnosDAO alumnoDao = new AlumnosDAO();

        //Insertando un nuevo objeto de tipo Persona
//        Persona personaNueva = new Persona("Carlos", "Esparza", "cesparza@mail.com", "554456587");
//        personaDao.insertar(personaNueva);

        //Modificar un objeto de persona existente
//        Persona personaModificar = new Persona(4, "Juan Carlos", "Esparza", "jcesparza@mail.com", "554456587");
//        personaDao.actualizar(personaModificar);

        //Eliminar un registro
        Alumnos alumnoEliminar = new Alumnos(4);
        alumnoDao.eliminar(alumnoEliminar);
        
        //Listado Persona
        List<Alumnos> alumnos = alumnoDao.seleccionar();

        alumnos.forEach(alumno -> {
            System.out.println("alumno = " + alumno);
        });
    }
}
