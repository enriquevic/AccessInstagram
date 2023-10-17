package br.com.roothub.accessinsta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.NoSuchElementException;

public class AccessInsta {
    public static void main(String[] args) {

        String username = "[Seu usuário do instagram]";
        String password = "[Sua senha do instagram]";

        System.out.println("Acessando...");
        
        // Local onde se encontra o chromedriver
        System.setProperty("webdriver.chrome.driver", "./src/main/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.instagram.com/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        System.out.println("Aguardando encontrar a classe _aa48");

        WebElement classe_aa48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_aa48")));

        classe_aa48.click();

        System.out.println("Inserindo usuário");

        WebElement usuarioInput = driver.findElement(By.name("username"));
        usuarioInput.sendKeys(username);

        System.out.println("Inserindo senha");

        WebElement senhaInput = driver.findElement(By.name("password"));
        senhaInput.sendKeys(password);

        System.out.println("Acessando...");

        WebElement entrarButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_acan _acap _acas _aj1-']")));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", entrarButton);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fechando pop-up");

        List<WebElement> elements = driver.findElements(By.cssSelector("div._ac8f div.x1i10hfl"));
        if (!elements.isEmpty()) {
            WebElement agoraNaoButton = elements.get(0);
            agoraNaoButton.click();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement agoraNaoButtonNovo = null;
        try {
            agoraNaoButtonNovo = driver.findElement(By.cssSelector("button._a9--._a9_1"));
        } catch (NoSuchElementException e) {
            // Se o elemento não estiver presente, nada precisa ser feito
        }

        if (agoraNaoButtonNovo != null) {
            agoraNaoButtonNovo.click();
        }

        System.out.println("Bem-vindo a sua conta");

        driver.quit();
    }
}
