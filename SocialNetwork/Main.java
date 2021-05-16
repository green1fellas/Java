package SocialNetwork;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Network network = new Network();

        while(true){
            System.out.println("What is your name?");
            Account acc1 = new Account(sc.next(), 0);
            network.vertices.add(0, new LinkedList<>());
            network.vertices.get(0).addFirst(acc1);

            while(true){

                System.out.println("Type in friend name and weight (1-100)");
                network.addEdge(network, acc1, new Account(sc.next(), sc.nextInt()));

                System.out.println("Add more friends?");
                if(sc.next().toLowerCase().equals("no"))
                    break;

            }

            System.out.println("Create another account?");
            if(sc.next().toLowerCase().equals("no"))
                break;

        }
        System.out.println("What number of people can attend event?");
        network.findCompatibility(network, sc.nextInt());
    }
}

//        Account scott = new Account("Scott", 0);
//        network.vertices.add(0, new LinkedList<>());
//        network.vertices.get(0).addFirst(scott);
//
//        network.addEdge(network, scott, new Account("Emma", 10));
//        network.addEdge(network, scott, new Account("Bren", 8));
//        network.addEdge(network, scott, new Account("Will", 5));
//        network.addEdge(network, scott, new Account("Fuck", 2));
//
//        Account emma = new Account("Emma", 0);
//        network.vertices.add(0, new LinkedList<>());
//        network.vertices.get(0).addFirst(emma);
//
//        network.addEdge(network, emma, new Account("Scott", 9));
//        network.addEdge(network, emma, new Account("Bren", 9));
//        network.addEdge(network, emma, new Account("Will", 7));
//        network.addEdge(network, emma, new Account("Fuck", 1));
//
//        Account bren = new Account("Bren", 0);
//        network.vertices.add(0, new LinkedList<>());
//        network.vertices.get(0).addFirst(bren);
//
//        network.addEdge(network, bren, new Account("Scott", 10));
//        network.addEdge(network, bren, new Account("Emma", 8));
//        network.addEdge(network, bren, new Account("Will", 8));
//        network.addEdge(network, bren, new Account("Fuck", 2));
//
//        Account will = new Account("Will", 0);
//        network.vertices.add(0, new LinkedList<>());
//        network.vertices.get(0).addFirst(will);
//
//        network.addEdge(network, will, new Account("Scott", 7));
//        network.addEdge(network, will, new Account("Bren", 10));
//        network.addEdge(network, will, new Account("Emma", 7));
//        network.addEdge(network, will, new Account("Fuck", 4));
//
//        Account fuck = new Account("Fuck", 0);
//        network.vertices.add(0, new LinkedList<>());
//        network.vertices.get(0).addFirst(fuck);
//
//        network.addEdge(network, fuck, new Account("Scott", 10));
//        network.addEdge(network, fuck, new Account("Bren", 10));
//        network.addEdge(network, fuck, new Account("Will", 5));
//        network.addEdge(network, fuck, new Account("Emma", 3));
//        network.addEdge(network, fuck, new Account("Extra", 10));
//
//        Account extra = new Account("Extra", 0);
//        network.vertices.add(0, new LinkedList<>());
//        network.vertices.get(0).addFirst(extra);
//
//        network.addEdge(network, extra, new Account("Scott", 10));
//        network.addEdge(network, extra, new Account("Bren", 10));
//        network.addEdge(network, extra, new Account("Will", 10));
//        network.addEdge(network, extra, new Account("Emma", 10));
//        network.addEdge(network, extra, new Account("Fuck", 10));
