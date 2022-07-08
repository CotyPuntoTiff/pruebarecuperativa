package com.recuperativa.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity//Declarar entidad
@Table(name="citas_medicas")//Tabla en base de datos
public class CitaMedica {
//----- Atributos
    @Id//Generado id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//Definimos estos valores como PK
    private Long id;

    private String paciente_id;
    @NotNull //Campo obligatorio;

    private Date hora;
    @NotNull //Campo obligatorio;

    private String area_medica;
    @NotNull //Campo obligatorio;

//----- Relaciones 
    //Relacion ManyToOne con paciente
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="rut") //Desde donde se va a unir a la otra tabla
    private Paciente paciente; // El objeto al que se hace referencia
    
//----- Constructor vacio
    public CitaMedica() {
    }
//----- Constructor con parametros
    public CitaMedica(Long id, String paciente_id, Date hora, String area_medica, Paciente paciente) {
        this.id = id;
        this.paciente_id = paciente_id;
        this.hora = hora;
        this.area_medica = area_medica;
        this.paciente = paciente;
    }

//----- Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPaciente_id() {
        return paciente_id;
    }
    public void setPaciente_id(String paciente_id) {
        this.paciente_id = paciente_id;
    }
    public Date getHora() {
        return hora;
    }
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public String getArea_medica() {
        return area_medica;
    }
    public void setArea_medica(String area_medica) {
        this.area_medica = area_medica;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
}
