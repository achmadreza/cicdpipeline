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
import webActions.Helper as Helper
import com.kms.katalon.core.testobject.ConditionType

Helper.selfSign()

WebUI.click(findTestObject('Object Repository/Page_Xignature App/div_Tanda Tangan'))

WebUI.dragAndDropToObject(findTestObject('Page_Xignature App/div_Tanda Tangan'), findTestObject('Page_Xignature App/div_of5_absolute inset-0'))

WebUI.click(findTestObject('Object Repository/Page_Xignature App/button_Sign Now'))

WebUI.click(findTestObject('Object Repository/Page_Xignature App/div_pinVerifikasi melalui pin'))
WebUI.click(findTestObject('Object Repository/Page_Xignature App/buttonSubmit'))

String otp = '113457'

// Loop untuk memasukkan setiap digit OTP ke dalam field input
for (int i = 0; i < otp.length(); i++) {
    TestObject otpField = new TestObject().addProperty("xpath", ConditionType.EQUALS, "(//input[contains(@class, 'pincode-input-text')])[" + (i+1) + "]")
    WebUI.setText(otpField, otp.charAt(i).toString())
    WebUI.delay(0.5) // Delay kecil untuk memastikan input sukses
}

// Klik tombol Submit
TestObject submitButton = new TestObject().addProperty("xpath", ConditionType.CONTAINS, "//button[contains(text(), 'Submit') and @type='submit']")
WebUI.click(submitButton)

TestObject errorMessage = new TestObject().addProperty("xpath", 
    com.kms.katalon.core.testobject.ConditionType.EQUALS, 
    "//div[@role='status' and contains(@class, 'go3958317564')]")

// Tunggu elemen muncul (maksimal 10 detik)
WebUI.waitForElementVisible(errorMessage, 10)

// Verifikasi teks error
WebUI.verifyElementText(errorMessage, "Pin anda salah.")

// Tunggu beberapa saat untuk verifikasi
WebUI.delay(3)
