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
class tokenObject { 
	String token
}
def jsonObjectToken = new tokenObject( 
	token: GlobalVariable.accessTokenGlints,
)
class localStorage {
	Object session
}
def jsonObject = new localStorage(
	session: jsonObjectToken,
)
def jsonString = JsonOutput.toJson(jsonObject)
WebUI.navigateToUrl('https://employers.staging.glints.id')
WebUI.executeJavaScript("localStorage.setItem('glintsEmployersApp','" + jsonString + "')", null)
WebUI.navigateToUrl('https://employers.staging.glints.id/dashboard')
WebUI.verifyElementVisible(findTestObject('Page_glints/card_jobList'))
WebUI.executeJavaScript('localStorage.clear()', null)

