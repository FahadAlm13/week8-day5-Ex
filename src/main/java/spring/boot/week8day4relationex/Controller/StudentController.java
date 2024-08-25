package spring.boot.week8day4relationex.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.week8day4relationex.Model.Student;
import spring.boot.week8day4relationex.Service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student,@PathVariable Integer id) {
        studentService.updateStudent(student,id);
        return ResponseEntity.status(200).body("Student updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted successfully");
    }
    @PutMapping("/assignStudentToCourse/{studentId}/{courseId}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer studentId,@PathVariable Integer courseId){
        studentService.assignStudentToCourse(studentId,courseId);
        return ResponseEntity.status(200).body("assign successfully");
    }
    @PutMapping("/changeMajor")
    public ResponseEntity changeStudentMajor(@RequestParam Integer studentId, @RequestParam String newMajor) {
        studentService.changeStudentMajor(studentId, newMajor);
        return ResponseEntity.status(200).body("Student major changed and courses dropped successfully");
    }

    @GetMapping("/getStudentsByCourseId/{courseId}")
    public ResponseEntity getStudentsByCourseId(@PathVariable Integer courseId) {
        List<Student> students = studentService.getStudentsByCourseId(courseId);
        return ResponseEntity.status(200).body(students);
    }
}
