import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Söp on 2016.12.13.. Creating multiple accounts using the MySQL server
 */
public class Workshop02 {

    public static void main(String[] args) throws SQLException, IOException {

        StringBuilder databaseUrl = new StringBuilder();
        databaseUrl.append("jdbc:mysql://127.0.0.1:3306/workshop02?user=root&password=");

        BufferedReader passWordReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Hello. Enter your password: ");
        String passWord = passWordReader.readLine();
        databaseUrl.append(passWord);
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl.toString());

        TableUtils.createTableIfNotExists(connectionSource, Account.class);

        Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);

        Account account = new Account("Captain America", "uejnsd632**234.");
        createAccountIfNotExists(accountDao, account);
        account = accountDao.queryForId("Captain America");
        System.out.println("Account: " + account.toString());

        createAccountIfNotExists(accountDao, new Account("Iron Man", "12345"));
        createAccountIfNotExists(accountDao, new Account("Wolverine", "12345"));
        createAccountIfNotExists(accountDao, new Account("Hulk", "12345"));
        createAccountIfNotExists(accountDao, new Account("Loki", "12345"));

        for (Account account1 : accountDao) {
            System.out.println(account1.getName());
        }

        QueryBuilder<Account, String> queryBuilder =
                accountDao.queryBuilder();

        List<Account> accountList = accountDao.queryBuilder()
                .selectColumns("name")
                .orderBy("name", true)
                .query();

        for (Account a : accountList) {
            System.out.println(a.getName());
        }

        connectionSource.close();
    }

    private static void createAccountIfNotExists(Dao<Account, String> accountDao, Account acc) throws SQLException {
        if (accountDao.queryForId(acc.getName()) == null) {
            accountDao.create(acc);
        }
    }
}