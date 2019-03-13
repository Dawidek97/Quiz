package example.quiz.model;

public class User {

    private Integer numberOfPoints = 0;

    public User(){
    }

    public void addPoint(){
        numberOfPoints++;
    }

    public Integer getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }
}
