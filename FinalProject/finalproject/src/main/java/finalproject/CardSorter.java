package finalproject;

public class CardSorter {

    private String color;
    private String rarity;
    private String manaValue;
    private String setRelease;
    private String releaseDate;

    public Card() {
        // Default constructor required for JSON deserialization
    }

    public Card(String color, String rarity, String manaValue, String setRelease, String releaseDate) {
        this.color = color;
        this.rarity = rarity;
        this.manaValue = manaValue;
        this.setRelease = setRelease;
        this.releaseDate = releaseDate;
    }

    // Getters and setters

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getManaValue() {
        return manaValue;
    }

    public void setManaValue(String manaValue) {
        this.manaValue = manaValue;
    }

    public String getSetRelease() {
        return setRelease;
    }

    public void setSetRelease(String setRelease) {
        this.setRelease = setRelease;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color='" + color + '\'' +
                ", rarity='" + rarity + '\'' +
                ", manaValue='" + manaValue + '\'' +
                ", setRelease='" + setRelease + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
