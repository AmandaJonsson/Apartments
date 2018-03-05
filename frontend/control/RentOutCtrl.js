

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
    
    
    showEditDeleteModal(rowData) {
        $("#rid").val(rowData.id);
        $("#radress").val(rowData.adress);
        $("#rdescription").val(rowData.description);
        $("#rname").val(rowData.name);
        $("#rphoneNr").val(rowData.phoneNr);
        $("#rmail").val(rowData.mail);
        $("#rimage").val(rowData.image);
        $("#editDeleteModal").modal('show');
    }
    
    
    update() {
        let id = $("#rid").val();
        let adr = $("#radress").val();
        let des = $("#rdescription").val();
        let name = $("#rname").val();
        let pho = $("#rphoneNr").val();
        let mail = $("#rmail").val();
        let img = $("#rimage").val();
        let reOu = new RentOut(id, adr, des, name, pho, mail, img);
        reOuReg.update(reOu);
        $("#editDeleteModal").modal('hide');
    }
    
    
    delete() {
        let id = $("#rid").val();
        reOuReg.delete(id);
        $("#editDeleteModal").modal('hide');
    }
    
    
    create() {
        let id = $("#id").val();
        let adr = $("#adress").val();
        let des = $("#description").val();
        let name = $("#name").val();
        let pho = $("#phoneNr").val();
        let mail = $("#mail").val();
        let img = $("#image").val();
        let reOu = new RentOut(id, adr, des, name, pho, mail, img);
        reOuReg.create(reOu);
    }
    
}

const listener = new Listener();
eB.register(listener);

$(document).ready(function() {
    let table = $('#rentOut').dataTable().api();
    table.on("click", "tbody tr", function(e) {
      listener.showEditDeleteModal(table.row(this).data());
    });
    $("#update").on("click", listener.update);
    $("#delete").on("click", listener.delete);
    $("#add").on("click", listener.create);
});
