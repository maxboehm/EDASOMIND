package com.maximilianboehm.git.model;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.treewalk.TreeWalk;

import com.maximilianboehm.git.access.struct.GTHistory;

public class MGitHistory {

   String path = "MongoTestCase/src/main/java/com/maximilianboehm/hsregensburg/bachelor/Employee.java";

   public GTHistory getHistory(File f) throws Exception{
      try(MRepositoryManager repManager = MRepositoryManager.getManager(f);){
         Repository repository = repManager.getRepository();

         Git git = new Git(repository);

         LogCommand logCommand = git.log()
               .add(git.getRepository().resolve(Constants.HEAD))
               .addPath(path);

         ObjectReader reader = null;
         try {
            reader = repository.newObjectReader();
            for (RevCommit revCommit : logCommand.call()) {
               System.out.println("AAA");
               RevTree tree = revCommit.getTree();

               // .. and narrow it down to the single file's path
               TreeWalk treewalk = TreeWalk.forPath(reader, path, tree);

               if (treewalk != null) {
                  // use the blob id to read the file's data
                  byte[] data = reader.open(treewalk.getObjectId(0)).getBytes();
                  //System.out.println(new String(data, "utf-8"));
                  //               return new String(data, "utf-8");
               } else {
                  //sSystem.out.println("");
                  //               return "";
               }
            }
         } finally{
            reader.release();
         }
      }
      return null;
   }

}