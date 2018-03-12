/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

/////////////////////////////////////////////////////
function RechercherEmployeParNom() {     
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

////////////////////////////////////////////////////////////////////////
function addRowHandlersDirectionGeneral() {
var table = document.getElementById("myTable");
    var rows = table.getElementsByTagName("tr");
    for (i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
                return function() { 
                                 
                                 var cell = row.getElementsByTagName("td")[0];
                                 var id = cell.innerHTML;
                                 //alert("id:" + id);
                                 if (confirm('Vous etes sur de vouloir faire employe '+id+' un direction general?')) {
                                              document.getElementsByName("employe").value = id;
                                                
                                } else {
                                    // Do nothing!
                                }
                                       
                           };
            };

        currentRow.onclick = createClickHandler(currentRow);
    }
  // alert("koko");
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function validerCreationEmploye() {
    var x = document.forms["EmployeForm"]["employe"].value;
    if (x == "") {
        x = document.forms["EmployeForm"]["nom"].value;
        if (x==""){
            alert("Il faur remplir le nom");
            return false;
        }
        x = document.forms["EmployeForm"]["prenom"].value;
        if (x==""){
            alert("Il faur remplir le prenom");
            return false;
        }
        x = document.forms["EmployeForm"]["adresse"].value;
        if (x==""){
            alert("Il faur remplir le adresse");
            return false;
        }
         x = document.forms["EmployeForm"]["email"].value;
        if (x==""){
            alert("Il faur remplir l'email");
            return false;
        }
         x = document.forms["EmployeForm"]["telephone"].value;
        if (x==""){
            alert("Il faur remplir le telephone");
            return false;
        }
    }
    return true;
}

//////////////////////////////////////////////////////////////////////////////////////

function modifierAffichageCategorie( nom) {     
    document.getElementById(nom).style.visibility = "hidden";
}   
///////////////////////////////////////////////////////////////////////////////////

function LectureSeulCategorie(nom) {
    var x = document.getElementById(nom).innerHTML;
    if (x==""){
        document.getElementById(nom).disabled = false;
    }else document.getElementById(nom).disabled = true;
}   
///////////////////////////////////////////////////////////////////////////////////

function RefreshSousCat(nom) {
    
} 

//////////////////////////////////////////////////////////////////////