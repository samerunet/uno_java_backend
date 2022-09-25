package com.unogame.uno.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

    //**************************************** */
    //  Entity Properties
    //**************************************** */

    @Id //Denotes this property as the id/primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //auto generates
    public Integer id;

    private String username;
    private String name;
    private String logo;
    private Integer score;
    private String friends;
    private String inventory;

    //**************************************** */
    //  Constructors
    //**************************************** */

    public Todo(){

    }

    public Todo(String username, String name, String logo, Integer score, String friends, String inventory){
        this.username = username;
        this.name = name;
        this.logo = logo;
        this.score = score;
        this.friends = friends;
        this.inventory = inventory;
    }

    //**************************************** */
    //  GETTERS AND SETTERS
    //**************************************** */

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername() {
        return username;
      }
    
      public void setUsername(String username) {
        this.username = username;
      }
    
      public String getName() {
        return name;
      }
    
      public void setName(String name) {
        this.name = name;
      }
    
      public String getLogo() {
            return logo;
        }
    
        public void setLogo(String logo) {
            this.logo = logo;
        }
    
        public Integer getScore() {
            return score;
        }
    
        public void setScore(Integer score) {
            this.score = score;
        }
    
        public String getFriends() {
            return friends;
        }
    
        public void setFriends(String friends) {
            this.friends = friends;
        }
    
        public String getInventory() {
            return inventory;
        }
    
        public void setInventory(String inventory) {
            this.inventory = inventory;
        }
    
}
