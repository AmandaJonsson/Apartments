
import {
  Rent
} from "./Rent.js"
import {
  eventBus as eB
} from "../util/eventBus.js"
import {
  rentService
} from "../service/RentService.js"

/**
 * 
 * Person responsible for class: Amanda Jonsson
 */
class RentRegistry {
   
   
   constructor() {
       this.rents = [];
    } 


    find(id) {
        return this.rents.find(a => a.id === id);
    }
    
    
    findAll() {
        rentService.findAll(data => {
          this.rents = data;
          return eB.notify("", data);
        });
    }
    
    
    create(rent) {
        rentService.create(rent, data => {
            return eB.notify("ADD", data);
        }); 
    }
    
    
    update(rent) {
        rentService.update(rent, callback => {
            var a = this.find(rent.id);
            this.rents = callback;
            eB.notify("UPDATE", this.rents);
        });
    }
    
    
    delete(id) {
        rentService.delete(id, data => {
           var a = this.find(id);
           this.rents = this.rents.filter(elem => elem !== a);
           return eB.notify("DELETE", this.rents); 
        });
    }
    
}

export const reReg = new RentRegistry();
