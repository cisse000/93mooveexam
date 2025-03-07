package com.example.demo.repository;



import java.util.List;

import com.example.demo.model.Adherent;
import org.springframework.data.repository.CrudRepository;

public interface AdherentRepository extends CrudRepository<Adherent, Integer> {
    List<Adherent> findByEmail(String email);
    void deleteByEmail(String email);

}