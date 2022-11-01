package com.example.taykotoproject.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Deal {
    private long dealId;
    private Long customerId;
    private Long vehicleId;
    private BigDecimal price;
    private BigDecimal deposit;
    private Date orderDate;
    private Date arriveDate;
    private String status;
    private Date depositDate;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Deal_Id")
    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }

    @Basic
    @Column(name = "Customer_Id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

//    @Basic
//    @Column(name = "Vehicle_Id")
//    public Long getVehicleId() {
//        return vehicleId;
//    }
//
//    public void setVehicleId(Long vehicleId) {
//        this.vehicleId = vehicleId;
//    }

    @Basic
    @Column(name = "Price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Deposit")
    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    @Basic
    @Column(name = "Order_Date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "Arrive_Date")
    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    @Basic
    @Column(name = "Deposit_Date")
    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return dealId == deal.dealId && Objects.equals(customerId, deal.customerId) && Objects.equals(vehicleId, deal.vehicleId) && Objects.equals(price, deal.price) && Objects.equals(deposit, deal.deposit) && Objects.equals(orderDate, deal.orderDate) && Objects.equals(arriveDate, deal.arriveDate) && Objects.equals(status, deal.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealId, customerId, vehicleId, price, deposit, orderDate, arriveDate, status);
    }

    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Vehicle_Id")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
