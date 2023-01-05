/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backbone.configuretion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author probook650
 */
public class Regex {
     public String realfind (String x ,String y){
    final String regex = x;
     String ypo="";
        final String string = y;
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        
        while (matcher.find()) {
           // System.out.println("Full match: " + matcher.group(0));
           ypo =  matcher.group(0); 
           
    } 
    
     return ypo;
    }  
    public   String sub(String x  ,String y,String z ){
    final String regex = x;
        final String string = z;
        final String subst = y;
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        
        // The substituted value will be contained in the result variable
        final String result = matcher.replaceAll(subst);
        
        //System.out.println("Substitution result: " + result);
    return  result;
    }
    
    public  boolean find  (String x,String row){
     final String regex = x;
             final String stringt = row;
        final Pattern patternt = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matchert = patternt.matcher(stringt);
              
            return matchert.find();
        }
    public  String[] findLine(String searchWord, String filename) throws IOException
 {
     
    String[] ans = new String[2];
     
     String replace="";
    
    
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while( (line = br.readLine( )) != null){
                
                  if (line.contains("interface vbui"))
                {
                replace = line.replace("interface", "");
                    
                    
                    
                    
                }
                  
                  else if(line.contains("BUP")){
                      replace = line.replace("BUP", "");
                      
                  }
                if (line.contains(searchWord))
                {
                   
                    
                    ans[0]=line;
                    ans[1]=filename+replace;
                    
                 break;
                }
            }
            
        }
        
        return ans;
 } 
    
    public  ArrayList<String> findLine2( String filename) throws IOException
 {
    

   
     ArrayList<String> alro = new ArrayList<>(); 
     ArrayList<String> alro2 = new ArrayList<>(); 
     ArrayList<String> alro3 = new ArrayList<>();
     
     String replace="";
    
        
    
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while( (line = br.readLine( )) != null){
                
            alro.add(realfind("\\d{9,15}",line));
           alro .removeIf(String::isEmpty); 
           
                 
               
            }
           
         ///////////
         
        Set<String> store = new HashSet<>();

        alro.stream().filter((name) -> (store.add(name) == false)).forEachOrdered((name) -> {
            alro2.add(name);
         }); //////////////
         
         
            
        }
          
         alro3.addAll(alro2);
          
        for(String searchWord : alro2){
        try (BufferedReader br2 = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while( (line = br2.readLine( )) != null){
                
                  if (line.contains("interface vbui"))
                {
                replace = line.replace("interface", "");
                    
                    
                    
                    
                }
                if (line.contains(searchWord))
                {
                   
                   
                    alro3.add(filename+replace+"="+line);
                     
                    
                 
                }
                }
            }
            
        }
        
                
      
        
        return alro3;
 }   
    
     
      public  String[] VfindLine(String searchWord, String filename) throws IOException
 {
     
    String[] ans = new String[4];
     
     ArrayList<String> add1 = new ArrayList<>();
boolean ans2=false ;
     
          
  
    
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
             out:
            
             while( (line = br.readLine( )) != null)
            {
            line=line.trim();
              add1.add(line);
                if (line.contains(searchWord))
                { 
                    int x=add1.indexOf(line);
                    ans[0]=line;
                    ans[1]=filename;
                    ans[2]=add1.get(x-1);
                 while( (line = br.readLine( )) != null){
                    
                 if (line.contains(ans[2])){
                     line = br.readLine( );
                 if(line.contains("vrrp")){
                 ans2=true;
                 break out;
                 }
                 }    
                 }                
                   
 
                    
                }
            }
             
                    
        if (ans2)
            ans[3]="T";
        else
            ans[3]="F";
             
            
        }
        
        return ans;
 }
    
}
