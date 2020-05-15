package com.company;

import java.util.ArrayList;
import java.util.Random;

public class FSMchance extends FSM {
    public ArrayList<Node> createEndNodes(ArrayList<String> outputs){
        ArrayList<Node> nodes = new ArrayList<>();
        for (String output : outputs) {
            Node n = new Node(("endNode-" + output), output);
            nodes.add(n);
        }
        return nodes;
    }
    public ArrayList<Node> createListOfAllTheNodes(ArrayList<Node> middleNodes, ArrayList<Node> endNodes){
        ArrayList<Node> allNodes = new ArrayList<>();
        for (Node middleNode: middleNodes){
            allNodes.add(middleNode);
        }
        for (Node endNode: endNodes){
            allNodes.add(endNode);
        }
        return allNodes;
    }
    //nodesSplitAmount is the amount of transitions per node
    //Create 2D list of layers of nodes [layer1(node0), layer2(node1, node2), ......]
    public ArrayList<ArrayList<Node>> createLayersOfTheNodes(int nodesSplitAmount, ArrayList<Node> arrayListOfAllTheNodes1D){
        ArrayList<ArrayList<Node>> layerdNodes = new ArrayList<>();
        ArrayList<Node> tempListOfAllNodes1D = new ArrayList<>();
        tempListOfAllNodes1D = (ArrayList<Node>)arrayListOfAllTheNodes1D.clone();
        int layerCounter = 0;
        while (tempListOfAllNodes1D.size() > 0){
            ArrayList<Node> layer = new ArrayList<>(layerCounter);
            int power = (int)Math.pow(nodesSplitAmount, layerCounter);
            for (int i = 0; i < power; i++){
                layer.add(tempListOfAllNodes1D.get(0));
                tempListOfAllNodes1D.remove(0);
            }
            layerdNodes.add(layer);
            layerCounter ++;
        }
        return layerdNodes;
    }
    //Create the Transitions for every node
    // if the transitionAmountEverySingleNode == 2, then it splits every node into 2 transitions
    public ArrayList<Transition> createTransitionsNodeToNodeWithWeight(ArrayList<ArrayList<Node>> rows, int transitionAmountEverySingleNode){
        int rowCounter = 0;
        ArrayList<Transition> transitions = new ArrayList<>();
        for (ArrayList<Node> row: rows) {
            if (row.size() != (int)Math.pow(transitionAmountEverySingleNode, rowCounter)){
                System.out.println("The rows doesn't fit with the transition amount per every single node!!");
                System.out.println("Change the rows or the transitionAmountEverySingleNode");
                return null;
            }
            if (rowCounter != 0){
                ArrayList<Node> rowBefore = rows.get((rowCounter -1));
                ArrayList<Node> currRow = new ArrayList<>();
                currRow = (ArrayList<Node>)row.clone();
                for (Node nodePrefRow: rowBefore) {
                    int nodeTransitionCreateCounter = 0;
                    for (Node nodeCurrRow: currRow) {
                        if (nodeTransitionCreateCounter == transitionAmountEverySingleNode){
                            break;
                        }
                        Transition t = new Transition(0.5, nodePrefRow, nodeCurrRow);
                        transitions.add(t);
                        nodeTransitionCreateCounter += 1;
                    }
                    if (nodeTransitionCreateCounter == transitionAmountEverySingleNode){
                        for (int i = 0; i < transitionAmountEverySingleNode; i++) {
                            currRow.remove(0);
                        }
                    }
                }
            }
            rowCounter += 1;
        }
        return transitions;
    }
    public Transition getRandomElement(ArrayList<Transition> list)
    {
        Random rand = new Random();
        return list.get(new Random().nextInt(list.size()));
    }
    public String rollDice(Node startNode){
        Node currNode = startNode;
        while (true){
            Transition chosenTransition = getRandomElement(currNode.getTransitions());
            if (chosenTransition.getEnd().getOutput() != null){
                return chosenTransition.getEnd().getOutput();
            }
            else {
                currNode = chosenTransition.getEnd();
            }
        }
    }
}
