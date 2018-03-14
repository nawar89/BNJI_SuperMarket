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
                                 if (confirm('Vous etes sur de vouloir changer le role demploye '+id+'?')) {
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

function LectureSeulCategorie(nom,champ) {
    var x = champ.innerHTML;
    console.log("TEXXXXt "+x);x 
    if (x==""){
        document.getElementById(nom).disabled = false;
    }else document.getElementById(nom).disabled = true;
}   
///////////////////////////////////////////////////////////////////////////////////

function RefreshComboBox(ddl1,ddl2,ddl3) {
   
            var row = ddl3.getElementsByTagName("option");
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
             console.log(selectedValue)
            ddl2.options.length = 0;
            for (i = 0; i < row.length; i++) {
                if (selectedValue == row[i].value){
                    createOption(ddl2, row[i].text, selectedValue);
                    
                }
            }      
    }

//////////////////////////////////////////////////////////////////////
function createOption(ddl, text, value) {
        var opt = document.createElement('option');
        opt.value = value;
        opt.text = text;
        ddl.options.add(opt);
    }

//////////////////////////////////////////



function RefreshTableEmployee(ddl1,Mytable) {
   
            var row = ddl1.getElementsByTagName("option");
            var selectedValue = ddl1.options[ddl1.selectedIndex].text;
             console.log(selectedValue)
             var input, filter, table, tr, td, i;
             
            filter = selectedValue.toUpperCase();
            table = document.getElementById(Mytable);
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
              td = tr[i].getElementsByTagName("td")[3];
              if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                  tr[i].style.display = "";
                } else {
                  tr[i].style.display = "none";
                }
              }       
            }
    }
    
    
 /////////////////////////////////////////////////////////////////////////////////
 
 function validerCreationDirectureMagasin(magasin) {
    var x = document.forms["EmployeForm"]["employe"].value;
    if (x == "") {
        var selectedValue = magasin.options[magasin.selectedIndex].text;
        console.log("selectedValue"+ selectedValue);
        if (selectedValue == "" || selectedValue == "0" || selectedValue == 0 ){
            
            alert("Il faur choisir un magasin");
            return false;
        }
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

////////////////////////////////////////////////////////////////////////

function validerCreationMagasin() {
    
    
       var  x = document.forms["MagasinForm"]["nom"].value;
        if (x==""){
            alert("Il faur remplir le nom");
            return false;
        }
        x = document.forms["MagasinForm"]["adresse"].value;
        if (x==""){
            alert("Il faur remplir le adresse");
            return false;
        }
        x = document.forms["MagasinForm"]["code"].value;
        if (x==""){
            alert("Il faur remplir le code");
            return false;
        }
         x = document.forms["MagasinForm"]["ville"].value;
        if (x==""){
            alert("Il faur remplir ville");
            return false;
        }
         x = document.forms["MagasinForm"]["ho"].value;
        if (x==""){
            alert("Il faur remplir les horarire ouvertures");
            return false;
        }
        
         x = document.forms["MagasinForm"]["hf"].value;
        if (x==""){
            alert("Il faur remplir le horaires fermetures");
            return false;
        }
         x = document.forms["MagasinForm"]["gps"].value;
        if (x==""){
            alert("Il faur remplir le gps");
            return false;
        }
    return true;
}
////////////////////////////////////////////////////////////////////////////////////

function AffictuerMagasinInfo(ddl1,magsin) {
   
            var row = ddl1.getElementsByTagName("option");
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
             console.log(selectedValue)
             var input, filter, table, tr, td, i;
            magsin.value =  selectedValue;
            if (selectedValue == 0){
                document.forms["MagasinForm"]["nom"].value = "";
                  document.forms["MagasinForm"]["adresse"].value = "";
                  document.forms["MagasinForm"]["ville"].value = "";
                  document.forms["MagasinForm"]["code"].value = "";
                  document.forms["MagasinForm"]["ho"].value = "";
                  document.forms["MagasinForm"]["hf"].value = "";
                  document.forms["MagasinForm"]["gps"].value = "";
                
            }else {
            filter = selectedValue.toUpperCase();
            table = document.getElementById('myTable');
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
              td = tr[i].getElementsByTagName("td")[0];
              if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                  //tr[i].style.display = "";
                  document.forms["MagasinForm"]["nom"].value = tr[i].getElementsByTagName("td")[1].innerHTML;
                  document.forms["MagasinForm"]["adresse"].value = tr[i].getElementsByTagName("td")[2].innerHTML;
                  document.forms["MagasinForm"]["ville"].value = tr[i].getElementsByTagName("td")[3].innerHTML;
                  document.forms["MagasinForm"]["code"].value = tr[i].getElementsByTagName("td")[4].innerHTML;
                  document.forms["MagasinForm"]["ho"].value = tr[i].getElementsByTagName("td")[5].innerHTML;
                  document.forms["MagasinForm"]["hf"].value = tr[i].getElementsByTagName("td")[6].innerHTML;
                  document.forms["MagasinForm"]["gps"].value = tr[i].getElementsByTagName("td")[7].innerHTML;
                    
                } 
              }       
            }
            
        }
            
    }
    /////////////////////////////////////////////////////////////////////////////////////
    
    
function AffictuerPromoInfo(ddl1,ddl2,table) {
   
            var row = ddl1.getElementsByTagName("option");
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
            var date = ddl2.value;
             console.log(selectedValue)
             var input, filter1,filtre2, tr, td, i;
             
            filter1 = selectedValue.toUpperCase();
            filtre2 = date;
            //table = document.getElementById(Mytable);
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
              td = tr[i].getElementsByTagName("td")[1];
              if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter1) > -1 || td.innerHTML.toUpperCase().indexOf(filtre2) > -1 ) {
                  tr[i].style.display = "";
                } else {
                  tr[i].style.display = "none";
                }
              }       
            }
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////
    
    function validerCreationPromotion() {
    
        var x = document.forms["PromotionForm"]["Articleselect"].value;
        if (x == "" || x == "0" || x == 0) {
        
            alert("Il faur choisir un article");
            return false;
        }
         x = document.forms["PromotionForm"]["datedeb"].value;
        if (x==""){
            alert("Il faur remplir le date debut");
            return false;
        }
        x = document.forms["PromotionForm"]["datefin"].value;
        if (x==""){
            alert("Il faur remplir le datefin");
            return false;
        }
        x = document.forms["PromotionForm"]["prixpromo"].value;
        if (x==""){
            alert("Il faur remplir le prix promo");
            return false;
        }
        
    return true;
}

///////////////////////////////////////////////////////////////////////////////////////

function addRowHandlersPromotion() {
    
var table = document.getElementById("myTable");
    var rows = table.getElementsByTagName("tr");
    document.getElementsByName('promo').value = "";
    document.forms["PromotionForm"]["datedeb"].value = "";
    document.forms["PromotionForm"]["datefin"].value = "";
    document.forms["PromotionForm"]["prixpromo"].value = "";
    for (i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
                return function() { 
                                 
                                 var cell = row.getElementsByTagName("td")[0];
                                 var id = cell.innerHTML;
                                 //alert("id:" + id);
                                 document.getElementsByName('promo').value = row.getElementsByTagName("td")[0].innerHTML;;
                                 document.forms["PromotionForm"]["datedeb"].value = row.getElementsByTagName("td")[4].innerHTML;
                                 document.forms["PromotionForm"]["datefin"].value = row.getElementsByTagName("td")[5].innerHTML;
                                 document.forms["PromotionForm"]["prixpromo"].value = row.getElementsByTagName("td")[7].innerHTML;
                                       
                           };
            };

        currentRow.onclick = createClickHandler(currentRow);
    }
  // alert("koko");
}

/////////////////////////////////////////////////////////

function AjouterDansTable(ddl1,table) {
   
            //var row = ddl1.getElementsByTagName("option");
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
            var selectedText = ddl1.options[ddl1.selectedIndex].text;
             console.log(selectedValue)
             var input, filter1,filtre2, tr, td, i;
             var ok = true;
            filter1 = selectedValue.toUpperCase();
            //table = document.getElementById(Mytable);
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
              td = tr[i].getElementsByTagName("td")[1];
              if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter1) > -1 || td.innerHTML.toUpperCase().indexOf(filtre2) > -1 ) {
                  ok = false;
                  break;
                } 
              }       
            }
            if (ok){
                var row = table.insertRow(0);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);
                cell1.innerHTML = selectedValue;
                cell2.innerHTML = selectedText;
                cell3.innerHTML = "";
                cell4.innerHTML = "1";
  
            }
            
    }