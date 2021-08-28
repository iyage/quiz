package com.example.wkquizapp.Repository;

import com.example.wkquizapp.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Long> {
    List<CourseModel>findCourseModelByTeacherId(Long id);
    List<CourseModel> findCourseModelByStudentsId(Long id);
}
