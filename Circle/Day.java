public class Day {

    public class DaysOfWeek {
        public static String DayOfWeekStr(String NumberOfDay) {
            String dayStr = "";
            switch (NumberOfDay) {
                case "1":
                    dayStr = "Sunday";
                    break;
                case "2":
                    dayStr = "Monday";
                    break;
                case "3":
                    dayStr = "Tuesday";
                    break;
                case "4":
                    dayStr = "Wednesday";
                    break;
                case "5":
                    dayStr = "Thursday";
                    break;
                case "6":
                    dayStr = "Friday";
                    break;
                case "7":
                    dayStr = "Saturday";
                    break;
            }
            return dayStr;
        }
    }

    public static void main(String[] args) {
        System.out.println("Days Of week: ");

        for (int i = 1; i < 8; i++) {
            System.out.println("Number: " + i + "\tDay Of Week: " + DaysOfWeek.DayOfWeekStr(Integer.toString(i)));
        }

    }

}