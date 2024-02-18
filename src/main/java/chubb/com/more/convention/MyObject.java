package chubb.com.more.convention;

import java.time.LocalDateTime;

public class MyObject {
    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "date=" + date +
                '}';
    }
}
