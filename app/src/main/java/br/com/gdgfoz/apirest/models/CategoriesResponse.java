
package br.com.gdgfoz.apirest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoriesResponse {

    @SerializedName("data")
    @Expose
    private List<Category> data = new ArrayList<Category>();

    /**
     * 
     * @return
     *     The data
     */
    public List<Category> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Category> data) {
        this.data = data;
    }

}
