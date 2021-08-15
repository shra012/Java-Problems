package com.ogrds.cache;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ) {
		//1. Create a cache manager
		CacheManager cm = CacheManager.newInstance("src/main/java/com/ogrds/resources/ehcache.xml");
		//2. Get a cache called "cache1"
		Cache cache = cm.getCache("students");

		//3.Create a Element with the KeyName and StudentsPojo Value
		Object key = new String("Shravan_101_1");
		Object key1 = new String("Shravan_101_2");

		Object value = new StudentPojo(101,1,"Sastra","Shravan");
		Object value1 = new StudentPojo(101,2,"Sastra","Kumar");

		Element element = new Element(key, value);
		Element element1 = new Element(key1, value1);

		//4. Put few elements in cache
		cache.put(element);
		cache.put(element1);

		//5. Get element from cache
		Element ele = cache.get("Shravan_101_*");

		//6. Print out the element
		String output = (ele == null ? null : ele.getObjectValue().toString());
		System.out.println(output);

		//7. Search Files Using Cache Query and Results
		String keyPart = "Shravan_101_";
		String studentId = "studentId";
		Integer studentId1 = 1;
		Integer studentId2 = 2;
		Attribute<Integer> studentIdAttribute =cache.getSearchAttribute(studentId);
		Query query = cache.createQuery();
		query.includeKeys();
		query.includeValues();
		List<Result> results = null;

		query.addCriteria(Query.KEY.ilike(keyPart+"*").and(studentIdAttribute.eq(studentId1)).or(studentIdAttribute.eq(studentId2)));
		//query.addCriteria(Query.KEY.ilike(keyPart+"*").and(studentIdAttribute.eq(studentId2)));
		results = query.execute().all();
		//. shut down the cache manager
		results.forEach(System.out::println);
		cm.shutdown();
	}
}
