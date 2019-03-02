package com.company;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class FirstQuestionManually {

    public static HashSet<String> totalEdge;


    public static void main(String[] args)
    {
        totalEdge=new HashSet<>();
        HashSet<String> exploredEdge=new HashSet<>();
        HashSet<String> blueEdge=new HashSet<>();
        HashSet<String> redEdge=new HashSet<>();

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

        System.out.println("Here it is two player Game:\n Player A and Player B \n player A will have Blue Color edge and Player B will have Red Color edge");
        System.out.println("List of unexplored edges: ");
        displayEdges(totalEdge);
    //    displayEdges();
       // System.out.println(getRandom());
      /*  String str=getRandom();
        System.out.println(str);
        totalEdge.remove(str);
        displayEdges();*/
        String turnColor="Blue";
        Triangle tr=new Triangle();
        int A_win=0,B_win=0,no_win=0;
        while(true)
        {
            System.out.println("------------------------ "+turnColor+" turns ----------------------------------------");


            System.out.println("Write edge from list  or write EXIT for exit ");
            displayEdges(totalEdge);
            Scanner sc=new Scanner(System.in);
            String str=sc.next();
            if(str.length()>4)
                System.out.println("not valid input please write e.g.v1v2");
            if(str.equals("EXIT"))
                break;
            if(turnColor=="Blue")
            {
                blueEdge.add(str);
                turnColor="Red";
                if(tr.isTriangle(new ArrayList<>(blueEdge)))
                {
                    System.out.println("Woah!! Player A(Blue) made Unicolor Triangle");
                    displayEdges(blueEdge);
                    A_win++;
                    break;
                }

            }
            else
            {
                redEdge.add(str);
                turnColor="Blue";
                if(tr.isTriangle(new ArrayList<>(redEdge)))
                {
                    System.out.println("hurrey!! Player B(Red) made Unicolor Triangle");
                    displayEdges(blueEdge);
                    B_win++;
                    break;

                }
            }

            totalEdge.remove(str);
            if(totalEdge.size()==0)
            {
                System.out.println("Ooops!! None of player made unicolor Triangle");
                break;
            }

        }
        System.out.println("Number of Game won by PLayer A :"+A_win);
        System.out.println("Number of Game won by PLayer B :"+B_win);
        System.out.println("Number of Game won by  Neither A or B  :"+B_win);

       /* list=new ArrayList<>();
    /*    for(edges ed:edges.values())
        {
            //list.add(ed.toString());


        }
      //  displayEdges();





      list.add("v2v6");

        list.add("v2v4");
       list.add("v5v6");
        list.add("v4v6");
        list.add("v3v4");
        list.add("v1v3");
        list.add("v4v5");



        Triangle tr= new Triangle();
      //  tr.display();

      //  System.out.println(tr.isTriangle(list));
        System.out.println(tr.best_Edge(list));*/






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
