
class RentOutService {
    
    constructor() {
        this.baseUrl = "http://localhost:8080/apartment/rest/rentOut";
    }
    
    
    findAll(callback) {
        window.$.ajax({
            url: this.baseUrl,
            method: "GET",
            context: this 
          }).done(data => { 
            callback(data);
          })
          .fail(msg => { 
            console.log(msg);
        });
    }
    
    
    create(rentOut, callback) {
        //console.log(rentOut);
        window.$.ajax({
            url: this.baseUrl,
            data: rentOut, 
            method: "POST",
            crossDomain: true,
            context: this
          }).done(data => {
            this.findAll(callback);
          })
          .fail(msg => {
            console.log(msg);
        });
    }
    
    
    find(id, callback) {
        $.ajax({
            url: this.baseUrl + "/" + id,
            method: "GET"
          }).done(data => {
            callback(data);
          })
          .fail(msg => {
            console.log(msg);
        });
    }
    
    
    delete(id, callback) {
        window.$.ajax({
              url: this.baseUrl + "/" + id,
              method: "DELETE",
              context: this
          }).done (data => {
              this.findAll(callback);
          })
          .fail(msg => {
              console.log(msg);
        });
    }
    
    
    update(rentOut, callback) {
        window.$.ajax({
              url: this.baseUrl + "/" + rentOut.id,
              data: rentOut,
              method: "PUT",
              crossDomain: true,
              context: this
          }).done(data => {
              this.findAll(callback);
          })
          .fail(msg => {
              console.log(msg);
        }); 
    }
  
}

export const rentOutService = new RentOutService();
