import org.zeromq.ZMQ;
public class Sub
{

    public static void main(String[] args)
    {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5563");
        subscriber.subscribe("B".getBytes(ZMQ.CHARSET));

        while (!Thread.currentThread().isInterrupted()) {
            String address = subscriber.recvStr();
            String contents = subscriber.recvStr();
            System.out.println(address + " : " + contents);

        }
    }
}