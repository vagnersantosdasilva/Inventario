ForAppending = 8
ForWriting = 2
ForReading = 1  
'strComputer = wscript.arguments(0)
'srtUser=wscript.arguments(1)
'strSenha=wscript.arguments(2)


'Objeto FSO
Set objFSO = CreateObject("Scripting.FileSystemObject")
		'Objeto para ler o arquivo
		Set objFileRead = objFSO.OpenTextFile("repositorio\processadores.ivt", ForReading)
		
		'Obejto para escrever
		Set objFileWrite = objFSO.OpenTextFile ("repositorio\processadores.ivt", ForWriting, True)


On Error Resume Next
strComputer = "."
Set objWMIService = GetObject("winmgmts:\\" & strComputer & "\root\cimv2")
Set colItems = objWMIService.ExecQuery("Select * from Win32_Processor",,48)
For Each objItem in colItems
	
	objFileWrite.WriteLine "Nome : " & objItem.Name
	objFileWrite.WriteLine "Arquitetura : " & objItem.DataWidth    '  64 ou 32 bits
	objFileWrite.WriteLine "ClockMaximo : " & objItem.MaxClockSpeed
	objFileWrite.WriteLine "Nucleos : " & objItem.NumberOfCores
	objFileWrite.WriteLine "NucleosLogicos : " & objItem.NumberOfLogicalProcessors
	objFileWrite.WriteLine "Fabricante : " & objItem.Manufacturer
	objFileWrite.WriteLine "Status : " & objItem.Status
	
Next
objFileWrite.Close
objFileRead.Close

