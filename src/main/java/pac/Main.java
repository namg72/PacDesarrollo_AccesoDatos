package pac;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        //Conexion a la BD

        try {
            SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
            Session session=sessionFactory.openSession();


            //Instanciamos objetos de la clase pac.Modulo y los insertamos en la bbdd

            Modulo modulo1=new Modulo("Programacion B", "M03B");
            Modulo modulo2=new Modulo("Acceso a Datos", "M06");
            Modulo modulo3=new Modulo("Desarrollo de aplicaciones moviles", "M08");
            Modulo modulo4=new Modulo("Servicios y procesos", "M09");

            saveModulo(session, modulo1);
            saveModulo(session, modulo2);
            saveModulo(session, modulo3);
            saveModulo(session, modulo4);


            //Instanciamos objetos de la clase pac.Profesor y los insertammos en la bbdd

            Profesor profesor1 = new Profesor ("Alvaro", "Hombre");

            saveProfesor(session, profesor1);

            Alumno alumno;

            //Instanciamos objetos de la clase pac.Alumno y le añadimos los modulos

            // Alumno 1
            alumno= new Alumno("Juan", "Espaniola", 26, "Hombre");
            alumno.addModulo(modulo1);
            alumno.addModulo(modulo2);
            alumno.addModulo(modulo3);
            alumno.addModulo(modulo4);
            saveAlumno(session, alumno);


            // Alumno 2
            alumno= new Alumno("Pedro", "Andorrana", 21, "Hombre");
            alumno.addModulo(modulo1);
            alumno.addModulo(modulo2);
            alumno.addModulo(modulo4);
            saveAlumno(session, alumno);


            // Alumno 3
            alumno= new Alumno("Marta", "Espaniola", 19, "Mujer");
            alumno.addModulo(modulo3);
            alumno.addModulo(modulo4);
            saveAlumno(session, alumno);


            // Alumno 4
            alumno = new Alumno("Carla", "Francesa", 35, "Mujer");
            alumno.addModulo(modulo2);
            alumno.addModulo(modulo3);
            alumno.addModulo(modulo4);
            saveAlumno(session, alumno);

            //Cerramos el session y el sessionFactory

            session.close();
            sessionFactory.close();

        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("Error de conexion con la base de datos");
        }


    }// FIN MAIN

    //Metodo insertar alumnos
    private static void saveAlumno(Session session, Alumno alumno){

        session.beginTransaction();
        session.save(alumno);
        session.getTransaction().commit();
        System.out.println("Insert into alumno, nombre: "+ alumno.getNombre() +", nacionalidad: "+ alumno.getNacionalidad() +
                " edad: "+ alumno.getEdad() + ", sexo: " + alumno.getSexo() + ", modulos: "+ alumno.getModulos().size());


    }
    //Metodo insertar profesores
    private static void saveProfesor(Session session, Profesor profesor){

        session.beginTransaction();
        session.save(profesor);
        session.getTransaction().commit();
        System.out.println("Insert into profesor, nombre: " + profesor.getNombre() +" sexo: "+ profesor.getSexo());


    }
    //Metodo insertar modulos
    private static void saveModulo(Session session, Modulo modulo){

        session.beginTransaction();
        session.save(modulo);
        session.getTransaction().commit();
        System.out.println("Insert into modulo, nombre: "+ modulo.getNombre() +" "+ modulo.getCodigo());

    }
}






