package com.lld.design.linkedin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Education {
	
	private String school;
    private String degree;
    private String fieldOfStudy;
    private String startDate;
    private String endDate;

}
