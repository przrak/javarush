package ru.javarush.pr1zrak.testtask.entity;

import javax.persistence.*;

@Entity
@Table(name = "part", schema = "test", catalog = "")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "need")
    private boolean need;

    @Column(name = "quantity")
    private int quantity;

    public Part() {
    }

    public Part(String name, boolean need, int quantity) {
        this.name = name;
        this.need = need;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeed() {
        return need;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", need=" + need +
                ", quantity=" + quantity +
                '}';
    }
}
