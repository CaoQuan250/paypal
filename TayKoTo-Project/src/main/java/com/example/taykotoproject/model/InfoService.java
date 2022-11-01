package com.example.taykotoproject.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class InfoService {
    private long serviceId;
    private Long vehicleId;
    private String vehicleMake;
    private String vehicleModel;
    private String bodyStyle;
    private String vehicleType;
    private Integer vehicleYear;
    private String vehicleEngine;
    private String vehicleHorsepower;
    private Short seat;
    private String color;
    private BigDecimal price;
    private String description;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Service_id")
    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "Vehicle_Id")
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "Vehicle_Make")
    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    @Basic
    @Column(name = "Vehicle_Model")
    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Basic
    @Column(name = "Body_Style")
    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Basic
    @Column(name = "Vehicle_Type")
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Basic
    @Column(name = "Vehicle_Year")
    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    @Basic
    @Column(name = "Vehicle_Engine")
    public String getVehicleEngine() {
        return vehicleEngine;
    }

    public void setVehicleEngine(String vehicleEngine) {
        this.vehicleEngine = vehicleEngine;
    }

    @Basic
    @Column(name = "Vehicle_Horsepower")
    public String getVehicleHorsepower() {
        return vehicleHorsepower;
    }

    public void setVehicleHorsepower(String vehicleHorsepower) {
        this.vehicleHorsepower = vehicleHorsepower;
    }

    @Basic
    @Column(name = "Seat")
    public Short getSeat() {
        return seat;
    }

    public void setSeat(Short seat) {
        this.seat = seat;
    }

    @Basic
    @Column(name = "Color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "Price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoService that = (InfoService) o;
        return serviceId == that.serviceId && Objects.equals(vehicleId, that.vehicleId) && Objects.equals(vehicleMake, that.vehicleMake) && Objects.equals(vehicleModel, that.vehicleModel) && Objects.equals(bodyStyle, that.bodyStyle) && Objects.equals(vehicleType, that.vehicleType) && Objects.equals(vehicleYear, that.vehicleYear) && Objects.equals(vehicleEngine, that.vehicleEngine) && Objects.equals(vehicleHorsepower, that.vehicleHorsepower) && Objects.equals(seat, that.seat) && Objects.equals(color, that.color) && Objects.equals(price, that.price) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, vehicleId, vehicleMake, vehicleModel, bodyStyle, vehicleType, vehicleYear, vehicleEngine, vehicleHorsepower, seat, color, price, description);
    }
}
