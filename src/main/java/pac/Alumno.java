package pac;

import java.util.HashSet;
import java.util.Set;

public class Alumno {

    private Long id;
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String sexo;
    private Set<Modulo> modulos;

    public Alumno() {
    }

    public Alumno(String nombre, String nacionalidad, int edad, String sexo) {

        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.sexo = sexo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    public void addModulo(Modulo modulo){

        if(modulos==null){

            modulos = new HashSet<Modulo>();
        }
        modulos.add(modulo);


    }







    @Override
    public String toString() {
        return
                "id=" + id +"\n"+
                ", nombre='" + nombre + "\n"+
                ", nacionalidad='" + nacionalidad + "\n"+
                ", edad=" + edad +"\n"+
                ", sexo='" + sexo + "\n"+
                ", modulos=" + modulos;

    }
}
