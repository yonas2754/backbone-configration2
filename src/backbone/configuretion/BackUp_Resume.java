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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author probook650
 */
public class BackUp_Resume {
    public String BackUp_Resume(String t){
        
                        Regex regexx = new Regex();
                        ArrayList<String> alr = new ArrayList<>();
                        String input =t;
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                            //System.out.println(line);
                            if(regexx.find("^\\d{9,20}$",line)){
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
                                    
                                    
                                    
                                    String[]  l =  (regexx.findLine(alr.get(k),"BUP\\"+filenames.get(i)));
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
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~\n"+regexx.realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(regexx.realfind("ip-host description.*",line));
                    });
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                       
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                       
                        for (int i = 0; i < newList.size(); i++) {
                          
                            String  imput1 = newList.get(i).replace(",","");
                            String imput2 = imput1.replace("|", "");
                            String  imput3 = imput2.replace("@", "");
                            String imput4 = imput3.replace("$", "");
                            String imput5 = imput4.replace("/", "-");
                            String imput51 = imput5.replace(":","");
                            String imput61 = imput51.replace("*", "");
                            String  imput6 = imput61.replace("+", "");
                            String imput62 = imput6.replace(">", "");
                            String imput63 = imput62.replace("<", "");
                            
                            
                            String imput7 = imput63.replace("[", "");
                            String imput8 = imput7.replace("]","" );
                            String imput9 = imput8.replace("%", "");
                            String imput10 = imput9.replace("?", "");
                            String imput11 = imput10.replace(";", "");
                            String imput12 = imput11.replace("#", "");
                            String imput13 = imput12.replace("!", "");
                            String imput14 = imput13.replace("{", "");
                            String imput15 = imput14.replace("}", "");
                            String imput151 = imput15.replace("(", "");
                            String imput152 = imput151.replace(")", "");
                            String imput16 = imput152.replace("&", "");
                            String imput17 = imput16.replace("^", "");
                            String imput18 = imput17.replace("_", "-");
                            ////
                         String imput20="";
    String imput21="";
     String imput25=""; 

     imput20 = regexx.realfind("\\D\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput18); 
      imput25 = regexx.realfind("\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput18);
     if(regexx.find("^-",imput20)||regexx.find("^-",imput25))
    {
        if(regexx.find("^-",imput20)){
   imput21= imput20;
   
    }else{
       imput21= imput25; 
        
        }
        
     } else {
         String first = regexx.realfind("^\\w",imput20);
        String first2 = regexx.realfind("^\\w",imput25);
         imput20 = regexx.realfind("\\d{1,2}[a-zA-Z]{2,4}\\d{1,2}",imput20);
         System.out.println("20 is"+imput20);
   
         
         imput25 = regexx.realfind("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25);
         
         
         
         if("".equals(imput20)&&!"".equals(imput25)){
              
             // System.out.println("f2 is"+ first2);
             imput21="-"+imput25;
             imput25=regexx.sub( "\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",first2+imput21,imput25);
             imput18=regexx.sub( "\\D\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25,imput18);
             
             //System.out.println("bhbhbh"+imput21);
             
         } else if("".equals(imput25)&&"".equals(imput20)){
             //System.out.println(imput21);
         }else{
            
             imput21="-"+imput20;
              
                  imput20=regexx.sub( "\\d{1,2}[a-zA-Z]{2,4}\\d{2}",first+imput21,imput20);
             imput18=regexx.sub( "\\D\\d{1,2}[a-zA-Z]{2,4}\\d{2}",imput20,imput18);
             
             //System.out.println(imput21);
         }                       }
           if(!regexx.find("\\d{10,13}-",imput18))  
   {
     String imput22=regexx.realfind("\\d{9,13}",imput18);
    // System.out.println("22 is "+ imput22);
      //System.out.println("112 is "+ imput18);
     
                             String imput23=imput22+"-";
                             
                            imput18=regexx.sub("\\d{10,13}",imput23,imput18);
     }
            imput18=regexx.sub("\\-\\-+","-",imput18); 
        //             System.out.println("18 is "+ imput18);
                            
                            ///
                            String yphr ="";
                            String ypo ="";
                            String vv ="";
                            String dv ="";
                            String ych ="";
                            String  myphr ="";
                            String  BB ="";
                            String  BBB ="";
                            String  BBBB ="";
                            String myphr1 = "";
                            String myphr2 = "";
                            String myphr3 = "";
                            String myphr4= "";
                            String myphr5 = "";
                            String myphr6 = "";
                            String myphr7 = "";
                            String myphr8 = "";
                            String myphr9 = "";
                            String myphr10 = "";
                            
                            String rfinal = "";
                            String chb = "";
                            String vyphr = "";
                            String sv = "";
                            
                            String  Rfinals  = "";
                            
                            String   ypht  = "";
                            String   pbr   = "";
                            final String regexsup = "\\d{9,16}\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\.{0,2}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}";
                            final String regex = "\\d{9,16}\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}\\-{0,1}\\_{0,1}\\w{0,1}\\d{3,4}\\-{0,1}\\\\{0,2}\\s";
                            final String string = imput18;
                            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                            final Matcher matcher = pattern.matcher(string);
                            
                            while (matcher.find()) {
                             
                                
                                
                                yphr = matcher.group(0);
                                
                            }
                            
                          yphr=yphr.trim();
                            
                            final String regex2 = "\\d{9,15}";
                            
                            
                            final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
                            final Matcher matcher2 = pattern2.matcher(string);
                            
                            while (matcher2.find()) {
                                
                                
                                ypo = ypo + matcher2.group(0);
                            }
                            
                           
                            
                            
                            if (!"".equals(yphr))
                            {
                             
                                vv = yphr.substring(yphr.length() - 4);
                             
                                final String regex3 = "sec-vlan";
                                
                                final Pattern pattern3 = Pattern.compile(regex3, Pattern.MULTILINE);
                                final Matcher matcher3 = pattern3.matcher(string);
                              
                                while (matcher3.find()) {
                                
                                    ych =  matcher3.group(0);
                                    
                                    
                                    
                                }
                               
                                
                                if (!"sec-vlan".equals(ych)){
                                 
                                    vv = vv.replace("b", "");
                                    vv = vv.replace("B", "");
                                    vv = vv.replace("v", "");
                                    vv = vv.replace("V", "");
                                    vv = vv.replace("-", "");
                                    vv = vv.replace("_", "");
                                    vv = vv.replace(".", "");
                                    vv = vv.replace(",", "");
                                    vv = vv.replace("/", "");
                                      
                                    myphr =   yphr.substring(0, yphr.length() - 4);
                                    BB = myphr.substring(myphr.length() - 1);
                                    BBB = myphr.substring(myphr.length() - 2);
                                    BBBB =myphr.substring(myphr.length() - 3);
                                    
                                    
                                    
                                    
                                    //System.out.println("myphr0"+myphr);
                                    myphr1 = regexx.sub("b$","",myphr);
                                    
                                   // System.out.println("myphr1"+myphr1);
                                    myphr2 = regexx.sub("B$","",myphr1);
                                    myphr3 = regexx.sub("v$","",myphr2);
                                    myphr4 = regexx.sub("V$","",myphr3);
                                    myphr5 = regexx.sub("/$","",myphr4);
                                    myphr6 = regexx.sub("-$","",myphr5);
                                    myphr7 = regexx.sub("_$","",myphr6);
                                    myphr8 = regexx.sub("\\.$","",myphr7);
                                    myphr9 = regexx.sub("\\,$","",myphr8);
                                    myphr10 = regexx.sub("\\\\,$","",myphr9);
                                    myphr = myphr10;
                                    //System.out.println("myphr+"+myphr9);
                                    
                                    
                                    
                                    final String regex5 = "[a-zA-Z]\\d{1}";
                                    final String string5 =  BBB;
                                    
                                    final Pattern pattern5 = Pattern.compile(regex5, Pattern.MULTILINE);
                                    final Matcher matcher5 = pattern5.matcher(string5);
                                    
                                    while (matcher5.find()) {
                                        
                                       if(vv.length()>3)
                {
                dv =  vv.substring(0, vv.length() - 4);
                // System.out.println("dv+"+dv);
                vv = vv.substring(1);
               // System.out.println("vv+"+vv);
                myphr=myphr+dv;
                }
                else if(vv.length()==3){
                dv =  vv.substring(0, vv.length() - 3);
                
                myphr=myphr+dv;
                }
                                    }
                                    
                                    rfinal = imput18.replace(yphr,myphr);
                                    
                                    
                                    final String regex7 = "\\d{3,5}";
                                    final String string7 = vv;
                                    
                                    final Pattern pattern7 = Pattern.compile(regex7, Pattern.MULTILINE);
                                    final Matcher matcher7 = pattern7.matcher(string7);
                                    
                                    while (matcher7.find()) {
                                        //System.out.println("Full match: " + matcher7.group(0));
                                        
                                        
                                        chb = chb + matcher7.group(0);                                      
                                        
                                    }
                                    
                                    
                                    
                                    
                                    final String regex6 = "vlan\\s\\d{4}";
                                    
                                    
                                    final Pattern pattern6 = Pattern.compile(regex6, Pattern.MULTILINE);
                                    final Matcher matcher6 = pattern6.matcher(string);
                                    
                                    while (matcher6.find()) {
                                       // System.out.println("Full match: " + matcher6.group(0));
                                        vyphr = vyphr + matcher6.group(0);
                                    }
                                    
                                    
                                    if (!"".equals(vyphr) && !"".equals(vv)){
                                        sv = vyphr + " sec-vlan "+ chb;
                                    }
                                    else{
                                        sv =" vlan "+ chb;
                                    }
                                    //System.out.println("sv+"+sv);
                                    
                                    final String regexr = "vlan\\s\\d{1,4}";
                                    final String Rfinal =rfinal ;
                                    final String subst = sv;
                                    
                                    final Pattern patternr = Pattern.compile(regexr, Pattern.MULTILINE);
                                    final Matcher matcherr = patternr.matcher(Rfinal);
                                    
                                    // The substituted value will be contained in the result variable
                                    final String result = matcherr.replaceAll(subst);
                                    
                                   // System.out.println("Substitution result: " + result);
                                    
                                    final String regexss = "\\s\\s+";
                                    final String stringss = result;
                                    final String substs = " ";
                                    
                                    final Pattern patterns = Pattern.compile(regexss, Pattern.MULTILINE);
                                    final Matcher matchers = patterns.matcher(stringss);
                                    
                                    // The substituted value will be contained in the result variable
                                    final String Results = matchers.replaceAll(substs);
                                    
                                   
                                    
                                    final String regex8= "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
                                    
                                    
                                    final Pattern pattern8 = Pattern.compile(regex8, Pattern.MULTILINE);
                                    final Matcher matcher8 = pattern8.matcher(string);
                                    
                                    while (matcher8.find()) {
                                       // System.out.println("Full match: " + matcher8.group(0));
                                        
                                        ypht = ypht + matcher8.group(0);
                                        
                                       // System.out.println(ypht);     
                                        
                                        
                                    }
                                    
                                    
                                    pbr = "\nno ip-host "+ypht+"\ny"+'\n'+Results;
                        
                                    qq = qq + pbr;
                                    
                                    
                                }
                                
                                
                            }
                            else if(regexx.find("^ip-host description.*?\\d+(M|K)[^ ]*?$",imput18))  { 
                                
                                ypht="";
                                final String regex8= "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
                                

                                final Pattern pattern8 = Pattern.compile(regex8, Pattern.MULTILINE);
                                final Matcher matcher8 = pattern8.matcher(imput18);
                                
                                while (matcher8.find()) {
                                  //  System.out.println("Full match: " + matcher8.group(0));
                                    
                                    ypht = ypht + matcher8.group(0);
                                    
                                    //System.out.println(ypht);
                                    
                                    
                                }
                                if(!"".equals(ypht)){
                                  String    ypkh =regexx.realfind(regexsup,imput18);
                        ypkh = ypkh.trim();
                                             if (ypkh.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 
                 String dg = ypkh.substring(ypkh.length() - 15); 
                 
               String   sr=ypkh.substring(0,15);
                String ypu = sr+"-"+dg ;
                 // System.out.println("ypu"+ypu);
                imput18 =regexx.sub(ypkh,ypu,imput18);
                 
                }
                                             
                                              else
                    
                {
                    
                 String dg = ypkh.substring(ypkh.length() - 15); 
                 
               String   sr=ypkh.substring(0,15);
                String ypu = sr+"-"+dg ;
                  //System.out.println("ypu"+ypu);
                imput18 =regexx.sub(ypkh,ypu,imput18);
                
                }
                  
                                             }
                                    
                                    
                                    if(regexx.find("vlan\\s\\d{4}",imput18)){
                                    pbr = "\nno ip-host "+ypht+"\ny"+'\n'+imput18;
                                    }
                                    else{
                                    pbr ="\n~~~~~~~~~~~\nError\t"+imput18+"\n~~~~~~~~~~~\n";
                                    }
                                }else
                                {
                                    pbr = '\n'+imput18+'\n'; 
                                }
                                
                                
                              
                                qq = qq + pbr;
                               
                                
                            }
                            else {
                                qq=qq+'\n'+imput18+'\n';
                                
                            }
                            
                        }               
                        
    
    return qq;
    }
}
