package com.whitehatjunior.vehiclerentingsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whitehatjunior.vehiclerentingsystem.entity.Inventoryvehicles;
import com.whitehatjunior.vehiclerentingsystem.entity.Users;
import com.whitehatjunior.vehiclerentingsystem.repository.InventoryOfVehiclesRepository;
import com.whitehatjunior.vehiclerentingsystem.repository.UsersRepository;

@RestController
public class VehicleRentingSystemController {

	@Autowired
	InventoryOfVehiclesRepository availableVehicles;

	@Autowired
	UsersRepository userRepository;

	@GetMapping("/availableVehicles")
	public List<Inventoryvehicles> availableVehicles() {
		return availableVehicles.findAll();
	}

	@PostMapping("/bookVehicle")
	public Inventoryvehicles bookVehicle(long bookByID, int numberOfDays, int userId, String emailID ) {
		Optional<Inventoryvehicles> vehicleOptional = availableVehicles.findById(bookByID);
		if (vehicleOptional.isPresent()) {
			Inventoryvehicles requestToBookvehicle = vehicleOptional.get();
			// Check if vehicle is booked, then throw an exception
			if (requestToBookvehicle.getBooked()) {
				throw new RuntimeException("Vehicle is already booked");
			}

			// calculate total rate of booking for provided duration of days
			int ratePerDay = requestToBookvehicle.getRate();
			int totalRateForBooking = ratePerDay * numberOfDays;
			requestToBookvehicle.setBooked(true);
			requestToBookvehicle.setDurationInDays(2);
			requestToBookvehicle.setTotalRateForBooking(totalRateForBooking);
			requestToBookvehicle.setUserEmailID(emailID);
			userRepository.saveAndFlush(Users.builder().id(new Long(1)).emailID("samarthnarula@Gmail.com").build());
			availableVehicles.saveAndFlush(requestToBookvehicle);
			return requestToBookvehicle;
		} else {
			throw new RuntimeException("Please provide a valid Booking id");
		}
	}

}
