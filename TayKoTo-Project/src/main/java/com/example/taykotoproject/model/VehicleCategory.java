package com.example.taykotoproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class VehicleCategory {
    private String bodyStyle;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Body_Style")
    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleCategory that = (VehicleCategory) o;
        return Objects.equals(bodyStyle, that.bodyStyle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyStyle);
    }
}
