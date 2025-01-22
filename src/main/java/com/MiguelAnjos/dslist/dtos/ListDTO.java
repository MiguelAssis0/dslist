package com.MiguelAnjos.dslist.dtos;

import com.MiguelAnjos.dslist.projections.GameMinProjection;

public class ListDTO {

    private Long id;
    private String title;
    private Integer position;
    private String listName;

    public ListDTO() {}
    public ListDTO(Long id, String title, Integer position, String listName) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.listName = listName;
    }

    public ListDTO(GameMinProjection gameMinProjection) {

        this.id = gameMinProjection.getId();
        this.title = gameMinProjection.getTitle();
        this.position = gameMinProjection.getPosition();
        this.listName = gameMinProjection.getListName();
    }

    public Long getId() {
        return id;
    };

    public void setId(Long id){
        this.id = id;
    };

    public String getTitle(){
        return title;
    };

    public void setTitle(String title){
        this.title = title;
    };

    public Integer getPosition(){
        return position;
    };

    public void setPosition(Integer position){
        this.position = position;
    };

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
