package com.gmail;
 
import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class gmailLogin {
 
  //Excel API to read test data from excel workbook
  private String[][] getExcelData(String xlPath, String shtName, String tbName) throws Exception{
    String[][] tabArray=null;
    Workbook workbk = Workbook.getWorkbook(new File(xlPath));
    Sheet sht = workbk.getSheet(shtName);
    int sRow,sCol,eRow,eCol,ci,cj;
    Cell tableStart=sht.findCell(tbName);
    sRow=tableStart.getRow();
    sCol=tableStart.getColumn();
    Cell tableEnd= sht.findCell(tbName, sCol+1,sRow+1, 100, 64000, false);
    eRow=tableEnd.getRow();
    eCol=tableEnd.getColumn();
    System.out.println("startRow="+sRow+", endRow="+eRow+", " + "startCol="+sCol+", endCol="+eCol);
    tabArray=new String[eRow-sRow-1][eCol-sCol-1];
    ci=0;
    for (int i=sRow+1;i<eRow;i++,ci++){
      cj=0;
      for (int j=sCol+1;j<eCol;j++,cj++){
        tabArray[ci][cj]=sht.getCell(j,i).getContents();
      }
    }
    return(tabArray);
  }
 
  //Data provider definition
  @DataProvider(name = "DP")
  public Object[][] createData() throws Exception{
    Object[][] retObjArr=getExcelData("C:\\Users\\Trose\\workspace\\tng\\TestData.xls","TestData","Login");
    return(retObjArr);
  }
 
  //Actual test functionality
  @Test(dataProvider = "DP")
  public void loginGmail(String Usrname, String Pwd){
 
    //Firefox browser instantiation
    WebDriver driver = new FirefoxDriver();
 
    //Loading the gmail URL
 
    driver.get("http://www.gmail.com");
 
    //User name input field identification and data entered
    WebElement usernametext = driver.findElement(By.name("Email"));
    usernametext.sendKeys(Usrname);
 
    //Password input field identification and data entered
    WebElement passwordtext = driver.findElement(By.name("Passwd"));
    passwordtext.sendKeys(Pwd);
 
    //Sign in button identification and click it
    WebElement signinbutton = driver.findElement(By.name("signIn"));
    signinbutton.click();
 
    //Closing the browser
    driver.close();
  }
 
}