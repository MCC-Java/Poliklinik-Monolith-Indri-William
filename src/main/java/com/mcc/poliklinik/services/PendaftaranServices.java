/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.services;

import com.mcc.poliklinik.entities.Pendaftaran;
import com.mcc.poliklinik.repositories.PendaftaranRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TOSHIBA
 */

@Service
public class PendaftaranServices {
    
    
    @Autowired
    PendaftaranRepository pendaftaranRepository;
    
    public List<Pendaftaran> getAll() {
        return pendaftaranRepository.findAll();
    }
    
    public void save(Pendaftaran pendaftaran) {
        pendaftaranRepository.save(pendaftaran);
    }
    
    public void delete(Integer no) {
        pendaftaranRepository.delete(new Pendaftaran(no));
    }
    
    public Pendaftaran findById(Integer no) {
        return pendaftaranRepository.findById(no).get();
    }
}
    


