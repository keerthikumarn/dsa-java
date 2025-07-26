package com.lld.design.linkedin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Experience {

	private String title;
    private String company;
    private String startDate;
    private String endDate;
    private String description;
}
