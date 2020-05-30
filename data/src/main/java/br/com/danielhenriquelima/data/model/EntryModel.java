package br.com.danielhenriquelima.data.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "entry")
public class EntryModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private float value;
    private Date date;
    private Date dueDate;
    private String category;
    private String type;

    @Ignore
    public EntryModel(String name, float value, Date date, Date dueDate, String category, String type) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.category = category;
        this.type = type;
    }

    public EntryModel(int id, String name, float value, Date date, Date dueDate, String category, String type) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
