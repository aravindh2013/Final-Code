package com.pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Parfum_Page {

	public WebDriver driver;

	@FindBy(xpath = "//*[text()='Mehr Filter anzeigen']")
	private WebElement mehrFilter;
	@FindBy(xpath = "//*[@class='facets-wrapper']//descendant::div[@data-testid='Geschenk für']//descendant::*[@data-testid='arrow-icon']")
	private WebElement geschenkfür;
	@FindBy(xpath = "//*[text()='Geburtstag']//ancestor::a[@type='text']//descendant::input")
	private WebElement geschenkfürElement;
	@FindBy(xpath = "//*[@class='facets-wrapper']//descendant::div[@data-testid='classificationClassName']//descendant::*[@data-testid='arrow-icon']")
	private WebElement produktart;
	@FindBy(xpath = "(//*[text()='Eau de Parfum'])[1]//ancestor::a[@type='text']//descendant::input")
	private WebElement produktartElement;
	@FindBy(xpath = "//*[@class='facets-wrapper']//descendant::div[@data-testid='brand']//descendant::*[@data-testid='arrow-icon']")
	private WebElement marke;
	@FindBy(xpath = "//*[text()='Ariana Grande']//ancestor::a[@type='text']//descendant::input")
	private WebElement markeEelment;
	@FindBy(xpath = "//*[@class='facets-wrapper']//descendant::div[@data-testid='gender']//descendant::*[@data-testid='arrow-icon']")
	private WebElement FürWen;
	@FindBy(xpath = "//*[text()='Weiblich']//ancestor::a[@type='text']//descendant::input")
	private WebElement FürWenElement;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMehrFilter() {
		return mehrFilter;
	}

	public WebElement getGeschenkfür() {
		return geschenkfür;
	}

	public WebElement getGeschenkfürElement() {
		return geschenkfürElement;
	}

	public WebElement getProduktart() {
		return produktart;
	}

	public WebElement getProduktartElement() {
		return produktartElement;
	}

	public WebElement getMarke() {
		return marke;
	}

	public WebElement getMarkeEelment() {
		return markeEelment;
	}

	public WebElement getFürWen() {
		return FürWen;
	}

	public WebElement getFürWenElement() {
		return FürWenElement;
	}

	public Parfum_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

}
