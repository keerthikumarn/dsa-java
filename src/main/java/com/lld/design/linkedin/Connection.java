package com.lld.design.linkedin;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Connection {
	
	private User user;
	private Timestamp timestamp;

}
