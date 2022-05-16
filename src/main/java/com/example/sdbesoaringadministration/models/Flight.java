/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Creates an object of Flight
 *
 */

package com.example.sdbesoaringadministration.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Flight")
@Table(name = "FLIGHTS")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column
    private LocalDateTime timeStart;

    @Column
    private LocalDateTime timeEnd;

    @Column
    private long timeFlown;

    @Column
    private Boolean instructionFlight;

    @Column
    private String remarks;


    @JsonIgnore
    @OneToOne(mappedBy = "flight")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "billed_person_id",
            referencedColumnName = "id")
    private Person billedPerson;

    @ManyToOne
    @JoinColumn(
            name = "plane_id",
            referencedColumnName = "id")
    private Plane plane;

    @ManyToOne
    @JoinColumn(
            name = "starting_methode_id",
            referencedColumnName = "id")
    private StartingMethode startingMethode;

    @ManyToOne
    @JoinColumn(name = "passenger_id",
            referencedColumnName = "id")
    private Person passenger;

    @ManyToOne
    @JoinColumn(name = "captain_id",
            referencedColumnName = "id")
    private Person captain;

    @ManyToOne
    @JoinColumn(name = "airport_end_id",
            referencedColumnName = "id")
    private Airport airportEnd;

    @ManyToOne
    @JoinColumn(name = "airport_start_id",
            referencedColumnName = "id")
    private Airport airportStart;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart( LocalDateTime timeStart ) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd( LocalDateTime timeEnd ) {
        this.timeEnd = timeEnd;
    }

    public long getTimeFlown() {
        return timeFlown;
    }

    public void setTimeFlown( long timeFlown ) {
        this.timeFlown = timeFlown;
    }

    public Boolean getInstructionFlight() {
        return instructionFlight;
    }

    public void setInstructionFlight( Boolean instructionFlight ) {
        this.instructionFlight = instructionFlight;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks( String remarks ) {
        this.remarks = remarks;
    }

    public void setPlane( Plane plane ) {
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
    }

    public StartingMethode getStartingMethode() {
        return startingMethode;
    }

    public void setStartingMethode( StartingMethode startingMethode ) {
        this.startingMethode = startingMethode;
    }

    public Person getPassenger() {
        return passenger;
    }

    public void setPassenger( Person passenger ) {
        this.passenger = passenger;
    }

    public Person getCaptain() {
        return captain;
    }

    public void setCaptain( Person captain ) {
        this.captain = captain;
    }

    public Airport getAirportStart() {
        return airportStart;
    }

    public Airport getAirportEnd() {
        return airportEnd;
    }

    public void setAirportEnd( Airport airportEnd ) {
        this.airportEnd = airportEnd;
    }

    public void setAirportStart( Airport airportStart ) {
        this.airportStart = airportStart;
    }

    public Person getBilledPerson() {
        return billedPerson;
    }

    public void setBilledPerson( Person billedPerson ) {
        this.billedPerson = billedPerson;
    }


}
