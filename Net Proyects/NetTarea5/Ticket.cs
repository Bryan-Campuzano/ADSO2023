using System;

namespace TicketManagement.Models
{
    public class Ticket
    {
        public int TicketID { get; set; }
        public string Title { get; set; } = string.Empty;
        public string Description { get; set; } = string.Empty;
        public string Status { get; set; } = string.Empty;
    }
}
