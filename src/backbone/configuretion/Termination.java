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
public class Termination {
    public String Termination(String t){
    
    /////////////
                       Regex regex = new Regex();
                     ArrayList<String> alr = new ArrayList<>();
                        String input =t;
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                            //System.out.println(line);
                            if(regex.find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout1 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                        
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                            ArrayList<String> alro = new ArrayList<>();
                            for (int k = 0; k < alr.size(); k++){
                                
                                try {
                                    
                                    
                                    
                                    String[]  l =  (regex.findLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    if(l[1]!=null){
                                        //fileout.add("\n----------\n"+l[1]+"\n--------------------------------------------------\n");
                                        alro.add(alr.get(k));
                                          //fileout.add(l[0]);
                                          fileout1.add(l[1]+"="+l[0]);
                                    }
                                  
                                    
                        
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(BackboneConfiguretion.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                                  
                             
                           
                            
                            alr.removeAll(alro);
                            
                       
                        }  
                        
                        
                            Collections.sort(fileout1);
                            fileout1.stream().map((line) -> {
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~\n"+regex.realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(regex.realfind("ip-host description.*",line));
                    });
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                       
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        String   pbr   = "";
                        for (int i = 0; i < newList.size(); i++) {
                          
                            String  imput1 = newList.get(i).replace(",","");
                               String ip = regex.realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",imput1);
                               if(regex.find("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",imput1)){
                               pbr = "\nno ip-host "+ip+"\ny";
                               
                               }else{
                                  pbr = '\n'+imput1+'\n';
                               }
                                qq = qq + pbr;
                    
                            }
                         qq = qq + "\n###########################REPORT###############################\n";
                         for (int i = 0; i < newList.size(); i++) {
                          
                            String  imput1 = newList.get(i).replace(",","");
                               String ip = regex.realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",imput1);
                                String SmartG = regex.realfind("smartgroup\\d+\\.\\d+",imput1);
                                String PH = regex.realfind("\\d{9,15}",imput1);
                               if(regex.find("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",imput1)){
                               pbr = "\n"+PH+"\t"+ip+"\t"+SmartG;
                               
                               }else{
                                  pbr = '\n'+imput1+'\n';
                               }
                                qq = qq + pbr;
                    
                            }
                           
                                
                            
                            
    
    
    return qq;
    }
    
}
