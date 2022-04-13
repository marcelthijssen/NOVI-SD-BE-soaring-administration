package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Member;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Validated
public class MemberDto extends PersonDto {

    private String userName;
    private String password;
    private String membership;
    private String role;
    private String pilotLicense;

   public MemberDto(){}

    public MemberDto( Long id, String gender, String firstName, String lastName, LocalDate birthday, String streetName, String houseNumber, String postalcode, String city, String country, String email, String phone, String userName, String password, String membership, String role, String pilotLicense ) {
        super( id, gender, firstName, lastName, birthday, streetName, houseNumber, postalcode, city, country, email, phone );
        this.userName = userName;
        this.password = password;
        this.membership = membership;
        this.role=role;
        this.pilotLicense = pilotLicense;
    }

    public static Member memberDtoToMember( MemberDto dto ) {
        Member m = new Member();


        m.setId( dto.getId() );
        m.setMembership( dto.getMembership() );
        m.setUserName( dto.getUserName() );
        m.setPassword( dto.getPassword() );
        m.setRole( dto.getRole() );
        m.setPilotLicense( dto.getPilotLicense() );
        m.setGender( dto.getGender() );
        m.setFirstName( dto.getFirstName() );
        m.setLastName( dto.getLastName() );
        m.setBirthday( dto.getBirthday() );
        m.setStreetName( dto.getStreetName() );
        m.setHouseNumber( dto.getHouseNumber() );
        m.setCity( dto.getCity() );
        m.setCountry( dto.getCountry() );
        m.setEmail( dto.getEmail() );
        m.setPhone( dto.getPhone() );

        return m ;
    }

    public static MemberDto memberToMemberDto( Member m ) {
        MemberDto dto = new MemberDto();

        dto.setId( m.getId() );
        dto.setMembership( m.getMembership() );
        dto.setUserName( m.getUserName() );
        dto.setPassword( m.getPassword() );
        dto.setRole( m.getRole() );
        dto.setPilotLicense( m.getPilotLicense() );
        dto.setGender( m.getGender() );
        dto.setFirstName( m.getFirstName() );
        dto.setLastName( m.getLastName() );
        dto.setBirthday( m.getBirthday() );
        dto.setStreetName( m.getStreetName() );
        dto.setHouseNumber( m.getHouseNumber() );
        dto.setCity( m.getCity() );
        dto.setCountry( m.getCountry() );
        dto.setEmail( m.getEmail() );
        dto.setPhone( m.getPhone() );

        return dto ;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership( String membership ) {
        this.membership = membership;
    }

    public String getPilotLicense() {
        return pilotLicense;
    }

    public void setPilotLicense( String pilotLicense ) {
        this.pilotLicense = pilotLicense;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }


}
