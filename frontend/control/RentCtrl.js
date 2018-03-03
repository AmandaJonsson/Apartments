

import {
  reReg
} from "../model/RentRegistry.js"
import {
  Rent
} from "../model/Rent.js"
import {
  eventBus as eB
} from "../util/eventBus.js"


class Listener {
    
    
    onModelEvent(event, data) {
        var table = $('#rent').DataTable();
        table.rows().remove();
        table.rows.add(data).draw();
    }
    
    
    showEditDeleteModal(rowData) {
        $("#rid").val(rowData.id);
        $("#rdescription").val(rowData.description);
        $("#rmail").val(rowData.mail);
        $("#rname").val(rowData.name);
        $("#rphoneNr").val(rowData.phoneNr);
        $("#editDeleteModal").modal('show');
    }
    
    
    update() {
        //console.log("update");
        let id = $("#rid").val();
        let des = $("#rdescription").val();
        let mail = $("#rmail").val();
        let name = $("#rname").val();
        let pho = $("#rphoneNr").val();
        let re = new Rent(id, des, mail, name, pho);
        reReg.update(re);
    }
    
    
    delete() {
        //console.log("delete");
        let id = $("#rid").val();
        reReg.delete(id);
    }
    
    
    create() {
        //console.log("create");
        let id = $("#rid").val();
        let des = $("#rdescription").val();
        let mail = $("#rmail").val();
        let name = $("#rname").val();
        let pho = $("#rphoneNr").val();
        let re = new Rent(id, des, mail, name, pho);
        reReg.create(re);
    }
    
}

const listener = new Listener();
eB.register(listener);

$(document).ready(function() {
    let table = $('#rent').dataTable().api();
    table.on("click", "tbody tr", function(e) {
      listener.showEditDeleteModal(table.row(this).data());
    });
    $("#update").on("click", listener.update);
    $("#delete").on("click", listener.delete);
    $("#add").on("click", listener.create);
});
