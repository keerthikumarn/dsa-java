package com.ldc.demo;

public class LDCConfiguration {
	
	private String correlationId;
	private String fieldType;
	private String initialValue;
	private String intermediateValue;
	private String endValue;
	private String durationField;
	private String partialRecordCount;
	private String statusField;
	private String stitchedCdrOutput;
	private String timeoutField;
	private long timeoutPeriod;
	private long tolerance;

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}

	public String getIntermediateValue() {
		return intermediateValue;
	}

	public void setIntermediateValue(String intermediateValue) {
		this.intermediateValue = intermediateValue;
	}

	public String getEndValue() {
		return endValue;
	}

	public void setEndValue(String endValue) {
		this.endValue = endValue;
	}

	public String getDurationField() {
		return durationField;
	}

	public void setDurationField(String durationField) {
		this.durationField = durationField;
	}

	public String getPartialRecordCount() {
		return partialRecordCount;
	}

	public void setPartialRecordCount(String partialRecordCount) {
		this.partialRecordCount = partialRecordCount;
	}

	public String getStatusField() {
		return statusField;
	}

	public void setStatusField(String statusField) {
		this.statusField = statusField;
	}

	public String getStitchedCdrOutput() {
		return stitchedCdrOutput;
	}

	public void setStitchedCdrOutput(String stitchedCdrOutput) {
		this.stitchedCdrOutput = stitchedCdrOutput;
	}

	public String getTimeoutField() {
		return timeoutField;
	}

	public void setTimeoutField(String timeoutField) {
		this.timeoutField = timeoutField;
	}

	public long getTimeoutPeriod() {
		return timeoutPeriod;
	}

	public void setTimeoutPeriod(long timeoutPeriod) {
		this.timeoutPeriod = timeoutPeriod;
	}

	public long getTolerance() {
		return tolerance;
	}

	public void setTolerance(long tolerance) {
		this.tolerance = tolerance;
	}
}
