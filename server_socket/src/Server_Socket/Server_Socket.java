package Server_Socket;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import org.json.JSONObject;
public class Server_Socket {
    private static Thread th_close;                
    private static int serverport = 5050;
    private static ServerSocket serverSocket;    
    private static ArrayList<Socket> socketlist=new ArrayList<Socket>();
    
    private static int MAXARRAYSIZE = 200;
    private static String[] userlist = new String[MAXARRAYSIZE];
    private static int user_size = 0;
    
    private static String LOGIN_REQUEST = "bG9naW5fcmVxdWVzdA==";
    private static String SAVE_REQUEST = "c2F2ZV9yZXF1ZXN0";
    
    public static void main(String[] args){
    	
    	renew_userlist();
    	
    	
        try {
            serverSocket = new ServerSocket(serverport);    
            System.out.println("Server is runnning...");
            th_close=new Thread(Judge_Close);                
            th_close.start();                                
            
            while (!serverSocket.isClosed()) {
                
                waitNewSocket();
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    private static Runnable Judge_Close=new Runnable(){    
        @Override
        public void run() {                                
            
            try {
                while(true){
                    Thread.sleep(2000);                    
                    for(Socket close:socketlist){
                        if(isServerClose(close))        
                            socketlist.remove(close);
                    }
                }
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }
    };
    private static Boolean isServerClose(Socket socket){    
        try{  
            socket.sendUrgentData(0);        
            return false;                    
        }catch(Exception e){
            return true;                      
        }  
    }  
    
    public static void waitNewSocket() {
        try {
            Socket socket = serverSocket.accept();
            
            createNewThread(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void createNewThread(final Socket socket) {
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    
                    socketlist.add(socket);
                    
                    BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
                    
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String tmp;
                    JSONObject json_read,json_write;
                    
                    
                    
                    if(socket.isConnected()) {
                        tmp = br.readLine();

                        //client request login
                        if( tmp.compareTo(LOGIN_REQUEST) == 0){
                        	String username = br.readLine();;
                        	System.out.println("User login: " + username);
                        	
                        	boolean flag = false;
                        	for(int i=0; i<user_size; i=i+1)
                        		if( username.compareTo(userlist[i]) == 0)
                        			flag = true;

                        	if(flag){
                        		BufferedReader 	reader = null;
                        		String temp_data;
                        		
                        		try{
                        			reader = new BufferedReader(new FileReader(".\\src\\user_data\\" + username));
                        			temp_data = reader.readLine();
                                    bw.write(temp_data); bw.newLine();
                                    bw.flush();
                            	} catch (Exception e) {
                                    e.printStackTrace();
                            	} finally {
                                    try { if (reader!=null) reader.close(); } catch (Exception e) {}
                                }
                        		
                        	}
                        	else{
                                bw.write(""); bw.newLine();
                                bw.flush();

                        	}
                        	System.out.println("User login completed: " + username);
                        }
                        
                        // client request save
                        else if( tmp.compareTo(SAVE_REQUEST) == 0){
                        	String username = br.readLine();               	
                        	System.out.println("User data saved: " + username);
                        	
                        	boolean flag = false;
                        	for(int i=0; i<user_size; i=i+1)
                        		if( tmp.compareTo(userlist[i]) == 0)
                        			flag = true;
                        	
                        	if(flag){
                        		// save this user's data
                        		String tempJSON = br.readLine();
                        		BufferedWriter 	writer = null;
                        		try{
                        			writer = new BufferedWriter(new FileWriter(".\\src\\user_data\\" + username));
                        			writer.write(tempJSON); writer.newLine();
                        			writer.flush();
                        		} catch (Exception e) {
                                    e.printStackTrace();
                            	} finally {
                                    try { if (writer!=null) writer.close(); } catch (Exception e) {}
                                }
                        		
                        		
                        	}
                        	else{
                        		BufferedWriter 	writer = null;
                        		//add this user to userlist
                        		try{
                        			writer = new BufferedWriter(new FileWriter(".\\src\\user_list\\user.txt",true));
                        			writer.write(username); writer.newLine();
                        			writer.flush();
                        		} catch (Exception e) {
                                    e.printStackTrace();
                            	} finally {
                                    try { if (writer!=null) writer.close(); } catch (Exception e) {}
                                }
                        		
                        		renew_userlist();
                        		
                        		// save this user's data
                        		String tempJSON = br.readLine();
                        		try{
                        			writer = new BufferedWriter(new FileWriter(".\\src\\user_data\\" + username));
                        			writer.write(tempJSON); writer.newLine();
                        			writer.flush();
                        		} catch (Exception e) {
                                    e.printStackTrace();
                            	} finally {
                                    try { if (writer!=null) writer.close(); } catch (Exception e) {}
                                }	
                        	}
                        	
                        	System.out.println("User save completed: " + username);
                        	
                        }
                        
                        socketlist.remove(socket);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                	}  
            }
        });
        
        t.start();
    }
    
    
    public static void renew_userlist(){
    	
    	BufferedReader 	reader = null;
    	user_size = 0;
    	try{
    		reader = new BufferedReader(new FileReader(".\\src\\user_list\\user.txt"));
    		String line;
    	    while ((line=reader.readLine()) != null){	    	
    	    	userlist[user_size] = line;
    	    	user_size = user_size + 1;
    	    }
    	} catch (Exception e) {
            e.printStackTrace();
    	} finally {
            try { if (reader!=null) reader.close(); } catch (Exception e) {}
        }
    }
}