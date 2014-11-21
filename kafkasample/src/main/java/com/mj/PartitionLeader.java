package com.mj;

import kafka.javaapi.PartitionMetadata;
import kafka.javaapi.TopicMetadata;
import kafka.javaapi.TopicMetadataRequest;
import kafka.javaapi.consumer.SimpleConsumer;

import java.util.Collections;
import java.util.List;

/**
 * Created by mkhangaonkar on 11/19/14.
 */
public class PartitionLeader {

  public PartitionLeader() {


  }

  public void printLeader() {

    SimpleConsumer consumer = new SimpleConsumer("localhost", 9092, 100000, 64 * 1024, "leaderLookup");

    List<String> topics = Collections.singletonList("mjtopic");
    TopicMetadataRequest req = new TopicMetadataRequest(topics);

    kafka.javaapi.TopicMetadataResponse resp = consumer.send(req);

    List<TopicMetadata> metaData = resp.topicsMetadata();

    int[] leaders = new int[12] ;

    for (TopicMetadata item : metaData) {
      for (PartitionMetadata part : item.partitionsMetadata()) {

          // System.out.println("partition " + part.partitionId()) ;
          // System.out.println("Leader :" + part.leader().id() + " " + part.leader().host()) ;
          leaders[part.partitionId()] = part.leader().id() ;


      }
    }

    for (int j = 0 ; j < 12 ; j++) {

      System.out.println("Leader for partition " + j + " " + leaders[j]) ;

    }

  }

  public static void main(String[] args) {

    PartitionLeader leader = new PartitionLeader() ;

    leader.printLeader() ;

  }

}
