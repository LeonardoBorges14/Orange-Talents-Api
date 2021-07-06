package com.api.endpoints;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "comics", url="https://gateway.marvel.com/v1/public/comics?ts=1624800143"
		+ "&apikey=74876972a7fa546c5c5d5e42a85f4938&hash=f81534fbd67fac51028ddf125e3b7874")
public interface ComicEndpoint {

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	Object getComic(@Param("id")@PathVariable Long id);
	
}
