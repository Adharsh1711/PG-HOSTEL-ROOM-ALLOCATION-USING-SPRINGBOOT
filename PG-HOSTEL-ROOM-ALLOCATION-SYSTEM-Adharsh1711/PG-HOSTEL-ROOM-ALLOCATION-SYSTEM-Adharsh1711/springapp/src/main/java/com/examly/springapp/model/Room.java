package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String roomNumber;
    private Double pricePerNight;
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private RoomCategory roomCategory;

    public Room() {}

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public Boolean getAvailable() {
        return available;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }
}
