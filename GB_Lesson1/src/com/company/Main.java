package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] arr_c ={105, 90,80};
        Course course = new Course (arr_c);
        Member_team [] members = new Member_team[4];
        members [0] = new Member_team("player1",110,false);
        members [1] = new Member_team("player2",80,false);
        members [2] = new Member_team("player3",90,false);
        members [3] = new Member_team("player4",120,false);
        Team team = new Team("dream Team", members);
        team.infoTeams();
        System.out.println(course);
        course.doIt (team, members);
        team.showResults();
       }
}
