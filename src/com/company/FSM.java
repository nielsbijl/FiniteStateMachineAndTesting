package com.company;

import java.util.ArrayList;

abstract class FSM {
    public ArrayList<Node> createNodes(int amount) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            ArrayList<Transition> transitions = new ArrayList<>(i);
            Node n = new Node(("node" + i), transitions);
            nodes.add(n);
        }
        return nodes;
    }
    public void addTransitionsToNodes(ArrayList<Node> allNodes, ArrayList<Transition> allTransitions){
        ArrayList<Node> allNodesWithItsTransitions = new ArrayList<>();
        for (Node node: allNodes){
            for (Transition transition : allTransitions){
                if (node == transition.getStart()){
                    node.addTransition(transition);
                }
            }
        }
    }
}
