package com.letsgo.place.model.dto;

public class CopyToMyScheduleDTO {
    private String title;
    private String budgetDetail;
    private String todoDetail;
    private String userId;
    private String generatedId;
    
    public CopyToMyScheduleDTO(String title, String budgetDetail, String todoDetail, String userId) {
        this.title        = title;
        this.budgetDetail = budgetDetail;
        this.todoDetail   = todoDetail;
        this.userId       = userId;
    }
    
    public String getTitle(){
    	return title; 
    }
    public String getBudgetDetail(){ 
    	return budgetDetail; 
    }
    public String getTodoDetail(){ 
    	return todoDetail;
    }
    public String getUserId(){ 
    	return userId;
    }
    public String getGeneratedId(){ 
    	return generatedId; 
    }

    public void setGeneratedId(String generatedId) {
        this.generatedId = generatedId;
    }
}
