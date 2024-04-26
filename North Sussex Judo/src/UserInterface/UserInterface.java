package UserInterface;

import java.util.ArrayList;

import CostCalculation.MonthlyCost;
import CostCalculation.TrainingCostCalculation;

public class UserInterface {
    public static void welcomeMessage() {

        String red = "\u001B[31m";
        String reset = " \u001B[0m";
        String blue = "\u001B[34m";

        System.out.println(red + "************************************************************************************" +reset);
        System.out.println(blue + "*                    Welcome to North Sussex Judo                                    *" + reset);
        System.out.println(blue + "*                           Training Program                                         *"+ reset);
        System.out.println(red + "************************************************************************************" +reset);

    }
    
    public static void thankMessage(){

        String magenta = "\u001B[35m";
        String green = " \u001B[32m";
        String reset = " \u001B[0m";

        
        System.out.println(green + "************************************************************************************" +reset);
        System.out.println(magenta + "*                     Thank You for Registering!                                    *" + reset);
        System.out.println(magenta + "*             We look forward to training with you.                                 *" + reset);
        System.out.println(green + "************************************************************************************" +reset);
    }   

    public static void displayTrainingPlan() {
        String title = "\033[1m                     Training Plan                   \033[0m";
        String[] headers = {"Training Plan", "Prices ($USD)"};
        String[][] data = {
            {"Beginner (2 sessions per week) - weekly fee", " $25.00"},
            {"Intermediate (3 sessions per week) - weekly fee", "$30.00"},
            {"Elite (5 sessions per week) - weekly fee", "$35.00"},
            {"Private tuition - per hour", "$9.00"},
            {"Competition entry fee - per competition", "$22.00"}
        };

        displayTable(title, headers, data); //displaying training plan in table format
    }

    public static void displayWeightCategories() {
        String title = "\033[1m         Weight Categories                 \033[0m";
        String[] headers = {"Categories","Upper Weight Limit (kg)"};
        String[][] data = {
            {"Heavyweight", "Unlimited (over 100)"},
            {"Light-Heavyweight", "100"},
            {"Middleweight", "90"},
            {"Light-Middleweight", "81"},
            {"Lightweight", "73"},
            {"Flyweight", "66"}
        };

        displayTable(title, headers, data);
    }

    public static void displayResult(){
        String yellow = "\u001B[33m";
        String reset = "\u001b[0m";

        MonthlyCost monthlyCost = TrainingCostCalculation.calculateTrainingCost();
        String title = "Monthly Fee of " + monthlyCost.getAthleteName();
        String[] headers = {"Description", "Amount ($)"};
        String[][] data = {
            {"Plan Fee", String.format("%.2f", monthlyCost.getPlanFee())},
            {"Private Coaching Fee", String.format("%.2f", monthlyCost.getPrivateCoachingFee())},
            {"Competition Fee", String.format("%.2f", monthlyCost.getCompetitionFee())},
            {"Total Fee", String.format("%.2f", monthlyCost.getTotalFee())}
        };

        System.out.println("\n" + yellow);
        displayTable(title, headers, data);
        System.out.println(monthlyCost.getComparisonMessage() + reset);
    }
//displaying the final result
    public static void displayResultOfAll(){
        String blue = "\u001b[34m";
        String reset = "\u001b[0m";
        ArrayList<MonthlyCost> monthlyCosts = TrainingCostCalculation.monthlyCostsList;

        String title = "Monthly Cost Overview";
        String[] headers = {"Name", "Plan Fee", "Private Coaching Fee", "Competition Fee", "Total"};
        String[][] data = new String[monthlyCosts.size()][headers.length];

        for (int i = 0; i < monthlyCosts.size(); i++){
            MonthlyCost result = monthlyCosts.get(i);
            data[i] = new String[]{
                result.getAthleteName(),
                String.format("%.2f", result.getPlanFee()),
                String.format("%.2f", result.getPrivateCoachingFee()),
                String.format("%.2f", result.getCompetitionFee()),
                String.format("%.2f", result.getTotalFee())
            };
        }

        System.out.println(blue);
        displayTable(title, headers, data);
        System.out.println(reset);
    }

    public static void displayTable(String title, String[] headers, String[][] data){
        int[] columnWidths = new int[headers.length];
    
        // Calculate column widths according to header lengths
        for (int i = 0; i < headers.length; i++){
            columnWidths[i] = headers[i].length();
        }
    
        // Update column widths based on data
        for (String[] row : data){
            for (int i = 0; i < row.length; i++){
                if (row[i].length() > columnWidths[i]){
                    columnWidths[i] = row[i].length();
                }
            }
        }
    
        // Display the table title
        System.out.println("\n" + title);
    
        // Print table headers
        printHorizontalLine(columnWidths);
        printRow(headers, columnWidths);
        printHorizontalLine(columnWidths);
    
        // Print table data
        for (String[] row : data){
            printRow(row, columnWidths);
        }
    
        // Print bottom border
        printHorizontalLine(columnWidths);
    }
    
    // Helper method to print a horizontal line
    private static void printHorizontalLine(int[] columnWidths) {
        System.out.print("+");
        for (int width : columnWidths) {
            System.out.print("-".repeat(width + 2) + "+");
        }
        System.out.println();
    }
    
    // Printing row with proper alignment
    private static void printRow(String[] rowData, int[] columnWidths) {
        for (int i = 0; i < rowData.length; i++) {
            System.out.printf("| %-" + columnWidths[i] + "s ", rowData[i]);
        }
        System.out.println("|");
    }
      
}
