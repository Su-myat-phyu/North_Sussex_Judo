package CostCalculation;

public class Plans {
    public static class BeginnerTrainingPlan implements TrainingPlan{
    
            @Override
            public double calculateMonthlyPlanFee(){
                return 25 * 4; // calculate monthly plan fee for Beginner
            }
    }

    public static class IntermediateTrainingPlan implements TrainingPlan{
    
        @Override
        public double calculateMonthlyPlanFee(){
            return 30 * 4; // calculate monthly plan fee for Intermediate
        }
}

    public static class EliteTrainingPlan implements TrainingPlan{   
        
        @Override
        public double calculateMonthlyPlanFee(){
            return 35 * 4; // calculate monthly plan fee for Elite
        }
    }
}
