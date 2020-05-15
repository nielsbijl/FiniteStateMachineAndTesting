package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n--------------------------------");
        System.out.println("Finite State Machine Chance Base");
        System.out.println("Finite State Machine Chance Base");
        System.out.println("--------------------------------\n");

        //Create a dice with 8 eyes
        FSMchance fsmChance = new FSMchance();
        //A dice with 8 eyes has 7 middel nodes
        ArrayList<Node> middleNodes = fsmChance.createNodes(7);
        //A dice with 8 eyes has 8 outputs
        ArrayList<String> outputs = new ArrayList<>();
        outputs.add("One");
        outputs.add("Two");
        outputs.add("Three");
        outputs.add("four");
        outputs.add("Five");
        outputs.add("Six");
        outputs.add("Seven");
        outputs.add("eight");
        //A dice with 8 eyes has 8 end nodes
        ArrayList<Node> endNodes = fsmChance.createEndNodes(outputs);
        //A total of 15 nodes
        ArrayList<Node> allNodes = fsmChance.createListOfAllTheNodes(middleNodes, endNodes);
        //A total of 15 nodes has 4 layers because every node splits into 2 new nodes
        ArrayList<ArrayList<Node>> layers = fsmChance.createLayersOfTheNodes(2, allNodes);
        //The 15 nodes has a total of 14 transitions
        ArrayList<Transition> allTransitions = fsmChance.createTransitionsNodeToNodeWithWeight(layers, 2);
        System.out.println("Amount of transitions: " + allTransitions.size());
        //Every transition has a start node and an end node
        System.out.println("Printing start/end node of every transition.....");
        for (Transition trans : allTransitions){
            System.out.println(trans.getStart().getId() + "  " + trans.getEnd().getId());
        }
        //Giving every node his transitions (in this case every middle node has 2 transitions, the end node doesn't have any)
        fsmChance.addTransitionsToNodes(allNodes, allTransitions);
        System.out.println("\nRolling the dice.......");
        System.out.println("The output of the dice is: " + fsmChance.rollDice(layers.get(0).get(0)));

        System.out.println("\n--------------------------------");
        System.out.println("Finite State Machine Text Base");
        System.out.println("Finite State Machine Text Base");
        System.out.println("--------------------------------\n");


        //Final State Machine Text Based
        // Create the Final State Machine
        FSMtext fsm = new FSMtext();
        // Create ArrayList with the input of the text machine
        ArrayList<String> input = new ArrayList<>();

        //Create Nodes
        ArrayList<Node> fsmTextNodes = fsm.createNodes(4);


        // Create Transmissions
        ArrayList<Transition> fsmTransitionsTextReadBased = new ArrayList<>();
        Transition s0s1 = new Transition("B", fsmTextNodes.get(0), fsmTextNodes.get(1));
        Transition s0s2 = new Transition("A", fsmTextNodes.get(0), fsmTextNodes.get(2));
        Transition s1s2 = new Transition("B", fsmTextNodes.get(1), fsmTextNodes.get(2));
        Transition s2s3 = new Transition("B", fsmTextNodes.get(2), fsmTextNodes.get(3));
        Transition s3s0 = new Transition("B", fsmTextNodes.get(3), fsmTextNodes.get(0));
        Transition s1s1 = new Transition("A", fsmTextNodes.get(1), fsmTextNodes.get(1));
        Transition s3s3 = new Transition("A", fsmTextNodes.get(3), fsmTextNodes.get(3));
        Collections.addAll(fsmTransitionsTextReadBased, s0s1, s0s2, s1s2, s2s3, s3s0, s1s1, s3s3);

        // Add transmissions to nodes
        fsm.addTransitionsToNodes(fsmTextNodes, fsmTransitionsTextReadBased);

        // Test error
        System.out.println("Testing the error......");
        input.add("A");
        input.add("A");
        input.add("B");
        System.out.println(fsm.runReadTextFSM(input, fsmTextNodes.get(0)));

        // Test happy flow
        System.out.println("Testing the happyflow.......");
        input.clear();
        input.add("B");
        input.add("A");
        input.add("B");
        input.add("B");
        input.add("A");
        input.add("B");
        System.out.println(fsm.runReadTextFSM(input, fsmTextNodes.get(0)));
    }
}
