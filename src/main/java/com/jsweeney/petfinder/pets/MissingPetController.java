package com.jsweeney.petfinder.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MissingPetController {

    private final MissingPetRepository missingPetRepository;

    public MissingPetController(MissingPetRepository missingPetRepository) {
        this.missingPetRepository = missingPetRepository;
    }

    @GetMapping("/missingpets")
    public List<MissingPetReport> all() {
        return missingPetRepository.findAll();
    }

    @PostMapping("/missingpets")
    public MissingPetReport newMissingPetReport(@RequestBody MissingPetReport missingPetReport) {
        return missingPetRepository.save(missingPetReport);
    }

    @GetMapping("/missingpets/{id}")
    public MissingPetReport one(@PathVariable Long id) {
        return missingPetRepository.findById(id).orElseThrow(() -> new MissingPetReportNotFoundException(id));
    }

    @PutMapping("/missingpets/{id}")
    public MissingPetReport replaceMissingPet(@RequestBody MissingPetReport missingPetReport, @PathVariable Long id) {
        return missingPetRepository.findById(id).map(missingPet -> {
            missingPet.getPet().setAge(missingPetReport.getPet().getAge());
            missingPet.getPet().setBreed(missingPetReport.getPet().getBreed());
            missingPet.getPet().setName(missingPetReport.getPet().getName());
            missingPet.getPet().setDescription(missingPetReport.getPet().getDescription());
            missingPet.getPet().setSpecies(missingPetReport.getPet().getSpecies());
            missingPet.setLatitude(missingPetReport.getLatitude());
            missingPet.setLongitude(missingPetReport.getLongitude());
            missingPet.setReportedMissingDate(missingPetReport.getReportedMissingDate());
            return missingPetRepository.save(missingPet);
        }).orElseGet(() -> {
            missingPetReport.setId(id);
            return missingPetRepository.save(missingPetReport);
        });
    }

    @DeleteMapping("/missingpets/{id}")
    public void deleteMissingPetReport(@PathVariable Long id) {
        missingPetRepository.deleteById(id);
    }

}
