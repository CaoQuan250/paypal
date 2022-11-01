package com.example.taykotoproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
public class Vehicle {
    private long vehicleId;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private Integer vehicleYear;
    private String vehicleEngine;
    private String vehicleHorsepower;
    private String bodyStyle;
    private String status;
    private BigDecimal price;
    private String img;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Vehicle_Id")
    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @NotBlank(message = "Not blank")
    @Column(name = "Vehicle_Make")
    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    @Basic
    @NotBlank(message = "Not blank")
    @Column(name = "Vehicle_Model")
    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
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
    @Column(name = "Body_Style")
    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "Img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleId == vehicle.vehicleId && Objects.equals(vehicleMake, vehicle.vehicleMake) && Objects.equals(vehicleModel, vehicle.vehicleModel) && Objects.equals(vehicleType, vehicle.vehicleType) && Objects.equals(vehicleYear, vehicle.vehicleYear) && Objects.equals(vehicleEngine, vehicle.vehicleEngine) && Objects.equals(vehicleHorsepower, vehicle.vehicleHorsepower) && Objects.equals(bodyStyle, vehicle.bodyStyle) && Objects.equals(status, vehicle.status) && Objects.equals(price, vehicle.price) && Objects.equals(img, vehicle.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, vehicleMake, vehicleModel, vehicleType, vehicleYear, vehicleEngine, vehicleHorsepower, bodyStyle, status, price, img);
    }

    private Set<Deal> deal;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
    public Set<Deal> getDeal() {
        return deal;
    }

    public void setDeal(Set<Deal> deal) {
        this.deal = deal;
    }
}
