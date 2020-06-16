package br.com.danielhenriquelima.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class Entry implements Serializable {

    private int id;
    private String name;
    private float value;
    private Date date;
    private Date dueDate;
    private int categoryId;
    private boolean isCredito;

    public Entry(String name, float value, Date date, int category, boolean isCredito) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.categoryId = category;
        this.isCredito = isCredito;
        this.dueDate = date;
    }

    public Entry(String name, float value, Date date, Date dueDate, int category, boolean isCredito) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.categoryId = category;
        this.isCredito = isCredito;
    }

    public Entry(int id, String name, float value, Date date, Date dueDate, int category, boolean isCredito) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.categoryId = category;
        this.isCredito = isCredito;
    }

    public int getId() {
        return id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public float getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public boolean isCredito() {
        return isCredito;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", date=" + date +
                ", dueDate=" + dueDate +
                ", categoryId=" + categoryId +
                ", isCredito=" + isCredito +
                '}';
    }
}
