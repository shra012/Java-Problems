package com.shrvn.cache.main;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

public class MyCache {
	private static CacheManager myCacheManager; 
	public static void main(String[] args) {
		initCacheManager();
		Cache cache = myCacheManager.getCache("myCacheName"); 
		cache.put(new Element("name", "Shravan")); 
		//This updates the entry for "name" 
		cache.put(new Element("name", "kumar"));
		//Get values from cache
		Element element = cache.get("name"); 
		String value = (String) element.getObjectValue();
		System.out.println(value);
	}

	public static void initCacheManager() {
		CacheConfiguration cacheConfiguration = new CacheConfiguration();
		cacheConfiguration.setName("myCacheName");
		cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
		cacheConfiguration.setMaxEntriesLocalHeap(1000);
		Configuration config = new Configuration();
		config.addCache(cacheConfiguration);
		myCacheManager = CacheManager.newInstance(config);
	}
	
	public static void initCacheManagerDocStyle() {
		//Create a singleton CacheManager using defaults 
		myCacheManager = CacheManager.create(); 
		//Create a Cache specifying its configuration. 
		Cache testCache = new Cache( 
		  new CacheConfiguration("testCache", 1000) //maxEntriesLocalHeap
		    .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU) 
		    .eternal(false) 
		    .timeToLiveSeconds(60) 
		    .timeToIdleSeconds(30) 
		    .diskExpiryThreadIntervalSeconds(0) 
		    .persistence(new PersistenceConfiguration().strategy(Strategy.LOCALTEMPSWAP))); 
		myCacheManager.addCache(testCache);
	}
}
