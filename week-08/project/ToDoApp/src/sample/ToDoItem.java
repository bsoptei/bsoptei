package sample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Söp on 2016.12.15..
 */
@DatabaseTable(tableName = "tasks")
class ToDoItem {
    @DatabaseField(generatedId = true)
    public Integer id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String description;
    @DatabaseField
    private String date;

    public ToDoItem() {
    }

    ToDoItem(String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String toString(){
        return String.format("%s, %s", date, description);
    }
}
