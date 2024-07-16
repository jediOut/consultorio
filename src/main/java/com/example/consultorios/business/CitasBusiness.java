package com.example.consultorios.business;

import com.example.consultorios.dao.CitasDAO;
import com.example.consultorios.dao.ConsultoriosDAO;
import com.example.consultorios.dao.DoctoresDAO;
import com.example.consultorios.entity.CitasEntity;
import com.example.consultorios.entity.ConsultoriosEntity;
import com.example.consultorios.entity.DoctoresEntity;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitasBusiness {

    @Autowired
    private DoctoresDAO doctoresDAO;
    @Autowired
    private ConsultoriosDAO consultoriosDAO;
    @Autowired
    private CitasDAO dao;

    public List<CitasEntity> fyndAllCitas() {
        return dao.fyndAllCitas();
    }

    public List<ConsultoriosEntity> fyndAllConsultorios() {
        return consultoriosDAO.fyndAllConsultorios();
    }

    public List<DoctoresEntity> fyndAllDoctores() {
        return doctoresDAO.fyndAllDoctores();
    }

    @Transactional
    public void guardarCita(CitasEntity cita) {
        if (validarMismaHora(cita.getConsultorio(), cita.getHoraConsulta())) {
            throw new IllegalArgumentException("Ya existe una cita en el mismo consultorio a la misma hora.");
        }

        if (validadMismoDoctoryMismaHora(cita.getDoctor(), cita.getHoraConsulta())) {
            throw new IllegalArgumentException("Ya existe una cita para el mismo doctor a la misma hora.");
        }

        if (validarMaxCitasPorDoctor(cita.getDoctor(), cita.getHoraConsulta().toLocalDate()) >= 8) {
            throw new IllegalArgumentException("El doctor ya tiene 8 citas programadas para este día.");
        }

        List<CitasEntity> citasPacienteMismoDia = dao.listarCitasPacienteEnFecha(cita.getNombrePaciente(), cita.getHoraConsulta().toLocalDate());
        for (CitasEntity citaExistente : citasPacienteMismoDia) {
            LocalDateTime horaCitaExistente = citaExistente.getHoraConsulta();
            if (Math.abs(Duration.between(horaCitaExistente, cita.getHoraConsulta()).toHours()) < 2) {
                throw new IllegalArgumentException("Debe haber al menos dos horas entre cada cita para el mismo paciente.");
            }
        }

        dao.guardar(cita);
    }

    private boolean validarMismaHora(ConsultoriosEntity consultorio, LocalDateTime horaConsulta) {
        return dao.validarMismaHora(consultorio, horaConsulta);
    }

    private boolean validadMismoDoctoryMismaHora(DoctoresEntity doctor, LocalDateTime horaConsulta) {
        return dao.validadMismoDoctoryMismaHora(doctor, horaConsulta);
    }

    private int validarMaxCitasPorDoctor(DoctoresEntity doctor, LocalDate fecha) {
        return dao.validarMaxCitasPorDoctor(doctor, fecha);
    }
}
