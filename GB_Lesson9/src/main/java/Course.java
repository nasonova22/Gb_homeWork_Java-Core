import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    String nameCourse;

    public Course(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNameCourse() {
        return this.nameCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "nameCourse='" + nameCourse + '\'' +
                '}';
    }
}
