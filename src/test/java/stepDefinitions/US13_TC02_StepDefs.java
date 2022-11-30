package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.MedunnaPages;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US13_TC02_StepDefs {
    MedunnaPages pages=new MedunnaPages();

    Actions action=new Actions(Driver.getDriver());
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    StringBuilder expectedAppointmentId=null;
    StringBuilder expectedPatientName=null;
    SoftAssert softAssert=new SoftAssert();
    String color = "yellow";
    String color1 = "black";


    @And("Doktor acilan sayfada Request Inpatient'a tiklar.")
    public void doktorAcilanSayfadaRequestInpatientATiklar() {
        jse.executeScript("arguments[0].style.border = '4px solid "+color1+"'", pages.requestInpatientButton);
        jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'" , pages.requestInpatientButton);
        ReusableMethods.waitFor(1);
        pages.requestInpatientButton.click();
    }

    @And("Doktor ekranda islem ile ilgili mesaji gorur.")
    public void doktorEkrandaIslemIleIlgiliMesajiGorur() {


        ReusableMethods.waitForVisibility(pages.inPatientRoleAlert,10);
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 6px solid black;');", pages.inPatientRoleAlert);
        //jse.executeScript("arguments[0].setAttribute('style', ' border: 6px solid black;');", pages.inPatientRoleAlert);
        softAssert.assertTrue(pages.inPatientRoleAlert.isDisplayed(),"Mesaj görüntülenemedi");
        ReusableMethods.waitFor(1);
    }

    @And("Doktor My PAGES menusu altindaki My Inpatients'a tiklar.")
    public void doktorMyPAGESMenusuAltindakiMyInpatientsATiklar() {
        jse.executeScript("arguments[0].style.border = '4px solid "+color1+"'", pages.myPagesMenu);
        jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'" , pages.myPagesMenu);
        ReusableMethods.waitFor(1);
        pages.myPagesMenu.click();

        jse.executeScript("arguments[0].style.border = '4px solid "+color1+"'", pages.myinpatientsClick);
        jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'" , pages.myinpatientsClick);
        ReusableMethods.waitFor(1);
        jse.executeScript("arguments[0].click();", pages.myinpatientsClick);
    }

    @Then("Doktor hastasinin In Patients listesinde oldugunu gorur.")
    public void doktorHastasininInPatientsListesindeOldugunuGorur() {


        List<WebElement> actualInPatientAppointmentIds=pages.inpatientAppointmentsIds;
        List<WebElement> actualInPatientDatas=pages.inPatientDatas;

        jse.executeScript("arguments[0].style.border = '4px solid "+color1+"'",actualInPatientAppointmentIds.get(2) );
        jse.executeScript("arguments[0].style.border = '4px solid "+color1+"'",actualInPatientDatas.get(2) );
        jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'" , actualInPatientAppointmentIds.get(2));
        jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'" , actualInPatientDatas.get(2));

        softAssert.assertTrue(actualInPatientAppointmentIds.get(actualInPatientAppointmentIds.size()-1).getText().contains(US13_TC01_StepDefs.expectedAppointmentId),"İstenen hasta listede yok.");
        softAssert.assertTrue(actualInPatientDatas.get(actualInPatientDatas.size()-1).getText().contains(US13_TC01_StepDefs.expectedPatientName),"İstenen hasta listede yok.");
        softAssert.assertAll();
        ReusableMethods.waitFor(2);
    }


}
