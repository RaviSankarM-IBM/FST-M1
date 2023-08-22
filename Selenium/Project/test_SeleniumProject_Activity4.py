# Import webdriver from selenium
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
import unittest

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

       
    pim = driver.find_element(By.ID, "menu_pim_viewPimModule")
    employeelist = driver.find_element(By.ID, "menu_pim_viewEmployeeList")
    
    pim.click()
    employeelist.click()
    #Find and click the submit button
    driver.find_element(By.ID, "btnAdd").click()
        
    firstname = driver.find_element(By.ID, "firstName")
    lastname = driver.find_element(By.ID, "lastName")
    firstname.sendKeys("EmpFstNm2")
    lastname.sendKeys("EmpLstNm2")

    driver.find_element(By.ID, "btnSave").click()
    
    pim1 = driver.find_element(By.XPATH, "/html/body/div[1]/div[2]/ul/li[2]/a")
    pim1.click()

    emplist = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewEmployeeList\"]")
    emplist.click()
       
    empsearch = driver.find_element(By.XPATH, "//*[@id=\"empsearch_employee_name_empName\"]")
    empsearch.click()

    empsearch.sendKeys("EmpFstNm2")

    search = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/p/input[1]")

    search.click()

    fstnamevalue = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[3]/a")
    #fstnamevalue = driver.find_element(By.XPATH("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td[3]/a"))
    print("Employee First Name " + fstnamevalue.text)

    lstnamevalue = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[4]/a")
    #lstnamevalue = driver.find_element(By.XPATH("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td[4]/a"))
    print("Employee Last Name " + lstnamevalue.text)
    
    def name(empfstnm):
        fstnm = "EmpFstNm2"
        
        message1 = "Employee First Name is not matching"
        
        empfstnm.assertEquals(fstnm, fstnamevalue.text, message1)
    
    def name1(emplstnm):
        lstnm = "EmpLstNm2"
        message2 = "Employee Last Name is not matching"
        emplstnm.assertEquals(lstnm, lstnamevalue.text, message2)
    

    driver.quit()
