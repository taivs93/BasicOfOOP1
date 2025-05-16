import entity.Selection;
import entity.Student;
import manager.StudentManager;
import java.util.Scanner;
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
            Selection selection = Selection.getSelectionFromValue(choice);
            switch (selection) {
                case ADD:
                    student = inputStudent();
                    studentManager.addStudent(student);
                    break;
                case UPDATE:
                    student = inputStudent();
                    studentManager.updateStudent(student);
                    break;
                case DELETE:
                    System.out.print("Nhập ID: ");
                    id = scanner.next();
                    studentManager.deleteStudent(id);
                    break;
                case GETBYID:
                    System.out.print("Nhập ID: ");
                    id = scanner.next();
                    studentManager.getStudentById(id);
                    break;
                case GETBYNAME:
                    System.out.print("Nhập tên: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    studentManager.getStudentsByName(name);
                    break;
                case SORTBYNAME:
                    studentManager.sortStudentListByName();
                    break;
                case SORTBYGPA:
                    studentManager.sortStudentListByGPA();
                    break;
                case PRINT:
                    studentManager.printStudentList();
                    break;
                case EXIT:
                    isInUsed = false;
                    break;
            }
        }


    }
    private static void menu(){
        System.out.println("Menu");
        for (Selection selection : Selection.values()){
            System.out.println(selection.getChoice() + " ." + selection.getDescription());
        }
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