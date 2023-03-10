package com.uniovi.sdi2223308spring.pageobjects2;

import com.uniovi.sdi2223308spring.util2.SeleniumUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PO_PrivateView extends PO_NavView {

    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Seleccionamos el alumnos userOrder
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public void login(WebDriver driver, String dni, String password, String checkText) {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, dni, password);
        PO_View.checkElementBy(driver, "text", checkText);
    }

    static public void logout(WebDriver driver) {
        //Ahora nos desconectamos y comprobamos que aparece el menú de registro
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        //Logout
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

    static public void checkElement(WebDriver driver, String checkText) {
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText,result.get(0).getText());
    }

    static public void clickOnMenuItem(WebDriver driver, String menu, String item) {
        //Pinchamos en la opción de menú de Notas: //li[contains(@id, 'marks-menu')]/a
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", menu);
        elements.get(0).click();
        //Pinchamos en la opción de lista de notas.
        elements = PO_View.checkElementBy(driver, "free", item);
        elements.get(0).click();
    }

    static public void goToLastPage(WebDriver driver) {
        //Esperamos a que se muestren los enlaces de paginación la lista de notas
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//a[contains(@class, 'page-link')]");
        //Nos vamos a la última página
        elements.get(3).click();
    }

    static public void deleteMark(WebDriver driver, String nota) {
        //Esperamos a que aparezca la Nueva nota en la última página
        //Y Pinchamos en el enlace de borrado de la Nota "Nota Nueva 1"
        List<WebElement> elements = PO_View.checkElementBy(driver, "free",
                "//td[contains(text(), '" + nota + "')]/following-sibling::*/a[contains(@href, 'mark/delete')]");
        elements.get(0).click();
    }

}
