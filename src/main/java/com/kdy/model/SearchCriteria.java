package com.kdy.model;

/**
 * Created by user on 2017-04-10.
 */
public class SearchCriteria extends Criteria {
    private String SearchType;
    private String keyword;

    public String getSearchType() {
        return SearchType;
    }

    public void setSearchType(String searchType) {
        SearchType = searchType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "SearchType='" + SearchType + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
