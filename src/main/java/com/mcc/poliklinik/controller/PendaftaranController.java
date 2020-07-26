/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.controller;

import com.mcc.poliklinik.entities.Pendaftaran;
import com.mcc.poliklinik.services.PemeriksaanService;
import com.mcc.poliklinik.services.PendaftaranServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author TOSHIBA
 */

@Controller
public class PendaftaranController {
    
    @Autowired
    PendaftaranServices pendaftaranServices;
    
    @Autowired
    PemeriksaanService pemeriksaanService;
    
    @GetMapping("")
    public String home() {
    return "home";
    }
  
    
    @GetMapping("/pendaftaran")
    public String index(Model model) {
        model.addAttribute("pendaftaran", new Pendaftaran());
        model.addAttribute("pendaftarans", pendaftaranServices.getAll());
        model.addAttribute("pemeriksaans", pemeriksaanService.getAll());
        return "index";
    }
    
    @PostMapping("/pendaftaran/save")
    public String save(@Valid Pendaftaran pendaftaran) {
        pendaftaranServices.save(pendaftaran);
        return "redirect:/pendaftaran";
    }
    
    @GetMapping("/{no}")
    public String getById(Model model, @PathVariable("no") String no) {
        model.addAttribute("pendaftaran", pendaftaranServices.findById(Integer.parseInt(no)));
        model.addAttribute("pendaftarans", pendaftaranServices.getAll());
        return "redirect:/";
    }
    
    @GetMapping("/delete/{no}")
    public String delete(Model model, @PathVariable("no") String no) {
        pendaftaranServices.delete(Integer.parseInt(no));
        return "redirect:/pendaftaran";
    }
}

