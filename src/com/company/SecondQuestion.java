package com.company;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SecondQuestion {

    public static HashSet<String> totalEdge;
    public static HashSet<String> explored;
    public static HashSet<String> blueEdge;
    public static HashSet<String> redEdge;
    public static ArrayList<ArrayList<String>> BlueTriangle;
    public static void main(String[] args) throws InterruptedException {

        totalEdge=new HashSet<>();
        explored=new HashSet<>();
        HashSet<String> iteration=new HashSet<>();
        blueEdge=new HashSet<>();
        redEdge=new HashSet<>();
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
        iteration.addAll(totalEdge);
        System.out.println("This is Part B of the Assignment ");
        System.out.println("Here it is two player Game:\n Player A and Player B \n player A will have Blue Color edge and Player B will have Red Color edge");
        System.out.println("List of unexplored edges: ");
        displayEdges(totalEdge);
        String turnColor="Blue";
        String str=getRandom();
        System.out.println(str);
        System.out.println("here Player will find an edge for which player A will definitely win");
        Triangle tr=new Triangle();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of time you want to iterate the Game");
        boolean start=false;
        int count=sc.nextInt();
        if(count>0)
        {
            start=true;
        }
        /*
       System.out.println("------------------------------------ "+ turnColor+ " turn -----------------------------------");
        displayEdges(totalEdge);
        blueEdge.add(str);
        totalEdge.remove(str);
        System.out.println("PLayer A chose : "+ str);
        turnColor="Red";*/
        int first=0;
        int iter=0;
        int A_win=0,B_win=0,no_win=0;




        while(start &&iter<count)
        {
            System.out.println("------------------------------------ "+ turnColor+ " turn -----------------------------------");
            displayEdges(totalEdge);
         //   System.out.println(totalEdge.size());
            if(turnColor=="Blue")
            {
                if(first==0)
                {
                    str=getRandom();
                    first=1;
                }
                else{
                    str=tr.best_Edge(new ArrayList<>(blueEdge),redEdge);
                }
                blueEdge.add(str);
                totalEdge.remove(str);
                explored.add(str);
                System.out.println("PLayer A chose : "+ str);
                if(tr.isTriangle(new ArrayList<>(blueEdge)))
                {
                    System.out.println("Player A win");
                    displayEdges(blueEdge);
                    totalEdge.addAll(iteration);
                   // System.out.println(totalEdge.size());
                    BlueTriangle.add(new ArrayList<>(blueEdge));

                    blueEdge.removeAll(blueEdge);
                    redEdge.removeAll(redEdge);
                    explored.removeAll(explored);
                    first=0;
                    iter++;
                    A_win++;
                    turnColor="Blue";
                  //  break;
                }
                else {
                    turnColor = "Red";
                }

            }
            else
            {
                 str=getRandom();
              //  str=tr.best_Edge(new ArrayList<>(blueEdge));
                redEdge.add(str);
                totalEdge.remove(str);
                explored.add(str);
                System.out.println("PLayer B chose : "+ str);
                if(tr.isTriangle(new ArrayList<>(redEdge)))
                {
                    System.out.println("Player B win");
                    displayEdges(redEdge);
                    redEdge.removeAll(redEdge);
                    blueEdge.removeAll(blueEdge);
                    explored.removeAll(explored);
                    totalEdge.addAll(iteration);
                    System.out.println(totalEdge.size());

                    iter++;
                    B_win++;
                    first=0;
                   // break;

                }
                turnColor="Blue";

            }
            if(totalEdge.size()==0)
            {
                System.out.println("No one Win");
                totalEdge.addAll(iteration);
                no_win++;
                //break;

            }
            TimeUnit.MICROSECONDS.sleep(1);


        }
        System.out.println("Number of time A win : " +A_win);
        System.out.println("Number of Time B win : "+ B_win);
        System.out.println("Number of Time no one  win : "+ no_win);

        System.out.println("Here I am following Player A strategy So, no matter what is opponent's move \n player A will always wins ");
        System.out.println("Number of triangle created :"+ BlueTriangle);





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
        while(true) {
            int size = totalEdge.size();
            int random = new Random().nextInt(size);
            int i = 0;
            for (String str : totalEdge) {
                if (i == random) {
                    if (!explored.contains(str) && !blueEdge.contains(str))
                    {
                        return str;
                    }

                }
                i++;
            }
        }

    }
}
