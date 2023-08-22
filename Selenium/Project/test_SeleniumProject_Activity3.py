# Import webdriver from selenium
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
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

    driver.quit()
