package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonborrar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonpi = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonraiz = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonsuma = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button9 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button8 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button7 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonresta = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button6 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button5 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonmultiplicacion = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttondivision = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button0 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonpunto = null;
public anywheresoftware.b4a.objects.ButtonWrapper _buttonigual = null;
public b4a.example.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 46;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _button_click(String _buttontext) throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Private Sub Button_Click(ButtonText As String)";
 //BA.debugLineNum = 211;BA.debugLine="EditText1.Text = EditText1.Text & ButtonText";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+_buttontext));
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public static String  _button0_click() throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Private Sub Button0_Click";
 //BA.debugLineNum = 161;BA.debugLine="EditText1.Text = EditText1.Text & \"0\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"0"));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Private Sub Button1_Click";
 //BA.debugLineNum = 166;BA.debugLine="EditText1.Text = EditText1.Text & \"1\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"1"));
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Private Sub Button2_Click";
 //BA.debugLineNum = 171;BA.debugLine="EditText1.Text = EditText1.Text & \"2\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"2"));
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
 //BA.debugLineNum = 174;BA.debugLine="Private Sub Button3_Click";
 //BA.debugLineNum = 176;BA.debugLine="EditText1.Text = EditText1.Text & \"3\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"3"));
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Private Sub Button4_Click";
 //BA.debugLineNum = 181;BA.debugLine="EditText1.Text = EditText1.Text & \"4\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"4"));
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public static String  _button5_click() throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Private Sub Button5_Click";
 //BA.debugLineNum = 186;BA.debugLine="EditText1.Text = EditText1.Text & \"5\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"5"));
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return "";
}
public static String  _button6_click() throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Private Sub Button6_Click";
 //BA.debugLineNum = 191;BA.debugLine="EditText1.Text = EditText1.Text & \"6\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"6"));
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
return "";
}
public static String  _button7_click() throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Private Sub Button7_Click";
 //BA.debugLineNum = 196;BA.debugLine="EditText1.Text = EditText1.Text & \"7\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"7"));
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public static String  _button8_click() throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Private Sub Button8_Click";
 //BA.debugLineNum = 201;BA.debugLine="EditText1.Text = EditText1.Text & \"8\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"8"));
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public static String  _button9_click() throws Exception{
 //BA.debugLineNum = 204;BA.debugLine="Private Sub Button9_Click";
 //BA.debugLineNum = 206;BA.debugLine="EditText1.Text = EditText1.Text & \"9\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"9"));
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return "";
}
public static String  _buttonborrar_click() throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Private Sub ButtonBorrar_Click";
 //BA.debugLineNum = 59;BA.debugLine="If EditText1.Text.Length > 0 Then";
if (mostCurrent._edittext1.getText().length()>0) { 
 //BA.debugLineNum = 60;BA.debugLine="EditText1.Text = EditText1.Text.SubString2(0, Ed";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText().substring((int) (0),(int) (mostCurrent._edittext1.getText().length()-1))));
 };
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _buttonborrar_longclick() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Private Sub ButtonBorrar_LongClick";
 //BA.debugLineNum = 66;BA.debugLine="EditText1.Text = \"\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _buttondivision_click() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Private Sub ButtonDivision_Click";
 //BA.debugLineNum = 100;BA.debugLine="EditText1.Text = EditText1.Text & \" / \"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+" / "));
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _buttonigual_click() throws Exception{
String _texto = "";
String[] _elementos = null;
String _operador = "";
double _num1 = 0;
double _num2 = 0;
double _resultado = 0;
 //BA.debugLineNum = 103;BA.debugLine="Private Sub ButtonIgual_Click";
 //BA.debugLineNum = 104;BA.debugLine="Dim texto As String";
_texto = "";
 //BA.debugLineNum = 105;BA.debugLine="Dim elementos() As String";
_elementos = new String[(int) (0)];
java.util.Arrays.fill(_elementos,"");
 //BA.debugLineNum = 106;BA.debugLine="Dim operador As String";
_operador = "";
 //BA.debugLineNum = 107;BA.debugLine="Dim num1, num2, resultado As Double";
_num1 = 0;
_num2 = 0;
_resultado = 0;
 //BA.debugLineNum = 110;BA.debugLine="texto = EditText1.Text.Trim";
_texto = mostCurrent._edittext1.getText().trim();
 //BA.debugLineNum = 113;BA.debugLine="elementos = Regex.Split(\" \", texto)";
_elementos = anywheresoftware.b4a.keywords.Common.Regex.Split(" ",_texto);
 //BA.debugLineNum = 116;BA.debugLine="If elementos.Length >= 3 Then";
if (_elementos.length>=3) { 
 //BA.debugLineNum = 118;BA.debugLine="If IsNumber(elementos(0)) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_elementos[(int) (0)])) { 
 //BA.debugLineNum = 119;BA.debugLine="num1 = elementos(0)";
_num1 = (double)(Double.parseDouble(_elementos[(int) (0)]));
 };
 //BA.debugLineNum = 121;BA.debugLine="operador = elementos(1)";
_operador = _elementos[(int) (1)];
 //BA.debugLineNum = 122;BA.debugLine="If IsNumber(elementos(2)) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_elementos[(int) (2)])) { 
 //BA.debugLineNum = 123;BA.debugLine="num2 = elementos(2)";
_num2 = (double)(Double.parseDouble(_elementos[(int) (2)]));
 };
 //BA.debugLineNum = 127;BA.debugLine="Select operador.ToLowerCase";
switch (BA.switchObjectToInt(_operador.toLowerCase(),"+","-","*","/")) {
case 0: {
 //BA.debugLineNum = 129;BA.debugLine="resultado = num1 + num2";
_resultado = _num1+_num2;
 break; }
case 1: {
 //BA.debugLineNum = 131;BA.debugLine="resultado = num1 - num2";
_resultado = _num1-_num2;
 break; }
case 2: {
 //BA.debugLineNum = 133;BA.debugLine="resultado = num1 * num2";
_resultado = _num1*_num2;
 break; }
case 3: {
 //BA.debugLineNum = 136;BA.debugLine="If num2 <> 0 Then";
if (_num2!=0) { 
 //BA.debugLineNum = 137;BA.debugLine="resultado = num1 / num2";
_resultado = _num1/(double)_num2;
 }else {
 //BA.debugLineNum = 139;BA.debugLine="ToastMessageShow(\"Error: División por cero\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: División por cero"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 140;BA.debugLine="Return";
if (true) return "";
 };
 break; }
default: {
 //BA.debugLineNum = 143;BA.debugLine="ToastMessageShow(\"Operador no válido\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Operador no válido"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 144;BA.debugLine="Return";
if (true) return "";
 break; }
}
;
 //BA.debugLineNum = 148;BA.debugLine="EditText1.Text = resultado";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(_resultado));
 }else {
 //BA.debugLineNum = 150;BA.debugLine="ToastMessageShow(\"Formato no válido\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Formato no válido"),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public static String  _buttonmultiplicacion_click() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Private Sub ButtonMultiplicacion_Click";
 //BA.debugLineNum = 95;BA.debugLine="EditText1.Text = EditText1.Text & \" * \"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+" * "));
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public static String  _buttonpi_click() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Private Sub ButtonPi_Click";
 //BA.debugLineNum = 71;BA.debugLine="EditText1.Text = EditText1.Text & \"3.14159265359\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"3.14159265359"));
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public static String  _buttonpunto_click() throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Private Sub ButtonPunto_Click";
 //BA.debugLineNum = 156;BA.debugLine="EditText1.Text = EditText1.Text & \".\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+"."));
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public static String  _buttonraiz_click() throws Exception{
double _num = 0;
 //BA.debugLineNum = 74;BA.debugLine="Private Sub ButtonRaiz_Click";
 //BA.debugLineNum = 76;BA.debugLine="Dim num As Double";
_num = 0;
 //BA.debugLineNum = 77;BA.debugLine="If IsNumber(EditText1.Text) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._edittext1.getText())) { 
 //BA.debugLineNum = 78;BA.debugLine="num = Sqrt(EditText1.Text)";
_num = anywheresoftware.b4a.keywords.Common.Sqrt((double)(Double.parseDouble(mostCurrent._edittext1.getText())));
 };
 //BA.debugLineNum = 80;BA.debugLine="EditText1.Text = num";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(_num));
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _buttonresta_click() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Private Sub ButtonResta_Click";
 //BA.debugLineNum = 90;BA.debugLine="EditText1.Text = EditText1.Text & \" - \"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+" - "));
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _buttonsuma_click() throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Private Sub ButtonSuma_Click";
 //BA.debugLineNum = 85;BA.debugLine="EditText1.Text = EditText1.Text & \" + \"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(mostCurrent._edittext1.getText()+" + "));
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private EditText1 As EditText";
mostCurrent._edittext1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private ButtonBorrar As Button";
mostCurrent._buttonborrar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private ButtonPi As Button";
mostCurrent._buttonpi = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private ButtonRaiz As Button";
mostCurrent._buttonraiz = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private ButtonSuma As Button";
mostCurrent._buttonsuma = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private Button9 As Button";
mostCurrent._button9 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private Button8 As Button";
mostCurrent._button8 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private Button7 As Button";
mostCurrent._button7 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private ButtonResta As Button";
mostCurrent._buttonresta = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private Button6 As Button";
mostCurrent._button6 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private Button5 As Button";
mostCurrent._button5 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private Button4 As Button";
mostCurrent._button4 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private ButtonMultiplicacion As Button";
mostCurrent._buttonmultiplicacion = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private Button3 As Button";
mostCurrent._button3 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private Button2 As Button";
mostCurrent._button2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private Button1 As Button";
mostCurrent._button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private ButtonDivision As Button";
mostCurrent._buttondivision = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private Button0 As Button";
mostCurrent._button0 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private ButtonPunto As Button";
mostCurrent._buttonpunto = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private ButtonIgual As Button";
mostCurrent._buttonigual = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
}
