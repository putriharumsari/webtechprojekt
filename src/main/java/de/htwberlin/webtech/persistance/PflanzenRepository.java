package de.htwberlin.webtech.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PflanzenRepository extends JpaRepository<PflanzenEntity, Long> {

    List<PflanzenEntity> findAllByPlantName(String plantName);
}
