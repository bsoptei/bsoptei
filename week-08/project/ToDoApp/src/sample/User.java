package sample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
class User {
    @DatabaseField(id = true)
    private String name;

    public User() {
    }

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

}