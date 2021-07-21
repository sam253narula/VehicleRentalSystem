package com.whitehatjunior.vehiclerentingsystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "INVENTORY_OF_VEHICLES")
@Entity
public class Inventoryvehicles {
	
	@Id
	private Long id;
	private int rate;
	private String vehicleType;
	private String fakeBarcode;
	private int parkingStallNumber;
	private Date startDateTime;
	private int durationInDays;
	private Boolean booked;
	private int totalRateForBooking;
	private String userEmailID;
}
