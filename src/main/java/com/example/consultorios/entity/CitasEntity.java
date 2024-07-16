package com.example.consultorios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "citas")
@NamedQueries({
    @NamedQuery(name = "CitasEntity.findAll", query = "SELECT c FROM CitasEntity c"),})
public class CitasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_consultorio", referencedColumnName = "id")
    private ConsultoriosEntity consultorio;

    @ManyToOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id")
    private DoctoresEntity doctor;

    @Column(name = "hora_consulta")
    private LocalDateTime horaConsulta;

    @Column(name = "nombre_paciente")
    private String nombrePaciente;

    public CitasEntity() {
    }

    public CitasEntity(Integer id, ConsultoriosEntity consultorio, DoctoresEntity doctor, LocalDateTime horaConsulta, String nombrePaciente) {
        this.id = id;
        this.consultorio = consultorio;
        this.doctor = doctor;
        this.horaConsulta = horaConsulta;
        this.nombrePaciente = nombrePaciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConsultoriosEntity getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(ConsultoriosEntity consultorio) {
        this.consultorio = consultorio;
    }

    public DoctoresEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctoresEntity doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalDateTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getHoraConsultaString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return horaConsulta.format(formatter);
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
}
