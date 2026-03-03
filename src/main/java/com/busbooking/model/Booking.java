package com.busbooking.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "bookings")
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    private Integer seatsBooked;
    private Double totalPrice;
    private String status = "CONFIRMED";
    private LocalDateTime bookingDate = LocalDateTime.now();
    private String passengerNames;
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long v) { this.bookingId = v; }
    public User getUser() { return user; }
    public void setUser(User v) { this.user = v; }
    public Schedule getSchedule() { return schedule; }
    public void setSchedule(Schedule v) { this.schedule = v; }
    public Integer getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(Integer v) { this.seatsBooked = v; }
    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double v) { this.totalPrice = v; }
    public String getStatus() { return status; }
    public void setStatus(String v) { this.status = v; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime v) { this.bookingDate = v; }
    public String getPassengerNames() { return passengerNames; }
    public void setPassengerNames(String v) { this.passengerNames = v; }
}
