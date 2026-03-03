package com.busbooking.dto;
public class BookingRequest {
    private Long userId;
    private Long scheduleId;
    private Integer seatsBooked;
    private String passengerNames;
    public Long getUserId() { return userId; }
    public void setUserId(Long v) { this.userId = v; }
    public Long getScheduleId() { return scheduleId; }
    public void setScheduleId(Long v) { this.scheduleId = v; }
    public Integer getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(Integer v) { this.seatsBooked = v; }
    public String getPassengerNames() { return passengerNames; }
    public void setPassengerNames(String v) { this.passengerNames = v; }
}
