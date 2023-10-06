package demowebshop.FactoryEnviroment;

import demowebshop.interfaces.BooksPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class abc {

    public static void main(String[] args) {
        String xpathgoc = "//li[text()='textCanThay']";
        System.out.printf(changeXpath(xpathgoc, "textCanThay", "The credentials provided are incorrect"));
    }

    static String changeXpath(String xpath, String textcanchuyen, String textThay) {
      return xpath.replace(textcanchuyen, textThay);
    }


    }



