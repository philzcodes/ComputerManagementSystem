// script.js
document.addEventListener("DOMContentLoaded", function () {
  const notificationSettingsForm = document.getElementById(
    "notificationSettingsForm"
  );

  notificationSettingsForm.onsubmit = function (event) {
    event.preventDefault();
    alert("Notification settings saved successfully!");
  };

  // Example of dynamically adding a new alert
  const alertsList = document.getElementById("alertsList");
  const newAlert = document.createElement("li");
  newAlert.className = "alert-item critical";
  newAlert.textContent = "Firewall 1: Security breach detected!";
  alertsList.appendChild(newAlert);
});
