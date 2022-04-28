package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Airport;
;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;


@Validated
public class AirportDto {
    private Long id;
    @Length(min = 4, max = 4, message = "ICAO notation must have exactly 4 characters")
    private String Icao;
    @NotBlank(message = "City can not be empty")
    private String city;
    @NotBlank(message = "Country must be added")
    private String country;
    public AirportDto() {
    }
    public AirportDto( Long id, String ICAO, String city, String country ) {
        this.id = id;
        this.Icao = ICAO;
        this.city = city;
        this.country = country;
    }

    public String getIcao() {
        return Icao;
    }

    public void setIcao( String icao ) {
        this.Icao = icao;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }
}
