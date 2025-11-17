package co.istad.sms;

public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Double score;
    private Boolean isActive;

    public Student() {}

    public Student(String name, String gender, Double score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
