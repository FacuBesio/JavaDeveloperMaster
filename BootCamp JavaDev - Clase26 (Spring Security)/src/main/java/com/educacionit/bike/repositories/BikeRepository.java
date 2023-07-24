package com.educacionit.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educacionit.bike.models.Bike;

// <Bike, Long> Se indica la Clase a la que será aplicado y el tipo de dato de la Clave Primaria
public interface BikeRepository  extends JpaRepository<Bike, Long>{

}
