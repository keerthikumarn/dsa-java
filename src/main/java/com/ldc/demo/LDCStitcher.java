package com.ldc.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LDCStitcher {

	public List<CDR> stitchCDRs(List<CDR> partialCDRs, LDCConfiguration config) {
		List<CDR> stitchedRecords = new ArrayList<>();
		String currentCorrelationId = null;
		List<CDR> currentGroup = new ArrayList<>();
		Collections.sort(partialCDRs, Comparator.comparing(CDR::getTimestamp));

		for (CDR cdr : partialCDRs) {
			if (currentCorrelationId == null) {
				currentCorrelationId = cdr.getCorrelationId();
			}

			if (cdr.getCorrelationId().equals(currentCorrelationId)) {
				currentGroup.add(cdr);
			} else {
				if (shouldStitch(currentGroup, config)) {
					stitchedRecords.add(stitch(currentGroup, config));
				}
				currentCorrelationId = cdr.getCorrelationId();
				currentGroup = new ArrayList<>();
				currentGroup.add(cdr);
			}
		}
		if (!currentGroup.isEmpty() && shouldStitch(currentGroup, config)) {
			stitchedRecords.add(stitch(currentGroup, config));
		}
		return stitchedRecords;
	}

	private boolean shouldStitch(List<CDR> group, LDCConfiguration config) {
		// Check if the configuration has all three values set
		String initialValue = config.getInitialValue();
		String intermediateValue = config.getIntermediateValue();
		String endValue = config.getEndValue();

		// If any of the values are null or empty, we cannot stitch
		if (initialValue == null || initialValue.isEmpty() || intermediateValue == null || intermediateValue.isEmpty()
				|| endValue == null || endValue.isEmpty()) {
			return false;
		}

		// Check if all CDRs in the group have the required values
		for (CDR cdr : group) {
			String ldcIndicator = cdr.getLdcIndicator();

			// Check if ldcIndicator is not null before comparing
			if (ldcIndicator!=null && ldcIndicator.equals("0")) {
				return true;
			}
		}

		return false;
	}

	private CDR stitch(List<CDR> group, LDCConfiguration config) {
		long totalDuration = group.stream().mapToLong(CDR::getDuration).sum();
		CDR firstCdr = group.get(0);
		CDR stitchedCdr = new CDR(firstCdr.getCorrelationId(), firstCdr.getTimestamp(), totalDuration);
		stitchedCdr.setLdcIndicator(config.getEndValue());
		return stitchedCdr;
	}
}
