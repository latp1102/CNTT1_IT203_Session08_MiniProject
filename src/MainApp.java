import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager(100);
        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====\n");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Sắp xếp sinh viên theo điểm tb");
            System.out.println("6. Sắp xếp sinh viên theo tên");
            System.out.println("7. Thống kê");
            System.out.println("0. Thoát chương trình");
            System.out.println("Nhập lựa chọn cua bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Mã sv: ");
                    String id = sc.nextLine();
                    System.out.print("Họ tên");
                    String fullName = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Giới tính: ");
                    String gender = sc.nextLine();
                    System.out.print("Toán: ");
                    double math = Double.parseDouble(sc.nextLine());
                    System.out.print("Lý: ");
                    double physics = Double.parseDouble(sc.nextLine());
                    System.out.print("Hóa: ");
                    double chemistry= Double.parseDouble(sc.nextLine());
                    if(manager.addStudent(new Student(id, fullName, age, gender, math, physics, chemistry))){
                        System.out.println("Thêm thành công");
                    }else {
                        System.out.println("Thêm thất bại");
                    }
                    break;
                case 2:
                    manager.displays();
                    break;
                case 3:
                    System.out.print("Nhập tên cần tìm");
                    manager.findByName(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhập mã sv xóa: ");
                    manager.deleteById(sc.nextLine());
                    break;
                case 5:
                    manager.sortAvg();
                    manager.displays();
                    break;
                case 6:
                    manager.sortNameAZ();
                    manager.displays();
                    break;
                case 7:
                    manager.statitics();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }while (choice != 0);
    }
}
