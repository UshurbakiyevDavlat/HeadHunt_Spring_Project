package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database;

import lombok.Data;

@Data
public class OutputMessage {
    private String from;
    private String text;
    private String time;

    public OutputMessage(String from, String text, String time) {
        this.from = from;
        this.text = text;
        this.time = time;
    }
}
