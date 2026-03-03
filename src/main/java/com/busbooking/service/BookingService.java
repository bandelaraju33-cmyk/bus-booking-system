package com.busbooking.service;
import com.busbooking.dto.BookingRequest;
import com.busbooking.model.Booking;
import com.busbooking.model.Schedule;
import com.busbooking.model.User;
import com.busbooking.repository.BookingRepository;
import com.busbooking.repository.ScheduleRepository;
import com.busbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class BookingService {
    @Autowired private BookingRepository bookingRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ScheduleRepository scheduleRepository;

    @Transactional
    public Booking bookTicket(BookingRequest request) {
        User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found!"));
        Schedule schedule = scheduleRepository.findById(request.getScheduleId())
            .orElseThrow(() -> new RuntimeException("Schedule not found!"));
        if (schedule.getAvailableSeats() < request.getSeatsBooked()) {
            throw new RuntimeException("Not enough seats! Only " + schedule.getAvailableSeats() + " left.");
        }
        schedule.setAvailableSeats(schedule.getAvailableSeats() - request.getSeatsBooked());
        scheduleRepository.save(schedule);
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSchedule(schedule);
        booking.setSeatsBooked(request.getSeatsBooked());
        booking.setTotalPrice(schedule.getPrice() * request.getSeatsBooked());
        booking.setPassengerNames(request.getPassengerNames());
        booking.setStatus("CONFIRMED");
        booking.setBookingDate(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Transactional
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found!"));
        if ("CANCELLED".equals(booking.getStatus())) {
            throw new RuntimeException("Booking already cancelled!");
        }
        booking.setStatus("CANCELLED");
        Schedule schedule = booking.getSchedule();
        schedule.setAvailableSeats(schedule.getAvailableSeats() + booking.getSeatsBooked());
        scheduleRepository.save(schedule);
        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(Long userId) { return bookingRepository.findByUserUserId(userId); }
    public List<Booking> getAllBookings() { return bookingRepository.findAll(); }
    public Optional<Booking> getBookingById(Long id) { return bookingRepository.findById(id); }
}
