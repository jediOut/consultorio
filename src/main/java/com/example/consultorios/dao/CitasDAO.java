package com.example.consultorios.dao;

import com.example.consultorios.entity.CitasEntity;
import com.example.consultorios.entity.ConsultoriosEntity;
import com.example.consultorios.entity.DoctoresEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CitasDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CitasEntity> fyndAllCitas() {
        String jpql = "SELECT c FROM CitasEntity c";
        return entityManager.createQuery(jpql, CitasEntity.class).getResultList();
    }

    @Transactional
    public void guardar(CitasEntity cita) {
        entityManager.persist(cita);
    }

    public boolean validarMismaHora(ConsultoriosEntity consultorio, LocalDateTime horaConsulta) {
        String jpql = "SELECT COUNT(c) FROM CitasEntity c WHERE c.consultorio = :consultorio AND c.horaConsulta = :horaConsulta";
        Long count = entityManager.createQuery(jpql, Long.class)
                .setParameter("consultorio", consultorio)
                .setParameter("horaConsulta", horaConsulta)
                .getSingleResult();
        return count > 0;
    }

    public boolean validadMismoDoctoryMismaHora(DoctoresEntity doctor, LocalDateTime horaConsulta) {
        String jpql = "SELECT COUNT(c) FROM CitasEntity c WHERE c.doctor = :doctor AND c.horaConsulta = :horaConsulta";
        Long count = entityManager.createQuery(jpql, Long.class)
                .setParameter("doctor", doctor)
                .setParameter("horaConsulta", horaConsulta)
                .getSingleResult();
        return count > 0;
    }

    public int validarMaxCitasPorDoctor(DoctoresEntity doctor, LocalDate fecha) {
        String jpql = "SELECT COUNT(c) FROM CitasEntity c WHERE c.doctor = :doctor AND c.horaConsulta BETWEEN :fechaInicio AND :fechaFin";
        LocalDateTime fechaInicio = fecha.atStartOfDay();
        LocalDateTime fechaFin = fecha.atTime(23, 59, 59);
        Long count = entityManager.createQuery(jpql, Long.class)
                .setParameter("doctor", doctor)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getSingleResult();
        return count.intValue();
    }

    public List<CitasEntity> listarCitasPacienteEnFecha(String nombrePaciente, LocalDate fecha) {
        String jpql = "SELECT c FROM CitasEntity c WHERE c.nombrePaciente = :nombrePaciente AND c.horaConsulta BETWEEN :fechaInicio AND :fechaFin";
        LocalDateTime fechaInicio = fecha.atStartOfDay();
        LocalDateTime fechaFin = fecha.atTime(23, 59, 59);
        return entityManager.createQuery(jpql, CitasEntity.class)
                .setParameter("nombrePaciente", nombrePaciente)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();
    }
}
