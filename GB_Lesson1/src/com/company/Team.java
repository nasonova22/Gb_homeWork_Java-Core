package com.company;

public class Team {
    private String name_team;
    private Member_team [] members ;


    public Team(String name_team, Member_team [] members) {
        this.name_team = name_team;
        this.members =  members;
    }

    // вывод информации обо всех членах команды
    public void infoTeams () {
        System.out.println("Команда - "+ name_team);
        for (int i=0; i<=3; i++)
        System.out.println(members[i]);
    }

    // вывод информации об успешных членах команды
    public void showResults () {
        System.out.println("Преодолели полосу препятствий - ");
        for (int i = 0; i <= 3; i++)
            if (members[i].successMember())
                System.out.println(members[i]);
    }
 }
