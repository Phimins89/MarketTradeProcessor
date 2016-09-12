/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var wsUri = "ws://" + document.location.host + document.location.pathname + "tradeprocessorendpoint";
var websocket = new WebSocket(wsUri);

websocket.onmessage = function(evt) { onMessage(evt); };
websocket.onerror = function(evt) { onError(evt); };

function sendData(json) {
    console.log("sending text: " + json);
    websocket.send(json);
}
             
function onMessage(evt) {
    console.log("received: " + evt.data);
   }

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}
