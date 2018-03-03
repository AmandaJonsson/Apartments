
import {
  RentOut
} from "./RentOut.js"
import {
  eventBus as eB
} from "../util/eventBus.js"
import {
  rentOutService
} from "../service/RentOutService.js"


class RentOutRegistry {
   
   
   constructor() {
       this.rentOuts = [
           new RentOut("OO", "oo", "oo", "oo", "11", "o@com", "ollev")
       ];
    } 


    find(id) {
        return this.rentOuts.find(a => a.id === id);
    }
    
    
    findAll() {
        rentOutService.findAll(data => {
          this.rentOuts = data;
          return eB.notify("", data);
        });
    }
    
    
    create(rentOut) {
        rentOutService.create(rentOut, data => {
            return eB.notify("ADD", data);
        }); 
    }
    
    
    update(rentOut) {
        rentOutService.update(rentOut, callback => {
            var a = this.find(rentOut.id);
            this.rentOuts = callback;
            eB.notify("UPDATE", this.rentOuts);
        });
    }
    
    
    delete(id) {
        rentOutService.delete(id, data => {
           var a = this.find(id);
           this.rentOuts = this.rentOuts.filter(elem => elem !== a);
           return eB.notify("DELETE", this.rentOuts); 
        });
    }
    
}

export const reOuReg = new RentOutRegistry();
