package com.community.controller;

import net.sf.ehcache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheClearer {
	@RequestMapping(value = "/cache/clear", method = RequestMethod.GET)
	public String clearCache(@RequestParam(name = "cacheRegion") String cacheRegion) {
		CacheManager.getInstance().getCache(cacheRegion).removeAll();
		return "Success";
	}
}
