package com.rmp.MLuGG.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmp.MLuGG.Models.Command;


@Repository
public interface CommandRepository extends JpaRepository<Command, Long>{

}
