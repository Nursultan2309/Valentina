package com.company.models;

import com.company.exceptions.MaxCountSubsWishes;

public class Subscriber {
    private double id;
    private String phone;
    private boolean isActive;
    private int countWishes;
    public Subscriber(){}
    public Subscriber(String phone){
        this.phone=phone;
        this.id=Math.random();
        this. isActive=false;
        this.countWishes=0;

    }

    public double getId() {
        return id;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCountWishes() {
        return countWishes;
    }

    public void incrementSubsWish() {
        if(countWishes>=2){
throw new MaxCountSubsWishes("Вы достигли максимального кол-во отправок");
        }
        else{
            countWishes++;
        }
    }

}
