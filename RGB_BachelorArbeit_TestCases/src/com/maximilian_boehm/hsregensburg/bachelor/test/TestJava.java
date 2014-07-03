package com.maximilian_boehm.hsregensburg.bachelor.test;

import static org.hamcrest.core.IsEqual.equalTo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.maximilian_boehm.javasourceparser.access.JPAccessFactory;
import com.maximilian_boehm.javasourceparser.access.JPHome;
import com.maximilian_boehm.javasourceparser.access.struct.JPAnnotation;
import com.maximilian_boehm.javasourceparser.access.struct.JPClass;
import com.maximilian_boehm.javasourceparser.access.struct.JPField;
import com.maximilian_boehm.javasourceparser.model.JPModelFactory;
import com.maximilian_boehm.javasourceparser.model.meta.JPAnnotationImpl;
public class TestJava {

   @Test
   public void test() throws Exception {

      File f = new File("/Users/Max/Documents/Programmierung/git/MBRepository/MongoTestCase/src/main/java/com/maximilianboehm/hsregensburg/bachelor/Employee.java");

      JPHome  jpHome  = JPAccessFactory.getHome();
      JPClass jpClass = jpHome.getParsedClass(f);

      System.out.println(jpClass.getClassName());
      Assert.assertEquals(jpClass.getClassName(), "Employee");

      System.out.println(jpClass.getPackageName());
      Assert.assertEquals(jpClass.getPackageName(), "com.maximilianboehm.hsregensburg.bachelor");

      for(JPAnnotation anno:jpClass.getAnnotations()){
         System.out.println(anno.getType());
         for(String s:anno.getAttributes().keySet())
            System.out.println(s+"="+anno.getAttributes().get(s));
      }
      Assert.assertThat(jpClass.getAnnotations(), equalTo(getAnnotations4Clazz()));


      for(JPField field:jpClass.getFields()){
         System.out.println(field.getName());
         System.out.println(field.getType());
         if(field.hasAnnotations())
            for(JPAnnotation anno:field.getAnnotations()){
               System.out.println(anno.getType());
               if(anno.hasAttributes())
                  for(String s:anno.getAttributes().keySet())
                     System.out.println(s+"="+anno.getAttributes().get(s));
            }
      }
   }

   private List<JPAnnotation> getAnnotations4Clazz() {
      List<JPAnnotation> listAnnotation = new ArrayList<JPAnnotation>();
      JPAnnotationImpl anno = JPModelFactory.createJPAnnotation();
      anno.setType("Entity");

      anno.addAttribute("noClassnameStored", "true");
      anno.addAttribute("value", "\"hotels\"");

      listAnnotation.add(anno);
      return listAnnotation;
   }
}