package com.example.vejret.models;

import javax.persistence.*;

@Entity
public class Clouds{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int all;

    public Clouds(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }


    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
