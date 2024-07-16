package com.example.consultorios.controller;

import com.example.consultorios.business.CitasBusiness;
import com.example.consultorios.entity.CitasEntity;
import com.example.consultorios.entity.ConsultoriosEntity;
import com.example.consultorios.entity.DoctoresEntity;
import com.example.consultorios.view.CitasView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CitasController {

    @Autowired
    private CitasBusiness business;

    @GetMapping("/citas")
    public String index(Model model) {
        CitasView citasView = new CitasView();
        citasView.setCitasList(business.fyndAllCitas());
        model.addAttribute("citasView", citasView);
        return "citas";
    }

    @GetMapping("/citas/nueva")
    public String nuevaCitaForm(Model model) {
        CitasView citasView = new CitasView();

        model.addAttribute("cita", new CitasEntity());

        List<ConsultoriosEntity> consultorios = business.fyndAllConsultorios();
        List<DoctoresEntity> doctores = business.fyndAllDoctores();

        citasView.setListaConsultorios(consultorios);
        citasView.setListaDoctores(doctores);

        model.addAttribute("citasView", citasView);

        return "formularioCitas";
    }

    @PostMapping("/citas/guardar")
    public String guardarCita(@ModelAttribute("cita") CitasEntity cita, RedirectAttributes redirectAttributes) {
        business.guardarCita(cita);
        redirectAttributes.addFlashAttribute("mensaje", "¡Cita guardada correctamente!");
        return "redirect:/citas";
    }
}
