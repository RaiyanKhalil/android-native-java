package com.example.raiyanmidterm_002;

public class Order {
    double chickenSandwich = 6.99;
    double peanutButter = 6.99;
    double cSoup = 5.99;
    double grilledCheese = 4.99;
    double milk = 0.99;
    double juice = 1.99;
    double soda = 1.35;
    double coffee = 1.35;

    public Order(){

    }

    public Order(double chickenSandwich, double peanutButter, double cSoup, double grilledCheese,
                 double milk, double juice, double soda, double coffee){
        this.chickenSandwich = chickenSandwich;
        this.peanutButter = peanutButter;
        this.cSoup = cSoup;
        this.grilledCheese = grilledCheese;
        this. milk = milk;
        this.juice = juice;
        this.soda = soda;
        this.coffee = coffee;

    }

    public double calculatePrice(double itemOne, double itemTwo) {
        double totalCost = itemOne + itemTwo;

        return totalCost;
//        Double.parseDouble(totalCost)
    }

    public double getChickenSandwich() {
        return chickenSandwich;
    }

    public void setChickenSandwich(double chickenSandwich) {
        this.chickenSandwich = chickenSandwich;
    }

    public double getPeanutButter() {
        return peanutButter;
    }

    public void setPeanutButter(double peanutButter) {
        this.peanutButter = peanutButter;
    }

    public double getcSoup() {
        return cSoup;
    }

    public void setcSoup(double cSoup) {
        this.cSoup = cSoup;
    }

    public double getGrilledCheese() {
        return grilledCheese;
    }

    public void setGrilledCheese(double grilledCheese) {
        this.grilledCheese = grilledCheese;
    }

    public double getMilk() {
        return milk;
    }

    public void setMilk(double milk) {
        this.milk = milk;
    }

    public double getJuice() {
        return juice;
    }

    public void setJuice(double juice) {
        this.juice = juice;
    }

    public double getSoda() {
        return soda;
    }

    public void setSoda(double soda) {
        this.soda = soda;
    }

    public double getCoffee() {
        return coffee;
    }

    public void setCoffee(double coffee) {
        this.coffee = coffee;
    }


}
