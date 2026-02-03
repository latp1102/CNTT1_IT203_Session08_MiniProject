public class Student {

    private String id;
    private String fullName;
    private int age;
    private String gender;

    private double math;
    private double physics;
    private double chemistry;

    private double avg;
    private String rank;

    public Student(String id, String fullName, int age, String gender,
                   double math, double physics, double chemistry) {

        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;

        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;

        calculate();
    }

    // Tính điểm TB + xếp loại
    private void calculate() {
        avg = (math + physics + chemistry) / 3;

        if (avg >= 8.5 && math >= 6.5 && physics >= 6.5 && chemistry >= 6.5) {
            rank = "Giỏi";
        } else if (avg >= 6.5 && math >= 5 && physics >= 5 && chemistry >= 5) {
            rank = "Khá";
        } else if (avg >= 5 && math >= 3.5 && physics >= 3.5 && chemistry >= 3.5) {
            rank = "Trung bình";
        } else {
            rank = "Yếu";
        }
    }
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getAvg() {
        return avg;
    }

    public String getRank() {
        return rank;
    }
    public void setScores(double math, double physics, double chemistry) {
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        calculate();
    }
    public void display() {
        System.out.printf("%-8s %-20s %-5d %-6s %-6.2f %-10s%n",
                id, fullName, age, gender, avg, rank);
    }
}
