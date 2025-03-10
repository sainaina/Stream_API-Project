package coursemanagement.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;
    private String title;
    private String[] getInstructorName;
    private String[] getRequirements;
    private LocalDate startDate;

    public String[] getRequirements() {
        return new String[0];
    }

    public String[] getInstructorNames() {
        return new String[0];
    }
}