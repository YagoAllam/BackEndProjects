package it.itfinance.challenge;

import java.time.OffsetDateTime;

public class EventlogRow {
	
	private String processId;
	private String activityName;
	private OffsetDateTime timestamp;
	
	public EventlogRow(String processId, String activityName, OffsetDateTime timestamp) {
		this.processId = processId;
		this.activityName = activityName;
		this.timestamp = timestamp;
	}
	
	public String getProcessId() {
		return processId;
	}

	public String getActivityName() {
		return activityName;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}
	
}
