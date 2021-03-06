import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Söp on 2016.12.14.. Create tables with foreign objects
 */
public class Workshop03 {
    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) throws SQLException, IOException {
        StringBuilder databaseUrl = new StringBuilder();
        databaseUrl.append("jdbc:mysql://127.0.0.1:3306/workshop03?user=root&password=");

        BufferedReader passWordReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Hello. Enter your password: ");
        String passWord = passWordReader.readLine();
        databaseUrl.append(passWord);
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl.toString());

        Address address = new Address("Andrássy út", "Budapest", "1061", "Hungary");
        Address address2 = new Address("Kossuth Lajos u.", "Veszprém", "8200", "Hungary");
        Address address3 = new Address("Veszprémi út", "Balatonalmádi", "8220", "Hungary");
        Address address4 = new Address("Szív u.", "Budapest", "1063", "Hungary");

        accounts.add(new Account("Captain America", "uejnsd632**234.", address));
        accounts.add(new Account("Superman", "12345", address2));
        accounts.add(new Account("Spiderman", "12345", address3));
        accounts.add(new Account("Batman", "12345", address4));

        Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);

        TableUtils.createTableIfNotExists(connectionSource, Account.class);
        TableUtils.createTableIfNotExists(connectionSource, Address.class);

        for (Account account : accounts) {
            createAccountIfNotExists(accountDao, account);
        }
        //Experimenting with 2 types of querying
        System.out.println(accountDao.queryForEq("name", "Captain America").toString());
        System.out.println(accountDao.queryForId("Captain America"));
        connectionSource.close();
    }

    private static void createAccountIfNotExists(Dao<Account, String> accountDao, Account acc) throws SQLException {
        if (accountDao.queryForId(acc.getName()) == null) {
            accountDao.create(acc);
        }
    }
}