package com.example.demo.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "sales")
public class SalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String client        ;
    private String seller        ;
    private Date   creation_date ;
    private double total         ;


    public SalesEntity() {
    }

    public SalesEntity(Long id, String client, String seller, Date creation_date, double total) {
        this.id = id;
        this.client = client;
        this.seller = seller;
        this.creation_date = creation_date;
        this.total = total;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSeller() {
        return this.seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Date getCreation_date() {
        return this.creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", client='" + getClient() + "'" +
            ", seller='" + getSeller() + "'" +
            ", creation_date='" + getCreation_date() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }



    
    
}