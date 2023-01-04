package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistance.PflanzenEntity;
import de.htwberlin.webtech.persistance.PflanzenRepository;
import de.htwberlin.webtech.web.api.Pflanzen;
import de.htwberlin.webtech.web.api.PflanzenManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PflanzenService {

    private final PflanzenRepository pflanzenRepository;

    public PflanzenService(PflanzenRepository pflanzenRepository) {
        this.pflanzenRepository = pflanzenRepository;

    }

    public List<Pflanzen> findAll(){
        List<PflanzenEntity> pflanzen = pflanzenRepository.findAll();
        return pflanzen.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Pflanzen findById(Long id) {
        var pflanzenEntity = pflanzenRepository.findById(id);
        return pflanzenEntity.map(this::transformEntity).orElse(null);
    }

    public Pflanzen create(PflanzenManipulationRequest request) {
        var pflanzenEntity = new PflanzenEntity(request.getPlantName(), request.getAnotherName(), request.getFarbe());
        pflanzenEntity = pflanzenRepository.save(pflanzenEntity);
        return transformEntity(pflanzenEntity);
    }

    public Pflanzen update(Long id, PflanzenManipulationRequest request) {
        var pflanzenEntityOptional = pflanzenRepository.findById(id);
        if (pflanzenEntityOptional.isEmpty()) {
            return null;
        }
        var pflanzenEntity = pflanzenEntityOptional.get();
        pflanzenEntity.setPlantName(request.getPlantName());
        pflanzenEntity.setAnotherName(request.getAnotherName());
        pflanzenEntity.setFarbe(request.getFarbe());
        pflanzenEntity = pflanzenRepository.save(pflanzenEntity);

        return transformEntity(pflanzenEntity);
    }

    public boolean deleteById(Long id) {
        if (!pflanzenRepository.existsById(id)) {
            return false;
        }

        pflanzenRepository.deleteById(id);
        return true;
    }

    private Pflanzen transformEntity(PflanzenEntity pflanzenEntity) {
        return new Pflanzen(
                pflanzenEntity.getId(),
                pflanzenEntity.getPlantName(),
                pflanzenEntity.getAnotherName(),
                pflanzenEntity.getFarbe()
        );
    }
}
