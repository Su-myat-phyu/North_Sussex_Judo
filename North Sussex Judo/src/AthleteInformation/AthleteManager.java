package AthleteInformation;

import java.util.Scanner;

import UserInterface.UserInterface;

public class AthleteManager {

    public static Athlete registerAthlete() {
        
        String name = "";
        String trainingPlan = "";
        double currentWeight = 0;
        String competitionWeightCategory = "";
        int noOfCompetitionsEntered = 0;
        int privateCoachingHours = 0;

        //user input for athlete name
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the Athlete Name.");
        while (true) {
            name = input.nextLine();
            if (name.trim().isEmpty()){
                System.out.println("Name cannot be empty.");
            }else if (!name.matches(".*\\d.*")){
                break;
            }else{
                System.out.println("Invalid! Please try again and enter the Athlete Name with no number."); //validation to handle user input
            }
            
        }

        // user input for training plan
        System.out.println("The following are the available training plans in North Sussex Judo Training Center."); 
        UserInterface.displayTrainingPlan(); //displaying available training plan to user

        boolean planStatus = true;
        while (planStatus) {
            System.out.println("Please choose the Training Plan you would like to attend. (1. Beginner, 2. Intermediate, 3. Elite)\nChoose 1,2,3");

            String inputstr = input.nextLine();

            if (!inputstr.trim().isEmpty()){
                try {
                    int choice = Integer.parseInt(inputstr);

                    switch (choice){
                        case 1:
                            trainingPlan = "Beginner";  
                            planStatus = false;
                            break;
                        
                        case 2:
                            trainingPlan = "Intermediate";
                            planStatus = false;
                            break;
                        
                        case 3:
                            trainingPlan = "Elite";
                            planStatus = false;
                        break;

                        default:
                        System.out.println("Please enter a valid option (1, 2, 3).");
                    }
                   

                } catch (NumberFormatException e){
                    System.out.println("Invalid input. Please enter a valid integer (1, 2, 3)"); //validation for user input for training plan
                }
            } else {
                System.out.println("Input cannot be empty. Please enter a valid option (1, 2, 3).");
            }
        }
        //user input for current weight

    System.out.println("Please enter the current weight of the athlete (kg).");

    while (true) {
        try{
            currentWeight = Double.parseDouble(input.nextLine());
            if (currentWeight <= 0) {
                System.out.println("Weight must be a positive number. Please enter a valid weight input.");
            } else{
                break;
            }
        } catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a numeric value for weight input.");
        }
        
    }

    //user input for competition weight category
    System.out.println("The following are the competition weight categories.");
    UserInterface.displayWeightCategories(); //displaying competition weight category to user

    boolean competitionStatus = true;
    while (competitionStatus) {
        System.out.println("Please select the competition category (1.Heavyweight, 2.Light-Heavyweight, 3.Middleweight, 4.Light-Middleweight, 5.Lightweight, 6.Flyweight)");
        System.out.println("Enter a number between 1 and 6");

        String inputStr = input.nextLine().trim();

        if (!inputStr.isEmpty()){
            try {
                int competitionChoice = Integer.parseInt(inputStr);

                switch (competitionChoice) {
                    case 1:
                        competitionWeightCategory = "Heavyweight";
                        competitionStatus = false;
                        break;

                    case 2:
                        competitionWeightCategory = "Light-Heavyweight";
                        competitionStatus = false;
                        break;
                        
                    case 3:
                        competitionWeightCategory = "Middleweight";
                        competitionStatus = false;
                        break;

                    case 4:
                        competitionWeightCategory = "Light-Middleweight";
                        competitionStatus = false;
                        break;

                    case 5:
                        competitionWeightCategory = "Lightweight";
                        competitionStatus = false;
                        break;

                    case 6:
                        competitionWeightCategory = "Flyweight";
                        competitionStatus = false;
                        break;
                    default:
                    System.out.println("Please enter a valid option (1 to 6)");

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer (1 to 6).");
            }
        } else{
            System.out.println("Input cannot be empty. Please enter a valid option (1 to 6).");
        }
    }
    //user input for number of competitions entered

        if (!trainingPlan.equalsIgnoreCase("beginner")) {
            while (true) {
                try {
                    System.out.println("Please enter the number of competitions entered this month: (maximum 2)");
                    noOfCompetitionsEntered = Integer.parseInt(input.nextLine());

                    if (noOfCompetitionsEntered < 0){
                        System.out.println("Please enter a valid option (non-negative number)."); 
                    }else if (noOfCompetitionsEntered > 2){
                        System.out.println("Only maximum 2 competitions allowed!");
                    }else{
                        break;
                    }
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid integer for the number of competitions.");
            }
        }
    } else{
        System.out.println("\nThose who select Beginner Plan cannot enter competitions!");
    }

    //user input for private coaching hours (Optional)
    
    boolean privateCoachingStatus = true;
    while (true){
        System.out.println("Do athlete want to take private coaching sessions? (Y/N)");

        //Read the input line
        String addPrivateCoaching = input.nextLine().trim().toLowerCase();

        //Check if the input is not empty
        if (!addPrivateCoaching.isEmpty()){
            if (addPrivateCoaching.equals("y")){
                while (privateCoachingStatus){
                    System.out.println("Please enter the number of hours of private coaching for athlete a month.");
                    if (input.hasNextInt()){
                        privateCoachingHours = input.nextInt();

                        if (privateCoachingHours < 0){
                            System.out.println("Please enter a valid non-negative number of hours.");
                        } else if (privateCoachingHours > 20){
                            System.out.println("Athletes can only receive a maximum of 20 hours of private coaching a month.");
                        } else {
                            privateCoachingStatus = false;
                        }
                    } else {
                        String invalidInput = input.nextLine();
                        System.out.println("Invalid input. Pleaase enter a valid integer for the number of hours.");
                    }
                }
                break;
            } else if (addPrivateCoaching.equals("n")){
                //if no private coaching, break the loop
                break;
            } else{
                System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
            }
        } else{
            System.out.println("Input cannot be empty. Please enter 'y' for yes or 'n' for no.");
        }
    }
    return new Athlete(name, trainingPlan, currentWeight, competitionWeightCategory, noOfCompetitionsEntered, privateCoachingHours);
}
}
