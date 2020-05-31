package br.com.danielhenriquelima.data.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

import br.com.danielhenriquelima.domain.model.Entry;

@Entity(tableName = "entry")
public class EntryModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private float value;
    private Date date;
    private Date dueDate;
    private int categoryModelId;
    private boolean isCredit;

    public EntryModel(){}

    @Ignore
    public EntryModel(String name, float value, Date date, Date dueDate, int categoryModelId, boolean isCredit) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.categoryModelId = categoryModelId;
        this.isCredit = isCredit;
    }

    @Ignore
    public EntryModel(Entry entry){
        this.name = entry.getName();
        this.value = entry.getValue();
        this.date = entry.getDate();
        this.dueDate = entry.getDueDate();
        this.isCredit = entry.isCredito();
        this.categoryModelId = entry.getCategoryId();
    }

    @Ignore
    public EntryModel(int id, String name, float value, Date date, Date dueDate, int categoryModelId, boolean isCredit) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.date = date;
        this.dueDate = dueDate;
        this.categoryModelId = categoryModelId;
        this.isCredit = isCredit;
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

    public int getCategoryModelId() {
        return categoryModelId;
    }

    public void setCategoryModelId(int categoryModelId) {
        this.categoryModelId = categoryModelId;
    }

    public boolean isCredit() {
        return isCredit;
    }

    public void setCredit(boolean credit) {
        isCredit = credit;
    }
}
