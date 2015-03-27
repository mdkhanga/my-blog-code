package com.mj;


import org.apache.kafka.clients.producer.KafkaProducer ;
// import kafka.producer.KeyedMessage;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.Properties;

public class KafkaProducer082 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties props = new Properties();
		 
		// props.put("metadata.broker.list", "host2:9092,host3:9092");
    props.put("bootstrap.servers", "localhost:9092");
		// props.put("serializer.class", "kafka.serializer.StringEncoder");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		// props.put("partitioner.class", "example.producer.SimplePartitioner");
		props.put("request.required.acks", "1");

		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		
		String date = "04092014" ;
		// String topic = "my-replicated-topic" ;
		String topic = "mjtopic" ;
		
		
		for (int i = 1 ; i <= 1000000 ; i++) {
			
			String msg = date + " This is message " + i ;
			System.out.println(msg) ;
			
			ProducerRecord<String, String> data = new ProducerRecord<String, String>(topic, String.valueOf(i), msg);
			 
			producer.send(data);
			
			
		}
		
		producer.close();
		

	}

}
