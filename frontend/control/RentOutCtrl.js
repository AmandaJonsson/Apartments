

import {
  reOuReg
} from "../model/RentOutRegistry.js"
import {
  RentOut
} from "../model/RentOut.js"
import {
  eventBus as eB
} from "../util/eventBus.js"


class Listener {
    
    
    onModelEvent(event, data) {
        var table = $('#rentOut').DataTable();
        table.rows().remove();
        table.rows.add(data).draw();
    }
    
    
    update() {
        //console.log("update");
        let id = $("#rid").val();
        let adr = $("#radress").val();
        let des = $("#rdescription").val();
        let name = $("#rname").val();
        let pho = $("#rphoneNr").val();
        let mail = $("#rmail").val();
        let img = $("#rimage").val();
        let reOu = new RentOut(id, adr, des, name, pho, mail, img);
        reOuReg.update(reOu);
    }
    
    
    delete() {
        //console.log("delete");
        let id = $("#rid").val();
        reOuReg.delete(id);
    }
    
    
    create() {
        //console.log("create");
        let id = $("#rid").val();
        let adr = $("#radress").val();
        let des = $("#rdescription").val();
        let name = $("#rname").val();
        let pho = $("#rphoneNr").val();
        let mail = $("#rmail").val();
        let img = $("#rimage").val();
        let reOu = new RentOut(id, adr, des, name, pho, mail, img);
        reOuReg.create(reOu);
    }
    
}

const listener = new Listener();
eB.register(listener);


