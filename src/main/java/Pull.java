import org.zeromq.ZMQ;

public class Pull {
    public static void main(String[] args) throws Exception {
        ZMQ.Context ctx = ZMQ.context(1);
        ZMQ.Socket puller = ctx.socket(ZMQ.PULL);
        puller.connect("tcp://*:12344");
        byte[] buf = puller.recv();
        System.out.println(new String(buf));
        ctx.close();
    }
}