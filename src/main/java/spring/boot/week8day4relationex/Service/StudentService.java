package spring.boot.week8day4relationex.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.week8day4relationex.API.ApiException;
import spring.boot.week8day4relationex.Model.Course;
import spring.boot.week8day4relationex.Model.Student;
import spring.boot.week8day4relationex.Repository.CourseRepository;
import spring.boot.week8day4relationex.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student, Integer id) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("Student not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());

        studentRepository.save(student1);
    }

    public void deleteStudent(Integer id) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student1);
    }

    public void assignStudentToCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentById(studentId);
        Course course = courseRepository.findCourseById(courseId);
        if (student == null || course == null) {
            throw new ApiException("Can't assign ");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeStudentMajor(Integer studentId, String newMajor) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        student.setMajor(newMajor);
//        student.getCourses().clear(); ما تشتغل مادري ليه 
        for (Course course : student.getCourses()) {
            course.getStudents().remove(student);
        }
        studentRepository.save(student);
    }

    public List<Student> getStudentsByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        return new ArrayList<>(course.getStudents());
    }
}
