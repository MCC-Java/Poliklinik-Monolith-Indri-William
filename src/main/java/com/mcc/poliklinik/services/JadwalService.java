/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.services;

import com.mcc.poliklinik.entities.Jadwal;
import com.mcc.poliklinik.repositories.JadwalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */

@Service
public class JadwalService {
    
     @Autowired
     JadwalRepository jadwalRepository;
    
    public List<Jadwal> getAll() {
        return jadwalRepository.findAll();
    }
    
    public void save(Jadwal jadwal) {
        jadwalRepository.save(jadwal);
    }
    
    public void delete(Integer id) {
        jadwalRepository.delete(new Jadwal(id));
    }
    
    public Jadwal findById(Integer id) {
        return jadwalRepository.findById(id).get();
    }
    
}
