import org.zeromq.ZMQ;

public class Push{
    public static void main(String[] args) throws Exception {
        ZMQ.Context ctx = ZMQ.context(1);
        ZMQ.Socket pusher = ctx.socket(ZMQ.PUSH);
        pusher.bind("tcp://*:12344");
        pusher.send("PING".getBytes());
        ctx.close();
    }
}