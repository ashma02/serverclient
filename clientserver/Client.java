import java.net.*;
import java.io.*;
import java.util.Scanner;

 class Client{
 	public static void main(String[] args){
 		try{
 			Scanner scan = new Scanner(System.in);

 		Socket s = new Socket("localhost",4000);
          
           DataOutputStream dout = new DataOutputStream(s.getOutputStream());
         DataInputStream din = new DataInputStream(s.getInputStream());



 		while(true){
 		 System.out.println("type a msg...");
        String msg = scan.nextLine();

        
          dout.writeUTF(msg);
          if(msg.equals("bye")){
          	break;
          	
          }

        
          String reply = (String)din.readUTF();
          System.out.println("server replies"+ reply);
        }
         s.close();
         dout.close();
         din.close();
      

 		}catch(Exception e){
			System.out.println("error");
			
		}

 	}
 }