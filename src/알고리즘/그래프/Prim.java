package 알고리즘.그래프;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {
    public ArrayList<PrimEdge> primFunc(String startNode, ArrayList<PrimEdge> primEdges) {
        PrimEdge currentPrimEdge;
        ArrayList<PrimEdge> currentPrimEdgeList;

        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<PrimEdge> mst = new ArrayList<>();
        HashMap<String, ArrayList<PrimEdge>> adjacentPrimEdges = new HashMap<>();

        for (int index = 0; index < primEdges.size(); index++) {
            currentPrimEdge = primEdges.get(index);
            if (!adjacentPrimEdges.containsKey(currentPrimEdge.node1)) {
                adjacentPrimEdges.put(currentPrimEdge.node1, new ArrayList<>());
            }
            if (!adjacentPrimEdges.containsKey(currentPrimEdge.node2)) {
                adjacentPrimEdges.put(currentPrimEdge.node2, new ArrayList<>());
            }
        }

        for (int index = 0; index < primEdges.size(); index++) {
            currentPrimEdge = primEdges.get(index);
            currentPrimEdgeList = adjacentPrimEdges.get(currentPrimEdge.node1);
            currentPrimEdgeList.add(new PrimEdge(currentPrimEdge.weight, currentPrimEdge.node1, currentPrimEdge.node2));
            currentPrimEdgeList = adjacentPrimEdges.get(currentPrimEdge.node2);
            currentPrimEdgeList.add(new PrimEdge(currentPrimEdge.weight, currentPrimEdge.node2, currentPrimEdge.node1));
        }

        connectedNodes.add(startNode);
        ArrayList<PrimEdge> candidatePrimEdgeList = adjacentPrimEdges.getOrDefault(startNode, new ArrayList<>());
        PriorityQueue<PrimEdge> priorityQueue = new PriorityQueue<>();
        for (int index = 0; index < candidatePrimEdgeList.size(); index++) {
            priorityQueue.add(candidatePrimEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            PrimEdge poppedPrimEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedPrimEdge.node2)) {
                // 해당 PrimEdge 를 mst 에 추가
                connectedNodes.add(poppedPrimEdge.node2);
                mst.add(new PrimEdge(poppedPrimEdge.weight, poppedPrimEdge.node1, poppedPrimEdge.node2));

                ArrayList<PrimEdge> adjacentPrimEdgeNodes = adjacentPrimEdges.getOrDefault(poppedPrimEdge.node2, new ArrayList<>());
                for (int index = 0; index < adjacentPrimEdgeNodes.size(); index++) {
                    PrimEdge adjacentPrimEdgeNode = adjacentPrimEdgeNodes.get(index);
                    if(!connectedNodes.contains(adjacentPrimEdgeNode.node2)) {
                        priorityQueue.add(adjacentPrimEdgeNode);
                    }
                }
            }
        }
        return mst;

    }

    public ArrayList<PrimEdge> primFunc2(String startNode, ArrayList<PrimEdge> primEdges) {
        ArrayList<PrimEdge> mst = new ArrayList<>();
        ArrayList<String> connectedNodes = new ArrayList<>();
        HashMap<String, ArrayList<PrimEdge>> adjacentEdges = new HashMap<>();

        for(PrimEdge edge : primEdges) {
            if(!adjacentEdges.containsKey(edge.node1)) {
                adjacentEdges.put(edge.node1, new ArrayList<>());
            }

            if(!adjacentEdges.containsKey(edge.node2)) {
                adjacentEdges.put(edge.node2, new ArrayList<>());
            }
        }

        for(PrimEdge edge : primEdges){
            ArrayList<PrimEdge> edges = adjacentEdges.get(edge.node1);
            edges.add(new PrimEdge(edge.weight, edge.node1, edge.node2));

            edges = adjacentEdges.get(edge.node2);
            edges.add(new PrimEdge(edge.weight, edge.node2, edge.node1));
        }

        connectedNodes.add(startNode);
        PriorityQueue<PrimEdge> priorityQueue = new PriorityQueue<>();

        for(PrimEdge edge : adjacentEdges.getOrDefault(startNode, new ArrayList<>())) {
            priorityQueue.add(edge);
        }

        while(priorityQueue.size() > 0) {
            PrimEdge edge = priorityQueue.poll();
            if(!connectedNodes.contains(edge.node2)) {
                connectedNodes.add(edge.node2);
                mst.add(edge);

                for(PrimEdge edge1 : adjacentEdges.getOrDefault(edge.node2, new ArrayList<>())) {
                    if(!connectedNodes.contains(edge1.node2)) {
                        priorityQueue.add(edge1);
                    }
                }
            }
        }

        return mst;
    }
    
    public static void main(String[] args) {
        ArrayList<PrimEdge> primEdges = new ArrayList<>();
        primEdges.add(new PrimEdge(7, "A", "B"));
        primEdges.add(new PrimEdge(5, "A", "D"));
        primEdges.add(new PrimEdge(8, "B", "C"));
        primEdges.add(new PrimEdge(9, "B", "D"));
        primEdges.add(new PrimEdge(7, "D", "E"));
        primEdges.add(new PrimEdge(5, "C", "E"));
        primEdges.add(new PrimEdge(7, "B", "E"));
        primEdges.add(new PrimEdge(6, "D", "F"));
        primEdges.add(new PrimEdge(8, "E", "F"));
        primEdges.add(new PrimEdge(9, "E", "G"));
        primEdges.add(new PrimEdge(11, "F", "G"));

        Prim prim = new Prim();
        System.out.println(prim.primFunc2("A", primEdges));
    }
}
