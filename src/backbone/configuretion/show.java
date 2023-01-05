/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backbone.configuretion;


import java.util.ArrayList;

/**
 *
 * @author probook650
 */
public class show {
    public String show(String t ,String tt){
    
                                // Now add the particular background color
                            ArrayList<String> alr = new ArrayList<>();
                             Regex regex = new Regex();
                        String vbui =tt;
                        vbui = vbui.trim();
                        String input =t;
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                           // System.out.println(line);
                            if(regex.find("^\\d{9,20}$",line)){
                                alr.add(line);}
                            
                        }
                        String  sh ="show running-config-interface vbui" ;
                        String y= sh+vbui+" | i ";
                        for (int i = 0; i < alr.size(); i++) {
                            qq=qq+'\n'+y+alr.get(i);
                            
                            
                        } 
                        return qq;
    }
}
