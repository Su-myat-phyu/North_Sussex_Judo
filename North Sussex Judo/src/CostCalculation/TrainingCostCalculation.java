package CostCalculation;

import AthleteInformation.Athlete;
import AthleteInformation.AthleteManager;

import java.util.ArrayList;

public class TrainingCostCalculation {

    public static final ArrayList<MonthlyCost> monthlyCostsList = new ArrayList<>();

    public static MonthlyCost calculateTrainingCost(){
        Athlete athlete = AthleteManager.registerAthlete(); //register athlete
        MonthlyCost monthlyCost = new MonthlyCost(); //create an object to store calculated monthly cost

        monthlyCost.setAthleteName(athlete.getName());

        TrainingPlan trainingPlan = getTrainingPlan(athlete.getTrainingPlan());
        double monthlyPlanFee = trainingPlan.calculateMonthlyPlanFee();
        monthlyCost.setPlanFee(monthlyPlanFee);

        WeightCategory weightCategory = getWeightCategory(athlete.getCompetitionWeightCategory());
        String weightDifference = weightCategory.calculateWeightDifference(athlete); 
        monthlyCost.setComparisonMessage(weightDifference);

        monthlyCost.setPrivateCoachingFee(athlete.getPrivateCoachingHours() * 9); //calculate private coaching fee based on the athlete's input
        monthlyCost.setCompetitionFee(athlete.getNoOfCompetitionsEntered() * 22); //calculate competition fee based on the athlete's input

        monthlyCostsList.add(monthlyCost); //All of the necessary fees are added to the monthly cost list

        return monthlyCost;
    }
// retrieve the appropriate training plan based on the athlete's input
    private static TrainingPlan getTrainingPlan(String plan){
        switch (plan){
            case "Beginner":
                return new Plans.BeginnerTrainingPlan();
            case "Intermediate":
                return new Plans.IntermediateTrainingPlan();
            case "Elite":
                return new Plans.EliteTrainingPlan();   
            default:
                throw new IllegalStateException("Unexpected value: " + plan);
        }
    }

// retrieve the appropriate weight category based on the athlete's input
    private static WeightCategory getWeightCategory(String category) {
         switch (category) {
            case "Heavyweight":
                return new WeightCategoryCalculator("Heavyweight", Integer.MAX_VALUE);
            case "Light-Heavyweight":
                return new WeightCategoryCalculator("Light-Heavyweight", 100);
            case "Middleweight":
                return new WeightCategoryCalculator("Middleweight", 90);
            case "Light-Middleweight":
                return new WeightCategoryCalculator("Light-Middleweight", 81);
            case "Lightweight":
                return new WeightCategoryCalculator("Lightweight", 73);
            case "Flyweight":
                return new WeightCategoryCalculator("Flyweight", 66);
            default:
                return new WeightCategoryCalculator("Invalid Weight Category", 0);
        }
    }
    
}
