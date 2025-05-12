package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Student {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private double gPA;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Student() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateTimeFormatter.format(dateOfBirth);
    }

    public void setDateOfBirth(String inputDateOfBirth) {
        this.dateOfBirth = LocalDate.parse(inputDateOfBirth,dateTimeFormatter);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getgPA() {
        return gPA;
    }

    public void setgPA(double gPA) {
        this.gPA = gPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + this.getDateOfBirth() +
                ", gPA=" + gPA +
                '}';
    }
}
