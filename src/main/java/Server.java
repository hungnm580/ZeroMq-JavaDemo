import java.io.PrintWriter;
import java.io.StringWriter;
import org.zeromq.ZMQ;

public class Server {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.REP);
        socket.bind ("tcp://*:5555");
        try {
            while (!Thread.currentThread ().isInterrupted ()) {
                byte[] reply = socket.recv(0);
                System.out.println("Received Hello");
                String request = "World" ;
                socket.send(request.getBytes (), 0);
                Thread.sleep(1000); // Do some 'work'
            }
        } catch(Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println(sw.toString());
        }
        socket.close();
        context.term();

    }

}