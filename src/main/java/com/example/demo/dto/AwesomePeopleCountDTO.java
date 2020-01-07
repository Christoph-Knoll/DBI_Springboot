package com.example.demo.dto;

public class AwesomePeopleCountDTO {
    private boolean isAwesome;
    private long count;

    public AwesomePeopleCountDTO(boolean isAwesome, long count){
        this.isAwesome = isAwesome;
        this.count = count;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public long getCount() {
        return count;
    }
}