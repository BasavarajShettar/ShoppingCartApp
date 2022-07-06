package com.example.ShoppingCart.Model;

import javax.persistence.Entity;

@Entity
public class Book extends Product
{

    private String gener;
    private String author;
    private String publications;


    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublications() {
        return publications;
    }

    public void setPublications(String publications) {
        this.publications = publications;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((gener == null) ? 0 : gener.hashCode());
        result = prime * result + ((publications == null) ? 0 : publications.hashCode());
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
        Book bk = (Book) obj;
        if (author == null) {
            if (bk.author != null)
                return false;
        } else if (!author.equals(bk.author))
            return false;
        if (gener == null) {
            if (bk.gener != null)
                return false;
        } else if (!gener.equals(bk.gener))
            return false;
        if (publications == null) {
            if (bk.publications != null)
                return false;
        } else if (!publications.equals(bk.publications))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "gener='" + gener + '\'' +
                ", author='" + author + '\'' +
                ", publications='" + publications + '\'' +
                '}';
    }
}
