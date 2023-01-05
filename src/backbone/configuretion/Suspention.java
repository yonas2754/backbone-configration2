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
public class Suspention {
    
    public String Suspention(String t){
         
                        String qq="";
                        Regex regexx = new Regex();
                        ArrayList<String> alr = new ArrayList<>();
                       
                        
                        
                        String input =t;
                        input = input.trim();
                        
                        
                        // For loop for iterating over the List
                        
                        
                        String[] lines = input.split("\\r?\\n");
                        for (String line : lines) {
                      //      System.out.println(line);
                            if(regexx.find("^ip-host description.*?\\d+(M|K)[^ ]*?$",line)){
                                alr.add(line);}
                            
                        }
                        
                        
//opreation
for (int i = 0; i < alr.size(); i++) {
   // System.out.println("yonau");
    String  imput1 = alr.get(i).replace(",","");
    
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
    //System.out.println(imput18);
    ////////////////////////
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
         //System.out.println("20 is"+imput20);
   
         
         imput25 = regexx.realfind("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}",imput25);
         
         
         
         if("".equals(imput20)&&!"".equals(imput25)){
              
            //  System.out.println("f2 is"+ first2);
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
             
            /// System.out.println(imput21);
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
                     System.out.println("18 is "+ imput18);

            //////////////////////////////
            
    ////////////////////////////
    
    String xsec  ="";
    String xch  ="";
    String yph  ="";
    String yph1  ="";
    String vv1  ="";
    String chj  ="";
    int ag;
    String ypo  ="";
    String removesec  ="";
    String rsec  ="";
    String ssec  ="";
    String z ="";
    String date ="";
    int size ;
    String stri ="";
    String strii ="";
    String ypu ="";
    String ffinal ="";
    String ffinals ="";
    String ypht ="";
    String pbr ="";
    String vxch ="";
    String vxch2 ="";
    String vrsec ="";
    String vsec ="";
    
    
    
    final String regex = "\\d{9,16}\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}\\-{0,1}\\_{0,1}\\w{0,1}\\d{3,4}";
    final String regexsup =     "\\d{9,16}\\-{0,2}\\.{0,2}[a-zA-Z]{0,1}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}\\-{0,2}\\.{0,2}\\w{0,15}-{0,2}\\.{0,2}\\w{0,15}\\.{0,2}\\-{0,2}\\d{0,3}\\-{0,1}\\w{0,5}\\-{0,1}\\d{0,3}\\-{0,1}";
    
    xsec =regexx.realfind("sec-vlan\\s\\d{2,4}",imput18);
    xsec = xsec.trim();
    //System.out.println("xsec"+xsec);
    
    xch =regexx.realfind("sec-vlan",imput18);
    xch = xch.trim();
    
    //System.out.println("xch"+xch);
    yph =regexx.realfind(regexsup,imput18);
    yph = yph.trim();
    
  
            
   
    //System.out.println("yph"+yph);
    
    yph1 =regexx.realfind(regex,imput18);
    yph1 = yph1.trim();
    //System.out.println("yph1"+yph1);
    
    
    
    
    if(!"".equals(yph1)){
        vv1 = yph1.substring(yph1.length() - 4);
      //  System.out.println("vv1"+vv1);
        chj = regexx.realfind("^.*\\d{3,4}$",vv1);
        chj = chj.trim();
        //System.out.println("chj"+chj);
        ag =chj.length();
        
        
    }else{ag=0;}
    //System.out.println("vv1"+vv1);
    
    
    
    
    ypo=regexx.realfind("\\d{9,15}",imput18);
    
    if ("sec-vlan".equals(xch)){
        
        
        removesec = regexx.sub("sec-vlan\\s\\d{2,4}","",  imput18);
      //  System.out.println("removesec "+removesec);
        
        if (!"".equals(yph)){
            rsec = regexx.sub("sec-vlan","b", xsec);
            ssec=regexx.sub("\\s","", rsec);
            z =  yph + ssec;
            
            
            
          if (z.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 String st=regexx.sub(imput21,"",yph);
               String   sr=st.substring(0,17);
                 ypu = sr+ imput21;
                  //System.out.println("ypu"+ypu);
                 z =  ypu+ ssec;        
                }
                else {
                date = yph.substring(yph.length() - 7);  
                size = date.length();  
                stri=yph.substring(0,17); 
                strii = stri + "-";
                ypu = strii + date ;
                z =  ypu+ ssec;
                }
            }
            
            
            ffinal = regexx.sub(yph, z,removesec);
            ffinals = regexx.sub("\\s\\s+" , " ", ffinal);
            ypht=regexx.realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}" ,ffinals);
            ypht = ypht.trim();
            pbr = "no ip-host "+ypht+"\ny";
            qq=qq+"\n"+pbr+"\n"+ffinals;
            
            
        }
    }      
    else if( !"sec-vlan".equals(xch) && ag ==0) {
        
        vxch = regexx.realfind("vlan\\s\\d{4}",imput18);
        size = vxch.length();
        
        vxch2 = vxch;
       // System.out.println("vxchvxchvxch222222222"+vxch2);
        
        vxch=vxch.substring(0,vxch.length() - 2);
        
        
        //System.out.println("vxchvxchvxch"+vxch);
        removesec = regexx.sub("vlan\\s\\d{2,4}",vxch,  imput18);
        
        yph = regexx.realfind(regexsup,imput18);
        yph = yph.trim();
        if (!"".equals(yph)){
            vrsec = regexx.sub("vlan","b",vxch2);
            vsec=regexx.sub("\\s", "", vrsec);
            z =  yph + vsec;
     
           if (z.length()>31){
                if (!"".equals(imput20)||!"".equals(imput25)){
                 String st=regexx.sub(imput21,"",yph);
               String   sr=st.substring(0,17);
                 ypu = sr+ imput21;
                  
                 z =  ypu+ vsec;        
                }
                else {
                date = yph.substring(yph.length() - 7);  
                size = date.length();  
                stri=yph.substring(0,17); 
                strii = stri + "-";
                ypu = strii + date ;
                z =  ypu+ vsec;
                 
                }
            }
            
            ffinal = regexx.sub(yph, z,removesec);
            ffinals = regexx.sub("\\s\\s+" , " ", ffinal);
            
            ypht=regexx.realfind("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}" ,ffinals);
            ypht = ypht.trim();
            pbr = "no ip-host "+ypht+"\ny";
            qq=qq+"\n"+pbr+"\n"+ffinals;
            
            
            
            
            
        }
        
        
    }
    
    
    
    
    
    
}


        
    return qq;
    }
}
