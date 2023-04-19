import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime; 

public class ClientMain {

    private static PrintWriter out;
    private static BufferedReader in;
    private static String clientName;

    private static Socket setup(String hostName, int portNumber) {
        Socket kkSocket = null;
        try {
            kkSocket = new Socket(hostName, portNumber);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }

        try {
            out = new PrintWriter(kkSocket.getOutputStream(), true);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        try{
            in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return kkSocket;
    }

    static void readFromNetwork(BufferedReader in){
        String s = "";
        while (true){
            
        }

    }

    static void sendDate(){
        Thread th = new Thread(
            () -> {
                while (true) {
                    LocalDateTime now = LocalDateTime.now();
                    String msg = now.toString();
                    out.println(clientName + " - " +msg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
        th.start();
    }
    public static void main(String[]args){
        Logger log = new Logger();

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        clientName = args[2];

        log.log("INFO", "client_main", "Starting Client " + clientName + "... host -> " + hostName + " port -> " + portNumber);
        
        Socket kkSocket = setup(hostName, portNumber);

        sendDate();
        
    }    
}
