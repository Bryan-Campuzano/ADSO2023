using Microsoft.AspNetCore.Mvc.RazorPages;
using TicketManagement.Models;
using System.Collections.Generic;

namespace TicketManagement.Pages
{
    public class TicketsModel : PageModel
    {
        public List<Ticket> Tickets { get; set; } = new List<Ticket>();

        public void OnGet()
        {
            Tickets = new List<Ticket>
            {
                new Ticket { TicketID = 1, Title = "First Ticket", Description = "Description for first ticket", Status = "Open" },
                new Ticket { TicketID = 2, Title = "Second Ticket", Description = "Description for second ticket", Status = "Closed" }
            };
        }
    }
}
