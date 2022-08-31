package FunctionalTestsWexConnectiOS;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import iOSCardClasses.RepoCardiOS;
import iOSsharedClasses.AppStringsiOS;
import iOSsharedClasses.Capabilities;
import iOSsharedClasses.Logs;
import iOSsharedClasses.PhonePicker;
import iOSsharedClasses.ScrollOptionsiOS;
import io.appium.java_client.AppiumDriver;

public class WexConnectTabTest {
	static AppiumDriver<WebElement> driver;

	@Test
	public void wexConnectTabTest() throws Exception {

		Logs iOSLogs = new Logs();
		AppStringsiOS iOSText = new AppStringsiOS();
		ScrollOptionsiOS scroll = new ScrollOptionsiOS();
		PhonePicker phone = new PhonePicker();
		RepoCardiOS elements = new RepoCardiOS();

		String pass = iOSText.PASS;
		String fail = iOSText.FAIL;
		String info = iOSText.INFO;

		String tab;
		String sanFran = "San Francisco, CA";
		String newYork = "New York, NY";
		String ogdenUtah = "Ogden, UT";
		String dallasTexas = "Dallas, TX";
		String pickedLocation;
		String ev22 = "EV22";
		String edge20 = "edge20";
		String carWashOnly = "FIND A LOCTATION FOR THIS";
		

//TODO FILTERS ADD 
//TODO MORE USE CODE: edge20 (Looks for EDGE network save $0 banner) A good address is 3 ridgeway road scarboaroh ME)  
//TODO  USE CODE: ev22 (Coming SOON) 
//TODO Check for we couldnt find any stations (find a dead area with no stations or something)
//TODO add new phone allow location access
//TODO good sites for details 		
//		J1772 6.5kW AC - Dual look 527 Holly Drive, Ogden Utah (This one Found lots of places)
//		CHAdeMO 50 kW DC -  865 2nd street North, Washington UT 
//		Combo / CHAdeMO 50 kW DC - 865 2nd street North, Washington UT 
//		CHAdeMO 62.5kW DC - 884 Park Avenue, New York NY
//		Combo 62.0kW DC - 884 Park Avenue, New York NY
//		Combo 24.0kW DC - 183 Washington street, Las Vegas, NV 
//		CHAdeMO 500.0kW DC -  1746 Primrose Path, Las Vegas, NV  
//		Unknown location: 437 8th street South, New York, NY 
//		Lots of locations: Atlanta, GA 

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Smoke Test ";
		String build = "Build #:  ";
		String appName = "Wex Connect ";
		String server = "Stage ";

		try {
			iOSLogs.setupTestYellow(TestName + build + appName +server);

			System.out.println(phone.autoPhonePickerWexConnect(appName));

//More tab	
			tab = "MORE TAB";
			iOSLogs.setupTest("MORE TAB");
			Thread.sleep(3000);
			WebElement MoreTab = elements.MoreTab();
			Thread.sleep(3000);
			if (MoreTab != null && MoreTab.isEnabled()) {
				MoreTab.click();
				iOSLogs.CapturedLogs(pass, "More Tab found and pressed");

//				Promo Codes
//				ev22: Go back to maps and find a few with a banner for this (Probably find a location prior and use it.)
//				edge20  Go back to maps and find a few with a banner for this (Probably find a location prior and use it.)

				Thread.sleep(3000);
				WebElement WexConnectPromoCodesButton = elements.WexConnectPromoCodesButton();
				Thread.sleep(3000);
				if (WexConnectPromoCodesButton != null && WexConnectPromoCodesButton.isEnabled()) {
					WexConnectPromoCodesButton.click();
					Thread.sleep(3000);

					iOSLogs.CapturedLogs(pass, "Promo codes is found and pressed");
					Thread.sleep(2000);

					Thread.sleep(3000);
					WebElement WCDoneButton = elements.WCDoneButton();
					Thread.sleep(3000);
					if (WCDoneButton != null && WCDoneButton.isEnabled()) {
						WCDoneButton.click();

						iOSLogs.CapturedLogs(pass, "Done Button selected");
					} else {
						iOSLogs.CapturedLogs(info, "Done Button not found");
					}

					WebElement WexConnectPromoCodeTextBoxEV22 = elements.WexConnectPromoCodeTextBox(ev22);
					Thread.sleep(3000);
					if (WexConnectPromoCodeTextBoxEV22 != null && WexConnectPromoCodeTextBoxEV22.isEnabled()) {
						WexConnectPromoCodeTextBoxEV22.click();
						WexConnectPromoCodeTextBoxEV22.sendKeys(ev22);
						iOSLogs.CapturedLogs(pass, "Promo code " + ev22 + " added to text box");

						Thread.sleep(2000);
						WebElement WexConnectPromoCodeEnterCodeButtonEV22 = elements
								.WexConnectPromoCodeEnterCodeButton();
						Thread.sleep(3000);
						if (WexConnectPromoCodeEnterCodeButtonEV22 != null
								&& WexConnectPromoCodeEnterCodeButtonEV22.isEnabled()) {
							WexConnectPromoCodeEnterCodeButtonEV22.click();
							iOSLogs.CapturedLogs(pass, "ENTER CODE for " + ev22 + " Button selected");
							Thread.sleep(2000);

							Thread.sleep(3000);
							WebElement WexConnectPromoCodeAddCodeButton = elements.WexConnectPromoCodeAddCodeButton();
							Thread.sleep(3000);
							if (WexConnectPromoCodeAddCodeButton != null
									&& WexConnectPromoCodeAddCodeButton.isEnabled()) {
								WexConnectPromoCodeAddCodeButton.click();
								iOSLogs.CapturedLogs(pass, "Add code Button selected");
								Thread.sleep(2000);

								Thread.sleep(3000);
								WebElement WCDonePlusButton = elements.WCDoneButton();
								Thread.sleep(3000);
								if (WCDonePlusButton != null && WCDonePlusButton.isEnabled()) {
									WCDonePlusButton.click();

									iOSLogs.CapturedLogs(pass, "Done plus Button selected");
								} else {
									iOSLogs.CapturedLogs(info, "Done plus not found");
								}

								WebElement WexConnectPromoCodeTextBoxEdge20 = elements
										.WexConnectPromoCodeTextBox(edge20);
								Thread.sleep(3000);
								if (WexConnectPromoCodeTextBoxEdge20 != null
										&& WexConnectPromoCodeTextBoxEdge20.isEnabled()) {
									WexConnectPromoCodeTextBoxEdge20.click();
									WexConnectPromoCodeTextBoxEdge20.sendKeys(edge20);
									iOSLogs.CapturedLogs(pass, "Promo code " + edge20 + " added to text box");

									Thread.sleep(2000);
									WebElement WexConnectPromoCodeEnterCodeButtonEdge20 = elements
											.WexConnectPromoCodeEnterCodeButton();
									Thread.sleep(3000);
									if (WexConnectPromoCodeEnterCodeButtonEdge20 != null
											&& WexConnectPromoCodeEnterCodeButtonEdge20.isEnabled()) {
										WexConnectPromoCodeEnterCodeButtonEdge20.click();
										iOSLogs.CapturedLogs(pass, "ENTER CODE for " + edge20 + " Button selected");
										Thread.sleep(2000);

										Capabilities.driver.navigate().back();
										iOSLogs.CapturedLogs(info, "Back Button from add promo screen pressed");

									} else {
										iOSLogs.CapturedLogs(info, "Promo code " + edge20 + " Text Box is not found");
									}

								} else {
									iOSLogs.CapturedLogs(info, "Promo code " + edge20 + " is not found");
								}

							} else {
								iOSLogs.CapturedLogs(info, "Add code Button is not found");
							}

						} else {
							iOSLogs.CapturedLogs(info, "ENTER CODE for " + ev22 + " is not found");
						}

					} else {
						iOSLogs.CapturedLogs(info, "Promo code " + ev22 + " Text Box is not found");
					}

				} else {
					iOSLogs.CapturedLogs(info, "Promo codes button is not found");
				}

//				Share
//				click and tap somewhere else on screen 
//					Thread.sleep(3000);

//TODO NO SHARE BUTTON FOUND??
//				WebElement WexConnectShareButton = elements.WexConnectShareButton();
//				Thread.sleep(3000);
//				if (WexConnectShareButton != null && WexConnectShareButton.isEnabled()) {
//					WexConnectShareButton.click();
//					iOSLogs.CapturedLogs(pass, "Share Button is found and pressed");
//					Thread.sleep(3000);
//
//					Capabilities.driver.navigate().back();
//					iOSLogs.CapturedLogs(pass, "Back Button pressed");
//
//				} else {
//					iOSLogs.CapturedLogs(info, "Share Button button is not found");
//				}

//				Terms of use 
//				Open and look for word general then push back (Can't find this its in a WebView) 
//				
				WebElement WexConnectTOUButton = elements.WexConnectTOUButton();
				Thread.sleep(3000);
				if (WexConnectTOUButton != null && WexConnectTOUButton.isEnabled()) {
					WexConnectTOUButton.click();
					iOSLogs.CapturedLogs(pass, "Terms of Use is found and pressed");
					Thread.sleep(3000);

					Capabilities.driver.navigate().back();
					iOSLogs.CapturedLogs(pass, "Back Button pressed");

				} else {
					iOSLogs.CapturedLogs(info, "Share Button button is not found");
				}
//				
//				privacy policy 
//				Open and look for word effective then push back 
//				
				WebElement WexConnectPPButton = elements.WexConnectPPButton();
				Thread.sleep(3000);
				if (WexConnectPPButton != null && WexConnectPPButton.isEnabled()) {
					WexConnectPPButton.click();
					iOSLogs.CapturedLogs(pass, "Privacy Policy is found and pressed");
					Thread.sleep(3000);

					Capabilities.driver.navigate().back();
					iOSLogs.CapturedLogs(pass, "Back Button pressed");

				} else {
					iOSLogs.CapturedLogs(info, "Privacy Policy button is not found");
				}

//				Version 
//				Check version shown in app text and add to test 

			} else {
				iOSLogs.CapturedLogs(info, tab + " found and pressed");
			}

//GAS TAB		
			tab = "GAS TAB";
			iOSLogs.setupTest("GAS TAB");
			Thread.sleep(3000);
			WebElement GasTab = elements.GasTab();
			Thread.sleep(3000);
			if (GasTab != null && GasTab.isEnabled()) {
				GasTab.click();
				iOSLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				iOSLogs.CapturedLogs(info, tab + " is not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyGasTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyGasTab != null && SearchNearbyGasTab.isEnabled()) {
				SearchNearbyGasTab.click();

				iOSLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = sanFran;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxGasTab = elements.SearchNearbyTextBox();
			Thread.sleep(3000);
			if (SearchNearbyTextBoxGasTab != null && SearchNearbyTextBoxGasTab.isEnabled()) {
				SearchNearbyTextBoxGasTab.click();
				SearchNearbyTextBoxGasTab.sendKeys(pickedLocation);
				iOSLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationGasTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationGasTab != null && SelectLocationGasTab.isEnabled()) {
				SelectLocationGasTab.click();
				iOSLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				iOSLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			Thread.sleep(3000);
			// scroll.ScrollUp();
			scroll.ScrollDown();
			scroll.ScrollUp();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement MapButtonGasTab = elements.MapButton();
			Thread.sleep(3000);
			if (MapButtonGasTab != null && MapButtonGasTab.isEnabled()) {
				MapButtonGasTab.click();
				iOSLogs.CapturedLogs(pass, "Map Button found and selected");
			} else {
				iOSLogs.CapturedLogs(info, "Map Button found not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyGasMapTab = elements.SearchNearbyWithText(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyGasMapTab != null && SearchNearbyGasMapTab.isEnabled()) {
				SearchNearbyGasTab.click();

				iOSLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = newYork;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxGasMapTab = elements.SearchNearbyTextBox();
			Thread.sleep(3000);
			if (SearchNearbyTextBoxGasMapTab != null && SearchNearbyTextBoxGasMapTab.isEnabled()) {
				SearchNearbyTextBoxGasMapTab.click();
				SearchNearbyTextBoxGasMapTab.sendKeys(pickedLocation);
				iOSLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationGasMapTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationGasMapTab != null && SelectLocationGasMapTab.isEnabled()) {
				SelectLocationGasMapTab.click();
				iOSLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				iOSLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			// TODO do more with the map results latter
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(pass, "Map results Displayed");
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement ListViewButtonGasTab = elements.ListViewButton();
			Thread.sleep(3000);
			if (ListViewButtonGasTab != null && ListViewButtonGasTab.isEnabled()) {
				ListViewButtonGasTab.click();
				iOSLogs.CapturedLogs(pass, "List View Button found and selected");
			} else {
				iOSLogs.CapturedLogs(info, "List View Button not found");
			}

//ChargeTab
			tab = "CHARGE TAB";
			iOSLogs.setupTest("CHARGE TAB");
			Thread.sleep(3000);
			WebElement ChargeTab = elements.ChargeTab();
			Thread.sleep(3000);
			if (ChargeTab != null && ChargeTab.isEnabled()) {
				ChargeTab.click();
				iOSLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				iOSLogs.CapturedLogs(info, tab + " is not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyChargeTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyChargeTab != null && SearchNearbyChargeTab.isEnabled()) {
				SearchNearbyChargeTab.click();

				iOSLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = sanFran;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxChargeTab = elements.SearchNearbyTextBox();
			Thread.sleep(3000);
			if (SearchNearbyTextBoxChargeTab != null && SearchNearbyTextBoxChargeTab.isEnabled()) {
				SearchNearbyTextBoxChargeTab.click();
				SearchNearbyTextBoxChargeTab.sendKeys(pickedLocation);
				iOSLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationChargeTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationChargeTab != null && SelectLocationChargeTab.isEnabled()) {
				SelectLocationChargeTab.click();
				iOSLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				iOSLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			Thread.sleep(3000);
			// scroll.ScrollUp();
			scroll.ScrollDown();
			scroll.ScrollUp();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement MapButtonChargeTab = elements.MapButton();
			Thread.sleep(3000);
			if (MapButtonChargeTab != null && MapButtonChargeTab.isEnabled()) {
				MapButtonChargeTab.click();
				iOSLogs.CapturedLogs(pass, "Map View Button found and selected");
			} else {
				iOSLogs.CapturedLogs(info, "Map View Button not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyChargeMapTab = elements.SearchNearbyWithText(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyChargeMapTab != null && SearchNearbyChargeMapTab.isEnabled()) {
				SearchNearbyChargeMapTab.click();

				iOSLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			pickedLocation = newYork;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxChargeMapTab = elements.SearchNearbyTextBox();
			Thread.sleep(3000);
			if (SearchNearbyTextBoxChargeMapTab != null && SearchNearbyTextBoxChargeMapTab.isEnabled()) {
				SearchNearbyTextBoxChargeMapTab.click();
				SearchNearbyTextBoxChargeMapTab.sendKeys(pickedLocation);
				iOSLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationChargeMapTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationChargeMapTab != null && SelectLocationChargeMapTab.isEnabled()) {
				SelectLocationChargeMapTab.click();
				iOSLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				iOSLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			// TODO do more with the map results latter
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(pass, "Map results Displayed");
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement ListViewButtonChargeTab = elements.ListViewButton();
			Thread.sleep(3000);
			if (ListViewButtonChargeTab != null && ListViewButtonChargeTab.isEnabled()) {
				ListViewButtonChargeTab.click();
				iOSLogs.CapturedLogs(pass, "List View Button found and selected");
			} else {
				iOSLogs.CapturedLogs(info, "List View Button not found");
			}

//Service tab
			tab = "SERVICE TAB";
			iOSLogs.setupTest("SERVICE TAB");
			Thread.sleep(3000);
			WebElement ServiceTab = elements.ServiceTab();
			Thread.sleep(3000);
			if (ServiceTab != null && ServiceTab.isEnabled()) {
				ServiceTab.click();
				iOSLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				iOSLogs.CapturedLogs(info, tab + " is not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyServiceTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyServiceTab != null && SearchNearbyServiceTab.isEnabled()) {
				SearchNearbyServiceTab.click();

				iOSLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = sanFran;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxServiceTab = elements.SearchNearbyTextBox();
			Thread.sleep(3000);
			if (SearchNearbyTextBoxServiceTab != null && SearchNearbyTextBoxServiceTab.isEnabled()) {
				SearchNearbyTextBoxServiceTab.click();
				SearchNearbyTextBoxServiceTab.sendKeys(sanFran);
				iOSLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + sanFran);
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationServiceTab = elements.SelectLocation(sanFran);
			Thread.sleep(3000);
			if (SelectLocationServiceTab != null && SelectLocationServiceTab.isEnabled()) {
				SelectLocationServiceTab.click();
				iOSLogs.CapturedLogs(pass, "Search for location and it was found");
			} else {
				iOSLogs.CapturedLogs(info, "Search for location and it was not found");
			}

			Thread.sleep(3000);
			// scroll.ScrollUp();
			scroll.ScrollDown();
			scroll.ScrollUp();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement MapButtonServicesTab = elements.MapButton();
			Thread.sleep(3000);
			if (MapButtonServicesTab != null && MapButtonServicesTab.isEnabled()) {
				MapButtonServicesTab.click();
				iOSLogs.CapturedLogs(pass, "Map View Button found and selected");
			} else {
				iOSLogs.CapturedLogs(info, "Map View Button not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyServicesMapTab = elements.SearchNearbyWithText(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyServicesMapTab != null && SearchNearbyServicesMapTab.isEnabled()) {
				SearchNearbyServicesMapTab.click();

				iOSLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = newYork;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxServicesMapTab = elements.SearchNearbyTextBox();
			Thread.sleep(3000);
			if (SearchNearbyTextBoxServicesMapTab != null && SearchNearbyTextBoxServicesMapTab.isEnabled()) {
				SearchNearbyTextBoxServicesMapTab.click();
				SearchNearbyTextBoxServicesMapTab.sendKeys(pickedLocation);
				iOSLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationServicesMapTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationServicesMapTab != null && SelectLocationServicesMapTab.isEnabled()) {
				SelectLocationServicesMapTab.click();
				iOSLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				iOSLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			// TODO do more with the map results latter
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(pass, "Map results Displayed");
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement ListViewButtonServiceTab = elements.ListViewButton();
			Thread.sleep(3000);
			if (ListViewButtonServiceTab != null && ListViewButtonServiceTab.isEnabled()) {
				ListViewButtonServiceTab.click();
				iOSLogs.CapturedLogs(pass, "List View Button found and selected");
			} else {
				iOSLogs.CapturedLogs(info, "List View Button not found");
			}

//Car Wash Tab
			tab = "CARWASH TAB";
			iOSLogs.setupTest(tab);
			Thread.sleep(3000);
			WebElement CarWashTab = elements.CarWashTab();
			Thread.sleep(3000);
			if (CarWashTab != null && CarWashTab.isEnabled()) {
				CarWashTab.click();
				iOSLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				iOSLogs.CapturedLogs(info, tab + " Tab is not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyCarWashTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyCarWashTab != null && SearchNearbyCarWashTab.isEnabled()) {
				SearchNearbyCarWashTab.click();

				iOSLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = sanFran;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxCarWashTab = elements.SearchNearbyTextBox();
			Thread.sleep(3000);
			if (SearchNearbyTextBoxCarWashTab != null && SearchNearbyTextBoxCarWashTab.isEnabled()) {
				SearchNearbyTextBoxCarWashTab.click();
				SearchNearbyTextBoxCarWashTab.sendKeys(sanFran);
				iOSLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + sanFran);
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationCarWashTab = elements.SelectLocation(sanFran);
			Thread.sleep(3000);
			if (SelectLocationCarWashTab != null && SelectLocationCarWashTab.isEnabled()) {
				SelectLocationCarWashTab.click();
				iOSLogs.CapturedLogs(pass, "Search for location and it was found");
			} else {
				iOSLogs.CapturedLogs(info, "Search for location and it was not found");
			}

			Thread.sleep(3000);
			// scroll.ScrollUp();
			scroll.ScrollDown();
			scroll.ScrollUp();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement MapButtonCarWashTab = elements.MapButton();
			Thread.sleep(3000);
			if (MapButtonCarWashTab != null && MapButtonCarWashTab.isEnabled()) {
				MapButtonCarWashTab.click();
				iOSLogs.CapturedLogs(pass, "Map View Button found and selected");
			} else {
				iOSLogs.CapturedLogs(info, "Map View Button not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyCarWashMapTab = elements.SearchNearbyWithText(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyCarWashMapTab != null && SearchNearbyCarWashMapTab.isEnabled()) {
				SearchNearbyCarWashMapTab.click();

				iOSLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = ogdenUtah;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxCarWashMapTab = elements.SearchNearbyTextBox();
			Thread.sleep(3000);
			if (SearchNearbyTextBoxCarWashMapTab != null && SearchNearbyTextBoxCarWashMapTab.isEnabled()) {
				SearchNearbyTextBoxCarWashMapTab.click();
				SearchNearbyTextBoxCarWashMapTab.sendKeys(pickedLocation);
				iOSLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				iOSLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationCarWashMapTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationCarWashMapTab != null && SelectLocationCarWashMapTab.isEnabled()) {
				SelectLocationCarWashMapTab.click();
				iOSLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				iOSLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			// TODO do more with the map results latter
			Thread.sleep(3000);
			iOSLogs.CapturedLogs(pass, "Map results Displayed");
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement ListViewButtonCarWashTab = elements.ListViewButton();
			Thread.sleep(3000);
			if (ListViewButtonCarWashTab != null && ListViewButtonCarWashTab.isEnabled()) {
				ListViewButtonCarWashTab.click();
				iOSLogs.CapturedLogs(pass, "List View Button found and selected");
			} else {
				iOSLogs.CapturedLogs(info, "List View Button not found");
			}

//DELETE USED Promo Codes after test
			tab = "MORE TAB";
			iOSLogs.setupTest("MORE TAB");
			Thread.sleep(3000);
			WebElement MoreTabDeletePromoCodes = elements.MoreTab();
			Thread.sleep(3000);
			if (MoreTabDeletePromoCodes != null && MoreTabDeletePromoCodes.isEnabled()) {
				MoreTabDeletePromoCodes.click();
				iOSLogs.CapturedLogs(pass, tab + " found and pressed");

				Thread.sleep(3000);
				WebElement WexConnectPromoCodesButtonTwo = elements.WexConnectPromoCodesButton();
				Thread.sleep(3000);
				if (WexConnectPromoCodesButtonTwo != null && WexConnectPromoCodesButtonTwo.isEnabled()) {
					WexConnectPromoCodesButtonTwo.click();
					Thread.sleep(3000);

					Thread.sleep(3000);
					WebElement WCRemovePromoOne = elements.WCRemovePromoOne();
					Thread.sleep(3000);
					if (WCRemovePromoOne != null && WCRemovePromoOne.isEnabled()) {
						WCRemovePromoOne.click();
						iOSLogs.CapturedLogs(pass, "Promo codes remove one selected");
					} else {
						iOSLogs.CapturedLogs(info, "Promo codes remove one not found");
					}

					Thread.sleep(3000);
					WebElement WCRemovePromoTwo = elements.WCRemovePromoTwo();
					Thread.sleep(3000);
					if (WCRemovePromoTwo != null && WCRemovePromoTwo.isEnabled()) {
						WCRemovePromoTwo.click();
						iOSLogs.CapturedLogs(pass, "Promo codes remove two selected");
					} else {
						iOSLogs.CapturedLogs(info, "Promo codes remove two not found");
					}

					iOSLogs.CapturedLogs(pass, "Promo codes two is found and pressed");
					Thread.sleep(2000);

				} else {
					iOSLogs.CapturedLogs(info, "Promo codes two Button not found");
				}

				Thread.sleep(3000);
				WebElement WCCancelButton = elements.WCCancelButton();
				Thread.sleep(3000);
				if (WCCancelButton != null && WCCancelButton.isEnabled()) {
					WCCancelButton.click();

					iOSLogs.CapturedLogs(pass, "Cancel Button selected");
				} else {
					iOSLogs.CapturedLogs(info, "Cancel Button not found");
				}

			} else {
				iOSLogs.CapturedLogs(info, tab + " is not found");
			}

			tab = "GAS TAB";
			iOSLogs.setupTest("GAS TAB");
			Thread.sleep(3000);
			WebElement OpenGasTabAfterPromoDelete = elements.GasTab();
			Thread.sleep(3000);
			if (OpenGasTabAfterPromoDelete != null && OpenGasTabAfterPromoDelete.isEnabled()) {
				OpenGasTabAfterPromoDelete.click();
				iOSLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				iOSLogs.CapturedLogs(info, tab + " is not found");
			}

			Thread.sleep(5000);

			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			iOSLogs.CapturedLogs(info, "Wex Connect open and close app Completed");

		} catch (Exception exp) {
			String errorMessage = exp.getMessage();
			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);
			} else {
				System.out.println("Error is: " + errorMessage);
			}
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			try {
				iOSLogs.CapturedLogs(fail, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}