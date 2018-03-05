ForAppending = 8
ForWriting = 2
ForReading = 1  
'strComputer = wscript.arguments(0)
'srtUser=wscript.arguments(1)
'strSenha=wscript.arguments(2)

Const HKLM = &h80000002

Set objCtx = CreateObject("WbemScripting.SWbemNamedValueSet")
	objCtx.Add "__ProviderArchitecture", 64
	objCtx.Add "__RequiredArchitecture", TRUE
Set objLocator = CreateObject("Wbemscripting.SWbemLocator")
Set objServices = objLocator.ConnectServer("","root\default","","",,,,objCtx)
Set objStdRegProv = objServices.Get("StdRegProv") 

'Objeto FSO
Set objFSO = CreateObject("Scripting.FileSystemObject")
'Objeto para ler o arquivo
Set objFileRead = objFSO.OpenTextFile("repositorio\programas.ivt", ForReading)

'Obejto para escrever
Set objFileWrite = objFSO.OpenTextFile ("repositorio\programas.ivt", ForAppending, True)


'objFileWrite.WriteLine "64-bit Applications"
'objFileWrite.WriteLine "--------------------------------------------------------------"


Call GetApplications 

	Sub GetApplications 
			On Error Resume next
			
			' Use ExecMethod to call the GetStringValue method
			Set Inparams = objStdRegProv.Methods_("EnumKey").Inparameters
			Inparams.Hdefkey = HKLM
			Inparams.Ssubkeyname = "Software\Microsoft\Windows\CurrentVersion\Uninstall\" 
			
			Set Inparams1 = objStdRegProv.Methods_("EnumKey").Inparameters
			Inparams.Hdefkey = HKLM
			Inparams.Ssubkeyname = "Software\Microsoft\Windows\CurrentVersion\Uninstall\" 
			
			set Outparams = objStdRegProv.ExecMethod_("EnumKey", Inparams,,objCtx)
			Set Outparams1 = objStdRegProv.ExecMethod_("EnumKey", Inparams,,objCtx)
		
		
			For Each strSubKey In Outparams.snames 
		
					Set Inparams = objStdRegProv.Methods_("GetStringValue").Inparameters
					Inparams.Hdefkey = HKLM
					Inparams.Ssubkeyname = "Software\Microsoft\Windows\CurrentVersion\Uninstall\" & strSubKey
					Inparams.Svaluename = "DisplayName"
					Set Outparams = objStdRegProv.ExecMethod_("GetStringValue", Inparams,,objCtx) 
					
					
					'Ideia para colocar data de instalação no relatorio
					Set Inparams = objStdRegProv.Methods_("GetStringValue").Inparameters
					Inparams.Hdefkey = HKLM
					Inparams.Ssubkeyname = "Software\Microsoft\Windows\CurrentVersion\Uninstall\" & strSubKey
					Inparams.Svaluename = "InstallDate" 
					Set Outparams1 = objStdRegProv.ExecMethod_("GetStringValue", Inparams,,objCtx)
					dataInstall = Outparams1.SValue

					if ("" & Outparams1.SValue) = "" then
						if (Outparams.sValue) <> "" then objFileWrite.WriteLine Outparams.SValue & ";" & "64-bit" & ";"
							
					Else
						if (Outparams.SValue)<>"" then objFileWrite.WriteLine Outparams.SValue & ";" & " 64-bit" & ";" & Outparams1.SValue
							
					End iF 
			Next 
			
	objFileWrite.close
	objFileRead.Close

	End Sub

