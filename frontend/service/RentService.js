
class RentService {
    
    constructor() {
        this.baseUrl = "http://localhost:8080/apartments/rest/re";
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
    
    
    create(rent, callback) {
        //console.log(rentOut);
        window.$.ajax({
            url: this.baseUrl,
            data: rent, 
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
    
    
    update(rent, callback) {
        window.$.ajax({
              url: this.baseUrl + "/" + rent.id,
              data: rent,
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

export const rentService = new RentService();
