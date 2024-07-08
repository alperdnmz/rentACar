package dev.alperdonmez.rentacar.entities.concretes;

public class Brand {
    private int brand_id;

    public Brand() {
    }

    public Brand(int brand_id, String name) {
        this.brand_id = brand_id;
        this.name = name;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
