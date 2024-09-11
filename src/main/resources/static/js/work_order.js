document.addEventListener("DOMContentLoaded", function () {
  const addWorkOrderBtn = document.getElementById("addWorkOrderBtn");
  const workOrderModal = document.getElementById("workOrderModal");
  const closeModalBtn = document.getElementsByClassName("close")[0];
  const workOrderForm = document.getElementById("workOrderForm");
  const modalTitle = document.getElementById("modalTitle");

  // Function to open modal for creating a work order
  addWorkOrderBtn.onclick = function () {
    workOrderModal.style.display = "block";
    modalTitle.textContent = "Create Work Order";
    workOrderForm.reset();
    workOrderForm.action = "/workorders/add";  // Set form action to create
  };

  // Function to close modal
  closeModalBtn.onclick = function () {
    workOrderModal.style.display = "none";
  };

  // Close modal when clicking outside of it
  window.onclick = function (event) {
    if (event.target === workOrderModal) {
      workOrderModal.style.display = "none";
    }
  };

  // Edit work order function
  window.editWorkOrder = function (id) {
    fetch(`/workorders/edit/${id}`)
      .then(response => response.json())
      .then(data => {
        workOrderModal.style.display = "block";
        modalTitle.textContent = "Edit Work Order";
        
        workOrderForm.taskName.value = data.taskName;
        workOrderForm.assignedTo.value = data.assignedTo;
        workOrderForm.status.value = data.status;

        workOrderForm.action = `/workorders/edit/${id}`;  // Set form action to edit
      });
  };

  // Delete work order function
  window.deleteWorkOrder = function (id) {
    if (confirm("Are you sure you want to delete this work order?")) {
      fetch(`/workorders/delete/${id}`, {
        method: "DELETE",
      })
        .then(response => {
          if (response.ok) {
            alert(`Work order with ID ${id} deleted successfully!`);
            window.location.reload(); // Reload the page after deletion
          } else {
            alert("Failed to delete work order.");
          }
        });
    }
  };
});
