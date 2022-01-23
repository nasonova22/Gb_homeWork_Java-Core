package com.company;

public class Member_team {
    private String name_m;
    private int possibil;
    private boolean success;


    public Member_team(String name_m, int possibil, boolean success) {
        this.name_m = name_m;
        this.possibil = possibil;
        this.success = success;
    }

    @ Override
    public String toString() {
        return "Участник " + name_m + "  Макс. высота прыжка: " + possibil + " Преодолел полосу - " + success;
    }

    //проверка успешности преодоления каждого препятствия
    public boolean changeSuccses (int dist ){
        if (this.possibil >= dist){
            this.success=true;
            return true;
        } else {
            this.success=false;
            return false;
        }
    }
    public  boolean successMember() {
       return this.success;
    }
 }
