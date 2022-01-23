package com.company;

public class Course {
     private int [] arr_course;

    public Course(int[] arr_course) {
        this.arr_course = arr_course;
    }
    @ Override
    public String toString() {
        return "Барьеры  " + arr_course[0]+ " "+ arr_course[1]+ " "+ arr_course[2];
    }
    // проверяем возможность участника преодолеть полосу препятствий
    // если не преодолел, меняем результат на false
    public void doIt (Team t, Member_team [] members){
        int i,j;
        for (j=0; j<4; j++) {
            for (i = 0; i < 3; i++) {
                if (!(members[j].changeSuccses(arr_course[i]))) {
                    break;
                }
            }
        }
    }
}

