function initScript() {

  var span = document.getElementsByClassName("close")[0];
  var okButton = document.getElementsByClassName("okButton")[0];
  var cancelButton = document.getElementsByClassName("cancelButton")[0];
  var okButton = document.getElementsByClassName("okButton")[0];

  span.onclick = function() {
    var modal = document.getElementsByClassName("modal")[0];
    modal.style.display = "none";
  }

  cancelButton.onclick = function() {
    alert("There's nothing to cancel.");

  }

  okButton.onclick = function() {
    alert("You can close this box by clicking on the x.");
  }
}
