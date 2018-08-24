package jsonarArquillian;

import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
//import org.jboss.arquillian.graphene.Graphene;
//import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@RunWith(Arquillian.class)
public class LoginScreenGrapheneTest {
	@FindBy(id = "username") // 2. injects an element
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "btn-login")
	private WebElement loginButton;

	@FindBy(id = "top-form:changePwd")
	private WebElement changePwd;

	@Drone
	private WebDriver browser;

	@Test
	public void should_login_successfully() {
		System.out.println("Before Opening home page");
		browser.get("http://www.localhost:8080/"); // 1. open the tested page
		System.out.println("Opened home page");
		userName.sendKeys("test_automation"); // 3. control the page
		System.out.println("Entered user name");
		Graphene.guardNoRequest(password).sendKeys("jS0nar$321");
		System.out.println("Entered password" + "");
		// loginButton.click();
		Graphene.guardAjax(loginButton).click();
		assertEquals("test_automation", changePwd.getText().trim());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
