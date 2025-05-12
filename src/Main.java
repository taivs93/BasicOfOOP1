import entity.Student;
import manager.StudentManager;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager studentManager = new StudentManager();
    public static void main(String[] args) {
        boolean isInUsed = true;
        Student student;
        String id;
        String name;
        while(isInUsed){
            menu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    student = inputStudent();
                    studentManager.addStudent(student);
                    break;
                case 2:
                    student = inputStudent();
                    studentManager.updateStudent(student);
                    break;
                case 3:
                    System.out.print("Nhập ID: ");
                    id = scanner.next();
                    studentManager.deleteStudent(id);
                    break;
                case 4:
                    System.out.print("Nhập ID: ");
                    id = scanner.next();
                    studentManager.getStudentById(id);
                    break;
                case 5:
                    System.out.print("Nhập tên: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    studentManager.getStudentsByName(name);
                    break;
                case 6:
                    studentManager.sortStudentListByName();
                    break;
                case 7:
                    studentManager.sortStudentListByGPA();
                    break;
                case 8:
                    studentManager.printStudentList();
                    break;
                case 9:
                    isInUsed = false;
                    break;
            }
        }


    }
    private static void menu(){
        System.out.println("Menu");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Sửa thông tin sinh viên");
        System.out.println("3. Xóa sinh viên");
        System.out.println("4. Tìm kiếm sinh viên theo mã số");
        System.out.println("5. Tìm kiếm sinh viên theo tên");
        System.out.println("6. Sắp xếp sinh viên theo tên");
        System.out.println("7. Sắp xếp sinh viên theo điểm trung bình");
        System.out.println("8. In ra danh sách sinh viên");
        System.out.println("9. Thoát");
        System.out.print("Lựa chọn: ");
    }
    private static Student inputStudent(){
        Student student = new Student();
        System.out.print("Nhập ID: ");
        student.setId(scanner.next());
        scanner.nextLine();
        System.out.print("Nhập tên: ");
        student.setName(scanner.nextLine());
        System.out.print("Nhập ngày sinh: ");
        student.setDateOfBirth(scanner.next());
        System.out.print("Nhập điểm: ");
        student.setgPA(scanner.nextDouble());
        return student;
    }
}