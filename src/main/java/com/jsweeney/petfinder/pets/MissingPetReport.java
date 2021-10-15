package com.jsweeney.petfinder.pets;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class MissingPetReport {

    public MissingPetReport() {}

    public MissingPetReport(Pet pet, double latitude, double longitude, LocalDate reportedMissingDate) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.pet = pet;
        this.reportedMissingDate = reportedMissingDate;
    }

    @Id
    @GeneratedValue
    private Long id;
    private double latitude;
    private double longitude;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pet_id", nullable = false)
    @JsonBackReference
    private Pet pet;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate reportedMissingDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getReportedMissingDate() {
        return reportedMissingDate;
    }

    public void setReportedMissingDate(LocalDate reportedMissingDate) {
        this.reportedMissingDate = reportedMissingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissingPetReport that = (MissingPetReport) o;
        return Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0 && Objects.equals(id, that.id) && Objects.equals(pet, that.pet) && Objects.equals(reportedMissingDate, that.reportedMissingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude, pet, reportedMissingDate);
    }

    @Override
    public String toString() {
        return "MissingPetReport{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", pet=" + pet +
                ", reportedMissingDate=" + reportedMissingDate +
                '}';
    }
}
