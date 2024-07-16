package com.example.consultorios.view;

import com.example.consultorios.entity.CitasEntity;
import com.example.consultorios.entity.ConsultoriosEntity;
import com.example.consultorios.entity.DoctoresEntity;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CitasView {

    private List<CitasEntity> citasList;
    private CitasEntity citas;
    private List<DoctoresEntity> listaDoctores;
    private List<ConsultoriosEntity> listaConsultorios;

    public List<CitasEntity> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<CitasEntity> citasList) {
        this.citasList = citasList;
    }

    public CitasEntity getCitas() {
        return citas;
    }

    public void setCitas(CitasEntity citas) {
        this.citas = citas;
    }

    public List<DoctoresEntity> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(List<DoctoresEntity> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public List<ConsultoriosEntity> getListaConsultorios() {
        return listaConsultorios;
    }

    public void setListaConsultorios(List<ConsultoriosEntity> listaConsultorios) {
        this.listaConsultorios = listaConsultorios;
    }
    
}
