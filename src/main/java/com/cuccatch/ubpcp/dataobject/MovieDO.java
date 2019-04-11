package com.cuccatch.ubpcp.dataobject;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieDO extends BaseEntity{
    @Column(nullable = false)
    private Integer rank;
    @Column(length = 100, nullable = false)
    private String img_url;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String alias;
    @Column(length = 100, nullable = false)
    private String country;
    @Column(length = 100,nullable = false)
    private String year;
    @Column(length = 30, nullable = false)
    private String type;
    @Column(nullable = false)
    private float score;
    @Column(nullable = false)
    private Integer score_num;
    @Column(length = 2000, nullable = false)
    private String description;
    @Column(length = 100, nullable = false)
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Integer getScore_num() {
        return score_num;
    }

    public void setScore_num(Integer score_num) {
        this.score_num = score_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
