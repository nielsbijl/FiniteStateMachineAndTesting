package com.company;

import java.util.ArrayList;

public class Node {
    private final String id;
    private ArrayList<Transition> transitions;
    private String output;

    // Constructors
    public Node(String id, ArrayList<Transition> Transitions){
        this.id = id;
        this.transitions = Transitions;
    }
    public Node(String id, String output){
        this.id = id;
        this.output = output;
    }
    public void addTransition(Transition inputTransition){
        try {
            this.transitions.add(inputTransition);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void clearTransition(){
        this.transitions.clear();
    }

    // Get functions
    public String getId(){
        return this.id;
    }
    public ArrayList<Transition> getTransitions(){
        return this.transitions;
    }
    public String getOutput(){
        return this.output;
    }
}
