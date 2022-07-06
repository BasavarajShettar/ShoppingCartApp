package com.example.ShoppingCart.Model;

import javax.persistence.*;
import java.io.Serializable;

public class User implements Serializable, Comparable<User>
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    private Cart cart;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }



    @Override
    public int compareTo(User u)
    {
        if (this.id == u.id) {
            return 0;
        } else if (this.id > u.id)
            return 1;
        else
            return -1;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cart == null) ? 0 : cart.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
        User us = (User) obj;
        if (cart == null) {
            if (us.cart != null)
                return false;
        } else if (!cart.equals(us.cart))
            return false;
        if (id != us.id)
            return false;
        if (userName == null) {
            if (us.userName != null)
                return false;
        } else if (!userName.equals(us.userName))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", cart=" + cart +
                '}';
    }
}
