package com.company;

import java.util.ArrayList;

public class FSMtext extends FSM {
    //Returns the nodes(states) the machine has been
    public ArrayList<String> runReadTextFSM(ArrayList<String> ABstring, Node startNode){
        ArrayList<String> nodeLocations = new ArrayList<String>();
        nodeLocations.add(startNode.getId());
        Node currentNode = startNode;
        for (String character : ABstring) {
            Boolean error = true;
            for (Transition possibleTransition : (currentNode.getTransitions())) {
                if ( possibleTransition.getReadable() == character){
                    currentNode = possibleTransition.getEnd();
                    nodeLocations.add(currentNode.getId());
                    error = false;
                    break;
                }
            }
            if (error == true){
                System.out.println("There went something wrong with node: " + currentNode.getId());
                return null;
            }
        }
        return nodeLocations;
    }
}
