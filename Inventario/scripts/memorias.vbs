ForAppending = 8
ForWriting = 2
ForReading = 1  


strComputer = "."
Set objFSO = CreateObject("Scripting.FileSystemObject")
Set objFileRead = objFSO.OpenTextFile("repositorio\memorias.ivt", ForReading)
Set objFileWrite = objFSO.OpenTextFile ("repositorio\memorias.ivt", ForWriting, True)


Set objWMIService = GetObject("winmgmts:\\" & strComputer & "\root\cimv2")
Set colItems = objWMIService.ExecQuery("Select * from Win32_PhysicalMemory",,48)

On Error Resume next
For Each objItem in colItems
    
    objFileWrite.WriteLine  "Fabricante: " & "" & objItem.Manufacturer
    objFileWrite.WriteLine  "Tipo: " & objItem.MemoryType       
    objFileWrite.WriteLine  "Slot: " & " "& objItem.DeviceLocator
    objFileWrite.WriteLine "Tamanho: " & " " & objItem.Capacity
    objFileWrite.WriteLine "TamanhoPalavra: " & " " & objItem.DataWidth
    objFileWrite.WriteLine "Velocidade: " & " " & objItem.Speed
    objFileWrite.WriteLine "Status: " & " " & objItem.Status
    
    
Next
objFileWrite.close
objFileRead.Close
