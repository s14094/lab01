package pl.pawellakomiec.domain;

import pl.pawellakomiec.domain.System;

import java.util.*;

public class Transmiter {

    private int id;
    private String name;
    private String input;
    private String output;
    private String fm;
    private int price;
    private int power;
    private System system;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getFm() {
        return fm;
    }

    public void setFm(String fm) {
        this.fm = fm;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }


    /*
    private List<System> transmiter;

    public List<System> getTransmiter() {
        return transmiter;
    }

    public void setTransmiter(List<System> transmiter) {
        this.transmiter = transmiter;
    }
    */
}

