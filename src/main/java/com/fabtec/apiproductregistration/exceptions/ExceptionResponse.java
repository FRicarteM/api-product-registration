package com.fabtec.apiproductregistration.exceptions;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {
	
private static final long serialVersionUID = 8486068814491095598L;
	
	private String title;
	private String timestamp;
	private String message;
	private int status;
	private String details;
	
	public ExceptionResponse(String title, String timestamp, String message, int status, String details) {
		this.title = title;
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.details = details;
	}
	public String getTitle() {
		return title;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public int getStatus() {
		return status;
	}
	public String getDetails() {
		return details;
	}
	
	public static ExceptionResponseBuilder builder() {
		return new ExceptionResponseBuilder();
	}
	
	public static class ExceptionResponseBuilder {
		
		private String title;
		private String timestamp;
		private String message;
		private int status;
		private String details;
		
		public ExceptionResponseBuilder() {
			
		}
		
		public ExceptionResponseBuilder title (String title) {
			this.title = title;
			return this;
		}

		public ExceptionResponseBuilder timestamp (String timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public ExceptionResponseBuilder message (String message) {
			this.message = message;
			return this;
		}

		public ExceptionResponseBuilder status (int status) {
			this.status = status;
			return this;
		}

		public ExceptionResponseBuilder details (String details) {
			this.details = details;
			return this;
		}
		
		public ExceptionResponse build() {
			return new ExceptionResponse(title,
								timestamp,
								message,
								status,
								details);
		}
		
	}
}
