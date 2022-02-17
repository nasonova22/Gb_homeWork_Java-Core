import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Course course1 = new Course("Музыка");
        Course course2 = new Course("Философия");
        Course course3 = new Course("Экономика");
        Course course4 = new Course("Языки");
        Course course5 = new Course("Эстетика");

        Student student1=new Student("Petr",(Arrays.asList(course1.nameCourse,course2.nameCourse,course3.nameCourse)));
        System.out.println(student1);
        Student student2=new Student("Dima",(Arrays.asList(course1.nameCourse,course3.nameCourse,course4.nameCourse, course5.nameCourse)));
        System.out.println(student2);
        Student student3=new Student("Fedor",(Arrays.asList(course1.nameCourse,course2.nameCourse, course4.nameCourse)));
        System.out.println(student3);
        Student student4=new Student("Anna",(Arrays.asList(course1.nameCourse,course2.nameCourse, course4.nameCourse,course5.nameCourse)));
        System.out.println(student4);
        Student student5=new Student("Inna",(Arrays.asList(course2.nameCourse,course4.nameCourse,course5.nameCourse)));
        System.out.println(student5);
        Student student6=new Student("Vera",(Arrays.asList(course4.nameCourse,course5.nameCourse)));
        System.out.println(student6);
        Student student7=new Student("Maria",(Arrays.asList(course1.nameCourse,course2.nameCourse)));
        System.out.println(student7);
        Student student8=new Student("Semen",(Arrays.asList(course3.nameCourse, course4.nameCourse)));
        System.out.println(student8);
        Student student9=new Student("Dina",(Arrays.asList(course3.nameCourse, course4.nameCourse)));
        System.out.println(student9);

        System.out.println();


        // 1.список уникальных курсов, на которые подписаны студенты. Список курсов не повторяется
        ArrayList<Course> listcourse = new ArrayList(Arrays.asList(student1.getCourses(),student2.getCourses(),student3.getCourses(),student4.getCourses(),student5.getCourses(),student6.getCourses(),student7.getCourses(),student8.getCourses(),student9.getCourses()));
        System.out.println(listcourse);
        List <Course > uniqueСourses = listcourse.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueСourses);
        System.out.println();

        // 2.самые любознательные студенты
        List<Student> inquisitiveStudent =new ArrayList(Arrays.asList(student1,student2,student3,student4,student5,student6,student7,student8,student9));
        inquisitiveStudent.stream().sorted((e1,e2)-> (e2.getCourses().size()- e1.getCourses().size()))
                .limit(3)
                .forEach ((e) -> System.out.println(e));

        //3.список студентов, подписанных на курс

        List<Student> courseSubscription =new ArrayList(Arrays.asList(student1,student2,student3,student4,student5,student6,student7,student8,student9));
        courseSubscription.stream().filter((e)-> (e.getCourses().contains(course2.getNameCourse())==true))
                                   .forEach ((e) -> System.out.println(e));


    }
}
