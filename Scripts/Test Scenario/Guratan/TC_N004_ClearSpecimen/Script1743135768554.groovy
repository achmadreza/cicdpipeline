import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.ConditionType

import webActions.Helper as Helper

WebUI.callTestCase(findTestCase("Login_Page/P001_Login"), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/Page_Xignature App/a_Pengaturan'))
//WebUI.click(findTestObject('Object Repository/Page_Xignature App/p_Pengaturan Specimen'))

TestObject iconButton = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//p[text()='Pengaturan Spesimen']")
WebUI.click(iconButton)
WebUI.click(findTestObject('Object Repository/Page_Xignature App/button_Create'))
TestObject specimenButton = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//div[@role='menuitem' and contains(@class, 'cursor-default') and text()='Spesimen']")
WebUI.click(specimenButton)
WebUI.click(findTestObject('Object Repository/Page_Xignature App/div_Upload Spesimen_w-300px h-300px border border-slate-500 darkborder-white bg-white flex justify-center items-center cursor-pointer'))
TestObject canvasObject = new TestObject()
canvasObject.addProperty("xpath", ConditionType.EQUALS, "//canvas[contains(@class, 'border border-slate-500')]")
WebElement canvas = WebUI.findWebElement(canvasObject)
def driver = DriverFactory.getWebDriver()
Actions action = new Actions(driver)

// Simulasi menggambar tanda tangan dengan mouse
action.moveToElement(canvas, 10, 10)
	  .clickAndHold()
	  .moveByOffset(50, 50)
	  .moveByOffset(-30, 20)
	  .moveByOffset(40, -10)
	  .release()
	  .perform()

// Klik tombol "Save" untuk menyimpan tanda tangan
TestObject clearButton = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//button[contains(@class, 'bg-red-500') and normalize-space()='Clear']")
WebUI.click(clearButton)





