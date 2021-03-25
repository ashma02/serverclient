 import java.net.*;
import java.io.*;
import java.util.Scanner;

class Server{
  public static void main (String[] args){
    try{
      Scanner scan = new Scanner(System.in);
      ServerSocket ss = new ServerSocket(4000);
       System.out.println("waiting for client ...");
      Socket s = ss.accept();
       System.out.println("client connected ");

       DataInputStream din = new DataInputStream(s.getInputStream());

               DataOutputStream dout = new DataOutputStream(s.getOutputStream());

       while(true){
         String msg = (String)din.readUTF();
          if(msg.equals("bye")){
            break;
            
          }
               System.out.println("client says="+msg);
 
                 System.out.println("type a reply");
                  String reply = scan.nextLine();
                   dout.writeUTF(reply);
               }
                  ss.close();
                  s.close();
           
                  dout.close();
                  din.close();

    }catch(Exception e){
      System.out.println("error");

    }
  }
}