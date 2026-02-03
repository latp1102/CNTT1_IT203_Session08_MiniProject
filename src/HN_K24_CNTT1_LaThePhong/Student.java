package HN_K24_CNTT1_LaThePhong;

public class Student {
    private String id;
    private String name;
    private double score;
    public Student(String id, String name, double score){
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public Student(){}
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public String getRank() {
        if (score >= 8.0) {
            return "Giỏi";
        } else if (score >= 6.5) {
            return "Khá";
        } else {
            return "Trung Bình";
        }
    }
    @Override
    public String toString(){
        return "Mã sv: " + id + " Tên sv: " + name + " Học lực: " + getRank();
    }

}




