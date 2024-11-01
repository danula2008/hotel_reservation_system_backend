package edu.icet.pms.controller;

import edu.icet.pms.dto.HallReservation;
import edu.icet.pms.service.HallReservationService;
import edu.icet.pms.util.composite_keys.HallReservationPK;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reserve/hall")
@RequiredArgsConstructor
public class HallReservationController {

    private final HallReservationService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addHallReservation(@RequestBody HallReservation hallReservation){
        service.addHallReservation(hallReservation);
        return "Hall Reservation successfully saved.";
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateHallReservation(@RequestBody HallReservation hallReservation){
        service.addHallReservation(hallReservation);
        return "Hall Reservation successfully updated.";
    }

    @DeleteMapping("/delete/{reservationId}/{hallId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteHallReservation(@PathVariable String reservationId, @PathVariable String hallId){
        service.deleteHallReservation(new HallReservationPK(hallId, reservationId));
        return "Hall Reservation successfully deleted.";
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<HallReservation> getAllHallReservations(){
        return service.getAllHallReservations();
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<HallReservation> getHallReservationById(@PathVariable String id){
        return service.getHallReservationByReservationId(id);
    }

    @GetMapping("/get/hall-id/{hallId}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<HallReservation> getHallReservationByHallId(@PathVariable String hallId){
        return service.getHallReservationByHallId(hallId);
    }

    @GetMapping("/get/starting-date/{date}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<HallReservation> getHallReservationByStartingDate(@PathVariable String date){
        return service.getHallReservationByStartingDate(LocalDate.parse(date));
    }

    @GetMapping("/get/ending-date/{date}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<HallReservation> getHallReservationByEndingDate(@PathVariable String date){
        return service.getHallReservationByEndingDate(LocalDate.parse(date));
    }
}
