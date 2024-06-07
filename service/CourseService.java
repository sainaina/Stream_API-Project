package coursemanagement.service;

import coursemanagement.exception.CourseNotFoundException;
import coursemanagement.model.Course;
import java.util.List;

public interface CourseService {
    List<Course> addNewCourse();
    List<Course> listAllCourses();
    Course findCourseById(Integer id) throws CourseNotFoundException;
    Course fineCourseByTitle(String title) throws CourseNotFoundException ;
}