package coursemanagement.service;

import coursemanagement.exception.CourseNotFoundException;
import coursemanagement.model.Course;
import coursemanagement.repository.CourseRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {
    private static List<Course> courseList = CourseRepository.allCourse();

    @Override
    public List<Course> addNewCourse() {
        System.out.println("===================================================");
        System.out.print("[+] Insert course ID: ");
        int id = new Scanner(System.in).nextInt();

        System.out.print("[+] Insert course title: ");
        String title = new Scanner(System.in).nextLine();

        System.out.print("[+] Insert instructor name: ");
        String[] instructorNames = new Scanner(System.in).nextLine().split(",");

        System.out.print("[+] Insert course requirements : ");
        String[] requirements = new Scanner(System.in).nextLine().split(",");

        System.out.print("[+] Insert course start date (yyyy-MM-dd): ");
        String dateStr = new Scanner(System.in).nextLine();
        LocalDate startDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Course newCourse = new Course(id, title, instructorNames, requirements, startDate);
        courseList.add(newCourse);

        System.out.println("Add New Course Successfully!");
        return courseList;
    }

    @Override
    public List<Course> listAllCourses() {
        for (courseList:courseList()
    }

    @Override
    public Course findCourseById(Integer id) throws CourseNotFoundException {
        return courseList.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));
    }

    @Override
    public Course fineCourseByTitle(String title) throws CourseNotFoundException {

        return null;
    }



    private void renderCourseTable(List<Course> courses) {
        System.out.println("===================================================");
        System.out.println("Course ID | Course Title | Instructor(s) | Requirements | Start Date");
        System.out.println("===================================================");
        for (Course course : courses) {
            // Handling instructor names
            String[] instructorNamesArray = course.getInstructorNames();
            String instructors = String.join(",", instructorNamesArray);

            // Handling rem8u2quirements
            String[] requirementsArray = course.getRequirements();
            String requirements = String.join(",", requirementsArray);

            System.out.printf("%-10d| %-12s| %-14s| %-12s| %s%n",
                    course.getId(), course.getTitle(),
                    instructors,
                    requirements,
                    course.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        System.out.println("===================================================");
    }

}
