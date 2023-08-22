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
    
    urlimg = driver.find_element(By.XPATH, "/html/body/div[1]/div/div[2]/div[1]/img").getAttribute("src")
    print("URL of the Image is: " + urlimg)
    

    driver.close()

