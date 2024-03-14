const dataTableOptions={

lengthMenu:[5,10,20],
pageLength:10,

destroy: true,
language:{
   lengthMenu:"Mostrar_MENU_Registros por página",
   zeroRecords:"Ningún usuario encontrado",
   info:"Mostrando de _START_ a _END_ de un total de _TOTAL_ registros",
   infoEmpty:"Ningún usuario encontrado",
   infoFiltered:"(filtrados desde _MAX_ registros totales)",
   search:"Buscar:",
   loadingRecords:"Cargando...",
   paginate:{ first:"Primero",
              last:"Último",
              next:"Siguiente",
              previous:"Anterior"
            }
        }
  };
$(document).ready(function () {
    $('#mitabla').DataTable(dataTableOptions);
});