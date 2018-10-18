package core;

import java.util.Properties;

import java.io.PrintStream;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
public class Thread  implements Runnable {
    private static KafkaProducer<String, String> producer;
    private static final String TOPIC = "windows";

    public void produce()
    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.1.49.63:9092");
        props.put("acks", "all");
        props.put("retries", Integer.valueOf(0));
        props.put("batch.size", Integer.valueOf(16384));
        props.put("linger.ms", Integer.valueOf(200));
        props.put("buffer.memory", Integer.valueOf(33554432));
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(props);
        AllJsonIndexPick jsonTest = new AllJsonIndexPick();
        String jsonData = jsonTest.getJsonData();
        producer.send(new ProducerRecord("windows", jsonData));
        System.out.println(jsonData);
    }

    public void run()
    {
        Thread thread = new Thread();
        thread.produce();
    }
}
