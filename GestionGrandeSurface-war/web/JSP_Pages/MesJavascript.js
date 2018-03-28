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

function AjouterDansTable(ddl1,table,tableTemp) {
   
            //var row = ddl1.getElementsByTagName("option");
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
            var selectedText = ddl1.options[ddl1.selectedIndex].text;
             console.log("selected val"+selectedValue)
             var input, filter1,filtre2, tr, td, i;
             var ok = true;
            filter1 = selectedValue.toUpperCase();
            //table = document.getElementById(Mytable);
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
              td = tr[i].getElementsByTagName("td")[0];
              if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter1) > -1 ) {
                  ok = false;
                  break;
                } 
              }       
            }
            console.log(ok);
            if (ok){
                var row = table.insertRow(1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);
                var cell5 = row.insertCell(4);
                cell1.name = "test";
                cell2.name = "test";
                cell3.name = "test";
                cell4.name = "test";
                
                cell1.innerHTML = selectedValue;
                cell2.innerHTML = selectedText;
                cell3.innerHTML = 0;
                cell4.innerHTML = 1;
                cell5.innerHTML = 0;
                cell5.style.display = 'none';
                cell4.contentEditable = true;
                cell4.addEventListener("onchange", function(){
                    //document.getElementById("demo").innerHTML = "Hello World";
                    cell5.innerHTML = parseInt(cell3.innerHTML) * parseInt(cell4.innerHTML);
                });
                var filter = selectedValue.toUpperCase();
                tr = tableTemp.getElementsByTagName("tr");
                for (var i = 0; i < tr.length; i++) {
                var td = tr[i].getElementsByTagName("td")[1];
                
                if (td) {
                    
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {

                        cell3.innerHTML = tr[i].getElementsByTagName("td")[3].innerHTML;
                        cell5.innerHTML = tr[i].getElementsByTagName("td")[3].innerHTML;
 
                    }
                }       
              } 
  
            }
            
    }
    
    /////////////////////////////////////////////////////////////////////////////////
    
    
function RefreshComboBoxTable(ddl1,ddl2,ddl3) {
            
            var tr = ddl3.getElementsByTagName("tr");
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
             var filter = selectedValue.toUpperCase();
             console.log("for id selected "+selectedValue);
             console.log("len "+tr.length);
            ddl2.options.length = 0;
            for (var i = 0; i < tr.length; i++) {
                var td = tr[i].getElementsByTagName("td")[0];
                
                if (td) {
                    
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        console.log("oui");
                        console.log(tr[i].getElementsByTagName("td")[1]);
                        console.log(tr[i].getElementsByTagName("td")[2]);
                        createOption(ddl2, tr[i].getElementsByTagName("td")[2].innerHTML, tr[i].getElementsByTagName("td")[1].innerHTML);
                    }
                }       
            } 
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
 function doSave(table) {
            var ok = false;
            document.forms["CommandeForm"]["lignes"].value = "";
            var myTableArray = [];
            var tr = table.getElementsByTagName("tr");
            for (var i = 0; i < tr.length; i++) {
            //document.getElementsByName('lignes').innerHTML = document.getElementsByName('lignes').innerHTML+"Ligne,"
            var arrayOfThisRow = [];
            var tableData = tr[i].getElementsByTagName("td");
            if (tableData.length > 0) {
              for (var j=0;j < tableData.length;j++){
                 arrayOfThisRow.push(tableData[j].innerHTML);
                 //alert(tableData[j].innerHTML);
                 ok = true;
                 document.forms["CommandeForm"]["lignes"].value= document.forms["CommandeForm"]["lignes"].value + tableData[j].innerHTML+",";
                 
              }
            myTableArray.push(arrayOfThisRow);
             }
           }
          
           console.log("lignes: " +document.forms["CommandeForm"]["lignes"].value);
           //document.forms["CommandeForm"]["lignes"].value = "1";
         //myTableArray = myTableArray.join(", ");
         if (!ok){
             alert("Il faut choisir au moins une article");
         }
         return ok;
            
}

////////////////////////////////////////////////////////////////////////////////////

function affectuerLivraisonAgent(table) {
       document.forms["LivraisonForm"]["livraison"].value = "";    
     //var table = document.getElementById("myTable");
    var rows = table.getElementsByTagName("tr");
    for (var i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
                return function() { 
                                 
                                 var cell = row.getElementsByTagName("td")[1];
                                 var id = cell.innerHTML;
                                 //alert("id:" + id);
                                
                                 if (confirm('Vous etes sur de vouloir prendre cette livraison ?')) {
                                              document.forms["LivraisonForm"]["livraison"].value = id;
                                              console.log("dans  "+document.forms["LivraisonForm"]["livraison"].value);
                                              document.getElementById('monForm').submit();
                                              //console.log('id '+id);
                                 }          
                                
                      };
            };

        currentRow.onclick = createClickHandler(currentRow);
        
        
    }  
    //alert('test');
    //document.forms["LivraisonForm"]["livraison"].value = "55";
     //document.getElementById('monForm').submit();
}

/////////////////////////////////////////////////////////////////////////

function AfficherReclamationLigneLivraison(div,table) {
    
     var rows = table.getElementsByTagName("tr");
    for (var i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
                return function() { 
                                 
                                 var cell = row.getElementsByTagName("td")[3];
                                 var livre = cell.innerHTML;
                                 var cell2 = row.getElementsByTagName("td")[4];
                                 //cell2.value = "33";
                                 var acepte = document.getElementsByName('acepte').value;
                                 //alert("id:" + id);
                                 console.log("TEETE   "+livre+"  "+ acepte);
                                 if (livre !== acepte){
                                     
                                     if (confirm('Vous voulez créer un reclamation ?')) {
                                            console.log("HERE");
                                            //div.style.visibility='visible';
                                            div.style.display = "block";
                                            //document.getElementById('recDev').style.visibility = 'visible';
                                            document.getElementsByName('ligneLivraisonID').value = row.getElementsByTagName("td")[1].innerHTML;
                                            row.getElementsByTagName("td")[7].innerHTML= acepte;
                                            console.log("row7 "+row.getElementsByTagName("td")[7].innerHTML);
         
                                     }else {
                                         cell2.value = livre;
                                         document.getElementsByName('acepte').value = livre;
                                         
                                     }
                                     
                                 }       
                                
                      };
            };

        currentRow.onclick = createClickHandler(currentRow);
        
        
    }  
    
    
            
}
///////////////////////////////////////////////////////////////////////
function test() {
    
    alert('hi');
            
}

////////////////////////////////////////////////////////////////////////////////////

function creerReclamationLigneLivraison(table,ddl1,div) {
    
     var rows = table.getElementsByTagName("tr");
    for (var i = 1; i < rows.length; i++) {
        var currentRow = table.rows[i];
        //console.log('GGGGGGG' + rows.length);
        if (currentRow.getElementsByTagName("td")[1].innerHTML === document.getElementsByName('ligneLivraisonID').value){
            console.log('ddd'+ document.getElementById('recText').value);
            currentRow.getElementsByTagName("td")[7].innerHTML = document.getElementById('recText').value;
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
            var selectedText = ddl1.options[ddl1.selectedIndex].text;
            currentRow.getElementsByTagName("td")[6].innerHTML = selectedText;
            document.getElementsByName('ligneLivraisonID').value = "";
            document.getElementById('recText').value = "";
            div.style.display = "none";
            
            
        }
        
        
    }  
    
    
            
}

/////////////////////////////////////////////////////
function doSaveLivraisonLigneAgent(table) {
            var ok = false;
            document.forms["LivraisonForm"]["livlignes"].value = "";
            var myTableArray = [];
            var tr = table.getElementsByTagName("tr");
            for (var i = 0; i < tr.length; i++) {
            //document.getElementsByName('lignes').innerHTML = document.getElementsByName('lignes').innerHTML+"Ligne,"
            var arrayOfThisRow = [];
            var tableData = tr[i].getElementsByTagName("td");
            if (tableData.length > 0) {
              for (var j=0;j < tableData.length;j++){
                 arrayOfThisRow.push(tableData[j].innerHTML);
                 //alert(tableData[j].innerHTML);
                 
                 ok = true;
                 if (j===1 || j===2 || j===6 || j===7)
                 {
                      document.forms["LivraisonForm"]["livlignes"].value= document.forms["LivraisonForm"]["livlignes"].value + tableData[j].innerHTML+",";
                 }else
                 if (j===8){
                     if (tableData[j].innerHTML !== ""){
                         
                       document.forms["LivraisonForm"]["livlignes"].value= document.forms["LivraisonForm"]["livlignes"].value + tableData[j].innerHTML+",";   
                     }else document.forms["LivraisonForm"]["livlignes"].value= document.forms["LivraisonForm"]["livlignes"].value + tableData[4].innerHTML+",";   
                    
                 }
                
                 
              }
            myTableArray.push(arrayOfThisRow);
             }
           }
          
           console.log("lignes: " +document.forms["LivraisonForm"]["livlignes"].value);
           //document.forms["CommandeForm"]["lignes"].value = "1";
         //myTableArray = myTableArray.join(", ");
        
         return ok;
            
}

////////////////////////////////////////////////////////////////////////////////////


function refrechQuantiteLivree(table) {
    
 var rows = table.getElementsByTagName("tr");
    for (var i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
                return function() { 
                                 
                                
                                 var acepte = document.getElementsByName('acepte').value;
                                  document.getElementsByName('acepte').value="";
                                  
                                 row.getElementsByTagName("td")[6].innerHTML= document.getElementsByName('dateTemp').value;
                                 row.getElementsByTagName("td")[5].innerHTML= acepte;
                                 console.log("row4 "+row.getElementsByTagName("td")[5].innerHTML);
                                 document.getElementsByName('dateTemp').value="";
         
                                    
                                         
                      };
            };

        currentRow.onclick = createClickHandler(currentRow);
        
        
    }  
    
            
}

//////////////////////////////////////////////////////////////////////////////////////////




function ActualiserTableCommandeAlivrer(table,tableTemp,ddl1) {
    document.getElementsByName('bonCommande').value = "";
 var rowsSupp = table.getElementsByTagName("tr");
  for (var i = 0; i < rowsSupp.length; i++) {
      rowsSupp.deleteRow(i);
  }       
 var rows = tableTemp.getElementsByTagName("tr");
 var selectedValue = ddl1.options[ddl1.selectedIndex].value;
 document.getElementsByName('bonCommande').value =  selectedValue;
    for (var i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
                return function() { 
                       if (row.getElementsByTagName("td")[0].innerHTML == selectedValue){
                           row.style.display = "none";
                           var Newrow = table.insertRow(1);
                            var cell1 = Newrow.insertCell(0);
                            var cell2 = Newrow.insertCell(1);
                            var cell3 = Newrow.insertCell(2);
                            var cell4 = Newrow.insertCell(3);
                            var cell5 = Newrow.insertCell(4);
                            var cell6 = Newrow.insertCell(5);
                            cell1.innerHTML = row.getElementsByTagName("td")[0];
                            cell2.innerHTML = row.getElementsByTagName("td")[1];
                            cell3.innerHTML = row.getElementsByTagName("td")[2];;
                            cell4.innerHTML = row.getElementsByTagName("td")[3];
                            cell5.innerHTML = row.getElementsByTagName("td")[6];
                            cell6.innerHTML = row.getElementsByTagName("td")[7];
                            
                           
                           
                       } else  row.style.display = "";        
                                         
                };
            };

        currentRow.onclick = createClickHandler(currentRow);
        
        
    }  
    
            
}

////////////////////////////////////////////////////////////////////////////////////



function chargerDonnees(table) {
            var ok = false;
            document.forms["demo-form2"]["ligneLivraisonQte"].value = "";
            var myTableArray = [];
            var tr = table.getElementsByTagName("tr");
            console.log("taille "+tr.length);
            for (var i = 0; i < tr.length; i++) {
            //document.getElementsByName('lignes').innerHTML = document.getElementsByName('lignes').innerHTML+"Ligne,"
            var arrayOfThisRow = [];
            var tableData = tr[i].getElementsByTagName("td");
            if (tableData.length > 0) {
              for (var j=0;j < tableData.length;j++){
                 arrayOfThisRow.push(tableData[j].innerHTML);
                 //alert(tableData[j].innerHTML);
                 console.log("current: "+" j "+j +" "+tableData[j].innerHTML);
                 ok = true;
                 //if(j===0 || j===1 || j===4 || j===5 )
                 document.forms["demo-form2"]["ligneLivraisonQte"].value= document.forms["demo-form2"]["ligneLivraisonQte"].value + tableData[j].innerHTML+",";
                 console.log("lignes: " +document.forms["demo-form2"]["ligneLivraisonQte"].value);
                
                 
              }
            myTableArray.push(arrayOfThisRow);
             }
           }
          
           
           //document.forms["CommandeForm"]["lignes"].value = "1";
         //myTableArray = myTableArray.join(", ");
        
         return ok;
            
}
/////////////////////////////////////////////////////////////


function RefreshComboBoxArticle(ddl1,ddl2,table) {
   
            var row = table.getElementsByTagName("tr");
            var selectedValue = ddl1.options[ddl1.selectedIndex].value;
             console.log(selectedValue)
            ddl2.options.length = 0;
            for (i = 0; i < row.length; i++) {
                if (selectedValue == row[i].getElementsByTagName("td")[0].innerHTML){
                    createOption(ddl2, row[i].getElementsByTagName("td")[2].innerHTML,row[i].getElementsByTagName("td")[1].innerHTML );
                    
                }
            }      
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////

  
    
function verifierInputClient(d1,d2,d3,d4) {
            console.log(d1.value+" "+d2.value)
           if (d1.value !== d2.value){
               
              // alert("Mdp et confirmation ne correspondent pas");
               d3.classList.toggle("show");
               return false;
               
           }
           return true;
    }
    
    /////////////////////////////////////////////////////
    
    
    function updateTablePanier(table,temp,ch) {
        ch.innerHTML = "0";
          var rows = table.getElementsByTagName("tr");
          var selectedVal = temp.value;
    for (i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var createClickHandler = 
            function(row) 
            {
                return function() { 
                                
                                row.getElementsByTagName("td")[5].innerHTML = selectedVal;
                                
                                row.getElementsByTagName("td")[4].innerHTML = parseFloat(row.getElementsByTagName("td")[2].innerHTML) * parseInt(selectedVal);
                                //row.getElementsByTagName("td")[3].innerHTML = 11;
                                 
                                 ch.innerHTML = parseInt(ch.innerHTML)+parseInt(row.getElementsByTagName("td")[4].innerHTML);
                                 console.log(ch.innerHTML); 
                                 
                      };
            };

        currentRow.onclick = createClickHandler(currentRow);
        
        
    }    
    ch.innerHTML ="€"+ch.innerHTML;
    }
   //////////////////////////////////////////// 
    function updateTotal(table,totalCh) {
          var rows = table.getElementsByTagName("tr");
    var total = 0;      
    for (var i = 0; i < rows.length; i++) {
        var currentRow = table.rows[i];
        console.log(currentRow.getElementsByTagName("td")[4].innerHTML);    
        //total +=  parseFloat(currentRow.getElementsByTagName("td")[4].innerHTML);      
        
    }    
     totalCh.innerHTML =  "€"+total;    
    }
    
    /////////////////////////////////////////////////////////////////
    
    function chargerDonneesPanier(table) {
            var ok = false;
            
            var myTableArray = [];
            var tr = table.getElementsByTagName("tr");
            for (var i = 0; i < tr.length; i++) {
            //document.getElementsByName('lignes').innerHTML = document.getElementsByName('lignes').innerHTML+"Ligne,"
            var arrayOfThisRow = [];
            var tableData = tr[i].getElementsByTagName("td");
            if (tableData.length > 0) {
              for (var j=0;j < tableData.length;j++){
                 //arrayOfThisRow.push(tableData[j].innerHTML);
                 //alert(tableData[j].innerHTML);
                 
                 ok = true;
                 if(j===0  || j===5 )
                 document.forms["PanierForm"]["vals"].value= document.forms["PanierForm"]["vals"].value + tableData[j].innerHTML+",";

              }
           // myTableArray.push(arrayOfThisRow);
             }
           }
          //document.forms["PanierForm"]["res"].value = "44";
           console.log("lignes: " +document.forms["PanierForm"]["vals"].value);
           //document.forms["CommandeForm"]["lignes"].value = "1";
         //myTableArray = myTableArray.join(", ");
        
         return ok;
            
}
//////////////////////////////////////////////////////////////////////////////////
    
  function changetextbox(d1,d2)
{
  
    console.log(d1.value);
   if ((d1.value === "Chef de Rayon") || (d1.value === "Agent de Rayon")) {
       console.log("ok");
       d2.style.display = 'block';
       
   }else d2.style.display = 'none';
}

///////////////////////////////////////////////////////////////////////////////////
    
function actualiserMoins(d1,d2)
{
  
    if(d1.value==="0"){
        d1.value = "0";
        d2.value ="0";
    }
    else {
        d2.value = parseInt(d1.value)-1;
    
    }
}
////////////////////////////////

    
function actualiserPlus(d1,d2)
{
  
    if(d1.value==="0"){
        d1.value = "0";
        d2.value ="0";
    }
    else {
        d2.value = parseInt(d1.value)+1;
    
    }
}

///////////////////////////////////////////////////