package com.github.codingricky.marvel.model;

import com.google.common.base.Objects;

import java.util.List;

public class Container<T> {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<T> results;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(offset)
                .addValue(limit)
                .addValue(total)
                .addValue(count)
                .addValue(results)
                .toString();
    }
}
