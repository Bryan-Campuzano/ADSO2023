using Gtk;
using System;

public class ByteConversionDialog : Dialog
{
    public Entry ValueEntry { get; private set; }
    public ComboBoxText ConversionTypeComboBox { get; private set; }

    public ByteConversionDialog(Window parent) : base("Conversión de Bytes", parent, DialogFlags.Modal)
    {
        SetDefaultSize(250, 150);
        SetPosition(WindowPosition.Center);

        // Crea un contenedor de tipo Box
        Box vbox = this.ContentArea as Box;

        ValueEntry = new Entry();
        ConversionTypeComboBox = new ComboBoxText();
        ConversionTypeComboBox.AppendText("Bytes a KB");
        ConversionTypeComboBox.AppendText("KB a MB");
        ConversionTypeComboBox.AppendText("MB a GB");
        ConversionTypeComboBox.AppendText("GB a TB");
        ConversionTypeComboBox.Active = 0;

        vbox.PackStart(new Label("Valor a convertir:"), false, false, 5);
        vbox.PackStart(ValueEntry, false, false, 5);
        vbox.PackStart(new Label("Tipo de conversión:"), false, false, 5);
        vbox.PackStart(ConversionTypeComboBox, false, false, 5);

        AddButton("Cancelar", ResponseType.Cancel);
        AddButton("Ok", ResponseType.Ok);

        ShowAll();
    }
}
