package diiage.potherat.demo.demoapp3.dal.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import diiage.potherat.demo.demoapp3.dal.room.dao.QuoteDao;
import diiage.potherat.demo.demoapp3.model.Quote;

@Database(entities = {Quote.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
abstract public class QuotesDatabase extends RoomDatabase {
    abstract public QuoteDao quoteDao();
}
