package com.whitehatjunior.vehiclerentingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whitehatjunior.vehiclerentingsystem.entity.Inventoryvehicles;


@Repository
public interface InventoryOfVehiclesRepository extends JpaRepository<Inventoryvehicles, Long> {

}

