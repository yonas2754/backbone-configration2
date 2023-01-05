/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backbone.configuretion;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author probook650
 */
public class clear {
   public String clears(String t ){
    
    ArrayList<String> alr = new ArrayList<>();
    Regex regex = new Regex();
                        String input =t;
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                           // System.out.println(line);
                           
                            if(regex.find("^\\s*ip-host description.*?\\d+(M|K)[^ ]*?$",line)){
                                alr.add(line);
                            
                            
                           
                            }else{
                           alr.add( regex.realfind("ip-host description.*?\\d+(M|K)[^ ]*?$",line));
                            }
                            
                        }
                        
                         alr.removeAll(Collections.singletonList(""));
                        for (int i = 0; i < alr.size(); i++) {
                            
                            qq = qq + "\n" + alr.get(i).trim();
                        } 
                      qq=qq.trim();
    
    
    return qq;
    }
    
}
