/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Controller of endpoint from '/planes'
 *
 * GET / POST / PUT / DELETE
 * and assings a owner and a technician to a specific plane
 *
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.PlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController( PlaneService planeService ) {
        this.planeService = planeService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllPlanes() {
        List<PlaneDto> planeDtoList = planeService.getAllPlanes();

        return new ResponseEntity<>( planeDtoList, HttpStatus.OK );
    }

    @GetMapping("/{plid}")
    public ResponseEntity<Object> getPlaneById( @PathVariable(name = "plid") Long plid ) {
        PlaneDto plane = planeService.getPlaneById( plid );
        try {
            return ResponseEntity.ok( plane );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Plane Not found", HttpStatus.NOT_FOUND );
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> createPlane( @Valid @RequestBody PlaneDto planeDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            planeService.createPlane( planeDto );
            return new ResponseEntity<>( "plane added to systeem", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/{plid}")
    public ResponseEntity<String> deletePlaneById( @PathVariable("plid") Long plid ) {

        planeService.deletePlaneById( plid );
        return new ResponseEntity<>( "Plane deleted from system", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{plid}")
    public PlaneDto updatePlane( @PathVariable("plid") Long plid, @RequestBody PlaneDto plane ) {

        return planeService.updatePlane( plid, plane );
    }

    //         assign owner to plane
    @PutMapping("/{plid}/price")
    public PlaneDto addMinutePrice( @PathVariable("plid") Long plid, @RequestBody PlaneDto plane ) {

        return planeService.addMinutePrice( plid, plane );
    }

    //         assign owner to plane
    @PutMapping("/{plid}/owner/{pid}")
    public ResponseEntity<Object> assignOwnerToPlane( @PathVariable("plid") Long plid, @PathVariable("pid") Long pid ) {
        planeService.assignOwnerToPlane( plid, pid );
        return new ResponseEntity<>( "Owner added to plane", HttpStatus.ACCEPTED );
    }


    //         assign technician to plane
    @PutMapping("/{plid}/technician/{pid}")
    public ResponseEntity<Object> assignTechnicianToPlane( @PathVariable("plid") Long plid, @PathVariable("pid") Long pid ) {
        planeService.assignTechnicianToPlane( plid, pid );
        return new ResponseEntity<>( "Technician added to plane", HttpStatus.ACCEPTED );
    }

    // need to upload file for plane
    @PutMapping("/flightstatus/{plid}")
    public String uploadFlightStatusPdf( @Valid @PathVariable("plid") Long plid, @RequestBody MultipartFile pdf ) throws IOException {
        planeService.uploadFlightStatusPdf( plid, pdf );
        return "File uploaded";
    }

    @GetMapping(value = "/{plid}/flightstatus", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] getFlightStatusPdfById( @PathVariable(name = "plid") Long plid ) {
        PlaneDto plane = planeService.getFlightStatusPdfById( plid );
        return plane.getFlightStatus();

    }
}
