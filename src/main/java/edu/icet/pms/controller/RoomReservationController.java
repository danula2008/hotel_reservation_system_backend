package edu.icet.pms.controller;

import edu.icet.pms.model.RoomReservation;
import edu.icet.pms.service.RoomReservationService;
import edu.icet.pms.util.composite_keys.RoomReservationPK;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reserve/room")
@RequiredArgsConstructor
@CrossOrigin
public class RoomReservationController {

    private final RoomReservationService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addRoomReservation(@RequestBody RoomReservation roomReservation){
        service.addRoomReservation(roomReservation);
        return "Room Reservation successfully saved.";
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateRoomReservation(@RequestBody RoomReservation roomReservation){
        service.addRoomReservation(roomReservation);
        return "Room Reservation successfully updated.";
    }

    @DeleteMapping("/delete/{reservationId}/{roomId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteRoomReservation(@PathVariable String reservationId, @PathVariable String roomId){
        service.deleteRoomReservation(new RoomReservationPK(roomId, reservationId));
        return "Room Reservation successfully deleted.";
    }

    @GetMapping("/get/all")
    public List<RoomReservation> getAllRoomReservations(){
        return service.getAllRoomReservations();
    }

    @GetMapping("/get/id/{id}")
    public RoomReservation getRoomReservationById(@PathVariable String id){
        return service.getRoomReservationByReservationId(id);
    }

    @GetMapping("/get/room-id/{roomId}")
    public List<RoomReservation> getRoomReservationByRoomId(@PathVariable String roomId){
        return service.getRoomReservationByRoomId(roomId);
    }
}
