package spring.boot.week8day4relationex.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.week8day4relationex.Model.Course;
import spring.boot.week8day4relationex.Service.CourseService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get/all")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Added course successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course, @PathVariable Integer id) {
        courseService.updateCourse(course, id);
        return ResponseEntity.status(200).body("Update course successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Deleted course successfully");
    }

    @GetMapping("/getTeacherName/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }
}
