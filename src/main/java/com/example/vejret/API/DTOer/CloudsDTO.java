package com.example.vejret.API.DTOer;

public class CloudsDTO{

    private int all;

    public CloudsDTO(){}

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "CloudsDTO{" +
                "all=" + all +
                '}';
    }
}
