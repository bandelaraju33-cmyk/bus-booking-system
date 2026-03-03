package com.busbooking.service;
import com.busbooking.model.Bus;
import com.busbooking.model.Schedule;
import com.busbooking.repository.BusRepository;
import com.busbooking.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ScheduleService {
    @Autowired private ScheduleRepository scheduleRepository;
    @Autowired private BusRepository busRepository;

    public Schedule createSchedule(Schedule schedule) {
        Bus bus = busRepository.findById(schedule.getBus().getBusId())
            .orElseThrow(() -> new RuntimeException("Bus not found!"));
        schedule.setBus(bus);
        if (schedule.getAvailableSeats() == null) {
            schedule.setAvailableSeats(bus.getTotalSeats());
        }
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> searchSchedules(String source, String destination, int seats) {
        return scheduleRepository.findBySourceAndDestinationAndSeats(source, destination, seats);
    }

    public List<Schedule> getAllSchedules() { return scheduleRepository.findAll(); }
    public Optional<Schedule> getScheduleById(Long id) { return scheduleRepository.findById(id); }
}
