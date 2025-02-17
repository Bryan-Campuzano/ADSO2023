using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using TicketManagement.Models;

namespace TicketManagement.Pages
{
    public class CreateTicketModel : PageModel
    {
        [BindProperty]
        public Ticket NewTicket { get; set; } = new Ticket();

        public void OnGet()
        {
        }

        public IActionResult OnPost()
        {
            if (ModelState.IsValid)
            {
                // Guardar el ticket en la base de datos o lista
                // Aquí puedes agregar la lógica de almacenamiento
                return RedirectToPage("/Tickets");
            }
            return Page();
        }
    }
}
