ForAppending = 8
ForWriting = 2
ForReading = 1  
'strComputer = wscript.arguments(0)
'srtUser=wscript.arguments(1)
'strSenha=wscript.arguments(2)


On Error Resume Next
strComputer = "."

'Objeto FSO
Set objFSO = CreateObject("Scripting.FileSystemObject")
'Objeto para ler o arquivo
Set objFileRead = objFSO.OpenTextFile("repositorio\unidadeArmazenamento.ivt", ForReading)

'Obejto para escrever
Set objFileWrite = objFSO.OpenTextFile ("repositorio\unidadeArmazenamento.ivt", ForWriting, True)


Set objWMIService = GetObject("winmgmts:\\" & strComputer & "\root\cimv2")
Set colItems = objWMIService.ExecQuery("Select * from Win32_DiskDrive",,48)
For Each objItem in colItems
	
		 objFileWrite.WriteLine  "Nome : " & objItem.Caption
		 objFileWrite.WriteLine  "Tamanho : " & objItem.Size
		 objFileWrite.WriteLine  "TipoDeMedia : " & objItem.MediaType
		 objFileWrite.WriteLine  "TipoDeInterface : " & objItem.InterfaceType
		 objFileWrite.WriteLine  "Status : " & objItem.Status
		 
		 
Next
objFileWrite.close
objFileRead.Close		 
