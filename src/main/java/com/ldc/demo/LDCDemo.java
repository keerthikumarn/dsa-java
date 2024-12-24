package com.ldc.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LDCDemo {

    public static void main(String[] args) {
        List<CDR> partialCDRs = new ArrayList<>();
        
        // Create CDRs with initial, intermediate, and end values set
        CDR cdr1 = new CDR("call1", LocalDateTime.now().minusMinutes(2), 30);
        cdr1.setInitialValue("Initial");
        cdr1.setIntermediateValue("Intermediate");
        cdr1.setEndValue("End");

        CDR cdr2 = new CDR("call1", LocalDateTime.now().minusMinutes(1), 45);
        cdr2.setInitialValue("Initial");
        cdr2.setIntermediateValue("Intermediate");
        cdr2.setEndValue("End");

        CDR cdr3 = new CDR("call2", LocalDateTime.now().minusMinutes(3), 60);
        cdr3.setInitialValue("Initial");
        cdr3.setIntermediateValue("Intermediate");
        cdr3.setEndValue("End");

        partialCDRs.add(cdr1);
        partialCDRs.add(cdr2);
        partialCDRs.add(cdr3);

        LDCConfiguration config = new LDCConfiguration();
        config.setCorrelationId("call1");
        config.setInitialValue("Initial");
        config.setIntermediateValue("Intermediate");
        config.setEndValue("End");

        LDCStitcher stitcher = new LDCStitcher();
        List<CDR> stitchedRecords = stitcher.stitchCDRs(partialCDRs, config);

        for (CDR record : stitchedRecords) {
            System.out.println("Stitched Record: " + record.getCorrelationId() + ", Duration: " + record.getDuration() + ", LDC Indicator: " + record.getLdcIndicator());
        }
    }
}
