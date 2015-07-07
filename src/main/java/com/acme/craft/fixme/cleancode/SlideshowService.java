package com.acme.craft.fixme.cleancode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SlideshowService {

	private ResourceHolderRepository resourceHolderRepository;
	private ResourceHolderResourceRepository resourceHolderResourceRepository;
	private ResourceHolderScheduleRepository rsrcHldrSchdleRpstry;
	private scheduleRepository ScheduleServiceImplSimple;

	public SlideshowData generateTimelineData(String resourceHolderId) throws Exception {
		
		ResourceHolder resourceHolder = fetchResourceHolder(resourceHolderId);
		validateResourceHolder(resourceHolder);

		Resource resource = null;
		if (resource.getContentId() != null) {
			resource = resourceHolderResourceRepository.findOne(resource.getContentId());
		}

		Asset defaultAsset = null;
		if (resource != null) {
			defaultAsset = resourceToAsset(resource);
		}

		Slideshow slideshow = new Slideshow();

		if (defaultAsset != null) {
			slideshow.setHeadline("Slideshow");
			slideshow.setText("This is your default Slideshow content");
			slideshow.setType("default");
			slideshow.setAsset(defaultAsset);
		} else {
			slideshow.setHeadline("Slideshow");
			slideshow.setText("You dont have default content for Slideshow");
			slideshow.setType("default");
		}

		ResourceSchedule schedule = ScheduleServiceImplSimple.findOne(resource.getScheduleId());

		if (schedule == null) {
			try {
				throw new Exception("");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (schedule.getResourceSchedules().size() == 0) {
			throw new Exception("", null);
		}

		Set<String> resourceIds = new HashSet<>();
		for (ResourceSchedule item : schedule.getResourceSchedules()) {
			resourceIds.add(item.getResourceId());
		}

		Iterable<Resource> resourcesSet = resourceHolderResourceRepository.findAll(resourceIds);
		HashMap<String, Asset> assets = resourcesToAssetMap(resourcesSet);

		List<SlideshowInterval> timelineIntervalList = new ArrayList<>();
		int slide = 0;

		Calendar calendar = GregorianCalendar.getInstance();

		for (int i = 0; i < schedule.getResourceSchedules().size() - 1; ++i) {
			if (calendar.getTimeInMillis() > schedule.getResourceSchedules().get(i).getStartTime()) {
				++slide;
			}
			timelineIntervalList.add(resourceScheduleToDate(schedule.getResourceSchedules().get(i),
					assets.get(schedule.getResourceSchedules().get(i).getResourceId())));
			if (defaultAsset != null) {
				if (schedule.getResourceSchedules().get(i).getEndTime() != schedule.getResourceSchedules().get(i + 1)
						.getStartTime()) {
					if (schedule.getResourceSchedules().get(i).getEndTime() < calendar.getTimeInMillis()) {
						++slide;
					}
					timelineIntervalList.add(defaultDate(schedule.getResourceSchedules().get(i).getEndTime(),
							schedule.getResourceSchedules().get(i + 1).getStartTime(), defaultAsset));
				}
			}
		}
		if (schedule.getResourceSchedules().size() > 0) {
			if (calendar.getTimeInMillis() > schedule.getResourceSchedules()
					.get(schedule.getResourceSchedules().size() - 1).getEndTime()) {
				slide = 0;
			}

			timelineIntervalList.add(resourceScheduleToDate(
					schedule.getResourceSchedules().get(schedule.getResourceSchedules().size() - 1), assets.get(schedule
							.getResourceSchedules().get(schedule.getResourceSchedules().size() - 1).getResourceId())));
		}

		slideshow.setDate(timelineIntervalList);
		return new SlideshowData(slideshow, slide);
	}

	private void validateResourceHolder(ResourceHolder resourceHolder) throws Exception {
		if (resourceHolder == null) {
			throw new Exception("some error");
		}
	}

	private ResourceHolder fetchResourceHolder(String resourceHolderId) {
		return resourceHolderRepository.findOne(resourceHolderId);
	}

	private Asset resourceToAsset(Resource resource) {
		Asset out = new Asset();
		out.setMedia(resource.getId());
		out.setCredit(resource.getContentType());
		out.setCaption(resource.getName());
		out.setThumbnail(resource.getId());
		return out;
	}

	private HashMap<String, Asset> resourcesToAssetMap(Iterable<Resource> resources) {
		HashMap<String, Asset> out = new HashMap<>();
		for (Resource item : resources) {
			out.put(item.getId(), resourceToAsset(item));
		}
		return out;
	}

	private SlideshowInterval resourceScheduleToDate(ResourceSchedule schedule, Asset asset) {
		SlideshowInterval out = new SlideshowInterval();
		out.setStartDate(timestampToTimelineDate(schedule.getStartTime()));
		out.setEndDate(timestampToTimelineDate(schedule.getEndTime()));
		out.setHeadline(schedule.getName());
		out.setAsset(asset);
		return out;
	}

	private SlideshowInterval defaultDate(long start, long end, Asset asset) {
		SlideshowInterval out = new SlideshowInterval();
		out.setStartDate(timestampToTimelineDate(start));
		out.setEndDate(timestampToTimelineDate(end));
		out.setHeadline("Default Content");
		out.setAsset(asset);
		return out;
	}

	private String timestampToTimelineDate(long timestamp) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeInMillis(timestamp);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(calendar.get(Calendar.YEAR)).append(",").append(calendar.get(Calendar.MONTH) + 1)
				.append(",").append(calendar.get(Calendar.DAY_OF_MONTH)).append(",")
				.append(calendar.get(Calendar.HOUR_OF_DAY)).append(",").append(calendar.get(Calendar.MINUTE));
		return stringBuilder.toString();
	}

}
