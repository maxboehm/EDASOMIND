package com.maximilianboehm.javasourceparser.access.struct.base;

import java.util.List;

import com.maximilianboehm.javasourceparser.access.struct.JPAnnotation;

public interface JPAnnotationHolder {
   
   public List<JPAnnotation> getAnnotations() throws Exception;
   public boolean hasAnnotations();
   
   //public void setAnnotations(List<JPAnnotation> listAnnotations);

}
