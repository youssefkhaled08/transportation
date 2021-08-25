package asu.cis.transportation;

public class TravelsModel {
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    private int icon;
    private String from;
    private String to;
    private String date;
    private String start;
    private String end;
    private float price;
    private int availableSeats;


    public TravelsModel(String from, String to, String date, String start, String end, float price, int availableSeats) {
        this.from = from;
        this.to = to;
        this.start = start;
        this.end = end;
        this.date = date;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "TravelsModel{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", price=" + price +
                ", availableSeats=" + availableSeats +
                '}';
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
