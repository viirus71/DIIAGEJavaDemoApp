package diiage.potherat.demo.demoapp3.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Quote {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String quote;
    private String source;
    private LocalDateTime date;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return Objects.equals(quote, quote1.quote) &&
                Objects.equals(source, quote1.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quote, source);
    }
}
