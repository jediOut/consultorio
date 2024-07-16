package com.example.consultorios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultorios")
@NamedQueries({
    @NamedQuery(name = "ConsultoriosEntity.findAll", query = "SELECT c FROM ConsultoriosEntity c"),})
public class ConsultoriosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_consultorio")
    private String numero;

    @Column(name = "piso")
    private String piso;

    public ConsultoriosEntity() {
    }

    public String getNombreCompleto() {
        return "Consultorio: " + numero + ", " + "Piso: " + piso + ".";
    }

    public ConsultoriosEntity(Integer id, String numero, String piso) {
        this.id = id;
        this.numero = numero;
        this.piso = piso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
}
