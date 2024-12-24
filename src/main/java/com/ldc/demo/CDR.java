package com.ldc.demo;

import java.time.LocalDateTime;

public class CDR {

	private String correlationId;
	private LocalDateTime timestamp;
	private long duration;
	private String ldcIndicator;

	// leg values
	private String initialValue;
	private String intermediateValue;
	private String endValue;

	public CDR(String correlationId, LocalDateTime timestamp, long duration) {
		this.correlationId = correlationId;
		this.timestamp = timestamp;
		this.duration = duration;
		this.ldcIndicator = "0";
		this.initialValue = null;
		this.intermediateValue = null;
		this.endValue = null;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getLdcIndicator() {
		return ldcIndicator;
	}

	public void setLdcIndicator(String ldcIndicator) {
		this.ldcIndicator = ldcIndicator;
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

}
