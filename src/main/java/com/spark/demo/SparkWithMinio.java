package com.spark.demo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class SparkWithMinio {
	
	public static void main(String[] args) {
		  SparkConf conf = new SparkConf()
	                .setAppName("SparkMinIOExample")
	                .setMaster("local[*]")
	                .set("spark.hadoop.fs.s3a.endpoint", "http://localhost:9000")
	                .set("spark.hadoop.fs.s3a.access.key", "test")
	                .set("spark.hadoop.fs.s3a.secret.key", "test1234")
	                .set("spark.hadoop.fs.s3a.path.style.access", "true")
	                .set("spark.hadoop.fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")

	                // Configure Spark event log directory to MinIO
	                .set("spark.eventLog.enabled", "true")
	                .set("spark.eventLog.dir", "s3a://spark-logs/eventLogs/")

	                // Configure Spark scratchpad (temporary dir) on MinIO
	                .set("spark.local.dir", "s3a://spark-logs/scratchpad/");

	                // Configure Spark jar binaries location
	                //.set("spark.jars", "s3a://spark-logs/jars/your-jar-file.jar");
		  
		  SparkSession sparkSession = SparkSession.builder().config(conf).getOrCreate();
		  
		  JavaSparkContext sc = new JavaSparkContext(sparkSession.sparkContext());
		  
		  sc.parallelize(java.util.Arrays.asList("Minio Spark Java", "Apache Spark with Minio", "Java spark job"))
          .flatMap(s -> java.util.Arrays.asList(s.split(" ")).iterator())
          .mapToPair(word -> new scala.Tuple2<>(word, 1))
          .reduceByKey(Integer::sum)
          .foreach(tuple -> System.out.println(tuple._1 + ": " + tuple._2));
	}

}
