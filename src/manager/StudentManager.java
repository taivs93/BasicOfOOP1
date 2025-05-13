package manager;

import entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentManager {
    private final List<Student> studentList = new ArrayList<>();
    public void addStudent(Student student){
        Optional<Student> existedStudent = findStudentById(student.getId());
        if(existedStudent.isEmpty()) {
            studentList.add(student);
            System.out.println("Thêm sinh viên thành công.");
            return;
        }
        System.out.println("ID sinh viên đã tồn tại.");
    }
    public void updateStudent(Student student){
        Optional<Student> existedStudent = findStudentById(student.getId());
        if (existedStudent.isEmpty()) {
            System.out.println("Không tìm thấy ID sinh viên");
            return;
        }
        existedStudent.get().setName(student.getName());
        existedStudent.get().setDateOfBirth(student.getDateOfBirth());
        existedStudent.get().setgPA(student.getgPA());
        System.out.println("Cập nhât thông tin sinh viên thành công");
    }
    public void deleteStudent(String studentId){
        Optional<Student> existedStudent = findStudentById(studentId);
        if (existedStudent.isEmpty()) {
            System.out.println("Không tìm thấy ID sinh viên");
            return;
        }
        studentList.remove(existedStudent.get());
        System.out.println("Xóa sinh viên thành công");
    }
    private Optional<Student> findStudentById(String studentId) {
        return studentList.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst();
    }
    public void getStudentById(String studentId){
        Optional<Student> existedStudent = findStudentById(studentId);
        if (existedStudent.isEmpty()) {
            System.out.println("Không tìm thấy ID sinh viên");
            return;
        }
        System.out.println(existedStudent.get());
    }
    public void getStudentsByName(String inputName){
        List<Student> studentsWithInputName = studentList.stream().filter(student -> student.getName().contains(inputName)).toList();
        if (studentsWithInputName.isEmpty()) System.out.println("Không tìm thấy sinh viên thỏa mãn");
        else studentsWithInputName.forEach(System.out::println);
    }
    public void sortStudentListByName(){
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println("Đã sắp xếp các sinh viên theo tên");
    }
    public void sortStudentListByGPA(){
        studentList.sort(Comparator.comparing(Student::getgPA));
        System.out.println("Đã sắp xếp các sinh viên theo điểm trung bình");
    }
    public void printStudentList() {
        String format = "| %-10s | %-20s | %-15s | %-5s |\n";
        System.out.printf(format, "ID", "NAME", "DATE OF BIRTH", "GPA");
        studentList.forEach(student -> {
            System.out.printf(format,
                    student.getId(),
                    student.getName(),
                    student.getDateOfBirth(),
                    student.getgPA());
        });
    }
}
