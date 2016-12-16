package sample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;

@DatabaseTable(tableName = "users")
class User {
    @DatabaseField(id = true)
    @Getter
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
