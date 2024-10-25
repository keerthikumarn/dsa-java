package com.designpatterns.saga;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ServiceDiscovery {

	private Map<String, OrchestrationChapter<?>> services = null;

	public Optional<OrchestrationChapter> findService(String service) {
		return Optional.ofNullable(services.getOrDefault(service, null));
	}

	public ServiceDiscovery discover(OrchestrationChapter<?> orchestrationChapterService) {
		services.put(orchestrationChapterService.getName(), orchestrationChapterService);
		return this;
	}

	public ServiceDiscovery() {
		this.services = new HashMap<>();
	}

}
