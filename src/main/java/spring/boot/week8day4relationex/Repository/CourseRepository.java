package spring.boot.week8day4relationex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.week8day4relationex.Model.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
}
