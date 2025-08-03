package com.spark.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;

public class RepeatThresholdDemo {
	private static final int BASE_THRESHOLD = 10;
	private static final int STEP = 10;

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().appName("Threshold Trigger Pipeline").master("local[*]")
				.getOrCreate();

		// Sample data: Replace this with actual data loading
		Dataset<Row> callData = spark.read().json("path_to_cdr_input.json");

		// callData schema: user_id, call_count
		JavaRDD<Row> rowRDD = callData.javaRDD();

		// Simulate fetching last triggered thresholds from a store
		Map<String, Integer> lastTriggeredMap = getLastTriggeredThresholds();

		// Process data and generate alerts
		JavaRDD<Row> alertRows = rowRDD.filter(row -> {
			String userId = row.getAs("user_id");
			int callCount = row.getAs("call_count");

			int lastThreshold = lastTriggeredMap.getOrDefault(userId, BASE_THRESHOLD);
			int currentBlock = callCount / STEP;
			int lastBlock = lastThreshold / STEP;

			// Only trigger if we moved into a new threshold block
			return callCount > BASE_THRESHOLD && currentBlock > lastBlock;
		}).map(row -> {
			String userId = row.getAs("user_id");
			int callCount = row.getAs("call_count");

			// Simulate updating the last triggered map (persist in real systems)
			int newThreshold = (callCount / STEP) * STEP;
			updateLastTriggeredThreshold(userId, newThreshold);

			// Return the alert row (can be saved or sent to alerting system)
			return RowFactory.create(userId, callCount, "ALERT_TRIGGERED");
		});

		// Define output schema for alerts
		StructType schema = new StructType().add("user_id", "string").add("call_count", "integer").add("alert_status",
				"string");
		Dataset<Row> alertDF = spark.createDataFrame(alertRows, schema);
		// Output: Save alerts or publish
		alertDF.show(); // or alertDF.write().format(...).save(...);
		spark.stop();
	}

	// Dummy function to simulate reading from DB/state store
	private static Map<String, Integer> getLastTriggeredThresholds() {
		Map<String, Integer> map = new HashMap<>();
		map.put("user_001", 10); // already triggered once
		map.put("user_002", 20); // triggered twice
		return map;
	}

	// Dummy function to simulate updating threshold back to DB
	private static void updateLastTriggeredThreshold(String userId, int newThreshold) {
		System.out.printf("Updating threshold for %s to %d%n", userId, newThreshold);
		// persist to DB or Redis here
	}
}
