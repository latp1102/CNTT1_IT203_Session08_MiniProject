public class StudentManager {
    private Student[] students;
    private int count;
    public StudentManager(int capacity){
        students = new Student[capacity];
        count = 0;
    }
    public boolean addStudent(Student s){
        if(count >= students.length || findById(s.getId()) != null){
            return false;
        }
        students[count++]  = s;
        return true;
    }
    public Student findById(String id){
        for(int i = 0; i < count; i++){
            if(students[i].getId().equalsIgnoreCase(id)){
                return students[i];
            }
        }
        return null;
    }
    public void findByName(String keyword){
        boolean found = false;
        for(int i = 0; i < count; i++){
            if(students[i].getFullName().toLowerCase().contains(keyword.toLowerCase())){
                students[i].display();
                found = true;
            }
        }
        if (!found){
            System.out.println("Không tìm thấy sinh viên");
        }
    }
    public boolean deleteById(String id){
        for (int i = 0; i < count; i++){
            if(students[i].getId().equalsIgnoreCase(id)){
                for (int j = i; j < count -1; j++){
                    students[j] = students[j+1];
                }
                students[--count] = null;
                return true;
            }
        }
        return false;
    }
    public void displays(){
        if(count == 0){
            System.out.println("Danh sách rỗng");
            return;
        }
        System.out.printf("%-8s %-10s %-10s %-8s %-8s %-10s%n", "Mã sv", "Họ tên", "Tuổi", "Giới tính", "Điểm TB", "Xếp loại");
        for (int i = 0; i < count; i++){
            students[i].display();
        }
    }
    public void sortAvg(){
        for(int i = 0; i < count - 1; i++){
            for(int j = 0; j < count - 1 -i; j++){
                if(students[j].getAvg() < students[j+1].getAvg()){
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
    }
    public void sortNameAZ(){
        for(int i = 0; i < count -1 ; i++){
            int min = i;
            for(int j= i+1; j < count; j++){
                if(students[j].getFullName().compareToIgnoreCase(students[min].getFullName()) < 0){
                    min =j;
                }
            }
            Student temp = students[i];
            students[i] = students[min];
            students[min] = temp;
        }
    }
    public void statitics(){
        if(count == 0){
            System.out.println("Danh sách rỗng");
            return;
        }
        int gioi = 0, kha = 0, trung_binh = 0, yeu = 0;
        Student max = students[0], min = students[0];
        double sum = 0;
        for(int i = 0; i < count; i++){
            double avg = students[i].getAvg();
            sum += avg;
            if(avg > max.getAvg()) {
                max = students[i];
            }
            if(avg < min.getAvg()) {
                min = students[i];
            }
            String r = students[i].getRank();
            if(r == null) r = "Yếu";

            switch (r){
                case "Giỏi": gioi++; break;
                case "Khá": kha++; break;
                case "Trung bình": trung_binh++; break;
                default: yeu++;
            }
        }
        System.out.println("Giỏi: " + gioi);
        System.out.println("Khá: " + kha);
        System.out.println("TB: " + trung_binh);
        System.out.println("Yếu: " + yeu);
        System.out.printf("Điểm TB: %.2f\n", sum/count);
        System.out.println("SV điểm cao:");
        max.display();
        System.out.println("SV điểm thấp:");
        min.display();
    }
}
