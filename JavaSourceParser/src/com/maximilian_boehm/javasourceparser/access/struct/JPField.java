package com.maximilian_boehm.javasourceparser.access.struct;

import com.maximilian_boehm.javasourceparser.access.struct.base.JPAnnotationHolder;

public interface JPField extends JPAnnotationHolder{
   
   public String getName();
   public String getType();
   
   
//   public void setName(String name);
//   public void setType(String type);
   
}