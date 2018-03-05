
Set WshShell = Wscript.CreateObject("Wscript.Shell")
Set obj= WshShell.Environment("SYSTEM")
variavel = obj("NUMBER_OF_PROCESSORS")
var2 = obj("PROCESSOR_ARCHITECTURE")
VAR3 = obj("PROCESSOR_REVISION")

Wscript.echo variavel
Wscript.echo var2
Wscript.echo var3


