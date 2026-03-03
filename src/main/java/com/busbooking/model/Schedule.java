package com.busbooking.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @ManyToOne @JoinColumn(name = "bus_id")
    private Bus bus;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer availableSeats;
    private String status = "ACTIVE";
    public Long getScheduleId() { return scheduleId; }
    public void setScheduleId(Long v) { this.scheduleId = v; }
    public Bus getBus() { return bus; }
    public void setBus(Bus v) { this.bus = v; }
    public String getSource() { return source; }
    public void setSource(String v) { this.source = v; }
    public String getDestination() { return destination; }
    public void setDestination(String v) { this.destination = v; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime v) { this.departureTime = v; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime v) { this.arrivalTime = v; }
    public Double getPrice() { return price; }
    public void setPrice(Double v) { this.price = v; }
    public Integer getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(Integer v) { this.availableSeats = v; }
    public String getStatus() { return status; }
    public void setStatus(String v) { this.status = v; }
}
