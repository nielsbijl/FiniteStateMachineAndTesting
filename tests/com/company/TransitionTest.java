package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TransitionTest {

    @Test
    public void getWeight() {
        ArrayList<Transition> transitions = new ArrayList<>();
        Node node = new Node("ID1", transitions);

        Transition transition = new Transition(0.5, node, node);
        assertEquals(java.util.Optional.of(0.5), transition.getWeight());
    }

    @Test
    public void getStart() {
        ArrayList<Transition> transitions = new ArrayList<>();
        Node node = new Node("ID1", transitions);

        Transition transition = new Transition(0.5, node, node);
        assertEquals(node, transition.getStart());
    }

    @Test
    public void getEnd() {
        ArrayList<Transition> transitions = new ArrayList<>();
        Node node = new Node("ID1", transitions);

        Transition transition = new Transition(0.5, node, node);
        assertEquals(node, transition.getEnd());
    }

    @Test
    public void getReadable() {
        ArrayList<Transition> transitions = new ArrayList<>();
        Node node = new Node("ID1", transitions);

        Transition transition = new Transition("R", node, node);
        assertEquals("R", transition.getReadable());
    }
}