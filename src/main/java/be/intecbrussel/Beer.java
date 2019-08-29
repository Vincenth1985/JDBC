package be.intecbrussel;

import java.util.Collections;

public class Beer {

    private int id;
    private String name;
    private int brewerId;
    private float price;
    private int stock;
    private float alcohol;
    private int version;


    public Beer(int id, String name, int brewerId, float price, int stock, float alcohol, int version) {
        this.id = id;
        this.name = name;
        this.brewerId = brewerId;
        this.price = price;
        this.stock = stock;
        this.alcohol = alcohol;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brewerId=" + brewerId +
                ", price=" + price +
                ", stock=" + stock +
                ", alcohol=" + alcohol +
                ", version=" + version +
                '}';
    }
}
