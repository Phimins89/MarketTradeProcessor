/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function defineJSON(evt) {
    var jsonData = document.getElementById("jsondata").value;
    sendData(jsonData);
    parent.document.getElementById("graph").reload();
}





