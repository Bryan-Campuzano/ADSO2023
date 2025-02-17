using Gtk;
using System;

public class MainWindow : Window
{
    private Entry display;
    private double result = 0;
    private string operation = "";
    private bool isOperationPerformed = false;

    [Obsolete]
    public MainWindow() : base("Calculadora")
    {
        SetDefaultSize(400, 300);
        SetPosition(WindowPosition.Center);

        var cssProvider = new CssProvider();
        cssProvider.LoadFromData("entry {background-color: #000000; color: #FFFFFF; font: 14px Arial;}");
        StyleContext.AddProviderForScreen(Gdk.Screen.Default, cssProvider, 800);

        var vbox = new VBox();

        display = new Entry { Text = "0", Editable = false };
        vbox.PackStart(display, false, false, 5);

        var table = new Table(6, 4, true);

        string[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "CE", "C", "Pesos a USD", "Bytes"
        };

        int count = 0;
        foreach (string text in buttons)
        {
            Button button = new Button(text);
            button.Clicked += OnButtonClicked;
            table.Attach(button, (uint)(count % 4), (uint)(count % 4 + 1), (uint)(count / 4), (uint)(count / 4 + 1));
            count++;
        }

        vbox.PackStart(table, true, true, 5);
        Add(vbox);
        ShowAll();
    }

    private void OnButtonClicked(object? sender, EventArgs e)
    {
        try
        {
            if (sender == null) return;

            Button button = (Button)sender;
            string buttonText = button.Label;

            if (char.IsDigit(buttonText, 0) || buttonText == ".")
            {
                if (display.Text == "0" || isOperationPerformed)
                    display.Text = "";

                isOperationPerformed = false;
                display.Text += buttonText;
            }
            else if (buttonText == "CE")
            {
                display.Text = "0";
            }
            else if (buttonText == "C")
            {
                display.Text = "0";
                result = 0;
            }
            else if (buttonText == "=")
            {
                PerformOperation();
                operation = "";
            }
            else if (buttonText == "Pesos a USD")
            {
                ConvertPesosToUsd();
            }
            else if (buttonText == "Bytes")
            {
                ConvertBytes();
            }
            else
            {
                operation = buttonText;
                result = double.Parse(display.Text);
                isOperationPerformed = true;
            }
        }
        catch (Exception ex)
        {
            ShowError(ex.Message);
        }
    }

    private void PerformOperation()
    {
        double currentValue = double.Parse(display.Text);
        switch (operation)
        {
            case "+":
                display.Text = (result + currentValue).ToString();
                break;
            case "-":
                display.Text = (result - currentValue).ToString();
                break;
            case "*":
                display.Text = (result * currentValue).ToString();
                break;
            case "/":
                display.Text = (result / currentValue).ToString();
                break;
        }
        result = double.Parse(display.Text);
    }

    private void ConvertPesosToUsd()
    {
        const double conversionRate = 0.053; // Ejemplo, tasa de cambio
        double pesos = double.Parse(display.Text);
        display.Text = (pesos * conversionRate).ToString();
    }

    private void ConvertBytes()
    {
        try
        {
            var dialog = new ByteConversionDialog(this);
            if (dialog.Run() == (int)ResponseType.Ok)
            {
                double value = double.Parse(dialog.ValueEntry.Text);
                string conversionType = dialog.ConversionTypeComboBox.ActiveText;
                double convertedValue = PerformByteConversion(value, conversionType);
                MessageDialog resultDialog = new MessageDialog(this, DialogFlags.DestroyWithParent, MessageType.Info, ButtonsType.Ok, $"Resultado: {convertedValue}");
                resultDialog.Run();
                resultDialog.Destroy();
            }
            dialog.Destroy();
        }
        catch (Exception ex)
        {
            ShowError(ex.Message);
        }
    }

    private double PerformByteConversion(double value, string conversionType)
    {
        switch (conversionType)
        {
            case "Bytes a KB":
                return value / 1024;
            case "KB a MB":
                return value / 1024;
            case "MB a GB":
                return value / 1024;
            case "GB a TB":
                return value / 1024;
            default:
                throw new InvalidOperationException("Tipo de conversión no válido");
        }
    }

    private void ShowError(string message)
    {
        MessageDialog md = new MessageDialog(this, DialogFlags.DestroyWithParent, MessageType.Error, ButtonsType.Close, message);
        md.Run();
        md.Destroy();
    }

    protected override bool OnDeleteEvent(Gdk.Event ev)
    {
        Application.Quit();
        return true;
    }
}
