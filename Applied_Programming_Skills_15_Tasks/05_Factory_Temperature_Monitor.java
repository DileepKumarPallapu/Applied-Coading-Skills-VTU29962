import java.util.*;
public class Factory_Temperature_Monitor {
 public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();int[] a=new int[n],r=new int[n];Arrays.fill(r,-1);Stack<Integer> st=new Stack<>();for(int i=n-1;i>=0;i--){a[i]=a[i];}for(int i=n-1;i>=0;i--){while(!st.isEmpty()&&st.peek()<=a[i])st.pop();if(!st.isEmpty())r[i]=st.peek();st.push(a[i]);}for(int i=0;i<n;i++){System.out.print(r[i]);if(i<n-1)System.out.print(" ");}}
}