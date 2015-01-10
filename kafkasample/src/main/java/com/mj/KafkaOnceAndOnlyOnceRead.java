package com.mj;


import kafka.api.FetchRequestBuilder;
import kafka.api.PartitionOffsetRequestInfo;
import kafka.common.TopicAndPartition;
import kafka.api.FetchRequest;
import kafka.javaapi.FetchResponse;
import kafka.javaapi.OffsetResponse;
import kafka.javaapi.consumer.SimpleConsumer;
import kafka.message.MessageAndOffset;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class KafkaOnceAndOnlyOnceRead {

  public static String clientname = "OnceAndOnlyOnce" ;
  public static String topic = "atopic" ;
  public static int partition = 0 ;

  public static RandomAccessFile readoffset ;

  static {
    try {
      readoffset = new RandomAccessFile("readoffset", "rw");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String args[]) throws Exception {


    SimpleConsumer consumer = new SimpleConsumer("localhost", 9092, 100000, 64 * 1024, clientname);

    long offset_in_partition = 0 ;

    try {
      offset_in_partition = readoffset.readLong();
    } catch(EOFException ef) {
      offset_in_partition = getOffset(consumer,topic,partition,kafka.api.OffsetRequest.EarliestTime(),clientname) ;
    }


    int messages = 0 ;
    while (true) {



      FetchRequest req = new FetchRequestBuilder()
          .clientId(clientname)
          .addFetch(topic, partition, offset_in_partition, 100000) // Note: this fetchSize of 100000 might need to be increased if large batches are written to Kafka
          .build();

      FetchResponse fetchResponse = consumer.fetch(req);

      long numRead = 0;
      for (MessageAndOffset messageAndOffset : fetchResponse.messageSet(topic, partition)) {
        long currentOffset = messageAndOffset.offset();
        if (currentOffset < offset_in_partition) {
          continue;
        }
        offset_in_partition = messageAndOffset.nextOffset();
        ByteBuffer payload = messageAndOffset.message().payload();

        byte[] bytes = new byte[payload.limit()];
        payload.get(bytes);
        System.out.println(String.valueOf(messageAndOffset.offset()) + ": " + new String(bytes, "UTF-8"));
        readoffset.seek(0);
        readoffset.writeLong(offset_in_partition);
        numRead++;
        messages++ ;

        if (messages == 10) {
          System.out.println("Pretend a crash happened") ;
          System.exit(0);
        }
      }

      if (numRead == 0) {
        try {
          System.out.println("No messages read. Sleep 10 secs") ;
          Thread.sleep(10000);
        } catch (InterruptedException ie) {
        }
      }

    }


  }

  public static long getOffset(SimpleConsumer consumer, String topic, int partition, long whichOffset, String clientname ) {

    TopicAndPartition topicAndPartition = new TopicAndPartition(topic, partition);
    Map<TopicAndPartition, PartitionOffsetRequestInfo> requestInfo = new HashMap<TopicAndPartition, PartitionOffsetRequestInfo>();
    requestInfo.put(topicAndPartition, new PartitionOffsetRequestInfo(whichOffset, 1));

    kafka.javaapi.OffsetRequest request = new kafka.javaapi.OffsetRequest(
        requestInfo, kafka.api.OffsetRequest.CurrentVersion(), clientname);
    OffsetResponse response = consumer.getOffsetsBefore(request);

    long[] offsets = response.offsets(topic, partition);
    return offsets[0];

  }

}
