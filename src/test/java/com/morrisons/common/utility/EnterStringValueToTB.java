package com.morrisons.common.utility;



import io.appium.java_client.android.AndroidDriver;

public class EnterStringValueToTB {

                
                public static void enterKeyPadKeys(AndroidDriver driver,String s ){
                
      
                                int lengthStr=s.length()-1;

                                
                                for(int i=0;i<=lengthStr;i++){
                                                
                                                
                                //System.out.println(s.charAt(i));
                                
                                
                                char numString =s.charAt(i);
                                
                       
                        switch (numString) {
                        
                            case '0':
                               
                               driver.pressKeyCode(7);
                               
                               System.out.println(numString);
                               
                               
                               
                    break;
                        
                            case '1':  
                               
                               driver.pressKeyCode(8);
                               System.out.println(numString);
                               
                                     break;
                            case '2': 
                               
                               driver.pressKeyCode(9);
                               
                               System.out.println(numString);
                                     break;
                            case '3':  
                               
                               driver.pressKeyCode(10);
                               
                               System.out.println(numString);
                               
                                     break;
                            case '4':  
                               
                               driver.pressKeyCode(11);
                               System.out.println(numString);
                               
                                     break;
                            case '5':  
                               
                            driver.pressKeyCode(12);
                               System.out.println(numString);
                               
                                     break;
                            case '6':  
                               
                               driver.pressKeyCode(13);
                               System.out.println(numString);
                               
                                     break;
                            case '7': 
                               
                            driver.pressKeyCode(14);
                               System.out.println(numString);
                               
                                     break;
                            case '8': 
                               
                               driver.pressKeyCode(15);
                               System.out.println(numString);
                               
                                     break;
                            case '9': 
                               
                               driver.pressKeyCode(16);
                               System.out.println(numString);
                               
                                     break;
                                     
                                     
                                     
                       //Characters
                                     
                                     
 case 'a':  
                               
                               driver.pressKeyCode(29);
                               System.out.println(numString);
                               
                                     break;
                            case 'b': 
                               
                               driver.pressKeyCode(30);
                               
                               System.out.println(numString);
                                     break;
                            case 'c':  
                               
                               driver.pressKeyCode(31);
                               
                               System.out.println(numString);
                               
                                     break;
                            case 'd':  
                               
                               driver.pressKeyCode(32);
                               System.out.println(numString);
                               
                                     break;
                            case 'e':  
                               
                            driver.pressKeyCode(33);
                               System.out.println(numString);
                               
                                     break;
                            case 'f':  
                               
                               driver.pressKeyCode(34);
                               System.out.println(numString);
                               
                                     break;
                                     
                 case 'F':  
                               
                               driver.pressKeyCode(34,59);
                               System.out.println(numString);
                               
                                     break;
                                     
                                     
                            case 'g': 
                               
                            driver.pressKeyCode(35);
                               System.out.println(numString);
                               
                                     break;
                                     
                                     
                            case 'G': 
                               
                                            driver.pressKeyCode(35,59);
                                               System.out.println(numString);
                                               
                                                     break;        
                                     
                                     
                            case 'h': 
                               
                               driver.pressKeyCode(36);
                               System.out.println(numString);
                               
                                     break;
                            case 'i': 
                               
                               driver.pressKeyCode(37);
                               System.out.println(numString);
                               
                                 break;
                                     
                  case 'j': 
                               
                               driver.pressKeyCode(38);
                               System.out.println(numString);
                               
                                     break;
                                     
                 case 'k': 
                
                              driver.pressKeyCode(39);
                              System.out.println(numString);
                
                   break;
                   
                 case 'K': 
                                              
                 driver.pressKeyCode(39, 59);
                              System.out.println(numString);
                
                      break;
                   
                   
                   
                   
         
               case 'l': 
                
                             driver.pressKeyCode(40);
                             System.out.println(numString);
                
                  break;
         
               case 'm': 
                
                           driver.pressKeyCode(41);
                           System.out.println(numString);
                
                break;
                
               case 'M': 
                               
                           driver.pressKeyCode(41,59);
                           System.out.println(numString);
                
                    break;
                
                
         
               case 'n': 
                
                            driver.pressKeyCode(42);
                            System.out.println(numString);
                
                break;
         
               case 'o': 
                
                            driver.pressKeyCode(43);
                            System.out.println(numString);
                
                 break;
         
case 'p': 
                
                driver.pressKeyCode(44);
                System.out.println(numString);
                
         break;
         
case 'q': 
                
                driver.pressKeyCode(45);
                System.out.println(numString);
                
         break;
         
case 'r': 
                
                driver.pressKeyCode(46);
                System.out.println(numString);
                
         break;
         
case 's': 
                
                driver.pressKeyCode(47);
                System.out.println(numString);
                
         break;
         
         
case 'S': 
                
                driver.pressKeyCode(47,59);
                System.out.println(numString);
                
         break;
         
case 't': 
                
                driver.pressKeyCode(48);
                System.out.println(numString);
                
         break;
         
         
case 'u': 
                
                driver.pressKeyCode(49);
                System.out.println(numString);
                
         break;
         
         
case 'v': 
                
                driver.pressKeyCode(50);
                System.out.println(numString);
                
         break;
         
         
case 'w': 
                
                driver.pressKeyCode(51);
                System.out.println(numString);
                
         break;
         
         
case 'x': 
                
                driver.pressKeyCode(52);
                System.out.println(numString);
                
         break;
         
case 'y': 
                
                driver.pressKeyCode(53);
                System.out.println(numString);
                
         break;
         
case 'z': 
                
                driver.pressKeyCode(54);
                System.out.println(numString);
                
         break;
         
case ' ': 
                
                driver.pressKeyCode(67);
                System.out.println(numString);
                
    break;
         

                            default: 
                               
                               
                                     break;
                        }
                                }  // End loop                      
}
                


}

