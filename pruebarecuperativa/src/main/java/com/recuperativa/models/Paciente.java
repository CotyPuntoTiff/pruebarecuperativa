package com.recuperativa.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity//Declarar entidad
@Table(name="pacientes")//Tabla en base de datos
public class Paciente {
//----- Atributoss
    @Id//Generado id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//Definimos estos valores como PK
    private Long id;

    private String rut;
    @NotNull //Campo obligatorio;

    private String nombre;
    @NotNull //Campo obligatorio;

    private Date fecha_nacimiento;
    @NotNull //Campo obligatorio;
    
//----- Relaciones 
    //Relacion OneToMany con citaMedicas
    @OneToMany(mappedBy ="daily",cascade=CascadeType.ALL ,fetch=FetchType.LAZY) //CASCADE ES UNA RESTRICCION QUE IMPIDE ELIMINAR EL USUARIO SI NO SE HA ROTO LA RELACION
    private List<CitaMedica>citaMedicas;
    
//----- Constructor vacio
public Paciente() {
}

//----- Constructor con parametros
public Paciente(Long id, String rut, @NotNull String nombre, @NotNull Date fecha_nacimiento,
@NotNull List<CitaMedica> citaMedicas) {
    this.id = id;
    this.rut = rut;
    this.nombre = nombre;
    this.fecha_nacimiento = fecha_nacimiento;
    this.citaMedicas = citaMedicas;
}

//-----Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public List<CitaMedica> getCitaMedicas() {
        return citaMedicas;
    }

    public void setCitaMedicas(List<CitaMedica> citaMedicas) {
        this.citaMedicas = citaMedicas;
    }

}
