package pop.sorting;

public enum SortingType {
    PRICE_DEC("cena: od najwyższej", "pd"),
    NONE("brak", "");

    private String urlQuery;
    private String sortingName;

    SortingType(String sortingName, String urlQuery) {
        this.urlQuery = urlQuery;
        this.sortingName = sortingName;
    }

    public String getUrlQuery() {
        return urlQuery;
    }

    public String getSortingName() {
        return sortingName;
    }

    public static SortingType getSortingByName(String sortingName) {
        for(SortingType sortingType : SortingType.values()) {
            if(sortingType.sortingName.equals(sortingName))
                return sortingType;
        }
        return NONE;
    }
}
