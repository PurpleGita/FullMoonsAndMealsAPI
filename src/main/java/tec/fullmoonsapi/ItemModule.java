package tec.fullmoonsapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Base64;
import java.util.List;

@Entity
public class ItemModule {

    @JsonIgnore
    private boolean food;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("isFood")
    private boolean isFood;
    private String name;
    private int price;
    private String currency;

    @Lob
    @JsonProperty("image")
    private byte[] image;

    private String taste;
    private String effect;

    @ElementCollection
    private List<String> allergies;

    public ItemModule() {
    }

    public ItemModule(boolean isFood, String name, int price, String currency, byte[] image, String taste, String effect, List<String> allergies) {
        this.isFood = isFood;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.image = image;
        this.taste = taste;
        this.effect = effect;
        this.allergies = allergies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setIsFood(boolean isFood) {
        this.isFood = isFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}