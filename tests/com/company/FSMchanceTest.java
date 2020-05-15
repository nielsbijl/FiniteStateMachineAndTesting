package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FSMchanceTest {

    @Test
    public void createEndNodes() {
        ArrayList<String> outputs = new ArrayList<>();
        outputs.add("One");
        outputs.add("Two");
        FSMchance fsmChance = new FSMchance();
        ArrayList<Node> endNodes = fsmChance.createEndNodes(outputs);
        ArrayList<Node> endNodesOutput = new ArrayList<>();
        Node node0 = new Node("node0", "One");
        Node node1 = new Node("node1", "Two");
        endNodesOutput.add(node0);
        endNodesOutput.add(node1);

        assertEquals(endNodesOutput, endNodes);
    }

    @Test
    public void createListOfAllTheNodes() {
        FSMchance fsmChance = new FSMchance();
        ArrayList<Node> listOfAllTheNodes = new ArrayList<>();
        ArrayList<Node> listOfAllTheNodesOutput = new ArrayList<>();
        ArrayList<Node> endNodes1 = new ArrayList<>();
        ArrayList<Node> endNodes2 = new ArrayList<>();
        Node node0 = new Node("node0", "One");
        Node node1 = new Node("node1", "Two");
        endNodes1.add(node0);
        endNodes1.add(node1);
        endNodes2.add(node0);
        endNodes2.add(node1);
        listOfAllTheNodesOutput.add(node0);
        listOfAllTheNodesOutput.add(node1);
        listOfAllTheNodesOutput.add(node0);
        listOfAllTheNodesOutput.add(node1);
        listOfAllTheNodes = fsmChance.createListOfAllTheNodes(endNodes1, endNodes2);

        assertEquals(listOfAllTheNodesOutput, listOfAllTheNodes);

    }

    @Test
    public void createLayersOfTheNodes() {
        FSMchance fsmChance = new FSMchance();
        ArrayList<Node> allNodes = new ArrayList<>();
        ArrayList<Node> layer0 = new ArrayList<>();
        ArrayList<Node> layer1 = new ArrayList<>();
        ArrayList<ArrayList<Node>> layersOutput = new ArrayList<>();
        Node node0 = new Node("node0", "One");
        Node node1 = new Node("node1", "Two");
        allNodes.add(node0);
        allNodes.add(node1);
        allNodes.add(node0);
        ArrayList<ArrayList<Node>> layers = fsmChance.createLayersOfTheNodes(2, allNodes);

        layer0.add(node0);
        layer1.add(node1);
        layer1.add(node0);
        layersOutput.add(layer0);
        layersOutput.add(layer1);

        assertEquals(layersOutput, layers);
    }
}