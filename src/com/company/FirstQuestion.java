package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class FirstQuestion {

    public static HashSet<String> totalEdge;
    public static ArrayList<ArrayList<String>> BlueTriangle;
    public static void main(String[] args) throws InterruptedException {
        totalEdge=new HashSet<>();
        HashSet<String> exploredEdge=new HashSet<>();
        HashSet<String> blueEdge=new HashSet<>();
        HashSet<String> redEdge=new HashSet<>();
        BlueTriangle=new ArrayList<>();

        totalEdge.add("v1v2");
        totalEdge.add("v1v3");
        totalEdge.add("v1v4");
        totalEdge.add("v1v5");
        totalEdge.add("v1v6");

        totalEdge.add("v2v3");
        totalEdge.add("v2v4");
        totalEdge.add("v2v5");
        totalEdge.add("v2v6");

        totalEdge.add("v3v4");
        totalEdge.add("v3v5");
        totalEdge.add("v3v6");

        totalEdge.add("v4v5");
        totalEdge.add("v4v6");

        totalEdge.add("v5v6");
        HashSet iteration=new HashSet<>();
        iteration.addAll(totalEdge);
        System.out.println("This is for negation of the game");
        System.out.println("Here it is two player Game:\n Player A and Player B \n player A will have Blue Color edge and Player B will have Red Color edge");
        System.out.println("List of unexplored edges: ");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("This is complete automatic game, it will select edge by itself randomly and negate the strategy");
        System.out.println("Enter the number of time you want to iterate the Game");
        boolean start=false;
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        if(count>0)
        {
            start=true;
        }
        displayEdges(totalEdge);
        String turnColor="Blue";
        Triangle tr=new Triangle();
        int A_win=0,B_win=0,no_win=0;
        int iter=0;
        while(start &&iter<count)
        {
            System.out.println("------------------------ "+turnColor+" turns ----------------------------------------");

            displayEdges(totalEdge);
            String str=getRandom();
            if(turnColor=="Blue")
            {
                blueEdge.add(str);
                System.out.println("Player A chose: "+str);
                turnColor="Red";
                if(tr.isTriangle(new ArrayList<>(blueEdge)))
                {
                    System.out.println("Woah!! Player B(Red) made Unicolor Triangle");
                    displayEdges(blueEdge);
                    B_win++;
                    blueEdge.removeAll(blueEdge);
                    totalEdge.addAll(iteration);
                    BlueTriangle.add(new ArrayList<>(blueEdge));
                    iter++;

                  //
                    // break;
                }

            }
            else
            {
                redEdge.add(str);
                System.out.println("Player A chose: "+str);
                turnColor="Blue";
                if(tr.isTriangle(new ArrayList<>(redEdge)))
                {
                    System.out.println("hurrey!! Player A(Blue) made Unicolor Triangle");
                    displayEdges(blueEdge);
                    BlueTriangle.add(new ArrayList<>(redEdge));
                    A_win++;
                    redEdge.removeAll(redEdge);
                    totalEdge.addAll(iteration);

                    iter++;
                 //  break;

                }
            }

            totalEdge.remove(str);
            if(totalEdge.size()==0)
            {
                System.out.println("Ooops!! None of player made unicolor Triangle");
                totalEdge.addAll(iteration);
                no_win++;
                iter++;
               // break;
            }

            System.out.println("\n\n");
            TimeUnit.MILLISECONDS.sleep(1);

        }
        System.out.println("Number of time A win " +A_win);
        System.out.println("Number of Time B win "+ B_win);
        System.out.println("Number of Time no one  win "+ no_win);
        if(no_win==0)
        {
            System.out.println("SO, no matter How many times game was being played but it will never happened  that game has no winner \n game will have at least one uni-color triangle(Red or Blue)");
        }
        System.out.println("Triangles Created: "+BlueTriangle);


    }
































    public static void displayEdges(HashSet<String> hr)
    {

        for(String s:hr) {
            System.out.print(s+"\t");


        }
        System.out.println("");

    }
    public static String getRandom()
    {
        int size=totalEdge.size();
        int random=new Random().nextInt(size);
        int i=0;
        for(String str:totalEdge)
        {
            if(i==random)
            {
                return str;
            }
            i++;
        }
        return new String();
    }
}

