package com.busbooking.repository;
import com.busbooking.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s WHERE LOWER(s.source) = LOWER(:source) AND LOWER(s.destination) = LOWER(:destination) AND s.availableSeats >= :seats AND s.status = 'ACTIVE'")
    List<Schedule> findBySourceAndDestinationAndSeats(@Param("source") String source, @Param("destination") String destination, @Param("seats") int seats);
}
