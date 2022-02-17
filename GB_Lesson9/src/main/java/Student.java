import java.util.ArrayList;
import java.util.List;

public class Student {
    String Name;
    List<String> courses;

    public Student(String name, List<String> courses) {
        Name = name;
        this.courses = courses;
    }

    public String getName() {
        return Name;
    }

    public List<String> getCourses() {
        return this.courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
