import java.util.*;
public class Warehouse_Product_Frequency_Manager {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in); int n=sc.nextInt(); HashMap<Integer,Integer> map=new HashMap<>();
  for(int i=0;i<n;i++){int id=sc.nextInt(); map.put(id,map.getOrDefault(id,0)+1);}
  int maxId=Integer.MAX_VALUE,maxFreq=0;
  for(Map.Entry<Integer,Integer> e:map.entrySet()){int id=e.getKey(),f=e.getValue(); if(f>maxFreq||(f==maxFreq&&id<maxId)){maxFreq=f;maxId=id;}}
  System.out.println(maxId+" "+maxFreq);
 }
}