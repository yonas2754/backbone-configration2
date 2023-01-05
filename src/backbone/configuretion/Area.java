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
public class Area {
    
  public String []  Area(String t){
    
                        ArrayList<String> alr = new ArrayList<>();
                        Regex regex = new Regex();
                        String input =t;
                        input = input.trim();
                         String[] ans = new String[2];
                        String qq="";
                        String qq2="";
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                           // System.out.println(line);
                            if(regex.find("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$",line)||regex.find("^\\d{9,20}$",line)){
              
                                alr.add(line);
                            }
                            
                            
                        }
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                         ArrayList<String> fileout1 = new ArrayList<>();
                         
                        File directoryPath = new File("BUP");
                        //List all files and directories
                       // System.out.println("------------All files------------");
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                       System.out.println(filenames);
                        for (int i = 0; i <  filenames.size(); i++){
                             ArrayList<String> alro = new ArrayList<>();
                            
                            for (int k = 0; k < alr.size(); k++){                                    

                                
                                try {
                                    
                                    
                                    String[]  l =  (regex.findLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    if(l[1] != null){
                                      //  fileout1.add("\n-------------\n"+l[1]+"\n------------------------------------------------------------\n");
                                    fileout1.add(l[1]+"="+alr.get(k));
                                    
                                     
                        alro.add(alr.get(k));
                                    }
                                   
                                    
                                    
                                 
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(BackboneConfiguretion.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                     
                           
                            
                             alr.removeAll(alro);
                            
                            
                        } 
                               Collections.sort(fileout1);
                               fileout1.stream().map((line) -> {
                                   fileout.add("\n-------------\n"+regex.realfind("BUP.*\\=",line)+"\n-----------------------------------------------------------------------------------\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(regex.realfind("\\d{9,20}",line));
                    });
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                       // System.out.println("newModified List: " + newfileout);
                       /////
                
                            
                               
                               
                        /// List<String> newList = newfileout;      
                        List<String> newList = newfileout.stream()
                              .distinct()
                               .collect(Collectors.toList());
                        
                        ///////
                       // System.out.println("ArrayList with duplicates removed: "
                         //       + newList);
                        for (int i = 0; i < newList.size(); i++) {
                            qq=qq+'\n'+newList.get(i);
                           // System.out.println("original out put file");
                            
                        }               
                        //ArrayList<String> newfileout3 = new ArrayList<>();
                       // newfileout3.addAll(alr);
                        //alr.removeAll(newList);
                        for (int i = 0; i < alr.size(); i++) {
                            qq2=qq2+"\n"+alr.get(i);
                        }
                            //System.out.println("original out put file");
            ans[0]=qq;
            ans[1]=qq2;
                            
return ans;
    }
    
}
