ForAppending = 8
ForWriting = 2
ForReading = 1  

'Interface com sistema
Set wshShell = CreateObject( "WScript.Shell" )
strComputerName = wshShell.ExpandEnvironmentStrings( "%COMPUTERNAME%" )
wshSehll.close
'Objeto FSO
Set objFSO = CreateObject("Scripting.FileSystemObject")

'Objeto para ler o arquivo
Set objFileRead = objFSO.OpenTextFile("repositorio\maquina.ivt", ForReading)

'Obejto para escrever
Set objFileWrite = objFSO.OpenTextFile ("repositorio\maquina.ivt", ForAppending, True)

		objFileWrite.WriteLine "hostname:" & strComputerName

objFileWrite.close
objFileRead.Close




