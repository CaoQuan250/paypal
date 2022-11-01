package com.example.taykotoproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class VehicleGallery {
    private long galleryId;
    private Long vehicleId;
    private String img;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Gallery_id")
    public long getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(long galleryId) {
        this.galleryId = galleryId;
    }

    @Basic
    @Column(name = "Vehicle_id")
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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
        VehicleGallery that = (VehicleGallery) o;
        return galleryId == that.galleryId && Objects.equals(vehicleId, that.vehicleId) && Objects.equals(img, that.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(galleryId, vehicleId, img);
    }
}
