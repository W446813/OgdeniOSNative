package iOSCarrierClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementID {

	ArrayList<String> MainMenuElements = new ArrayList<String>(Arrays.asList("menu","Home", "Account Activity","Card Maintenance","Price Locator","Register Check"
			,"Statements","Transaction Rejects","Transfer Funds","Contact Us","Logout", "//span[text()='No']","//span[text()='No']"));
	ArrayList<String> InPageElements = new ArrayList<String>(Arrays.asList("refresh","cardNum","password","userInput"));
	ArrayList<String> GoBackMenuElements = new ArrayList<String>(Arrays.asList("menu-aa", "menu-ccm", "menu-pl", "menu-rc", "menu-smart-state", "menu-tran-reject","menu-trans-fund"
			,"menu-ct", "Logout"));
    
	
    private String lookupID(String ID) {
    
        
        for(String i: MainMenuElements)
        {
            if(i.equals(ID))           
            {
                return i;
            }                
        }
        return "NOT_FOUND";
    }
    
private String lookupReturnID(String ID) {
    
        
        for(String i: GoBackMenuElements)
        {
            if(i.equals(ID))           
            {
                return i;
            }                
        }
        return "NOT_FOUND";
    }
private String lookupInPageElements(String ID) {
    
    
    for(String i: InPageElements)
    {
        if(i.equals(ID))           
        {
            return i;
        }                
    }
    return "NOT_FOUND";
}

//    private String lookupID(int num)
//    {
//        
//        if(Elements.size() < num)
//        {
//            return Elements.get(num);             
//        }
//        return "NOT_FOUND";
//    }
	

	public String Menu() throws Exception {

	 return lookupID("menu");
		}

	public String Home() throws Exception {

	 return lookupID("Home");
		}
	public String AccountActivity() throws Exception {

		 return lookupID("Account Activity");
		}
	
	public String CardMaintenance() throws Exception {

		 return lookupID("Card Maintenance");
		}

		public String PriceLocator() throws Exception {

		 return lookupID("Price Locator");
		}
		public String RegisterCheck() throws Exception {

		 return lookupID("Register Check");
		}
		

		public String Statements() throws Exception {

		 return lookupID("Statements");
		}

		public String TransactionRejects() throws Exception {

		 return lookupID("Transaction Rejects");
	    }
		public String TransferFunds() throws Exception {

		 return lookupID("Transfer Funds");
		}
		public String ContactUs() throws Exception {

		 return lookupID("Contact Us");
		}
		
		public String Logout() throws Exception {

			 return lookupID("Logout");
			}
		
		
		

		
		public String MenuInsideAccountActivity() throws Exception {

			 return lookupReturnID("menu-aa");
			
				}

			public String MenuInsideCardMaintenance() throws Exception {

			 return lookupReturnID("menu-ccm");
				}
			public String MenuInsidePriceLocator() throws Exception {

				 return lookupReturnID("menu-pl");
				}
			
			public String MenuInsideRegisterCheck() throws Exception {

				 return lookupReturnID("menu-rc");
				}

				public String MenuInsideStatements() throws Exception {

				 return lookupReturnID("menu-smart-state");
				}
				public String MenuInsideTransactionRejects() throws Exception {

				 return lookupReturnID("menu-tran-reject");
				}
				public String MenuInsideTransferFunds() throws Exception {

				 return lookupReturnID("menu-trans-fund");
				}

				public String MenuInsideContactUs() throws Exception {

				 return lookupReturnID("menu-ct");
			    }
				
				
				public String RefreshElement() throws Exception {

					 return lookupInPageElements("refresh");
					}
				
				public String LoginCardNumElement() throws Exception {

					 return lookupInPageElements("userInput");
					}
				
				public String LoginCardNumElementTwo() throws Exception {

					 return lookupInPageElements("cardNum");
					}
				public String LoginPinElement() throws Exception {

					 return lookupInPageElements("password");
					}
				
}





