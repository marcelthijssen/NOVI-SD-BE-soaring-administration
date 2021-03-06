/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Implements methodes for AirportController
 *
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Airport;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.repositories.AirportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl( AirportRepository airportRepository ) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<AirportDto> getAllAirports() {
        List<Airport> airportList = this.airportRepository.findAll();
        List<AirportDto> airportDtoList = new ArrayList<>();

        for ( Airport ap : airportList ) {
            AirportDto dto = airportToAirportDto( ap );

            airportDtoList.add( dto );
        }
        return airportDtoList;
    }

    @Override
    public AirportDto getAirportById( Long airport_id ) {
        try {
            Airport ap = airportRepository.findById( airport_id ).get();
            return airportToAirportDto( ap );
        } catch ( Exception e ) {
            throw new RecordNotFoundException( "Invalid airport id: " + airport_id, HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public Airport createAirport( AirportDto dto ) {

        Airport ap = airportDtoToAirport( dto );

        return this.airportRepository.save( ap );
    }

    @Override
    public ResponseEntity<Object> deleteAirportById( Long aperson_id ) {
        try {
            airportRepository.deleteById( aperson_id );
            return new ResponseEntity<>( "Airport is deleted", HttpStatus.OK );
        } catch ( RecordNotFoundException e ) {
            throw new RecordNotFoundException( "Airport not found", HttpStatus.NOT_FOUND );
        }
    }


    @Override
    public AirportDto updateAirport( Long aperson_id, AirportDto dto ) {
        try {
            Airport ap = airportRepository.findById( aperson_id ).get();
            ap.setId( dto.getId() );
            ap.setIcao( dto.getIcao() );
            ap.setCity( dto.getCity() );
            ap.setCountry( dto.getCountry() );

            airportRepository.save( ap );
            return dto;
        } catch ( RecordNotFoundException e ) {
            throw new RecordNotFoundException( "Airport not found", HttpStatus.NOT_FOUND );
        }
    }

    public static Airport airportDtoToAirport( AirportDto dto ) {
        Airport airport = new Airport();

        airport.setIcao( dto.getIcao() );
        airport.setCity( dto.getCity() );
        airport.setCountry( dto.getCountry() );

        return airport;
    }

    public AirportDto airportToAirportDto( Airport airport ) {
        AirportDto dto = new AirportDto();
        dto.setId( airport.getId() );
        dto.setIcao( airport.getIcao() );
        dto.setCity( airport.getCity() );
        dto.setCountry( airport.getCountry() );
        return dto;
    }
}