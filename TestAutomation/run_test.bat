set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_73
if /i %time:~0,2% LSS 10 (
set log4jdir=%date:~0,4%%date:~5,2%%date:~8,2%0%time:~1,1%%time:~3,2%%time:~6,2%
) else (
set log4jdir=%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%%time:~6,2%
)
call mvn test -Dlogdir=%log4jdir%
echo C:\ATC\ATC.exe android  C:\Users\Administrator\git\TestAutomation\target\%log4jdir% -c -r 
C:\ATC\ATC.exe android  C:\Users\Administrator\git\TestAutomation\target\%log4jdir% -c -r 