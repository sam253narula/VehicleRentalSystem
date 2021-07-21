package com.whitehatjunior.vehiclerentingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whitehatjunior.vehiclerentingsystem.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>  {

}
