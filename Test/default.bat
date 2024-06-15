@echo off

:: Comprobar si se tienen privilegios de administrador
NET FILE 1>NUL 2>NUL
if '%errorlevel%' == '0' ( goto gotPrivileges ) else ( goto getPrivileges )

:getPrivileges
:: Solicitar elevación de permisos de administrador
echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"
echo UAC.ShellExecute "%~s0", "", "", "runas", 1 >> "%temp%\getadmin.vbs"
"%temp%\getadmin.vbs"
del "%temp%\getadmin.vbs"
exit /B

:gotPrivileges
:: El script continúa aquí con privilegios de administrador

:: URL del archivo que deseas descargar
set "fileUrl=https://download.scdn.co/SpotifySetup.exe"

:: Ruta donde se guardará temporalmente el archivo descargado
set "tempFilePath=%TEMP%\ejemplo.exe"

:: Descarga el archivo desde Internet utilizando PowerShell
powershell.exe -Command "(New-Object System.Net.WebClient).DownloadFile('%fileUrl%', '%tempFilePath%')"

:: Verifica si la descarga fue exitosa
if not exist "%tempFilePath%" (
    echo Error: No se pudo descargar el archivo.
    pause
    exit /b 1
)

:: Ejecuta el archivo descargado
echo Ejecutando el archivo descargado...
start "" "%tempFilePath%"

echo Proceso completado.

pause
exit /b 0
