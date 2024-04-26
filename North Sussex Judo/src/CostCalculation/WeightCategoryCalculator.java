package CostCalculation;
import AthleteInformation.Athlete;

public class WeightCategoryCalculator implements WeightCategory{
    private final String categoryName;
    private final int weightRequirement;

    public WeightCategoryCalculator(String categoryName, int weightRequirement){
        this.categoryName = categoryName;
        this.weightRequirement = weightRequirement;
    }

    @Override
    public String calculateWeightDifference(Athlete athlete){
        double currentWeight = athlete.getCurrentWeight();
        
        // Handling the "Heavyweight" category separately
        if (categoryName.equals("Heavyweight") && currentWeight >= 100) {
            return "Congratulations! The athlete is eligible to enter Heavyweight competition category.";
        }
        
        // For other weight categories
        if (currentWeight == weightRequirement) {
            return "Congratulations! The athlete is eligible to enter " + categoryName + " competition category.";
        } else if (currentWeight < weightRequirement) {
            return "The athlete needs to gain " + (weightRequirement - currentWeight) + "kg to meet " + categoryName + " competition category requirement.";
        } else {
            return "The athlete needs to lose " + (currentWeight - weightRequirement) + "kg to meet " + categoryName + " competition category requirement.";
        }
    }
    
}


    

