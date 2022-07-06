package com.example.ShoppingCart.Model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product implements Comparable<Product>
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productId;
    private String productName;
    private int quantity;
    private int price;



    @Override
    public int compareTo(Product p)
    {
        if (this.productId == p.productId)
            return 0;
        else if (this.productId >p.productId)
            return 1;
        else
            return -1;
    }



    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + price;
        result = prime * result + (int) (productId ^ (productId >>> 32));
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + quantity;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product pt = (Product) obj;
        if (price != pt.price)
            return false;
        if (productId != pt.productId)
            return false;
        if (productName == null) {
            if (pt.productName != null)
                return false;
        } else if (!productName.equals(pt.productName))
            return false;
        if (quantity != pt.quantity)
            return false;
        return true;
    }




    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
