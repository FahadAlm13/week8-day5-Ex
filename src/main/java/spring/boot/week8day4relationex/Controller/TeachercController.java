package spring.boot.week8day4relationex.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.week8day4relationex.Model.Teacher;
import spring.boot.week8day4relationex.Service.TeacherService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeachercController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id) {
        teacherService.updateTeacher(teacher, id);
        return ResponseEntity.status(200).body("Teacher updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted successfully");
    }

    @GetMapping("/getTeacherByDetails/{id}")
    public ResponseEntity getTeacherByDetails(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherByDetails(id));
    }
}
