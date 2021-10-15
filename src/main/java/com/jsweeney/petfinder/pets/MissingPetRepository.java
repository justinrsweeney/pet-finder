package com.jsweeney.petfinder.pets;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissingPetRepository extends JpaRepository<MissingPetReport, Long> {}
