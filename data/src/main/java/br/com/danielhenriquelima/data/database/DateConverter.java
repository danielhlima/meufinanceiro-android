package br.com.danielhenriquelima.data.database;


import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

//    @TypeConverter
//    public static Category toString(String name){
//        return name == null ? null : new Category(name);
//    }
//
//    @TypeConverter
//    public static String toString(Category category){
//        return category == null ? null : category.getName();
//    }
}
