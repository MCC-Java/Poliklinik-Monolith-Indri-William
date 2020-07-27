/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.repositories;

import com.mcc.poliklinik.entities.Pemeriksaan;
// import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
 /// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */

@Repository
public interface PemeriksaanRepository extends JpaRepository<Pemeriksaan, Integer>{
    
    
  ///  @Query("SELECT * FROM pemeriksaan a INNER JOIN pendaftaran b on a.id=b.no")
  ///  public List<Pemeriksaan> FindAllWithDescriptionQuery();

    
}
