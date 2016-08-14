package buffalo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author TheMonsterOfTheDeep
 */
public class Buffalo {
    
    static int counter = 0;
    
    static String getBuffalo(int level) {
        if(level == 0) {
            counter = 1;
            return "Buffalo buffalo";
        }
        String tmp;
        String ret = (tmp = getBuffalo(level - 1)) + " " + tmp + " buffalo";
        counter *= 2;
        return ret;
    }
    
    static String getBuffaloString(int level) {
        String tmp;
        return (tmp = getBuffalo(level)) + " buffalo " + tmp + ".";
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iterations = args.length > 0 ? Integer.parseInt(args[0]) : 23;
        try {
            FileOutputStream file = new FileOutputStream("buffalo.txt");
            file.write(getBuffaloString(iterations).getBytes());
        } catch(IOException e) { }
        counter *= 2;
        System.out.println("There exist at least " + counter + " unique buffalo.");
    }
    
}
