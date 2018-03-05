
import {
  reReg
} from "../model/RentRegistry.js"

const columns = [{
    data: "id"
  },
  {
    data: "description"
  },
  {
    data: "mail"
  },
  {
    data: "name"
  },
  {
    data: "phoneNr"
  }
];

$(document).ready(function() {
  let rents = reReg.findAll();
  let table = $('#rent').DataTable({
    data: rents,
    columns: columns  // Must be here
  });
});

