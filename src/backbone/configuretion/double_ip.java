/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backbone.configuretion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author probook650
 */
public class double_ip {
  public   String double_ip(){
      
                        String qq="";
                        int lineNumber;
                        Regex regex = new Regex();
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout1 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                        
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        
                         System.out.println(filenames);
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                            ArrayList<String> alro = new ArrayList<>();
                           
                                
                                try {
                                    
                                 
                                    
                                    alro=  (regex.findLine2("BUP\\"+filenames.get(i)));
                                    alro.removeAll(Collections.singletonList(null));
                                    fileout1.addAll(alro);
                                 
                              
                                    
                        
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(BackboneConfiguretion.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            
                        } 
                        
                          
                               Collections.sort(fileout1);
                            fileout1.stream().map((line) -> {
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~\n"+regex.realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(regex.realfind("(^\\d{9,20}$|ip-host description.*)",line));
                    });
                        
                         /////////////
                         fileout.removeAll(Collections.singletonList(null));
                       
                        List<String> newList = fileout.stream()
                                .distinct()
                                .collect(Collectors.toList());

                         ////////////
                         
                         for (int i = 0; i < newList.size(); i++) {
                            qq=qq+'\n'+newList.get(i);
                            
                            
                        } 
  
  return qq;
  }
    
}
