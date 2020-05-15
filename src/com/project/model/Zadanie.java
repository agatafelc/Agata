package com.project.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "zadanie")
public class Zadanie {

    @Id
    @GeneratedValue
    @Column(name = "zadanie_id")
    private Integer zadanieId;

    @Column(nullable = false, length = 50)
    private String nazwa;

    @Column
    private Integer kolejnosc;

    @Column(length = 1000)
    private String opis;

    @CreationTimestamp
    @Column(name = "dataczas_dodania", nullable = false, updatable = false)
    private LocalDateTime dataCzasDodania;

    @UpdateTimestamp
    @Column(name = "dataczas_edycji", nullable = false)
    private LocalDateTime dataCzasEdycji;

    @ManyToOne
    @JoinColumn(name = "projekt_id")
    private Projekt projekt;

    public Zadanie(){}

    public Integer getZadanieId() {
        return zadanieId;
    }

    public void setZadanieId(Integer zadanieId) {
        this.zadanieId = zadanieId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getKolejnosc() {
        return kolejnosc;
    }

    public void setKolejnosc(Integer kolejnosc) {
        this.kolejnosc = kolejnosc;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDateTime getDataCzasDodania() {
        return dataCzasDodania;
    }

    public void setDataCzasDodania(LocalDateTime dataCzasDodania) {
        this.dataCzasDodania = dataCzasDodania;
    }

    public LocalDateTime getDataCzasEdycji() {
        return dataCzasEdycji;
    }

    public void setDataCzasEdycji(LocalDateTime dataCzasEdycji) {
        this.dataCzasEdycji = dataCzasEdycji;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }
}
