package com.demoreserva.demoreserva.controller;

import com.demoreserva.demoreserva.model.Reservation;
import com.demoreserva.demoreserva.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        Optional<Reservation> optionalReservation = reservationService.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation existingReservation = optionalReservation.get();
            existingReservation.setStartDate(reservationDetails.getStartDate());
            existingReservation.setEndDate(reservationDetails.getEndDate());
            existingReservation.setUserId(reservationDetails.getUserId());
            existingReservation.setRoomId(reservationDetails.getRoomId());
            existingReservation.setTotal(reservationDetails.getTotal());
            existingReservation.setTotalToPay(reservationDetails.getTotalToPay());
            existingReservation.setStatus(reservationDetails.getStatus());
            existingReservation.setNotified(reservationDetails.getNotified());

            Reservation updatedReservation = reservationService.save(existingReservation);
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
