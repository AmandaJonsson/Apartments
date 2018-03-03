
import {
  RentOut
} from "./RentOut.js"
import {
  eventBus as eB
} from "../util/eventBus.js"
import {
  RentOutService
} from "../service/RentOutService.js"


class RentOutRegistry {
   
   
   constructor() {
       this.rentOuts = [];
    } 


    find(id) {
        return this.rentOuts.find(a => a.id === id);
    }
    
    
    findAll() {
        RentOutService.findAll(data => {
          this.rentOuts = data;
          return eB.notify("", data);
        });
    }
    
    
    create(rentOut) {
        RentOutService.create(rentOut, data => {
            return eB.notify("ADD", data);
        }); 
    }
    
    
    update(rentOut) {
        RentOutService.update(rentOut, callback => {
            var a = this.find(rentOut.id);
            this.rentOuts = callback;
            eB.notify("UPDATE", this.rentOuts);
        });
    }
    
    
    delete(id) {
        RentOutService.delete(id, data => {
           var a = this.find(id);
           this.rentOuts = this.rentOuts.filter(elem => elem !== a);
           return eB.notify("DELETE", this.rentOuts); 
        });
    }
    
}

export const reOuReg = new RentOutRegistry();
