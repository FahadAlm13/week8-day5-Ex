package spring.boot.week8day4relationex.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.week8day4relationex.API.ApiException;
import spring.boot.week8day4relationex.Model.Teacher;
import spring.boot.week8day4relationex.Repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher, Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null) {
            throw new ApiException("Teacher not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setSalary(teacher.getSalary());

        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher1);
    }

    public Teacher getTeacherByDetails(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher1;
    }
}
