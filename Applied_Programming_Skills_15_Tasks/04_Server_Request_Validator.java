import java.util.*;
public class Server_Request_Validator {
 public static void main(String[] args){Scanner sc=new Scanner(System.in);String s=sc.nextLine();Stack<Character> st=new Stack<>();for(char c:s.toCharArray()){if(c=='('||c=='['||c=='{'||c=='<')st.push(c);else{if(st.isEmpty()){System.out.println("INVALID");return;}char t=st.pop();if((c==')'&&t!='(')||(c==']'&&t!='[')||(c=='}'&&t!='{')||(c=='>'&&t!='<')){System.out.println("INVALID");return;}}}System.out.println(st.isEmpty()?"VALID":"INVALID");}
}