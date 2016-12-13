package date;

import java.text.ParseException;

public interface BirthdayCalculator<T> {

    T parseDate(String str) throws ParseException;

    String printMonthAndDay(T date);

    boolean isAnniversaryToday(T date);

    int calculateAgeInYears(T birthday);

    int calculateDaysToNextAnniversary(T date);

}
