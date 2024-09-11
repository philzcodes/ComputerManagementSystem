// script.js
document.addEventListener("DOMContentLoaded", function () {
  const supportForm = document.getElementById("supportForm");

  supportForm.onsubmit = function (event) {
    event.preventDefault();
    const contactMethod = document.getElementById("contactMethod").value;
    const supportMessage = document.getElementById("supportMessage").value;

    alert(
      `Support request sent via ${contactMethod}. Message: ${supportMessage}`
    );
    // Implement actual support request submission logic here
  };
});
