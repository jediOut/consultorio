/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorios.dao;

import com.example.consultorios.entity.DoctoresEntity;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoctoresDAO {

    @Autowired
    private EntityManager entityManager;

    public List<DoctoresEntity> fyndAllDoctores() {
        return entityManager.createQuery("SELECT c FROM DoctoresEntity c", DoctoresEntity.class)
                .getResultList();
    }
}
