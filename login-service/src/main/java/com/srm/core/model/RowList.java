package com.srm.core.model;

import java.util.List;

public class RowList {

    String row;
    List<Seat> seatList;
    public RowList(String row, List<Seat> seatList) {
        super();
        this.row = row;
        this.seatList = seatList;
    }
    public String getRow() {
        return row;
    }
    public void setRow(String row) {
        this.row = row;
    }
    public List<Seat> getSeatList() {
        return seatList;
    }
    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
    public RowList() {

    }
}