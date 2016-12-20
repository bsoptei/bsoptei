package com.greenfoxacademy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Söp on 2016.12.20..
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Todo {
    public int id;
    public String title;
    public boolean isUrgent;
    public boolean isDone;

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
