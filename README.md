**Project Title**

Technical test for Nature.com

**Getting Started**

These instructions will get you a copy of the project up and running on your local machine for testing purposes. 


**Prerequisites**

You need to have the following installed on your system

1. Maven

2. Chrome or Firefox browser

3. Chrome Driver 

4. Java



**Installing**

For the Functional Test:

- If you are using a Mac OS simple install Brew and use Brew install Chrome Driver command on your terminal.
 This will install chrome to the right folder and path. 


- But if you are not using a Mac OS you will need to install the driver
to a folder and then on the Driver Manager Class you may need to set your path for your chrome driver in the Driver Manager Class.


- If you cannot get any of this and you have Mozilla Fire Fox, I have ensured to use the old Selenium 
which you can simple change the '`new ChromeDriver();`' in the Driver Manager Class
to '`new FireFoxDriver();`' Also don't forget to use an old version of FireFox. 




**Running the tests**



**1. FUNCTIONAL TEST:**
Tests can run via the Cucumber Runner Class which uses Junit as it's Runner or when compiling Maven.

You can also run via the testng.xml file.



**Coding style**


**1. FUNCTIONAL TEST:**
PageObjects was used to ensure readability and scalability of the code.

Cucumber was used with a feature file

Created a DSL for the selenium Webdriver.

Also used Junit and TestNg, depending on how it should be run.



**Author**

Tunde Oduniyi
