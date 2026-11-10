package com.morrisons.sma.pojo.service.range;

import java.util.ArrayList;

public class RangeRoot {

    private ArrayList<Range> range;

    public ArrayList<Range> getRange() {
        return range;
    }

    public void setRange(ArrayList<Range> range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "GetRangeRoot [range=" + range + "]";
    }


}
