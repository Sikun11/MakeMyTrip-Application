package com.nt.response;

import lombok.Data;

@Data
public class Ticket {

	private Integer tktId;
	private String tktStatus;
	private String trainNum;
	private String name;
	private String dob;
	private String gender;
	private String doj;
	private String source;
	private String destination;
}
