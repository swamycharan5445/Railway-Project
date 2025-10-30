package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nit.model.RailwayData;

@Repository
public interface RailRepository extends JpaRepository<RailwayData, Integer> {

    RailwayData findByUsernameAndPassword(String username, String password);

    RailwayData findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
