@echo off
rmdir /s /q  "%programfiles%/Ritiks Paint"
rmdir /s /q  "%HOMEDRIVE%%HOMEPATH%\Start Menu\Programs\New Folder"
echo y | del  "%userprofile%\Desktop\Ritik's Paint.lnk"
