package HN_K24_CNTT1_LaThePhong;
import java.util.Scanner;

public class Main {
    static Student[] students = new Student[100];
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiện thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo học lực");
            System.out.println("4. Sắp xếp theo học lực giảm dần");
            System.out.println("5. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    inputStudents(sc);
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    break;
                case 4:
                    sortBub();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (choice != 5);
    }
    public static void inputStudents(Scanner sc) {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên thứ " + (i + 1));
            String id;
            while (true) {
                System.out.print("Nhập mã sv: ");
                id = sc.nextLine();

                if (id.startsWith("SV") && id.length() == 5) {
                    String num = id.substring(2);
                    if (num.matches("\\d{3}")) {
                        break;
                    }
                }
            }
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("Nhập điểm tb: ");
            double score = sc.nextDouble();
            sc.nextLine();
            students[count++] = new Student(id, name, score);
        }
    }
    public static void displayStudent() {
        if (count == 0) {
            System.out.println("Chưa có sinh viên");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
    public static void sortBub() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[i].getScore() < students[j].getScore()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
}
