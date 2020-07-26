/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.controller;

import com.mcc.poliklinik.entities.Pemeriksaan;
import com.mcc.poliklinik.services.PemeriksaanService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */

@Controller
public class PemeriksaanController {
    
    
    @Autowired
    PemeriksaanService pemeriksaanService;
    
   
    @GetMapping("/pemeriksaan")
    public String index(Model model) {
        model.addAttribute("pemeriksaan", new Pemeriksaan());
        model.addAttribute("pemeriksaans", pemeriksaanService.getAll());
        return "pemeriksaan";
    }
    
    @PostMapping("/pemeriksaan/save")
    public String save(@Valid Pemeriksaan pemeriksaan) {
        pemeriksaanService.save(pemeriksaan);
        return "redirect:/pemeriksaan";
    }
    
    @GetMapping("/pemeriksaan/{id}")
    public String getById(Model model, @PathVariable("id") String id) {
        model.addAttribute("pemeriksaan", pemeriksaanService.findById(Integer.parseInt(id)));
        model.addAttribute("pemeriksaans", pemeriksaanService.getAll());
        return "redirect:/pemeriksaan";
    }
    
    @GetMapping("/pemeriksaan/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        pemeriksaanService.delete(Integer.parseInt(id));
        return "redirect:/pemeriksaan";
    }
    
}
