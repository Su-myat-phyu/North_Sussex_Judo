import UserInterface.UserInterface;

import java.util.Scanner;

import AthleteInformation.Athlete;
import AthleteInformation.AthleteManager;
import CostCalculation.MonthlyCost;
import CostCalculation.Plans;
import CostCalculation.TrainingCostCalculation;
import CostCalculation.TrainingPlan;
import CostCalculation.WeightCategory;
import CostCalculation.WeightCategoryCalculator;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        UserInterface.welcomeMessage();
        //looping registration process for 6 athletes
        for (int i = 0; i < 6; i++){
            UserInterface.displayResult();
        }

        while (true) {
            System.out.println("Do you want to add more athlete? (Y/N)");
            
            String addAnother = scanner.next().trim().toLowerCase();

            if (addAnother.equals("y")){
                UserInterface.displayResult();
            }else if (addAnother.equals("n")){
                UserInterface.displayResultOfAll();
                System.out.println("\n");
                UserInterface.thankMessage();
                break;
            }else{
                System.out.println("Invalid input! Please enter 'y' for yes and 'n' for no.");
            }
            
        }
    }

}