/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorios.dao;

import com.example.consultorios.entity.ConsultoriosEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultoriosDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public List<ConsultoriosEntity> fyndAllConsultorios() {

        return entityManager.createQuery("SELECT c FROM ConsultoriosEntity c", ConsultoriosEntity.class)
                .getResultList();
    }

}
