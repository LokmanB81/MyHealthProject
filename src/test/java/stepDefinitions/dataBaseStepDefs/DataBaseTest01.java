package stepDefinitions.dataBaseStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;
import utilities.DatabaseUtility;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class DataBaseTest01 {

    List<Object> actualData;

    @Given("kullanici conection kurar")
    public void kullanici_conection_kurar() {
        DatabaseUtility.createConnection();

    }

    @Given("kullanici tum yeni kayitli bilgileri ceker {string} ve {string}")
    public void kullanici_tum_yeni_kayitli_bilgileri_ceker_ve(String query, String columnName) {
        actualData=DatabaseUtility.getColumnData(query,columnName);
        System.out.println("actualData = " + actualData);

    }


    @Then("kallanici kullanici bilgilerini dogrular")
    public void kallanici_kullanici_bilgilerini_dogrular() {

        assertTrue("id bulunamadı",actualData.contains("301017"));

    }
}
