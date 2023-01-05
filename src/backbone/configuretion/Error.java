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
public class Error {
    public String Error(String t){
    Regex regexs = new Regex();
    ArrayList<String> alr = new ArrayList<>();
                        String input =t;
                        input = input.trim();
                        String qq="";
                        
                        // For loop for iterating over the List
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                            //System.out.println(line);
                            if(regexs.find("^\\d{9,20}$",line)){
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
                                    
                                    
                                    
                                    String[]  l =  (regexs.findLine(alr.get(k),"BUP\\"+filenames.get(i)));
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
                                fileout.add("\n~~~~~~~~~~~~~~~~~~~\n"+regexs.realfind("BUP.*\\=",line)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        return line;
                    }).forEachOrdered((line) -> {
                        fileout.add(regexs.realfind("ip-host description.*",line));
                    });
                        ArrayList<String> newfileout = new ArrayList<>();
                        fileout.removeAll(Collections.singletonList(null));
                        for (int i = 0; i < fileout.size(); i++){
                            newfileout.add(fileout.get(i).trim());}
                       
                
                        List<String> newList = newfileout.stream()
                                .distinct()
                                .collect(Collectors.toList());
                       
                        for (int i = 0; i < newList.size(); i++) {
                          
                            String  imput18 = newList.get(i);
                            
                            /////////////////
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
                            final String regexsup ="\\d{9,16}\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\.{0,2}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}";
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
                                    
                                    
                                  vv=regexs.realfind("\\d{1,4}",vv);
                                
                                
                                
                                
                                }}
                            
                            
                            
                            /////////////////////
                            
                            
                            
                            
                           if( newList.get(i).contains("ip-host description")){
                               ////////////////////
                           
                             
                             
                              if(!regexs.find("vlan\\s\\d{4}",imput18) && vv.length()<3 ){
                                    pbr = '\n'+imput18+"\n";
                                    
                                    }
                              if(regexs.find("sec-vlan",imput18) && !regexs.find("sec-vlan\\s\\d{3,4}",imput18) )   {
                                 pbr = '\n'+imput18+"\n";
                                    
                                 }
                               ////////////////////
                           
                           }
                           else if(regexs.find("~~",imput18)||regexs.find("BUP",imput18))
                               
                               
                                {
                                    pbr = '\n'+imput18+'\n'; 
                                }
                          qq = qq + pbr;   
                        }  
                         
    return qq;
    }
    
}
