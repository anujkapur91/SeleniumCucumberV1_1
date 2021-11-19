package SeleniumOrJavaTest;


import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Test {

    public static void main(String...args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        System.setProperty( "webdriver.edge.driver", "C:\\Users\\Anuj kapur\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        String strUrl = "";
        EdgeOptions eo = new EdgeOptions();
        eo.addArguments("--disable-notifications"); // disabeling notifications
        WebDriver driver = new EdgeDriver(eo);
        driver.get(strUrl);
        //Entering the username and password

//

        driver.findElement(By.xpath("")).sendKeys("admin");
        driver.findElement(By.xpath("")).sendKeys("admin");

        //Selecting the dropdown
        Select slct = new Select(driver.findElement(By.xpath("")));
        slct.selectByVisibleText("");


        driver.quit();

//-----------------------------------------------


//        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
//        String dbUrl = "jdbc:mysql://localhost:3036/emp";
//
//        //Database Username
//        String username = "root";
//
//        //Database Password
//        String password = "guru99";
//
//        //Query to Execute
//        String query = "select *  from employee;";
//
//        //Load mysql jdbc driver
//        Class.forName("com.mysql.jdbc.Driver");
//
//        //Create Connection to DB
//        Connection con = DriverManager.getConnection(dbUrl,username,password);
//
//        //Create Statement Object
//        Statement stmt = con.createStatement();
//
//        // Execute the SQL Query. Store results in ResultSet
//        ResultSet rs= stmt.executeQuery(query);
//
//        // While Loop to iterate through all data and print results
//        while (rs.next()){
//            String myName = rs.getString(1);
//            String myAge = rs.getString(2);
//            System. out.println(myName+"  "+myAge);
//        }
//        // closing DB Connection
//        con.close();


    }
}
