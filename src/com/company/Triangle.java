package com.company;

import java.sql.Array;
import java.util.*;

public class Triangle {

    public  List<ArrayList<String>> edgesTriangle=new LinkedList<>();
    public HashMap<ArrayList<String>,String> decidePossibilities=new HashMap<>();

    public Triangle()
    {
        intianlize();

    }
    void intianlize()
    {
        List<String> str= new ArrayList<String>();
        //v1v2v3
        str.add("v1v2");
        str.add("v1v3");
        str.add("v2v3");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();

        str=new ArrayList<>();
        //v1v2v4
        str.add("v1v2");
        str.add("v2v4");
        str.add("v1v4");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v1v2v5
        str.add("v1v2");
        str.add("v1v5");
        str.add("v2v5");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
       // str.clear();
        str=new ArrayList<>();
        //v1v2v6
        str.add("v1v2");
        str.add("v1v6");
        str.add("v2v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v1v3v4
        str.add("v1v3");
        str.add("v1v4");
        str.add("v3v4");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
       // str.clear();
        str=new ArrayList<>();
        //v1v3v5
        str.add("v1v3");
        str.add("v1v5");
        str.add("v3v5");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
       // str.clear();
        str=new ArrayList<>();
        //v1v3v6
        str.add("v1v3");
        str.add("v1v6");
        str.add("v3v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v1v4v5
        str.add("v1v4");
        str.add("v1v5");
        str.add("v4v5");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v1v4v6
        str.add("v1v4");
        str.add("v1v6");
        str.add("v4v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v1v5v6

        str.add("v1v5");
        str.add("v1v6");
        str.add("v5v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
       // str.clear();
        str=new ArrayList<>();
        //v2v3v4

        str.add("v2v3");
        str.add("v2v4");
        str.add("v3v4");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v2v3v5

        str.add("v2v3");
        str.add("v2v5");
        str.add("v3v5");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v2v3v6

        str.add("v2v3");
        str.add("v2v6");
        str.add("v3v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
       // str.clear();
        str=new ArrayList<>();
        //v2v4v5

        str.add("v2v4");
        str.add("v4v5");
        str.add("v2v5");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
       // str.clear();
        str=new ArrayList<>();
        //v2v4v6

        str.add("v2v4");
        str.add("v2v6");
        str.add("v4v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v2v5v6

        str.add("v2v5");
        str.add("v5v6");
        str.add("v2v6");

        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");


      // str.clear();
        str=new ArrayList<>();

        //v3v4v5

        str.add("v3v4");
        str.add("v4v5");
        str.add("v3v5");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v3v4v6
        str.add("v3v4");
        str.add("v4v6");
        str.add("v3v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
      //  str.clear();
        str=new ArrayList<>();
        //v3v5v6
        str.add("v3v5");
        str.add("v5v6");
        str.add("v3v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
       // str.clear();
        str=new ArrayList<>();
        //v4v5v6
        str.add("v4v5");
        str.add("v5v6");
        str.add("v4v6");
        edgesTriangle.add((ArrayList<String>) str);
        decidePossibilities.put((ArrayList<String>) str,"yes");
     //   str.clear();
       // System.out.println(edgesTriangle.contains(str));

    }

    void display()
    {

        System.out.println(edgesTriangle.size());
        for (ArrayList<String> st:edgesTriangle)
        {
            for(String ms:st)
            {
                System.out.print(ms+"\t");
            }
            System.out.println();
        }
    }
    boolean isTriangle(ArrayList<String> edges)
    {
       // int count[]=new int[20];
        HashSet<String> str2=new HashSet<>(edges);
        HashSet<String> str1;


       for( ArrayList<String> temp: edgesTriangle)
       {


           str1=new HashSet<String>(temp);

              if(str1.equals(str2))
                   return true;
              else if(is_Subset(str1,str2))
               {

                   return true;


               }

       }
       return false;
    }
    public boolean is_Subset(HashSet<String> triSet, HashSet<String> actualSet)
    {
        int count=0;
        for(String temp:triSet)
        {
            if(actualSet.contains(temp))
            {
                count++;
            }

        }
        if(count==3)
        {
            count=0;
            return true;
        }
        return false;

    }
    public String best_Edge(ArrayList<String> actualEdge,HashSet<String> explored) {
        int count[] = new int[20];
        HashSet<String> ActualSet = new HashSet<>(actualEdge);
        for (int i = 0; i < edgesTriangle.size(); i++) {
            HashSet<String> temp = new HashSet<>(edgesTriangle.get(i));
            for (String ms : temp) {
                if (ActualSet.contains(ms) && !explored.contains(ms)) {
                    count[i]++;
                }
                //here i add new stretegy
                if(explored.contains(ms))
                {
                    decidePossibilities.put(new ArrayList<String>(temp),"no");
                }

            }

        }
      /*  for(int i=0;i<20;i++)
        {
            System.out.println(i+" "+count[i]);
        }
        System.out.println(index);*/
        ArrayList<String> temp=new ArrayList<>();
   //   while(true) {

          int index = getindex(count);
          temp = edgesTriangle.get(index);
        /*  if(decidePossibilities.get(temp)=="yes")
          {
              break;
          }
      }*/




       // System.out.println(temp);
        for (String bestEdge:temp)
        {
            if(!ActualSet.contains(bestEdge))
            {
                return bestEdge;
            }
        }

        return new String("");
    }
    public int getindex(int temp[])
        {
            int max=temp[0];
            int ret=0;
            for(int i=0;i<temp.length;i++)
            {
                if(temp[i]>max && decidePossibilities.get(edgesTriangle.get(i))=="yes")
                {
                    max=temp[i] ;
                    ret=i;
                }
            }
            return ret;

        }

}
