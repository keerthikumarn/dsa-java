package com.spark.demo;

import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import scala.collection.JavaConverters;

public class SparkWithMinio {

	public static void main(String[] args) {

		boolean useCustomConfig = false;

		SparkConf conf = new SparkConf().setAppName("SparkMinIOExample").setMaster("local[*]")
				.set("spark.hadoop.fs.s3a.endpoint", "http://localhost:9000")
				.set("spark.hadoop.fs.s3a.access.key", "keerthi").set("spark.hadoop.fs.s3a.secret.key", "keerthi123")
				.set("spark.hadoop.fs.s3a.path.style.access", "true")
				.set("spark.hadoop.fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")

				// Configure Spark event log directory to MinIO
				.set("spark.eventLog.enabled", "true").set("spark.eventLog.dir", "s3a://spark-logs/eventLogs/")

				// Configure Spark scratchpad (temporary dir) on MinIO
				.set("spark.local.dir", "s3a://spark-logs/scratchpad/");
		if (useCustomConfig) {
			// make use of custom configration entries
			conf.set("spark.checkpoint.compress", "true").set("spark.dynamicAllocation.enabled", "true")
					.set("spark.driver.memory", "2g").set("spark.executor.memory", "4g").set("spark.cores.max", "4")
					.set("spark.driver.memoryOverhead", "512m").set("spark.default.parallelism", "8");
		} else {
			// use the default resources available from the node/machine
			int availableCores = Runtime.getRuntime().availableProcessors();
			long availableMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024);
			
			conf.set("spark.executor.memory", (availableMemory / 2) + "m")
            .set("spark.driver.memory", (availableMemory / 4) + "m")
            .set("spark.cores.max", String.valueOf(availableCores));
		}

		SparkSession sparkSession = SparkSession.builder().config(conf).getOrCreate();

		System.out.println("Default Spark Configuration Parameters:");
		for (Map.Entry<String, String> entry : JavaConverters.mapAsJavaMapConverter(sparkSession.conf().getAll())
				.asJava().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		JavaSparkContext sc = new JavaSparkContext(sparkSession.sparkContext());

		sc.parallelize(java.util.Arrays.asList("Minio Spark Java", "Apache Spark with Minio", "Java spark job"))
				.flatMap(s -> java.util.Arrays.asList(s.split(" ")).iterator())
				.mapToPair(word -> new scala.Tuple2<>(word, 1)).reduceByKey(Integer::sum)
				.foreach(tuple -> System.out.println(tuple._1 + ": " + tuple._2));
	}

}
