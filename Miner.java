package br.com.roothub.miner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.NoSuchElementException;

public class Miner {
    public static void main(String[] args) {
        
        String username = "[Seu usuário do insta]";
        String password = "[Sua senha do insta]";
        
        System.out.println("Acessando...");  
        
        // Configurar o caminho do driver do Chrome
        System.setProperty("webdriver.chrome.driver", "./src/main/chromedriver.exe");
        
        // Iniciar o WebDriver
        WebDriver driver = new ChromeDriver();
        
        // Abrir o Instagram
        driver.get("https://www.instagram.com/");
        
        // Definir um tempo limite de espera (por exemplo, 10 segundos)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        System.out.println("Aguardando encontrar a classe _aa48");
        
        // Aguardar até que o label com classe '_aa48' seja visível na página
        WebElement classe_aa48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_aa48")));

        // Clicar no label para ativar o campo de entrada
        classe_aa48.click();

        System.out.println("Inserindo usuário");
        
        // Encontrar o campo de entrada pelo nome (neste caso, 'username') e inserir o texto desejado
        WebElement usuarioInput = driver.findElement(By.name("username"));
        usuarioInput.sendKeys(username);
        
        System.out.println("Inserindo senha");
                
        // Encontrar o campo de entrada de senha pelo nome (neste caso, 'password') e inserir a senha desejada
        WebElement senhaInput = driver.findElement(By.name("password"));
        senhaInput.sendKeys(password);
        
        
        System.out.println("Acessando...");
            
        // Aguardar até que o botão "Entrar" seja visível na página
        WebElement entrarButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_acan _acap _acas _aj1-']")));

        // Clicar no botão "Entrar" usando JavaScript Executor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", entrarButton);

        // Pausa de 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fechando pop-up");
        
        // Verificar se o elemento com a classe "_ac8f" está presente
        List<WebElement> elements = driver.findElements(By.cssSelector("div._ac8f div.x1i10hfl"));
        if (!elements.isEmpty()) {
            WebElement agoraNaoButton = elements.get(0);
            agoraNaoButton.click();
        }
        
        // Verificar se o elemento com a classe "_a9-- _a9_1" está presente após esperar 5 segundos
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

        // Clicar no botão "Agora não" se ele estiver presente
        if (agoraNaoButtonNovo != null) {
            agoraNaoButtonNovo.click();
        }
        
        
        System.out.println("Bem-vindo a sua conta");
        
        // Fechar o navegador
        driver.quit();
    }
}
