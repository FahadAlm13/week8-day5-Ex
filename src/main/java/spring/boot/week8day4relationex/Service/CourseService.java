package spring.boot.week8day4relationex.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.week8day4relationex.API.ApiException;
import spring.boot.week8day4relationex.Model.Course;
import spring.boot.week8day4relationex.Repository.CourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course, Integer id) {
        Course updateCourse = courseRepository.findCourseById(id);
        if (updateCourse == null) {
            throw new ApiException("Course not found");
        }
        updateCourse.setName(course.getName());
        courseRepository.save(updateCourse);
    }

    public void deleteCourse(Integer id) {
        Course deleteCourse = courseRepository.findCourseById(id);
        if (deleteCourse == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(deleteCourse);
    }

    public String getTeacherName(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        if (course.getTeacher() == null) {
            throw new ApiException("Teacher not found in this course");
        }
        return course.getTeacher().getName();
    }
}
