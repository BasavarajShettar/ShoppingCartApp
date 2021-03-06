package com.example.ShoppingCart.Model;

import javax.persistence.Entity;

@Entity
public class Apparal extends Product
{

    private String type;
    private String brand;
    private String design;

    public String getType()
    {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    @Override
    public String toString()
    {
        return "Apparal{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", design='" + design + '\'' +
                '}';
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((design == null) ? 0 : design.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Apparal ap = (Apparal) obj;
        if (brand == null)
        {
            if (ap.brand != null)
                return false;
        } else if (!brand.equals(ap.brand))
            return false;
        if (design == null)
        {
            if (ap.design != null)
                return false;
        } else if (!design.equals(ap.design))
            return false;
        if (type == null)
        {
            if (ap.type != null)
                return false;
        } else if (!type.equals(ap.type))
            return false;
        return true;
    }
}
