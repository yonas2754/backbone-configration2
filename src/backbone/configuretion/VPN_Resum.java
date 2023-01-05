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
public class VPN_Resum {
    
    public String VPN_Resum(String t){
    Regex regexx = new Regex();
     ArrayList<String> alr = new ArrayList<>();
                        String input =t;
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                        //    System.out.println(line);
                            if(regexx.find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        String text = "";
                        String textR = "";
                        int lineNumber;
                        ArrayList<String> filenames = new ArrayList<>();
                        ArrayList<String> fileout = new ArrayList<>();
                        ArrayList<String> fileout2 = new ArrayList<>();
                        File directoryPath = new File("BUP");
                        //List all files and directories
                        //System.out.println("------------All files------------");
                        for (File file : directoryPath.listFiles()) {
                            
                            filenames.add(file.getName());
                            
                        }
                        //System.out.println(filenames);
                        String x ;
                        for (int i = 0; i <  filenames.size(); i++){
                             ArrayList<String> alro = new ArrayList<>();
                            for (int k = 0; k < alr.size(); k++){ 
                                
                                try {
                                    
                                    
                                    
                                    String[]  l =  (regexx.VfindLine(alr.get(k),"BUP\\"+filenames.get(i)));
                                    
                                    if("T".equals(l[3])){
                                        if(l[1]!=null){
                                            fileout2.add("\n~~~~~~~~~~~~~~~~~~~~~~~~\n"+l[1]+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                            fileout2.add(l[2]);
                                            alro.add(alr.get(k));
                                            // fileout2.add(l[0]);
                                            
                                            /////////
                                        }
                                        
                                        
                                    }
                                    else {
                                        
                                        if(l[1]!=null){
                                            if(l[1]!=null){
                                                fileout.add("\n~~~~~~~~~~~~~~~~~~~~\n"+l[1]+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");}
                                            fileout.add(l[2]);
                                            alro.add(alr.get(k));
                                            //fileout.add(l[0]);
                                            
                                            /////////
                                        }
                                        
                                    }
                                    
                                    
                          //          System.out.println("l[1]"+l[1]);
                                    
                                    // fileout.add(filenames.get(i));
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(BackboneConfiguretion.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            
                            
                        alr.removeAll(alro);    
                            
                        }         
                        ArrayList<String> newfileout2 = new ArrayList<>();
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        fileout2.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                        for (int i = 0; i < fileout2.size(); i++){
                            newfileout2.add(fileout2.get(i).trim());}
                        //System.out.println("newModified List: " + newfileout);
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        List<String> newList2 = newfileout2.stream()
                                .distinct()
                                .collect(Collectors.toList());
                        //System.out.println("ArrayList with duplicates removed: "
                          //      + newList);
                        //System.out.println("newModified List: " + newfileout);
                        for (int i = 0; i < newList.size(); i++) {
                            if(newList.get(i).contains("interface")){
                                qq=qq+"\n"+ newList.get(i)+"\nno shut"+"\nexit";
                            }
                            else if(newList.get(i).contains("ip-host description")){}
                            else{
                                
                                 
                                qq=qq+"\n"+ newList.get(i);
                            }
                            
                            
                            
                            
                        }              qq=qq+"\n===========VRRP==========VRRP=============VRRP==================";
                        for (int i = 0; i < newList2.size(); i++) {
                            
                            if(newList2.get(i).contains("interface")){ 
                                qq=qq+"\n"+ newList2.get(i)+"\nno shut"+"\nexit";
                            }else{
                                qq=qq+"\n"+ newList2.get(i);
                            }
                            
                        }        
    return qq;
    }
    
}
