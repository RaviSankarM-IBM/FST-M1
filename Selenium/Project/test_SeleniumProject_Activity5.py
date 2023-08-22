# Import webdriver from selenium
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/orangehrm")
    # Print the title of the page
    print("Page title is: ", driver.title)
    
        # Find the username field
    username = driver.find_element(By.ID, "txtUsername")
    # Find the password field
    password = driver.find_element(By.ID, "txtPassword")

    # Enter the given credentials
    # Enter username
    username.send_keys("orange")
    # Enter password
    password.send_keys("orangepassword123")
    
    # Find the login button    
    login = driver.find_element(By.ID, "btnLogin")
    login.click()
 
    hometitle = driver.title

    #Print the title of the page
    print("Home Page title after login is: " + hometitle)

    #Assertion for page title
    def pageheading(title):
        heading = 'orangeHRM'
        message = 'Title of the home page is not matching'
        title.assertEquals(heading, hometitle, message)

    myinfo = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]")
    myinfo.click()
    myinfo.click()

    edit = driver.find_element(By.XPATH, "//*[@id=\"btnSave\"]")
    edit.click()

    fstname = driver.find_element(By.XPATH, "//*[@id=\"personal_txtEmpFirstName\"]")
    fstname.clear()
    fstname.send_keys("First Name Edited")

    lstname = driver.find_element(By.XPATH, "//*[@id=\"personal_txtEmpLastName\"]")
    lstname.clear()
    lstname.send_keys("Last Name Edited")
    
    #Gender

    Nationality = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/ol[3]/li[3]/select")
    Nationality.click()
    Nationality.send_keys("Indian")
    Nationality.send_keys(Keys.ENTER)
    
    #DOB = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/ol[3]/li[4]/input")
    DOB = driver.find_element(By.XPATH, "//*[@id=\"personal_DOB\"]")
    DOB.clear()
    DOB.send_keys("1982-01-01")
    
    save = driver.find_element(By.XPATH, "//*[@id=\"btnSave\"]")
    save.click()

driver.quit()


