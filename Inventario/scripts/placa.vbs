ForAppending = 8
ForWriting = 2
ForReading = 1  


strComputer = "."

Set objFSO = CreateObject("Scripting.FileSystemObject")

'Obejto para escrever

Set objFileRead = objFSO.OpenTextFile("repositorio\placaMae.ivt", ForReading)
Set objFileWrite = objFSO.OpenTextFile ("repositorio\placaMae.ivt", ForWriting, True)

Set objWMIService = GetObject("winmgmts:\\" & strComputer & "\root\cimv2")
Set colItems = objWMIService.ExecQuery("Select * from Win32_BaseBoard",,48)

For Each objItem in colItems
  
	objFileWrite.WriteLine  "Manufacturer : " & objItem.Manufacturer
	objFileWrite.WriteLine  "Product: " & objItem.Product
	objFileWrite.WriteLine  "SerialNumber: " & objItem.SerialNumber
	objFileWrite.WriteLine  "Status: " & objItem.Status
	    
Next

objFileWrite.close
objFileRead.Close
