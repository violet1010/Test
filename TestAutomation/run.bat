
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_91
set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8
if /i %time:~0,2% LSS 10 (
set log4jdir=%date:~0,4%%date:~5,2%%date:~8,2%0%time:~1,1%%time:~3,2%%time:~6,2%
) else (
set log4jdir=%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%%time:~6,2%
)
set TESTXML_HOME=src/main/java/ykse/TestAutomation/TestNGConfig/

call mvn test -Dlogdir=%log4jdir% -DTestngXmlFileName=%TESTXML_HOME%%3.xml
echo C:\ATC\ATC.exe %2  C:\TestAutomation\target\%log4jdir% %1 -report %4
C:\ATC\ATC.exe %2  C:\TestAutomation\target\%log4jdir% %1 -report %4

