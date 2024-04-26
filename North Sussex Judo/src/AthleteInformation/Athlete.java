package AthleteInformation;

public class Athlete {
    private String name;
    private String trainingPlan;
    private double currentWeight;
    private String competitionWeightCategory;
    private int noOfCompetitionsEntered;
    private int privateCoachingHours;
    
    public Athlete (String name, String trainingPlan, double currentWeight, String competitionWeightCategory, int noOfCompetitionsEntered, int privateCoachingHours){
        this.name = name;
        this.trainingPlan = trainingPlan;
        this.currentWeight = currentWeight;
        this.competitionWeightCategory = competitionWeightCategory;
        this.noOfCompetitionsEntered = noOfCompetitionsEntered;
        this.privateCoachingHours = privateCoachingHours;
    }

    public String getName() {
        return name;
    }

    public String getTrainingPlan() {
        return trainingPlan;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public String getCompetitionWeightCategory() {
        return competitionWeightCategory;
    }

    public int getNoOfCompetitionsEntered() {
        return noOfCompetitionsEntered;
    }

    public int getPrivateCoachingHours() {
        return privateCoachingHours;
    }


}
