

        package GenericFramework.Resource.Airlines.POJOs;

        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;
        import lombok.Data;

        import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_id",
        "name",
        "country",
        "logo",
        "slogan",
        "head_quaters",
        "website",
        "established",
        "__v"
})
@Generated("jsonschema2pojo")
@Data
public class AirLineResponsePojo {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("id")
    private String id1;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("slogan")
    private String slogan;
    @JsonProperty("head_quaters")
    private String headQuaters;
    @JsonProperty("website")
    private String website;
    @JsonProperty("established")
    private String established;
    @JsonProperty("__v")
    private Integer v;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
//
//    @JsonProperty("_id")
//    public String getId() {
//        return id;
//    }
//
//    @JsonProperty("_id")
//    public void setId(String id) {
//        this.id = id;
//    }
//
//
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
//    @JsonProperty("__v")
//    public Integer getV() {
//        return v;
//    }
//
//    @JsonProperty("__v")
//    public void setV(Integer v) {
//        this.v = v;
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
