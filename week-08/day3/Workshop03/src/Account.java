import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Söp on 2016.12.13.. Account
 */
@DatabaseTable(tableName = "accounts")
public class Account {

    @DatabaseField(id = true)
    private String name;
    @DatabaseField(canBeNull = false)
    private String password;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    public Address address;

    public Account() {
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;

    }

    Account(String name, String password, Address address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }


    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String toString() {
        return String.format("{\nname: %s,\naddress = %s\n}", getName(), address.toString());
    }
}
