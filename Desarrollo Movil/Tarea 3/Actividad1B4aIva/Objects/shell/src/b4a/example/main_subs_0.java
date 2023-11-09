package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"Calculadora IVA\")";
Debug.ShouldStop(134217728);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Calculadora IVA")),main.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncalculariva_click() throws Exception{
try {
		Debug.PushSubsStack("btnCalcularIVA_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,31);
if (RapidSub.canDelegate("btncalculariva_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btncalculariva_click");}
RemoteObject _valorproducto = RemoteObject.createImmutable(0);
RemoteObject _tasaiva = RemoteObject.createImmutable(0);
RemoteObject _valoriva = RemoteObject.createImmutable(0);
RemoteObject _valorfinal = RemoteObject.createImmutable(0);
 BA.debugLineNum = 31;BA.debugLine="Sub btnCalcularIVA_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="Dim valorProducto As Double";
Debug.ShouldStop(1);
_valorproducto = RemoteObject.createImmutable(0);Debug.locals.put("valorProducto", _valorproducto);
 BA.debugLineNum = 34;BA.debugLine="valorProducto = edtValorProducto.Text";
Debug.ShouldStop(2);
_valorproducto = BA.numberCast(double.class, main.mostCurrent._edtvalorproducto.runMethod(true,"getText"));Debug.locals.put("valorProducto", _valorproducto);
 BA.debugLineNum = 37;BA.debugLine="Dim tasaIVA As Double";
Debug.ShouldStop(16);
_tasaiva = RemoteObject.createImmutable(0);Debug.locals.put("tasaIVA", _tasaiva);
 BA.debugLineNum = 38;BA.debugLine="tasaIVA = 0.19 ' editando este valor se puede cam";
Debug.ShouldStop(32);
_tasaiva = BA.numberCast(double.class, 0.19);Debug.locals.put("tasaIVA", _tasaiva);
 BA.debugLineNum = 40;BA.debugLine="Dim valorIVA As Double";
Debug.ShouldStop(128);
_valoriva = RemoteObject.createImmutable(0);Debug.locals.put("valorIVA", _valoriva);
 BA.debugLineNum = 41;BA.debugLine="valorIVA = valorProducto * tasaIVA";
Debug.ShouldStop(256);
_valoriva = RemoteObject.solve(new RemoteObject[] {_valorproducto,_tasaiva}, "*",0, 0);Debug.locals.put("valorIVA", _valoriva);
 BA.debugLineNum = 44;BA.debugLine="Dim valorFinal As Double";
Debug.ShouldStop(2048);
_valorfinal = RemoteObject.createImmutable(0);Debug.locals.put("valorFinal", _valorfinal);
 BA.debugLineNum = 45;BA.debugLine="valorFinal = valorProducto + valorIVA";
Debug.ShouldStop(4096);
_valorfinal = RemoteObject.solve(new RemoteObject[] {_valorproducto,_valoriva}, "+",1, 0);Debug.locals.put("valorFinal", _valorfinal);
 BA.debugLineNum = 48;BA.debugLine="lblValorOriginal.Text = \"Valor Original: \" & Numb";
Debug.ShouldStop(32768);
main.mostCurrent._lblvalororiginal.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Valor Original: "),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_valorproducto),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 49;BA.debugLine="lblIVA.Text = \"IVA (\" & NumberFormat(tasaIVA * 10";
Debug.ShouldStop(65536);
main.mostCurrent._lbliva.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("IVA ("),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_tasaiva,RemoteObject.createImmutable(100)}, "*",0, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))),RemoteObject.createImmutable("%): "),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_valoriva),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 50;BA.debugLine="lblValorFinal.Text = \"Valor Final: \" & NumberForm";
Debug.ShouldStop(131072);
main.mostCurrent._lblvalorfinal.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Valor Final: "),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_valorfinal),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private edtValorProducto As EditText";
main.mostCurrent._edtvalorproducto = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private btnCalcularIVA As Button";
main.mostCurrent._btncalculariva = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private lblValorOriginal As Label";
main.mostCurrent._lblvalororiginal = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private lblIVA As Label";
main.mostCurrent._lbliva = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private lblValorFinal As Label";
main.mostCurrent._lblvalorfinal = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}