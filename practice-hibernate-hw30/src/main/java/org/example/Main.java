package org.example;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hillel-persistence-unit");
        StudentDaoImpl studentDao = new StudentDaoImpl(emf);

        Student student = new Student("Kyrylo", "Shirkov", "sirkovkirill@gmail.com");
        studentDao.save(student);
        System.out.println("Student added: " + student);

        Homework homework = new Homework("Java HW", LocalDate.of(2025, 5, 24), 100);
        student.addHomework(homework);
        studentDao.save(student);
        System.out.println("Homework added: " + homework);

        Student foundStudent = studentDao.findById(student.getId());
        System.out.println("Student for ID: " + foundStudent);

        foundStudent.setLastName("Shyrkov");
        studentDao.update(foundStudent);
        System.out.println("Student data updated: " + studentDao.findById(foundStudent.getId()));

        boolean deleted = studentDao.deleteById(foundStudent.getId());
        System.out.println("Deleted: " + deleted);

        System.out.println("Students after deletion:");
        studentDao.findAll().forEach(System.out::println);

        emf.close();
    }
}