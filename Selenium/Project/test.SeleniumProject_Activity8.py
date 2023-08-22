# Import webdriver from selenium
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.select import Select
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

    pageheading = driver.find_element(By.XPATH, "//*[@id=\"content\"]/div/div[1]/h1")
    Heading = pageheading.text()
    print("Page Title is: " + Heading)
    
    #Assertion for page title
    def pageheading1(title1):
        heading1 = "Dashboard"
        message = "Title of the home page is not matching"
        title1.assertEquals(Heading, heading1, message)
    
    ApplyLeave = driver.find_element(By.XPATH, "//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[4]/div/a/img")
    ApplyLeave.click()
    ApplyLeave.click()

    #Find the dropdown
    LeaveTypeDropDown = driver.find_element(By.XPATH, "//*[@id=\"applyleave_txtLeaveType\"]")
    
    dropdown = Select(LeaveTypeDropDown)
    dropdown.select_by_index(1)
    print("Selected Leave option: " + dropdown.first_selected_option.text)

    def selectedvalue(leaveoption):
        LeaveType = "DayOff"
        choosenleave = dropdown.first_selected_option.text
        message = "DayOff leave option is not choosen"
        leaveoption.assertEquals(LeaveType, choosenleave, message)

    LeaveFromDate = driver.find_element(By.XPATH, "//*[@id=\"applyleave_txtFromDate\"]")
    LeaveFromDate.clear()
    LeaveFromDate.send_keys("2023-08-23")
    
    LeaveToDate = driver.find_element(By.XPATH, "//*[@id=\"applyleave_txtToDate\"]")
    LeaveToDate.clear()
    LeaveToDate.send_keys("2023-08-23")
    
    ApplyLeavebtn = driver.find_element(By.XPATH, "//*[@id=\"applyBtn\"]")
    ApplyLeavebtn.click()

    LeaveMenu = driver.find_element(By.XPATH, "//*[@id=\"menu_leave_viewLeaveModule\"]")
    LeaveMenu.click()

    MyLeave = driver.find_element(By.XPATH, "//*[@id=\"menu_leave_viewMyLeaveList\"]")
    MyLeave.click()

    SearchFromDate = driver.find_element(By.XPATH, "//*[@id=\"calFromDate\"]")
    SearchFromDate.clear()
    SearchFromDate.send_keys("2023-08-23");
    
    SearchToDate = driver.find_element(By.XPATH, "//*[@id=\"calToDate\"]")
    SearchToDate.clear()
    SearchToDate.send_keys("2023-08-23")
    
    Search = driver.find_element(By.XPATH, "//*[@id=\"btnSearch\"]")
    Search.click()

    LeaveStatus = driver.find_element(By.XPATH, "//*[@id=\"resultTable\"]/tbody/tr[1]/td[6]/a")
    print("Leave Status: " +LeaveStatus.text)
    AppliedLeaveStatus = LeaveStatus.text()

    def leavestatus(status):
        LeaveStatus1="Pending Approval(1.00)"
        message = "Applied Leave Status is not matching"
        status.assertEquals(LeaveStatus1, AppliedLeaveStatus, message)
        
       
driver.quit()


