import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain{
    static int portNumber = 1234;

    public static void main(String[]args) {      

        Logger log = new Logger();

        log.log("INFO", "server_main", "Starting Server");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e){
            // non si apre se la porta e gia utilizzata o la porta e riservata
            e.printStackTrace();
        }

        Socket clienSocket = null;
        try {
            // wait fino a che un client si connette
            clienSocket = serverSocket.accept();
            log.log("INFO", clienSocket.getLocalSocketAddress().toString(), "New connection");
        } catch (IOException e){
            e.printStackTrace();
        }

        BufferedReader in = null;

        try{
            in = new BufferedReader(
                new InputStreamReader(clienSocket.getInputStream())
            );
        } catch (IOException e){
            e.printStackTrace();
        }
        
        String s = "";
        try {
            while ((s = in.readLine()) != null) {
                if (s.equals("exit")){
                    break;
                }
                log.log("DATA", clienSocket.getLocalSocketAddress().toString(), s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}