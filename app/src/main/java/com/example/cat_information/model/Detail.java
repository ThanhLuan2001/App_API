package com.example.cat_information.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Detail {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("breeds")
    @Expose
    private List<Breed> breeds = null;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Breed> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Breed> breeds) {
        this.breeds = breeds;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public class Breed {
        @SerializedName("weight")
        @Expose
        private Weight weight;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("cfa_url")
        @Expose
        private String cfaUrl;
        @SerializedName("vetstreet_url")
        @Expose
        private String vetstreetUrl;
        @SerializedName("vcahospitals_url")
        @Expose
        private String vcahospitalsUrl;
        @SerializedName("temperament")
        @Expose
        private String temperament;
        @SerializedName("origin")
        @Expose
        private String origin;
        @SerializedName("country_codes")
        @Expose
        private String countryCodes;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("life_span")
        @Expose
        private String lifeSpan;
        @SerializedName("indoor")
        @Expose
        private Integer indoor;
        @SerializedName("lap")
        @Expose
        private Integer lap;
        @SerializedName("adaptability")
        @Expose
        private Integer adaptability;
        @SerializedName("affection_level")
        @Expose
        private Integer affectionLevel;
        @SerializedName("child_friendly")
        @Expose
        private Integer childFriendly;
        @SerializedName("cat_friendly")
        @Expose
        private Integer catFriendly;
        @SerializedName("dog_friendly")
        @Expose
        private Integer dogFriendly;
        @SerializedName("energy_level")
        @Expose
        private Integer energyLevel;
        @SerializedName("grooming")
        @Expose
        private Integer grooming;
        @SerializedName("health_issues")
        @Expose
        private Integer healthIssues;
        @SerializedName("intelligence")
        @Expose
        private Integer intelligence;
        @SerializedName("shedding_level")
        @Expose
        private Integer sheddingLevel;
        @SerializedName("social_needs")
        @Expose
        private Integer socialNeeds;
        @SerializedName("stranger_friendly")
        @Expose
        private Integer strangerFriendly;
        @SerializedName("vocalisation")
        @Expose
        private Integer vocalisation;
        @SerializedName("bidability")
        @Expose
        private Integer bidability;
        @SerializedName("experimental")
        @Expose
        private Integer experimental;
        @SerializedName("hairless")
        @Expose
        private Integer hairless;
        @SerializedName("natural")
        @Expose
        private Integer natural;
        @SerializedName("rare")
        @Expose
        private Integer rare;
        @SerializedName("rex")
        @Expose
        private Integer rex;
        @SerializedName("suppressed_tail")
        @Expose
        private Integer suppressedTail;
        @SerializedName("short_legs")
        @Expose
        private Integer shortLegs;
        @SerializedName("wikipedia_url")
        @Expose
        private String wikipediaUrl;
        @SerializedName("hypoallergenic")
        @Expose
        private Integer hypoallergenic;
        @SerializedName("reference_image_id")
        @Expose
        private String referenceImageId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getOrigin() {
            return origin;
        }


        public String getDescription() {
            return description;
        }




    }

}

