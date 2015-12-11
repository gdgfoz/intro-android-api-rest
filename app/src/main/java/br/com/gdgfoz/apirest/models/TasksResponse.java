
package br.com.gdgfoz.apirest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TasksResponse {

    @SerializedName("data")
    @Expose
    private List<Task> tasks = new ArrayList<Task>();
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * 
     * @return
     *     The tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * 
     * @param tasks
     *     The tasks
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * 
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
