package io.github.michaelbui99.lolinsightsbackend.entity;

import com.merakianalytics.orianna.types.common.Region;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RegionMap {
    private static RegionMap instance;
    private static ReentrantLock lock = new ReentrantLock();
    private Map<String, Region> regionMappings;

    private RegionMap() {
        regionMappings = new HashMap<>();
        regionMappings.put("EUW1", Region.EUROPE_WEST);
        regionMappings.put("EUN1", Region.EUROPE_NORTH_EAST);
        regionMappings.put("NA1", Region.NORTH_AMERICA);
        regionMappings.put("KR", Region.KOREA);
        regionMappings.put("JP1", Region.JAPAN);
    }

    public static RegionMap getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new RegionMap();
                }
            }
        }
        return instance;
    }

    public Map<String, Region> getRegionMappings() {
        return regionMappings;
    }
}
