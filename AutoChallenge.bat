set projectLocation=C:\Users\N Gnanasekaran\Desktop\Selenium\Eclipse_Workspace\AutoChallenge
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause