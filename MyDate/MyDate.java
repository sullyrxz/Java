import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class MyDate {

    public Calendar myDate = null;
    private int day = 0;
    private int month = 0;
    private int year = 0;
    public double userInput = 0;
    public int numberInput = 0;
    public long timeInMillis = 0;

    MyDate() {

        this.myDate = new GregorianCalendar();
        this.timeInMillis = myDate.getTimeInMillis();
        this.year = myDate.get(Calendar.YEAR);
        this.month = myDate.get(Calendar.MONTH);
        this.day = myDate.get(Calendar.DATE);
    }

    MyDate(int year, int month, int day) {

        this.myDate = new GregorianCalendar(year + 1900, month, day);
        this.timeInMillis = myDate.getTimeInMillis();
        this.year = myDate.get(Calendar.YEAR);
        this.month = myDate.get(Calendar.MONTH);
        this.day = myDate.get(Calendar.DATE);
    }

    MyDate(long timeInMillis) {

        this.myDate = new GregorianCalendar();
        this.myDate.setTimeInMillis(timeInMillis);
        this.year = myDate.get(Calendar.YEAR);
        this.month = myDate.get(Calendar.MONTH);
        this.day = myDate.get(Calendar.DATE);
        this.timeInMillis = timeInMillis;
    }

    public int getYear() {

        return year;
    }

    public int getMonth() {

        return month;
    }

    public int getDay() {

        return day;
    }

    public void setDate(long timeInMillis) {

        this.myDate.setTimeInMillis(this.timeInMillis + timeInMillis);
        this.year = myDate.get(Calendar.YEAR);
        this.month = myDate.get(Calendar.MONTH);
        this.day = myDate.get(Calendar.DATE);
        this.timeInMillis += timeInMillis;
    }

    public static void main(String args[]) throws ParseException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        MyDate myDate = new MyDate();
        MyDate myDate2 = new MyDate(34355555133101L);
        String outStr = String.format("The year is %d, the month is %d, the day is %d", myDate.getYear(),
                myDate.getMonth(), myDate.getDay());
        System.out.println(outStr);

        outStr = String.format("\nThe year is %d, the month is %d, the day is %d", myDate2.getYear(),
                myDate2.getMonth(), myDate2.getDay());
        System.out.println(outStr);

    }

}
