package nearbyshops.shop.dto.tomTom;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Poi {

    @JsonProperty(
            value = "name",
            required = true
    )
    private String name;

    @JsonProperty(
            value = "phone"
    )
    private String phone;

    @JsonProperty(
            value = "url"
    )
    private String url;

    @JsonProperty(
            value = "categories"
    )
    private List<String> categories;



    public Poi() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
