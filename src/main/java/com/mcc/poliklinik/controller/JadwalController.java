/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.controller;

import com.mcc.poliklinik.entities.Jadwal;
import com.mcc.poliklinik.services.JadwalService;
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
public class JadwalController {
    
    @Autowired
    JadwalService jadwalService;
    
   
    @GetMapping("/jadwal")
    public String index(Model model) {
        model.addAttribute("jadwal", new Jadwal());
        model.addAttribute("jadwals", jadwalService.getAll());
        return "jadwal";
    }
    
    @PostMapping("/jadwal/save")
    public String save(@Valid Jadwal jadwal) {
        jadwalService.save(jadwal);
        return "redirect:/jadwal";
    }
    
    @GetMapping("/jadwal/{id}")
    public String getById(Model model, @PathVariable("id") String id) {
        model.addAttribute("jadwal", jadwalService.findById(Integer.parseInt(id)));
        model.addAttribute("jadwals", jadwalService.getAll());
        return "redirect:/jadwal";
    }
    
    @GetMapping("/jadwal/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        jadwalService.delete(Integer.parseInt(id));
        return "redirect:/jadwal";
    }
}
