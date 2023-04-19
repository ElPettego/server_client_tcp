import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Logger {
    public static String C_RED     = "\u001B[31m";
    public static String C_GREEN   = "\u001B[32m";
    public static String C_YELLOW  = "\u001B[33m";
    public static String C_BLUE    = "\u001B[34m";
    public static String C_MAGENTA = "\u001B[35m";
    public static String C_CYAN    = "\u001B[36m";
    public static String C_RESET   = "\u001B[0m";

    public static String B_MAGENTA = "\u001B[45m";
    public static String B_GREY    = "\u001B[40m";
    public static String B_CYAN    = "\u001B[46m";
    public static String B_GREEN   = "\u001B[42m";
    public static String B_YELLOW  = "\u001B[43m";

    public Logger(){
    }

    public void log(String level, String agent, String message){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String time = dtf.format(now);
        
        String level_bg = null;

        if (level.equals("INFO")){
            level_bg = B_GREEN;
        } 
        if (level.equals("DATA")){
            level_bg = B_YELLOW;
        } 

        System.out.println(
            B_MAGENTA + C_YELLOW + time + C_RESET + " - " + 
            level_bg + level + C_RESET + " - " + 
            agent + " - " + message);
    }
    
}
