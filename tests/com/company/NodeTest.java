package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void addTransition() {
        ArrayList<Transition> transitions = new ArrayList<>();
        ArrayList<Transition> transitions2 = new ArrayList<>();
        Node node = new Node("ID1", transitions);
        Transition transition = new Transition(0.5, node, node);
        node.addTransition(transition);
        transitions2.add(transition);
        assertEquals(transitions2, node.getTransitions());
    }

    @Test
    public void clearTransition() {
        ArrayList<Transition> transitions = new ArrayList<>();
        ArrayList<Transition> transitions2 = new ArrayList<>();
        Node node = new Node("ID1", transitions);
        Transition transition = new Transition(0.5, node, node);
        node.addTransition(transition);
        node.clearTransition();
        assertEquals(transitions2, node.getTransitions());
    }

    @Test
    public void getId() {
        ArrayList<Transition> transitions = new ArrayList<>();
        Node node = new Node("ID1", transitions);
        assertEquals("ID1", node.getId());
    }

    @Test
    public void getTransitions() {
        ArrayList<Transition> transitions = new ArrayList<>();
        ArrayList<Transition> transitions2 = new ArrayList<>();
        Node node = new Node("ID1", transitions);
        Transition transition = new Transition(0.5, node, node);
        node.addTransition(transition);
        transitions2.add(transition);
        assertEquals(transitions2, node.getTransitions());
    }

    @Test
    public void getOutput() {
        Node node = new Node("ID1", "output");
        assertEquals("output", node.getOutput());
    }
}