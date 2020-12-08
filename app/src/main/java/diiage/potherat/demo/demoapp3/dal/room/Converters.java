package diiage.potherat.demo.demoapp3.dal.room;

import androidx.room.TypeConverter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Converters {

    @TypeConverter
    public static Long convertLocalDateTimeToDatabase(LocalDateTime dateTime) {
        return dateTime.toEpochSecond(ZoneOffset.UTC);
    }
    @TypeConverter
    public static LocalDateTime convertLocalDateTimeFromDatabase(Long dateTime)  {
        return LocalDateTime.ofEpochSecond(dateTime,0, ZoneOffset.UTC);
    }

}
