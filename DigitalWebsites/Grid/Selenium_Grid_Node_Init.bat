@echo off
cd\
o:
cd O:\QA and Testing Department\Roadrunner\Digital Websites\Selenium_Grid
java -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.internetexplorer.driver=IEDriverServer.exe -Dwebdriver.edge.driver=MicrosoftWebDriver.exe -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://10.211.4.91:4444/grid/register -port 5555