	package webActions

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.Point
import java.awt.Robot
import java.awt.event.InputEvent

import internal.GlobalVariable




public class Helper {
	public static void openAndMaximizeBrowser() {
		WebUI.openBrowser(GlobalVariable.BaseUrl)
		WebUI.maximizeWindow()
	}

	@Keyword
	public static void loginActions() {
		TestObject inputUserName = new TestObject().addProperty("xpath", ConditionType.CONTAINS, '//*[@id=":R2mqfb5kq:-form-item"]')
		TestObject inputPassword = new TestObject().addProperty("xpath", ConditionType.CONTAINS, '//*[@id=":R4mqfb5kq:-form-item"]/input')
		TestObject btnLogin = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//button[@type='submit' and contains(text(), 'Sign in')]");
		WebUI.setText(inputUserName, GlobalVariable.userName)
		WebUI.setText(inputPassword, GlobalVariable.password)
		WebUI.click(btnLogin)
	}

	public static void selfSign() {
		String filePath = "E:\\PDF\\sample.pdf"
		WebUI.callTestCase(findTestCase("Login_Page/P001_Login"), [:], FailureHandling.STOP_ON_FAILURE);
		WebUI.delay(5)
		TestObject clickTTEDokumen = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//a[contains(text(), 'TTE Dokumen')]");
		TestObject clickUploadDokumen = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//button[contains(text(), 'Upload Dokumen')]");
		WebUI.click(clickTTEDokumen)
		//		WebUI.click(clickUploadDokumen)
		TestObject uploadInput = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@type='file']")
		WebUI.uploadFile(uploadInput, filePath)
		WebUI.delay(3)
		TestObject clickSign = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//button[contains(@class, 'text-green-600') or contains(@class, 'text-green-400')]");
		WebUI.click(clickSign)
	}

	public static void selfSignMultiple() {
		TestObject clickSign = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//button[contains(@class, 'text-green-600') or contains(@class, 'text-green-400')]");
		WebUI.click(clickSign)
	}


	public static void requestFromOtherfSign() {
		String filePath = "E:\\PDF\\sample.pdf"
		WebUI.callTestCase(findTestCase("Login_Page/P001_Login"), [:], FailureHandling.STOP_ON_FAILURE);
		WebUI.delay(5)
		TestObject clickTTEDokumen = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//a[contains(text(), 'TTE Dokumen')]");
		TestObject clickUploadDokumen = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//button[contains(text(), 'Upload Dokumen')]");
		WebUI.click(clickTTEDokumen)
		//		WebUI.click(clickUploadDokumen)
		TestObject uploadInput = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//input[@type='file']")
		WebUI.uploadFile(uploadInput, filePath)
		WebUI.delay(3)
	}
	
	public static void guratan() {
	
		WebUI.callTestCase(findTestCase("Login_Page/P001_Login"), [:], FailureHandling.STOP_ON_FAILURE);
	}

	// **Tutup browser**lick
	public static void closeBrowser() {
		WebUI.closeBrowser()
	}
}


