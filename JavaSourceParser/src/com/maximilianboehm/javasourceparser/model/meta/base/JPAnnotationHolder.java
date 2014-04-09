package com.maximilianboehm.javasourceparser.model.meta.base;

import java.util.ArrayList;
import java.util.List;

import com.maximilianboehm.javasourceparser.access.struct.JPAnnotation;

public class JPAnnotationHolder {
   
   private List<JPAnnotation> listAnnotations;
   
   public void addAnnotation(JPAnnotation annotation){
      if(listAnnotations==null) listAnnotations = new ArrayList<JPAnnotation>();
      listAnnotations.add(annotation);
   }
   
   public void setAnnotations(List<JPAnnotation> listAnnotations) {
      this.listAnnotations = listAnnotations;
   }
   
   public List<JPAnnotation> getAnnotations() throws Exception {
      return listAnnotations;
   }


}
