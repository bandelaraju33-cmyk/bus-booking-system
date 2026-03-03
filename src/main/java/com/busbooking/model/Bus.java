package com.busbooking.model;
import jakarta.persistence.*;
@Entity
@Table(name = "buses")
public class Bus {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;
    private String busNumber;
    private Integer totalSeats;
    private String busType;
    private String operatorName;
    public Long getBusId() { return busId; }
    public void setBusId(Long v) { this.busId = v; }
    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String v) { this.busNumber = v; }
    public Integer getTotalSeats() { return totalSeats; }
    public void setTotalSeats(Integer v) { this.totalSeats = v; }
    public String getBusType() { return busType; }
    public void setBusType(String v) { this.busType = v; }
    public String getOperatorName() { return operatorName; }
    public void setOperatorName(String v) { this.operatorName = v; }
}
