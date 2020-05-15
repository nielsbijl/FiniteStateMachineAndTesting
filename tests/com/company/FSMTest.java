package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FSMTest {

    @Test
    public void createNodes() {
        FSMtext fsm = new FSMtext();
        ArrayList<Node> nodes = fsm.createNodes(2);

        ArrayList<Node> nodesOutput = new ArrayList<>();
        ArrayList<Transition> transitions0 = new ArrayList<>();
        ArrayList<Transition> transitions1 = new ArrayList<>();
        Node n0 = new Node(("node" + 0), transitions0);
        Node n1 = new Node(("node" + 1), transitions1);
        nodesOutput.add(n0);
        nodesOutput.add(n1);

        assertEquals(nodesOutput, nodes);
    }

    @Test
    public void addTransitionsToNodes() {
        FSMtext fsm = new FSMtext();

        ArrayList<Node> nodesOutput = new ArrayList<>();
        ArrayList<Transition> transitions0 = new ArrayList<>();
        Node n0 = new Node(("node" + 0), transitions0);
        Transition transition0 = new Transition(0.5, n0, n0);
        transitions0.add(transition0);
        fsm.addTransitionsToNodes(nodesOutput,transitions0);
    }
}