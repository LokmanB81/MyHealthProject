package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.MedunnaPages;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;

public class US14_TC01_StepDefs {
    MedunnaPages pages=new MedunnaPages();
    SoftAssert softAssert=new SoftAssert();
    String color = "yellow";
    String color1 = "indigo";
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    @Then("Doktor In Patients tablosundaki hasta bilgilerini gorur.")
    public void doktorInPatientsTablosundakiHastaBilgileriniGorur() {
        List<WebElement> actualInpatientTableHeads=pages.inPatientTableHeads;
        List<WebElement> actualInpatientTableAllDatas=pages.inPatientTableAllDatas;
        System.out.println("actualInpatientTableAllDatas.size() = " + actualInpatientTableAllDatas.size());

        List<String> expectedInpatientsTableHeads= Arrays.asList("ID","Start Date","End Date","Status","Description",
                "Created Date","Room","Appointment","Patient","");

        jse.executeScript("window.scrollBy(0,600)");

        jse.executeScript("arguments[0].style.border = '3px solid "+color1+"'", pages.table_tbody);
        jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'" , pages.table_tbody);

        for (int i = 0; i < actualInpatientTableHeads.size(); i++) {
            softAssert.assertEquals(actualInpatientTableHeads.get(i).getText(),expectedInpatientsTableHeads.get(i),"Tablo hatalı");
        }

        for (WebElement w:actualInpatientTableAllDatas ) {

            System.out.println(w.getText());
            softAssert.assertNotEquals(w.getText(),"","Tablo hatalı");
        }
      //  Assert.assertTrue("Tablo boş",actualInpatientTableAllDatas.size()>0);
    }
}
