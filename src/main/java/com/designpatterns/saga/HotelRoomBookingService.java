package com.designpatterns.saga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HotelRoomBookingService extends Service<String> {

	private static Logger logger = LoggerFactory.getLogger(HotelRoomBookingService.class);

	@Override
	public String getName() {
		return "Booking a hotel room";
	}

	@Override
	public ChapterResult<String> rollback(String value) {
		if (value.equals("crashed_order")) {
			logger.info("The Rollback for a chapter '{}' has been started. "
					+ "The data {} has been failed.The saga has been crashed.", getName(), value);

			return ChapterResult.failure(value);
		}

		logger.info(
				"The Rollback for a chapter '{}' has been started. " + "The data {} has been rollbacked successfully",
				getName(), value);

		return super.rollback(value);
	}

}
