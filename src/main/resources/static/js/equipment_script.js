document.addEventListener("DOMContentLoaded", function () {
  const addEquipmentBtn = document.getElementById("addEquipmentBtn");
  const equipmentModal = document.getElementById("equipmentModal");
  const closeModalBtn = document.getElementsByClassName("close")[0];
  const equipmentForm = document.getElementById("equipmentForm");
  const modalTitle = document.getElementById("modalTitle");

  // Function to open modal for adding equipment
  addEquipmentBtn.onclick = function () {
    equipmentModal.style.display = "block";
    modalTitle.textContent = "Add Equipment";
    equipmentForm.reset();
    equipmentForm.action = "/equipment/add";  // Set form action to 'add'
  };

  // Function to close modal
  closeModalBtn.onclick = function () {
    equipmentModal.style.display = "none";
  };

  // Close modal when clicking outside of it
  window.onclick = function (event) {
    if (event.target === equipmentModal) {
      equipmentModal.style.display = "none";
    }
  };

  // Edit equipment function
  window.editEquipment = function (id) {
    const equipmentModal = document.getElementById("equipmentModal");
    const modalTitle = document.getElementById("modalTitle");
    const equipmentForm = document.getElementById("equipmentForm");

    equipmentModal.style.display = "block";
    modalTitle.textContent = "Edit Equipment";

    // Load equipment data from the server for editing (replace with actual AJAX/API call)
    fetch(`/equipment/edit/${id}`)
      .then(response => response.json())
      .then(data => {
        equipmentForm.equipmentName.value = data.name;
        equipmentForm.model.value = data.model;
        equipmentForm.manufacturer.value = data.manufacturer;
        equipmentForm.installationDate.value = data.installationDate;
        equipmentForm.location.value = data.location;
        equipmentForm.failureProbability.value = data.failureProbability;
        equipmentForm.resourceRecommendation.value = data.resourceRecommendation;
        
        equipmentForm.schedulingRecommendation.value = data.schedulingRecommendation;
        equipmentForm.inventoryRecommendation.value = data.inventoryRecommendation;
        equipmentForm.riskLevel.value = data.riskLevel;
        
        // Update form action for editing
        equipmentForm.action = `/equipment/edit/${id}`;
      });
  };

  // Delete equipment function
  window.deleteEquipment = function (id) {
    if (confirm("Are you sure you want to delete this equipment?")) {
      // Make a DELETE request to the server
      fetch(`/equipment/delete/${id}`, {
        method: "DELETE",
      })
        .then(response => {
          if (response.ok) {
            alert(`Equipment with ID ${id} deleted successfully!`);
            window.location.reload(); // Reload the page after deletion
          } else {
	console.log(response);
            alert("Failed to delete equipment.");
      
          }
        });
    }
  };
});
