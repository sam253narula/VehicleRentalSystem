package com.whitehatjunior.vehiclerentingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name  = "USERS")
@Entity
public class Users {

	@Id
	private Long id;
	private String emailID;
}
