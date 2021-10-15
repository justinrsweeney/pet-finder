package com.jsweeney.petfinder.pets;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pet {

    public Pet() {}

    public Pet(String name, String breed, Species species, int age, String description) {
        this.name = name;
        this.breed = breed;
        this.species = species;
        this.age = age;
        this.description = description;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String breed;
    private Species species;
    private int age;
    private String description;
    @OneToMany(mappedBy = "pet")
    @JsonManagedReference
    private Set<MissingPetReport> missingPetReportList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<MissingPetReport> getMissingPetReportList() {
        return missingPetReportList;
    }

    public void setMissingPetReportList(Set<MissingPetReport> missingPetReportList) {
        this.missingPetReportList = missingPetReportList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(id, pet.id) && Objects.equals(name, pet.name) && Objects.equals(breed, pet.breed) && species == pet.species && Objects.equals(description, pet.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed, species, age, description);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", species=" + species +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
}
