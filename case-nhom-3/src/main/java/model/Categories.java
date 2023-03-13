package model;

public class Categories {

     private Long id;
     private String categoriesName;

    public Categories(Long id, String categoriesName) {
        this.id = id;
        this.categoriesName = categoriesName;
    }
    public Categories(String categoriesName)
    {
        this.categoriesName = categoriesName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }
}
