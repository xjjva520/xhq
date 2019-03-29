package com.xhq.xhqservice.service;

public interface IDealDataService<T> {
   T findById(String id,String traceId);
   
   T findByName(String name,String traceId);
}
