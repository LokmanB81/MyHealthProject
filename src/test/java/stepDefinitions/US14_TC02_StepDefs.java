package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.MedunnaPages;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US14_TC02_StepDefs {

    MedunnaPages pages=new MedunnaPages();
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();

    Actions actions=new Actions(Driver.getDriver());
    SoftAssert softAssert=new SoftAssert();
    List<String> actualStatusBoxList=new ArrayList<>();
    String color = "yellow";
    String color1 = "indigo";
    @And("Doktor In Patients listesinde istedigi hastanin satirindaki Edit'e tiklar.")
    public void doktorInPatientsListesindeIstedigiHastaninSatirindakiEditETiklar() {

        jse.executeScript("arguments[0].style.border = '3px solid "+color1+"'", pages.inPatientTableFirstEdit);
        jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'" , pages.inPatientTableFirstEdit);
        ReusableMethods.waitFor(1);
        pages.inPatientTableFirstEdit.click();
    }
    
    @And("Doktor In Patient Status bilgisini istedigi sekilde gunceller.")
    public void doktorInPatientStatusBilgisiniIstedigiSekildeGunceller() {

        //jse.executeScript("window.scrollBy(0,600)");
       // jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        jse.executeScript("arguments[0].style.border = '3px solid "+color1+"'", pages.statusSelectBox);
        jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'" , pages.statusSelectBox);
        ReusableMethods.waitFor(1);

        jse.executeScript("arguments[0].click();", pages.statusSelectBox);
      //  actions.moveToElement(pages.statusSelectBox).click().perform();
       /* Select select=new Select(pages.statusSelectBox);
        select.selectByValue("UNAPPROVED");
        actualStatusBoxList.add(pages.statusSelectBox.getAttribute("value"));
       // jse.executeScript("arguments[0].click();", pages.editipatientSaveButton);
      //  ReusableMethods.waitForVisibility(pages.inPatientRoleAlert,10);
      //  softAssert.assertTrue(pages.inPatientRoleAlert.isDisplayed(),"Mesaj görüntülenemedi");

        ReusableMethods.waitFor(1);
        select.selectByValue("STAYING");
        actualStatusBoxList.add(pages.statusSelectBox.getAttribute("value"));
      //  jse.executeScript("arguments[0].click();", pages.editipatientSaveButton);
       // ReusableMethods.waitForVisibility(pages.inPatientRoleAlert,10);
      //  softAssert.assertTrue(pages.inPatientRoleAlert.isDisplayed(),"Mesaj görüntülenemedi");

        ReusableMethods.waitFor(1);
        select.selectByValue("DISCHARGED");
        actualStatusBoxList.add(pages.statusSelectBox.getAttribute("value"));
      //  jse.executeScript("arguments[0].click();", pages.editipatientSaveButton);
      //  ReusableMethods.waitForVisibility(pages.inPatientRoleAlert,10);
      //  softAssert.assertTrue(pages.inPatientRoleAlert.isDisplayed(),"Mesaj görüntülenemedi");

        ReusableMethods.waitFor(1);
        select.selectByValue("CANCELLED");
        actualStatusBoxList.add(pages.statusSelectBox.getAttribute("value"));
      //  jse.executeScript("arguments[0].click();", pages.editipatientSaveButton);
      //  ReusableMethods.waitForVisibility(pages.inPatientRoleAlert,10);
       // softAssert.assertTrue(pages.inPatientRoleAlert.isDisplayed(),"Mesaj görüntülenemedi");
      //  ReusableMethods.waitFor(1);
      //  softAssert.assertAll();

       // System.out.println("actualStatusBoxList = " + actualStatusBoxList);

         */

    }

    @Then("Doktor Status bilgisinin istedigi durum oldugunu gorur")
    public void doktorStatusBilgisininIstedigiDurumOldugunuGorur() {
        List<String> expectedStatusBoxList= Arrays.asList("UNAPPROVED", "STAYING", "DISCHARGED", "CANCELLED");
        Assert.assertEquals(expectedStatusBoxList,actualStatusBoxList);
    }
}
