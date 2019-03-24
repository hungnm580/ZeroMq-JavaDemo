import org.zeromq.ZMQ;

public class Pub
{

    public static void main(String[] args) throws Exception
    {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        publisher.bind("tcp://*:5563");
        while (!Thread.currentThread().isInterrupted()) {
            publisher.sendMore("A");
            publisher.send("Hello, world!");
        }
    }
}