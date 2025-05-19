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
TestObject errorMessage = new TestObject().addProperty("xpath", 
    com.kms.katalon.core.testobject.ConditionType.EQUALS, 
    "//button[text()='Submit Spesimen' and @disabled]")

// Tunggu elemen muncul (maksimal 10 detik)
WebUI.waitForElementVisible(errorMessage, 10)

// Verifikasi teks error
WebUI.verifyElementText(errorMessage, "Submit Spesimen")

