package CostCalculation;

public class MonthlyCost {
    private double planFee;
    private double privateCoachingFee;
    private double competitionFee;
    private String athleteName;
    private String comparisonMessage;

    public double getPlanFee() {
        return planFee;
    }
    public void setPlanFee(double planFee) {
        this.planFee = planFee;
    }
    public double getPrivateCoachingFee() {
        return privateCoachingFee;
    }
    public void setPrivateCoachingFee(double privateCoachingFee) {
        this.privateCoachingFee = privateCoachingFee;
    }
    public double getCompetitionFee() {
        return competitionFee;
    }
    public void setCompetitionFee(double competitionFee) {
        this.competitionFee = competitionFee;
    }
    public String getAthleteName() {
        return athleteName;
    }
    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }
    public String getComparisonMessage() {
        return comparisonMessage;
    }
    public void setComparisonMessage(String comparisonMessage) {
        this.comparisonMessage = comparisonMessage;
    }
    
    public double getTotalFee(){
        return this.planFee + this.privateCoachingFee + this.competitionFee;
    }

    }


