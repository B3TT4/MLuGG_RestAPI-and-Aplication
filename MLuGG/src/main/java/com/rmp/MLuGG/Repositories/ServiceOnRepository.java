package com.rmp.MLuGG.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmp.MLuGG.Models.ServiceOn;

@Repository
public interface ServiceOnRepository extends JpaRepository<ServiceOn, Long>{

}
