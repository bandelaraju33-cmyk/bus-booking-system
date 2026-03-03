package com.busbooking.repository;
import com.busbooking.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BusRepository extends JpaRepository<Bus, Long> {}
