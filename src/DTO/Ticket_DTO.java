/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author vnngu
 */
public class Ticket_DTO {
    private int ID;
    private int ShowtimeID;
    private String Ticket_Type;
    private int Price;

    public Ticket_DTO() {
    }

    public Ticket_DTO(int ID, int ShowtimeID, String Ticket_Type, int Price) {
        this.ID = ID;
        this.ShowtimeID = ShowtimeID;
        this.Ticket_Type = Ticket_Type;
        this.Price = Price;
    }
     public Ticket_DTO(Ticket_DTO tkc) {
        this.ID = tkc.ID;
        this.ShowtimeID = tkc.ShowtimeID;
        this.Ticket_Type = tkc.Ticket_Type;
        this.Price = tkc.Price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getShowtimeID() {
        return ShowtimeID;
    }

    public void setShowtimeID(int ShowtimeID) {
        this.ShowtimeID = ShowtimeID;
    }

    public String getTicket_Type() {
        return Ticket_Type;
    }

    public void setTicket_Type(String Ticket_Type) {
        this.Ticket_Type = Ticket_Type;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    
}
