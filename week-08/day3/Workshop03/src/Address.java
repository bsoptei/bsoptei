import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Söp on 2016.12.14.. Address
 */
@DatabaseTable(tableName = "addresses")
public class Address {

    @DatabaseField(generatedId = true)
    public Integer id;
    @DatabaseField
    public String street;
    @DatabaseField
    public String city;
    @DatabaseField
    public String postCode;
    @DatabaseField
    public String country;

    public Address() {
    }

    public Address(String street, String city, String postCode, String country) {
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

    public String toString() {
        return String.format("{\npostCode = %s,\ncity = %s,\ncountry = %s\nstreet = %s\n}",
                postCode, city, country, street);
    }

//    public void setAccount(Account account) {
//        this.account = account;
//    }
}
