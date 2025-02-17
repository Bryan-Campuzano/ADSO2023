using System;
using Gtk;

class Program
{
    [Obsolete]
    static void Main(string[] args)
    {
        Application.Init();
        var win = new MainWindow();
        win.Show();
        Application.Run();
    }
}
