package GenericFramework.Resource.Airlines.POJOs;

//import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import lombok.*;

import java.util.stream.Stream;

//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//import javax.annotation.Generated;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "id",
//        "name",
//        "country",
//        "logo",
//        "slogan",
//        "head_quaters",
//        "website",
//        "established"
//})
//@Generated("jsonschema2pojo")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirLinePojo {

    String countryID= Stream.of("India","Nepal","Srilanka").findAny().get();
    @JsonProperty("id")
    private Integer id=new Faker().number().numberBetween(111111,9999999);
    @JsonProperty("name")
    private String name=new Faker().country().name();
    @JsonProperty("country")
    private String country=countryID;
    @JsonProperty("logo")
    private String logo="https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png";
    @JsonProperty("slogan")
    private String slogan=new Faker().country().name();
    @JsonProperty("head_quaters")
    private String headQuaters=new Faker().country().name();;
    @JsonProperty("website")
    private String website=new Faker().country().name();;
    @JsonProperty("established")
    private String established=new Faker().number().digit();
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
//
//    @JsonProperty("id")
//    public Integer getId() {
//        return id;
//    }
//
//    @JsonProperty("id")
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @JsonProperty("name")
//    public String getName() {
//        return name;
//    }
//
//    @JsonProperty("name")
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @JsonProperty("country")
//    public String getCountry() {
//        return country;
//    }
//
//    @JsonProperty("country")
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    @JsonProperty("logo")
//    public String getLogo() {
//        return logo;
//    }
//
//    @JsonProperty("logo")
//    public void setLogo(String logo) {
//        this.logo = logo;
//    }
//
//    @JsonProperty("slogan")
//    public String getSlogan() {
//        return slogan;
//    }
//
//    @JsonProperty("slogan")
//    public void setSlogan(String slogan) {
//        this.slogan = slogan;
//    }
//
//    @JsonProperty("head_quaters")
//    public String getHeadQuaters() {
//        return headQuaters;
//    }
//
//    @JsonProperty("head_quaters")
//    public void setHeadQuaters(String headQuaters) {
//        this.headQuaters = headQuaters;
//    }
//
//    @JsonProperty("website")
//    public String getWebsite() {
//        return website;
//    }
//
//    @JsonProperty("website")
//    public void setWebsite(String website) {
//        this.website = website;
//    }
//
//    @JsonProperty("established")
//    public String getEstablished() {
//        return established;
//    }
//
//    @JsonProperty("established")
//    public void setEstablished(String established) {
//        this.established = established;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}