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
    private Type type;

    public Entry(String name, float value, Date date, Category category, Type type) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.category = category;
        this.type = type;
        this.dueDate = date;
    }

    public Entry(String name, float value, Date date, Date dueDate, Category category, Type type) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.category = category;
        this.type = type;
    }

    public Entry(int id, String name, float value, Date date, Date dueDate, Category category, Type type) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.category = category;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Float.compare(entry.value, value) == 0 &&
                date.equals(entry.date) &&
                category == entry.category &&
                type == entry.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, date, category, type);
    }
}
