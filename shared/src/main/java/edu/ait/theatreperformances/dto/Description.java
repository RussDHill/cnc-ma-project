package edu.ait.theatreperformances.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@ApiModel(description="The name and description of a performance")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 4, max = 50, message = "Name must be between 4 and 50 characters")
    @ApiModelProperty(notes="Name must be between 4 and 50 characters")
    private String name;
    @Lob
    @Size(min = 30, max = 500, message = "Description must be between 30 and 500 characters")
    @ApiModelProperty(notes="Description must be between 30 and 500 characters")
    private String description;

    public Description() {
    }

    public Description(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

