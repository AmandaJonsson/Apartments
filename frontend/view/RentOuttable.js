
import {
  ReOuReg
} from "../model/RentOutRegistry.js"

const columns = [{
    data: "id"
  },
  {
    data: "adress"
  },
  {
    data: "description"
  },
  {
    data: "name"
  },
  {
    data: "phoneNr"
  },
  {
    data: "mail"
  },
  {
    data: "image"
  }
];

$(document).ready(function() {
  let rentOuts = ReOuReg.findAll();
  let table = $('#rentOut').DataTable({
    data: rentOuts,
    columns: columns  // Must be here
  });
});

