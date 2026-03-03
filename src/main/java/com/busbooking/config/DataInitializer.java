package com.busbooking.config;

import com.busbooking.model.Bus;
import com.busbooking.model.Schedule;
import com.busbooking.model.User;
import com.busbooking.repository.BusRepository;
import com.busbooking.repository.ScheduleRepository;
import com.busbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired private UserRepository userRepository;
    @Autowired private BusRepository busRepository;
    @Autowired private ScheduleRepository scheduleRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@bus.com");
            admin.setPassword("admin123");
            admin.setPhone("9000000000");
            admin.setRole("ADMIN");
            userRepository.save(admin);

            User user1 = new User();
            user1.setName("Rahul Sharma");
            user1.setEmail("rahul@example.com");
            user1.setPassword("pass123");
            user1.setPhone("9876543210");
            user1.setRole("USER");
            userRepository.save(user1);
            System.out.println("Users loaded!");
        }

        if (busRepository.count() == 0) {
            Bus b1 = new Bus(); b1.setBusNumber("KA-01-AB-1234"); b1.setTotalSeats(40); b1.setBusType("AC"); b1.setOperatorName("Karnataka Express");
            Bus b2 = new Bus(); b2.setBusNumber("MH-02-CD-5678"); b2.setTotalSeats(50); b2.setBusType("SLEEPER"); b2.setOperatorName("Mumbai Travels");
            Bus b3 = new Bus(); b3.setBusNumber("TN-03-EF-9012"); b3.setTotalSeats(35); b3.setBusType("NON_AC"); b3.setOperatorName("Tamil Nadu Express");
            busRepository.save(b1); busRepository.save(b2); busRepository.save(b3);

            LocalDateTime now = LocalDateTime.now().plusDays(1);
            Schedule s1 = new Schedule(); s1.setBus(b1); s1.setSource("Bangalore"); s1.setDestination("Mumbai"); s1.setDepartureTime(now.withHour(8)); s1.setArrivalTime(now.withHour(20)); s1.setPrice(1200.0); s1.setAvailableSeats(40); s1.setStatus("ACTIVE");
            Schedule s2 = new Schedule(); s2.setBus(b2); s2.setSource("Mumbai"); s2.setDestination("Delhi"); s2.setDepartureTime(now.withHour(22)); s2.setArrivalTime(now.plusDays(1).withHour(18)); s2.setPrice(1800.0); s2.setAvailableSeats(50); s2.setStatus("ACTIVE");
            Schedule s3 = new Schedule(); s3.setBus(b3); s3.setSource("Chennai"); s3.setDestination("Bangalore"); s3.setDepartureTime(now.withHour(6)); s3.setArrivalTime(now.withHour(12)); s3.setPrice(500.0); s3.setAvailableSeats(35); s3.setStatus("ACTIVE");
            Schedule s4 = new Schedule(); s4.setBus(b1); s4.setSource("Bangalore"); s4.setDestination("Hyderabad"); s4.setDepartureTime(now.withHour(7)); s4.setArrivalTime(now.withHour(13)); s4.setPrice(700.0); s4.setAvailableSeats(40); s4.setStatus("ACTIVE");
            Schedule s5 = new Schedule(); s5.setBus(b2); s5.setSource("Hyderabad"); s5.setDestination("Delhi"); s5.setDepartureTime(now.withHour(20)); s5.setArrivalTime(now.plusDays(1).withHour(14)); s5.setPrice(1500.0); s5.setAvailableSeats(50); s5.setStatus("ACTIVE");
            Schedule s6 = new Schedule(); s6.setBus(b3); s6.setSource("Delhi"); s6.setDestination("Mumbai"); s6.setDepartureTime(now.withHour(6)); s6.setArrivalTime(now.withHour(22)); s6.setPrice(1400.0); s6.setAvailableSeats(35); s6.setStatus("ACTIVE");
            Schedule s7 = new Schedule(); s7.setBus(b1); s7.setSource("Mumbai"); s7.setDestination("Chennai"); s7.setDepartureTime(now.withHour(21)); s7.setArrivalTime(now.plusDays(1).withHour(17)); s7.setPrice(1300.0); s7.setAvailableSeats(40); s7.setStatus("ACTIVE");
            Schedule s8 = new Schedule(); s8.setBus(b2); s8.setSource("Bangalore"); s8.setDestination("Delhi"); s8.setDepartureTime(now.withHour(18)); s8.setArrivalTime(now.plusDays(1).withHour(20)); s8.setPrice(2000.0); s8.setAvailableSeats(50); s8.setStatus("ACTIVE");
            Schedule s9 = new Schedule(); s9.setBus(b3); s9.setSource("Hyderabad"); s9.setDestination("Bangalore"); s9.setDepartureTime(now.withHour(8)); s9.setArrivalTime(now.withHour(14)); s9.setPrice(650.0); s9.setAvailableSeats(35); s9.setStatus("ACTIVE");
            Schedule s10 = new Schedule(); s10.setBus(b1); s10.setSource("Chennai"); s10.setDestination("Mumbai"); s10.setDepartureTime(now.withHour(9)); s10.setArrivalTime(now.plusDays(1).withHour(7)); s10.setPrice(1100.0); s10.setAvailableSeats(40); s10.setStatus("ACTIVE");

            scheduleRepository.save(s1); scheduleRepository.save(s2); scheduleRepository.save(s3);
            scheduleRepository.save(s4); scheduleRepository.save(s5); scheduleRepository.save(s6);
            scheduleRepository.save(s7); scheduleRepository.save(s8); scheduleRepository.save(s9);
            scheduleRepository.save(s10);
            System.out.println("Buses and Routes loaded!");
        }
    }
}
