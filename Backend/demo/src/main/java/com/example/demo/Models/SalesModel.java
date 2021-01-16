package com.example.demo.Models;


import java.util.Date;

public class SalesModel {

    private Long id;
    private String client;
    private String seller;
    private Date creation_date;
    private double total;

    public SalesModel() {
    }

    public SalesModel(Long id, String client, String seller, Date creation_date, double total) {
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