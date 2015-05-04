/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psas;

import java.sql.Date;

/**
 *
 * @author sanjay
 */
public class Complaint {
    private int id;
    private String title;
    private String description;
    private Date created_at;
    private String status;
    private int customer_id;
    private String priority;
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Date get_created_at() {
        return created_at;
    }
    
    public String getStatus() {
        return status;
    }
    
    public int getCustomerId() {
        return customer_id;
    }
    
    public String getPriority() {
        return priority;
    }
}
