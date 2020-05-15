package com.company;

public class Transition {
    private String readable;
    private Double weight;
    private final Node start;
    private Node end;
    public Transition(Double weight, Node start, Node end){
        this.weight = weight;
        this.start = start;
        this.end = end;
    }
    public Transition(String readable, Node start, Node end){
        this.readable = readable;
        this.start = start;
        this.end = end;
    }
    public Double getWeight(){
        return this.weight;
    }
    public Node getStart(){
        return this.start;
    }
    public Node getEnd(){
        return this.end;
    }
    public String getReadable(){return this.readable;}
}
