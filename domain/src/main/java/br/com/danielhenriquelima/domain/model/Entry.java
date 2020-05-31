package br.com.danielhenriquelima.domain.model;

import java.util.Date;
import java.util.Objects;

public class Entry {

    private int id;
    private String name;
    private float value;
    private Date date;
    private Date dueDate;
    private Category category;
    private boolean isCredito;

    public Entry(String name, float value, Date date, Category category, boolean isCredito) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.category = category;
        this.isCredito = isCredito;
        this.dueDate = date;
    }

    public Entry(String name, float value, Date date, Date dueDate, Category category, boolean isCredito) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.category = category;
        this.isCredito = isCredito;
    }

    public Entry(int id, String name, float value, Date date, Date dueDate, Category category, boolean isCredito) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public boolean isCredito() {
        return isCredito;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return id == entry.id &&
                Float.compare(entry.value, value) == 0 &&
                isCredito == entry.isCredito &&
                name.equals(entry.name) &&
                date.equals(entry.date) &&
                dueDate.equals(entry.dueDate) &&
                category.equals(entry.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, date, dueDate, category, isCredito);
    }
}
