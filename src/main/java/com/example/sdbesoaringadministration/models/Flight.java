/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Creates an object of Flight
 *
 */

package com.example.sdbesoaringadministration.models;

import com.example.sdbesoaringadministration.enums.FlightTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Enumerated(EnumType.STRING)
    @Column
    private FlightTypeEnum flightType;

    @ManyToOne
    @JoinColumn(
            name = "starting_methode_id",
            referencedColumnName = "id")
    private StartingMethode startingMethode;

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

    public FlightTypeEnum getFlightType() {
        return flightType;
    }

    public void setFlightType( FlightTypeEnum flightType ) {
        this.flightType = flightType;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Flight flight = ( Flight ) o;
        return timeFlown == flight.timeFlown && Objects.equals( id, flight.id ) && Objects.equals( timeStart, flight.timeStart ) && Objects.equals( timeEnd, flight.timeEnd ) && flightType == flight.flightType && Objects.equals( startingMethode, flight.startingMethode ) && Objects.equals( remarks, flight.remarks ) && Objects.equals( invoice, flight.invoice ) && Objects.equals( billedPerson, flight.billedPerson ) && Objects.equals( plane, flight.plane ) && Objects.equals( passenger, flight.passenger ) && Objects.equals( captain, flight.captain ) && Objects.equals( airportEnd, flight.airportEnd ) && Objects.equals( airportStart, flight.airportStart );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, timeStart, timeEnd, timeFlown, flightType, startingMethode, remarks, invoice, billedPerson, plane, passenger, captain, airportEnd, airportStart );
    }
}
