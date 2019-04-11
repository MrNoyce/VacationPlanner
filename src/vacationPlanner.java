import java.text.DecimalFormat;
import java.util.Scanner;
public class vacationPlanner {

    private static String lineBreakPls = "* * * * * * * * * * * * * * * * * * * * * * * * * * ";

    public static void main(String [] args) {
        System.out.println("Welcome to Vacation Planner!");
        userInfo();
        travelDetails();
        time();
        distance();

    }

    private static void userInfo() {
        Scanner inputName = new Scanner(System.in);
        Scanner inputDestination = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = inputName.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = inputDestination.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip");
        System.out.println(lineBreakPls);
        System.out.println();
    }

    private static void travelDetails() {
        /////Add Scanners
        Scanner numberOfDays = new Scanner(System.in);
        Scanner tripBudget = new Scanner(System.in);
        Scanner currencyCode = new Scanner(System.in);
        Scanner exchangeRate = new Scanner(System.in);
        /////// Ask questions and get input
        System.out.print("How many days are you going to spend travelling? ");
        int totalDays = numberOfDays.nextInt();
        System.out.print("How much money, in GBP, do you have as spending money? ");
        int totalBudget = tripBudget.nextInt();
        System.out.print("What is the currency code for your destination? ");
        String currCode = currencyCode.next();
        System.out.print("How many " + currCode + " are there in 1 GBP? ");
        double exRate = exchangeRate.nextDouble();
        ////// Formulate Responses based on user input
        ////// Math Ops based on input
        int totalHours = totalDays * 24;
        int totalMinutes = totalHours * 60;
        double dailyBudget = (double) totalBudget / totalDays;
        double convertedBudget = totalBudget * exRate;
        double convertDailyBudget = convertedBudget / totalDays;
        DecimalFormat df = new DecimalFormat("###.##");
        //////Print Statements
        System.out.println("If you are travelling for " + totalDays + " days that is the same as " + totalHours + " hours or " + totalMinutes + " minutes");
        System.out.println("if you car going to spend £" + totalBudget + " " + currCode + " that means per day you can spend up to £" + df.format(dailyBudget) + " GBP");
        System.out.println("Your total budget in " + currCode + " is " + convertedBudget + " " + currCode + ", which per day is " + df.format(convertDailyBudget) + " " + currCode);
        System.out.println(lineBreakPls);
        System.out.println();
    }

    private static void time() {
        String timeFromMidnight;
        String timeFromNoon;
        Scanner timeDiff = new Scanner(System.in);
        System.out.print("How many hours difference will there be? ");
        double timeDifference = timeDiff.nextDouble();
        int hoursDiff = (int) timeDifference % 24;
        int hoursDiffNoon = ((int) timeDifference + 12) % 24;
        int minsDiff = (int) (60 * (timeDifference - hoursDiff));
        if (minsDiff == 0) {
            timeFromMidnight = hoursDiff + ":00";
            timeFromNoon = hoursDiffNoon + ":00";
        }
        else{
            timeFromMidnight = hoursDiff + ":" + minsDiff;
            timeFromNoon = hoursDiffNoon + ":" + minsDiff;
        }
        System.out.println("That means when its midnight at home it will be " + timeFromMidnight + " in your travel destination \n" +
                "and when it is noon at home it will be " + timeFromNoon);
        System.out.println(lineBreakPls);
    }

    private static  void distance() {
        Scanner area = new Scanner(System.in);
        System.out.println("What is the square area of your destination country in KM2? ");
        int inputArea = area.nextInt();
        double miles = inputArea * 0.3861;
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.print("So, your destination's area is " + df.format(miles) + " in miles2.");
        System.out.println(lineBreakPls);
    }


}
