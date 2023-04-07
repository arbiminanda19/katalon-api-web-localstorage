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
import groovy.json.*

WebUI.openBrowser('')

//localStorage key with json object
class LocalStorage { 
	String accessToken
	String companyId
	String company_name
	String email
	String id
	String name
	String officeId
	String refreshToken
	String role 
}
def jsonObject = new LocalStorage( 
	accessToken: GlobalVariable.accessToken,
	companyId: GlobalVariable.companyId,
	company_name: GlobalVariable.companyName,
	email: GlobalVariable.email,
	id: GlobalVariable.id,
	name: GlobalVariable.name,
	officeId: GlobalVariable.officeId,
	refreshToken: GlobalVariable.refreshToken,
	role: GlobalVariable.role,
)
def jsonString = JsonOutput.toJson(jsonObject)
WebUI.navigateToUrl('https://kasirdemo.belajarqa.com')
WebUI.executeJavaScript("localStorage.setItem('KASIRAJA_USER','" + jsonString + "')", null)
WebUI.navigateToUrl('https://kasirdemo.belajarqa.com/dashboard')
WebUI.delay(2)
WebUI.refresh()
WebUI.verifyElementVisible(findTestObject('Page_kasirAja/h3_kasirAja'))
WebUI.executeJavaScript('localStorage.clear()', null)

